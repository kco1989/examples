package com.kco.springmvc.dao.write;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public interface TestWriteDao {

    int insertTest(@Param("name") String name);
}
