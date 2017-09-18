package com.kco;

import com.kco.springmvc.bean.zhf.AgentBean;
import com.kco.springmvc.service.ZhongheFu063Service;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by 666666 on 2017/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class TestZhongheFu063Service {

    @Resource
    private ZhongheFu063Service zhongheFu063Service;

    private static File file = new File("zhf.sql");

    @org.junit.Test
    public void testAll() throws IOException {
        addListWithout063Agent();
    }




    public void addListWithout063Agent() throws IOException {
        String shareSql = "INSERT INTO agent_share_rule (agent_no, service_id, card_type, holidays_mark, efficient_date, profit_type, cost_rate_type, per_fix_cost, cost_rate, share_profit_percent, check_status, lock_status) \n" +
                "VALUES('%s','544','0','0',now(),'5','1','2.00',NULL,'100.000000','1','0'),\n" +
                "      ('%s','545','1','0',now(),'5','2',NULL,'0.55','100.000000','1','0'),\n" +
                "      ('%s','545','2','0',now(),'5','2',NULL,'0.55','100.000000','1','0');\n\n";
        StringBuilder sb = new StringBuilder();
        StringBuilder shareSB = new StringBuilder();
        sb.append("# 还没有代理208的代理商 \n");
        sb.append("INSERT INTO agent_business_product(agent_no, bp_id, STATUS,default_bp_flag)VALUES \n");
        String sql = "\t('%s','%s',1,1),\n";
        List<AgentBean> agentBeanList = zhongheFu063Service.listWithout063Agent();
        for (AgentBean agentBean : agentBeanList){
            String agentNo = agentBean.getAgentNo();
            sb.append(String.format(sql, agentNo, "208"));
            shareSB.append(String.format(shareSql, agentNo,agentNo,agentNo));
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(";\n");
        FileUtils.write(file, sb, Charset.forName("UTF-8"));
        FileUtils.write(file, shareSB, Charset.forName("UTF-8"), true);
    }

}
