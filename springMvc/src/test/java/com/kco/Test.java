package com.kco;

import com.kco.springmvc.dao.TestReadDao;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 666666 on 2017/9/6.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class Test {
    private static String[] agentList = {
            "14328",
            "28903",
            "32531",
            "37044",
            "28063",
            "34621",
            "34734",
            "34934",
            "36422",
            "37906",
            "38584",
            "39388",
            "39489",
            "39613",
            "39736",
            "39771",
            "39805",
            "39886",
            "40255",
            "40257",
            "40613",
            "40624",
            "41374",
            "42214",
            "46777",
            "49806",
            "50346",
            "51045",
            "56676",
            "67084",
            "67091",
            "69191",
            "27493",
            "31051",
            "37418",
            "38161",
            "38284",
            "38725",
            "46661",
            "46832",
            "47594",
            "49404",
            "51003",
            "53676",
            "37928",
            "55836"
    };

    public static void main(String[] args) {
        String sql = "('%s','177','1','1'),";
        StringBuffer sb = new StringBuffer();
        for (String agent : agentList){
            sb.append(String.format(sql, agent) + "\n");
        }
        System.out.println(sb.toString());
    }

}
