package com.kco.pattern.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Demo2 implements Cloneable, Serializable{
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
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            ObjectOutputStream oos = new ObjectOutputStream(pos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(pis);
            Object o = ois.readObject();
            ois.close();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
        Demo2 demo2 = new Demo2();
        demo2.setAge(20);
        demo2.setName("张三");
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dot");
        demo2.setList(list);
        Demo2 clone = (Demo2)demo2.clone();
        System.out.println("是否为同一个对象:" + (demo2 == clone));
        System.out.println(demo2);
        System.out.println(clone);
        clone.getList().add("Pig");
        System.out.println("clone对象的list增加Pig元素后");
        System.out.println(demo2);
        System.out.println(clone);
    }
}
