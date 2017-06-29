package com.kco.springmvc.annotation;


import com.kco.springmvc.utils.CacheGroupEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法级的注解
 * 对该方法进行缓存
 * 如果redis能查到值,则直接返回redis的值,
 * 否则执行方法体,之后讲返回值缓存到redis中
 * @see ClearDbMember
 * Created by Administrator on 2017/6/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheDbMember {
    /**
     * 缓存组
     * @return
     */
    CacheGroupEnum cacheGroup() default CacheGroupEnum.Default;

    /**
     * 返回值类型
     * @return
     */
    Class[] returnClass();
}
