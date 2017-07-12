package com.kco.rediscache;

import com.kco.rediscache.bean.TestBean;
import com.kco.rediscache.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/23.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctn = new ClassPathXmlApplicationContext("META-INF/com/kco/rediscache/application.xml");
        TestService bean = ctn.getBean(TestService.class);
        System.out.println("=================");
        System.out.println(bean);

        TestBean testBean = new TestBean();
        testBean.setName("test3");
        testBean.setId("103");
        testBean.setAge(15);
        bean.add(testBean);

        bean.list();
        bean.list();
        bean.get("102");
    }



}
