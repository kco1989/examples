package com.kco.springmvc.annotation;

import com.kco.springmvc.utils.CacheGroupEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法级的注解
 * 清除指定缓存组的数据
 * @see CacheDbMember
 * Created by Administrator on 2017/6/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ClearDbMember{
    CacheGroupEnum cacheGroup() default CacheGroupEnum.Default;
}
