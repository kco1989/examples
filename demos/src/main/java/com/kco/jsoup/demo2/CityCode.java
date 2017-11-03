package com.kco.jsoup.demo2;

/**
 * Created by 666666 on 2017/11/3.
 */
public class CityCode {
    private String code;
    private String name;
    private String parentId;
    private String type;
    private String level;

    public String getLevel() {
        return level;
    }

    public CityCode setLevel(String level) {
        this.level = level;
        return this;
    }

    public CityCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + "\t" + code + "\t" + type + "\t" + level + "\t" + parentId +"\n";
    }
}
