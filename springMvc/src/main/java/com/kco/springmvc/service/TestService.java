package com.kco.springmvc.service;

import com.kco.springmvc.bean.TestBean;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface TestService {

    TestBean getTest(String name);

    boolean insertTest(String name);
}
