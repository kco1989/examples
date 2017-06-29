package com.kco.springmvc.dao;

import com.kco.springmvc.annotation.ReadOnlyDataSource;
import com.kco.springmvc.bean.TestBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/29.
 */
@ReadOnlyDataSource
public interface TestReadDao {

    TestBean getTest(@Param("name") String name);

}
