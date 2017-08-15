package com.kco.work.demo1;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Main {

    public static final String SQL = "INSERT INTO agent_share_rule(agent_no,service_id,card_type,holidays_mark,efficient_date,profit_type,cost_rate_type,per_fix_cost,cost_rate,share_profit_percent,check_status,lock_status)\n" +
            "VALUES('%s', '%s', '%s', '%s', NOW(), 5,'%s', %s, %s,100,1,1);\n";
    public static void main(String[] args) throws IOException {

//        ShareParam shareParam = ExcelUtils.parseWorkbook("C:\\Users\\Administrator\\Desktop\\新建文件夹\\Book1.xlsx");
        ShareParam shareParam = TxtUtils.parseWorkbook("C:\\Users\\Administrator\\Desktop\\新建文件夹\\txt.txt");
//        ShareParam shareParam = ExcelUtils.parseWorkbook("D:\\用户目录\\我的文档\\Tencent Files\\568877100\\FileRecv\\Book1.xlsx");
//        ShareParam shareParam = ExcelUtils.parseWorkbook("D:\\用户目录\\我的文档\\Tencent Files\\568877100\\FileRecv\\Book1.xlsx");
        System.out.println(shareParam);
        if (shareParam == null){
            System.err.println("解析数据异常");
            return;
        }
        if (CollectionUtils.isEmpty(shareParam.getAgentList())){
            System.err.println("代理商编号列表为空");
            return;
        }
        String now = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
        File outFileName = new File("分润sql" + now + ".sql");
        FileWriter fw = new FileWriter(outFileName);
        for (String agentNo : shareParam.getAgentList()){
            fw.append(builderShareSql(agentNo, shareParam) + "\n");
        }
        fw.flush();
        fw.close();
        System.out.println("生成ok: " + outFileName.getAbsolutePath());
        Runtime.getRuntime().exec("cmd start /C " + outFileName.getAbsolutePath());
    }

    private static String builderShareSql(String agentNo, ShareParam shareParam) {
        String transSql = builderShareSql(agentNo, shareParam.getTransServiceId(),
                                        shareParam.isTransCard(), 
                                        shareParam.isTransHoliday(),
                                        "2", "NULL", shareParam.getTransShare());
        String cashSql = builderShareSql(agentNo, shareParam.getCashServiceId(),
                                        shareParam.isCashCard(),
                                        shareParam.isCashHoliday(),
                                        "1", shareParam.getCashShare(), "NULL" );
        StringBuilder sb = new StringBuilder();
        sb.append(transSql).append(cashSql);
        return sb.toString();
    }

    private static String builderShareSql(String agentNo, String serviceId, boolean card, boolean holiday, String castRateType, String perFixCost, String costRate) {
        StringBuilder sb = new StringBuilder();
        if (!card && !holiday){ // 不区分卡,不区分节假日
            sb.append(String.format(SQL, agentNo, serviceId, "0", "0", castRateType, perFixCost, costRate));
        }else if(!card && holiday){// 不区分卡,区分节假日
            sb.append(String.format(SQL, agentNo, serviceId, "0", "1", castRateType, perFixCost, costRate));
            sb.append(String.format(SQL, agentNo, serviceId, "0", "2", castRateType, perFixCost, costRate));
        }else if(card && !holiday){// 区分卡,不区分节假日
            sb.append(String.format(SQL, agentNo, serviceId, "1", "0", castRateType, perFixCost, costRate));
            sb.append(String.format(SQL, agentNo, serviceId, "2", "0", castRateType, perFixCost, costRate));
        }else{
            sb.append(String.format(SQL, agentNo, serviceId, "1", "1", castRateType, perFixCost, costRate));
            sb.append(String.format(SQL, agentNo, serviceId, "1", "2", castRateType, perFixCost, costRate));
            sb.append(String.format(SQL, agentNo, serviceId, "2", "1", castRateType, perFixCost, costRate));
            sb.append(String.format(SQL, agentNo, serviceId, "2", "2", castRateType, perFixCost, costRate));
        }
        return sb.toString();
    }
}
