package com.kco.springmvc.utils;

/**
 * 缓存分组枚举
 * 不同类型的缓存分配不同的组
 * 在执行清缓存的时候,会把同组的缓存清空
 *
 * @see com.kco.springmvc.annotation.ClearDbMember
 * @see com.kco.springmvc.annotation.CacheDbMember
 *
 * Created by Administrator on 2017/6/23.
 */
public enum CacheGroupEnum {
    Default("default"),Test("test");
    private String name;

    CacheGroupEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
