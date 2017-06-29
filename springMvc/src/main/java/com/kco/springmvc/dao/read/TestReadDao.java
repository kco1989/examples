package com.kco.springmvc.dao.read;

import com.kco.springmvc.bean.TestBean;
import com.kco.springmvc.service.TestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public interface TestReadDao {

    TestBean getTest(@Param("name") String name);

}
