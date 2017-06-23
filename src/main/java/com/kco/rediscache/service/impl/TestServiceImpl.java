package com.kco.rediscache.service.impl;

import com.kco.rediscache.annotation.CacheDbMember;
import com.kco.rediscache.annotation.ClearDbMember;
import com.kco.rediscache.bean.TestBean;
import com.kco.rediscache.dao.TestDao;
import com.kco.rediscache.service.TestService;
import com.kco.rediscache.untils.CacheGroupEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试的服务接口实现类
 * Created by Administrator on 2017/6/23.
 */
@Service
public class TestServiceImpl implements TestService{
    @Resource
    private TestDao testDao;

    @Override
    @ClearDbMember(cacheGroup = CacheGroupEnum.Test)
    public void add(TestBean bean) {
        testDao.add(bean);
    }

    @Override
    @ClearDbMember(cacheGroup = CacheGroupEnum.Test)
    public void delete(String id) {
        testDao.delete(id);
    }

    @Override
    @ClearDbMember(cacheGroup = CacheGroupEnum.Test)
    public void update(TestBean bean) {
        testDao.update(bean);
    }

    @Override
    @CacheDbMember(cacheGroup = CacheGroupEnum.Test, returnClass = TestBean.class)
    public TestBean get(String id) {
        return testDao.get(id);
    }

    @Override
    @CacheDbMember(cacheGroup = CacheGroupEnum.Test, returnClass = TestBean.class)
    public List<TestBean> list() {
        return testDao.list();
    }
}
