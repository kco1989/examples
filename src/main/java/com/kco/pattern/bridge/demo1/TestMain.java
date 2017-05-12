package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class TestMain {
    public static void main(String[] args) {
        Head head1 = new Head(new Hair1(Color.Black),
                new Face1(Color.White,
                        new Eye1(Color.Black),
                        new Nose1(),
                        new Mouth1(),
                        new Ear2()));
        System.out.println(head1);

        Head head2 = new Head(new Hair2(Color.Yello),
                new Face2(Color.Blue,
                        new Eye2(Color.White),
                        new Nose2(),
                        new Mouth2(),
                        new Ear1()));
        System.out.println(head2);
    }
}
