package com.kco.pattern.facade.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Man {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        System.out.println("上班了....");
        mobilePhone.leaveHome();
        System.out.println("===============");
        System.out.println("下班回家了.....");
        mobilePhone.goHome();
    }
}
