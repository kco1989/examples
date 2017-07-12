package com.kco.pattern.build;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Computer {
    private String cpu;
    private String memory;
    private String graphicsCard;
    private String type;
    private String screen;
    private String operatingSystem;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "电脑配置{" +
                "CPU='" + cpu + '\'' +
                ", 内存='" + memory + '\'' +
                ", 显卡='" + graphicsCard + '\'' +
                ", 类型='" + type + '\'' +
                ", 显示器='" + screen + '\'' +
                ", 操作系统='" + operatingSystem + '\'' +
                '}';
    }
}
