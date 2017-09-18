package com.kco.springmvc.service.impl;

import com.kco.springmvc.bean.zhf.AgentBean;
import com.kco.springmvc.dao.ZhongheFu063Dao;
import com.kco.springmvc.service.ZhongheFu063Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 666666 on 2017/9/18.
 */
@Service
public class ZhongheFu063ServiceImpl implements ZhongheFu063Service{
    @Resource
    private ZhongheFu063Dao zhongheFu063Dao;
    @Override
    public List<AgentBean> listWithout063Agent() {
        return zhongheFu063Dao.listWithout063Agent();
    }
}
