package com.kco.rediscache.service;

import com.kco.rediscache.bean.TestBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试的服务接口
 * Created by Administrator on 2017/6/23.
 */
public interface TestService {

    void add(TestBean bean);
    void delete(String id);
    void update(TestBean bean);
    TestBean get(String id);
    List<TestBean> list();
//    Set<TestBean> set();
//    Map<String, TestBean> map();
}
