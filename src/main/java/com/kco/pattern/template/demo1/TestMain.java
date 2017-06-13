package com.kco.pattern.template.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class TestMain {
    public static void main(String[] args) {
        Game game = new KnightsOfValour();
        game.play();
        System.out.println("===============");
        Game game1 = new OrientalLegend();
        game1.play();
    }
}
