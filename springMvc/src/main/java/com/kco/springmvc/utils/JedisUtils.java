package com.kco.springmvc.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/23.
 */
@Component
public class JedisUtils {
    @Resource
    private JedisPool jedisPool;

    public void set(String key, String value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
//        jedis.close();
    }

    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
//        jedis.close();
        return value;
    }

    public void del(String key){
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
//        jedis.close();
    }
    public void sadd(String key, String member){
        Jedis jedis = jedisPool.getResource();
        jedis.sadd(key,member);
//        jedis.close();
    }
    public Set<String> smembers (String key){
        Jedis jedis = jedisPool.getResource();
        Set<String> smembers = jedis.smembers(key);
//        jedis.close();
        return smembers;
    }
}
