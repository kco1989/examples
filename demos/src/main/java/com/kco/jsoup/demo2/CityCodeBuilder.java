package com.kco.jsoup.demo2;

/**
 * Created by 666666 on 2017/11/3.
 */
public class CityCodeBuilder {
    private String code;
    private String name;
    private String parentId;
    private String type;
    private String level;
    public static CityCodeBuilder newBuilder(){
        return new CityCodeBuilder();
    }
    public CityCode builder(){
        CityCode cityCode = new CityCode();
        cityCode.setCode(this.code);
        cityCode.setName(this.name);
        cityCode.setParentId(this.parentId);
        cityCode.setType(this.type);
        cityCode.setLevel(this.level);
        return cityCode;
    }
    public CityCodeBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public CityCodeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CityCodeBuilder setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public CityCodeBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CityCodeBuilder setLevel(String level) {
        this.level = level;
        return this;
    }

}
