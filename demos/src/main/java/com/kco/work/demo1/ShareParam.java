package com.kco.work.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ShareParam {
    private String transServiceId;  // 交易服务id
    private String transShare;      // 交易分润
    private boolean transCard;      // 交易是否区分卡
    private boolean transHoliday;   // 交易是否区分节假日

    private String cashServiceId;  // 提现服务id
    private String cashShare;      // 提现分润
    private boolean cashCard;      // 提现是否区分卡
    private boolean cashHoliday;   // 提现是否区分节假日

    private List<String> agentList;

    public ShareParam() {
        agentList = new ArrayList<>();
    }

    public List<String> getAgentList() {
        return agentList;
    }
    public List<String> addAgentList(String agentNo){
        if(!agentList.contains(agentNo)){
            agentList.add(agentNo);
        }
        return agentList;
    }

    public String getTransServiceId() {
        return transServiceId;
    }

    public void setTransServiceId(String transServiceId) {
        this.transServiceId = transServiceId;
    }

    public String getTransShare() {
        return transShare;
    }

    public void setTransShare(String transShare) {
        this.transShare = transShare;
    }

    public boolean isTransCard() {
        return transCard;
    }

    public void setTransCard(boolean transCard) {
        this.transCard = transCard;
    }

    public boolean isTransHoliday() {
        return transHoliday;
    }

    public void setTransHoliday(boolean transHoliday) {
        this.transHoliday = transHoliday;
    }

    public String getCashServiceId() {
        return cashServiceId;
    }

    public void setCashServiceId(String cashServiceId) {
        this.cashServiceId = cashServiceId;
    }

    public String getCashShare() {
        return cashShare;
    }

    public void setCashShare(String cashShare) {
        this.cashShare = cashShare;
    }

    public boolean isCashCard() {
        return cashCard;
    }

    public void setCashCard(boolean cashCard) {
        this.cashCard = cashCard;
    }

    public boolean isCashHoliday() {
        return cashHoliday;
    }

    public void setCashHoliday(boolean cashHoliday) {
        this.cashHoliday = cashHoliday;
    }

    @Override
    public String toString() {
        return "ShareParam{" +
                "transServiceId='" + transServiceId + '\'' +
                ", transShare='" + transShare + '\'' +
                ", transCard=" + transCard +
                ", transHoliday=" + transHoliday +
                ", cashServiceId='" + cashServiceId + '\'' +
                ", cashShare='" + cashShare + '\'' +
                ", cashCard=" + cashCard +
                ", cashHoliday=" + cashHoliday +
                ", agentList=" + agentList +
                '}';
    }
}
