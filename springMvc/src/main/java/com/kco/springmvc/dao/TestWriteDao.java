package com.kco.springmvc.dao;

import com.kco.springmvc.annotation.WriteReadDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/29.
 */
@WriteReadDataSource
public interface TestWriteDao {
    int insertTest(@Param("name") String name);
}
