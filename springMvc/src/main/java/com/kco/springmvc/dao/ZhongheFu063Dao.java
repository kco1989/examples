package com.kco.springmvc.dao;

import com.kco.springmvc.annotation.ReadOnlyDataSource;
import com.kco.springmvc.bean.zhf.AgentBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@ReadOnlyDataSource
public interface ZhongheFu063Dao {

    List<AgentBean> listWithout063Agent();

}
