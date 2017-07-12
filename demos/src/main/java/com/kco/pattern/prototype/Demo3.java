package com.kco.pattern.prototype;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Demo3 implements Cloneable{
    private String name;
    private int age;
    private List<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), Demo3.class);
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Demo3 demo3 = new Demo3();
        demo3.setAge(20);
        demo3.setName("张三");
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dot");
        demo3.setList(list);
        Demo3 clone = (Demo3)demo3.clone();
        System.out.println("是否为同一个对象:" + (demo3 == clone));
        System.out.println(demo3);
        System.out.println(clone);
        clone.getList().add("Pig");
        System.out.println("clone对象的list增加Pig元素后");
        System.out.println(demo3);
        System.out.println(clone);
    }
}
