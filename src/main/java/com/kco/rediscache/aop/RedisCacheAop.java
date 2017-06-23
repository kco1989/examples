package com.kco.rediscache.aop;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.kco.rediscache.annotation.CacheDbMember;
import com.kco.rediscache.annotation.ClearDbMember;
import com.kco.rediscache.untils.CacheGroupEnum;
import com.kco.rediscache.untils.JedisUtils;
import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * redis缓存切面
 * Created by Administrator on 2017/6/23.
 */
@Component
public class RedisCacheAop {
    protected static Logger logger = LoggerFactory.getLogger(RedisCacheAop.class);
    private static Gson gson = new Gson();
    @Resource
    private JedisUtils jedisUtils;
    public void clearCacheMember(ClearDbMember clearDbMember){
        logger.info("进入 : clearCacheMember");
        CacheGroupEnum cacheGroupEnum = clearDbMember.cacheGroup();
        String name = cacheGroupEnum.getName();
        Set<String> smembers = jedisUtils.smembers(name);
        if (CollectionUtils.isEmpty(smembers)){
            return;
        }
        for (String member : smembers){
            jedisUtils.del(member);
        }
        jedisUtils.del(name);
        logger.info("清除缓存 :" + name);
        logger.info("离开 : clearCacheMember");
    }

    public Object dbCacheMember(ProceedingJoinPoint pjd, CacheDbMember cacheDbMember){
        logger.info("进入 : dbCacheMember");
        String key = getUniquenessKey(pjd);
        String result = jedisUtils.get(key);

        if (!StringUtils.isEmpty(result)){
            logger.info("缓存存在数据:" + result);
            return parseJson(result, pjd, cacheDbMember);
        }
        Object proceed = null;
        try {
            logger.info("缓存不存在数据,实际查询:");
            proceed = pjd.proceed();
            if (proceed != null){
                jedisUtils.set(key, gson.toJson(proceed));
                String groupName = cacheDbMember.cacheGroup().getName();
                jedisUtils.sadd(groupName, key);
            }
            return proceed;
        } catch (Throwable throwable) {
            logger.error("异常信息:" + throwable);
        }
        logger.info("离开 : dbCacheMember");
        return proceed;
    }

    private Object parseJson(String result, ProceedingJoinPoint pjd, CacheDbMember cacheDbMember) {
        MethodSignature signature = (MethodSignature) pjd.getSignature();
        Class returnType = signature.getReturnType();
        if (returnType.isAssignableFrom(List.class)){
            Class resultClass = cacheDbMember.returnClass()[0];
            return parseJsonList(result, resultClass);
        }else if (returnType.isAssignableFrom(Set.class)){
            Class resultClass = cacheDbMember.returnClass()[0];
            return parseJsonSet(result, resultClass);
        }else if(returnType.isAssignableFrom(Map.class)){
            Class keyClass = cacheDbMember.returnClass()[0];
            Class valueClass = cacheDbMember.returnClass()[1];
            return parseJsonMap(result, keyClass, valueClass);
        }else{
            Class resultClass = cacheDbMember.returnClass()[0];
            return parseJsonObject(result, resultClass);
        }
    }
    private <T> T parseJsonObject(String json, Class<T> resultClass) {
        return gson.fromJson(json, resultClass);
    }

    private List<LinkedTreeMap> parse(String json) {
        return gson.fromJson(json, new TypeToken<List>() {
        }.getType());
    }

    private <K,V> Map<K, V> parseJsonMap(String json, Class<K> keyClass,  Class<V> valueClass) {
        Map<Object,Object> map = gson.fromJson(json, new TypeToken<Map<Object,Object>>() {
        }.getType());
        Map<K, V> resultMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()){
            K key = gson.fromJson(gson.toJson(entry.getKey()), keyClass);
            V value = gson.fromJson(gson.toJson(entry.getValue()), valueClass);
            resultMap.put(key, value);
        }
        return resultMap;
    }

    private <T> Set<T> parseJsonSet(String json, Class<T> resultClass) {
        List<LinkedTreeMap> result = parse(json);
        Set<T> resultSet = new HashSet<>();
        for (LinkedTreeMap map : result){
            T t = gson.fromJson(gson.toJson(map), resultClass);
            resultSet.add(t);
        }
        return resultSet;
    }

    private <T> List<T> parseJsonList(String json, Class<T> resultClass) {
        List<LinkedTreeMap> result = parse(json);
        List<T> resultList = new ArrayList<>();
        for (LinkedTreeMap map : result){
            T t = gson.fromJson(gson.toJson(map), resultClass);
            resultList.add(t);
        }
        return resultList;
    }

    private String getUniquenessKey(ProceedingJoinPoint pjd){
        String key = pjd.getStaticPart().getSignature().toLongString() + gson.toJson(pjd.getArgs());
        return DigestUtils.md5Hex(key);
    }
}
