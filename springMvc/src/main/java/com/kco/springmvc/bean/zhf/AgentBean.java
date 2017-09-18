package com.kco.springmvc.bean.zhf;

public class AgentBean{
    private String agentNo;
    private String agentName;

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "AgentBean{" +
                "agentNo='" + agentNo + '\'' +
                ", agentName='" + agentName + '\'' +
                '}';
    }
}