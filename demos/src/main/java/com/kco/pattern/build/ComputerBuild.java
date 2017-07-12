package com.kco.pattern.build;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ComputerBuild {
    private String cpu;
    private String memory;
    private String graphicsCard;
    private String type;
    private String screen;
    private String operatingSystem;

    public String cpu() {
        return cpu;
    }

    public ComputerBuild cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public String memory() {
        return memory;
    }

    public ComputerBuild memory(String memory) {
        this.memory = memory;
        return this;
    }

    public String graphicsCard() {
        return graphicsCard;
    }

    public ComputerBuild graphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public String type() {
        return type;
    }

    public ComputerBuild type(String type) {
        this.type = type;
        return this;
    }

    public String screen() {
        return screen;
    }

    public ComputerBuild screen(String screen) {
        this.screen = screen;
        return this;
    }

    public String operatingSystem() {
        return operatingSystem;
    }

    public ComputerBuild operatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    public Computer build(){
        Computer computer = new Computer();
        if (cpu() != null){
            computer.setCpu(cpu());
        }
        if (memory() != null){
            computer.setMemory(memory());
        }
        if (graphicsCard() != null){
            computer.setGraphicsCard(graphicsCard());
        }
        if (type() != null){
            computer.setType(type());
        }
        if (screen() != null){
            computer.setScreen(screen());
        }
        if (operatingSystem() != null){
            computer.setOperatingSystem(operatingSystem());
        }
        return computer;
    }
}
