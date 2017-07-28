package com.kco.spring.demo5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
//@ActiveProfiles("prod")
@ActiveProfiles("dev")
public class DemoBeanInegrationTests {
    @Autowired
    private TestBean testBean;


    @Test
    public void prodBeanShouldInject(){
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
