package com.kco.springmvc.service.impl;

import com.kco.springmvc.bean.TestBean;
import com.kco.springmvc.dao.TestReadDao;
import com.kco.springmvc.dao.TestWriteDao;
import com.kco.springmvc.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestReadDao testReadDao;
    @Resource
    private TestWriteDao testWriteDao;
    @Override
    public TestBean getTest(String name) {
        return testReadDao.getTest(name);
    }

    @Override
    public boolean insertTest(String name) {
        return testWriteDao.insertTest(name) > 0;
    }
}
