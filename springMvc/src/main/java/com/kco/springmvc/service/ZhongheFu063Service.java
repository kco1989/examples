package com.kco.springmvc.service;

import com.kco.springmvc.bean.zhf.AgentBean;

import java.util.List;

/**
 * Created by 666666 on 2017/9/18.
 */
public interface ZhongheFu063Service {

    /**
     * 获取没有代理0.63的业务产品的代理商
     * @return 代理商集合
     */
    List<AgentBean> listWithout063Agent();

}
