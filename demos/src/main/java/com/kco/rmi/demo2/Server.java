package com.kco.rmi.demo2;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Server {
    public static void main(String[] args) {
        PersonServer person = new PersonServer();
        PersonSkeleton skel = new PersonSkeleton(person);
        skel.start();
    }
}
