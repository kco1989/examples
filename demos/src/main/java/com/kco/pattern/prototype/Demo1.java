package com.kco.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Demo1 implements Cloneable{
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
        return super.clone();
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
        Demo1 demo1 = new Demo1();
        demo1.setAge(20);
        demo1.setName("张三");
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dot");
        demo1.setList(list);
        Demo1 clone = (Demo1)demo1.clone();
        System.out.println("是否为同一个对象:" + (demo1 == clone));
        System.out.println(demo1);
        System.out.println(clone);
        System.out.println("clone对象的list增加Pig元素后");
        clone.getList().add("Pig");
        System.out.println(demo1);
        System.out.println(clone);
    }
}
