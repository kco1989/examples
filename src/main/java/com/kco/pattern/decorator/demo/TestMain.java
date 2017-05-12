package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("老板: 手抓饼 5元, 鸡蛋: 2元, 鸡肉 5元, 火腿 3元");

        System.out.println("顾客A: 老板要一份手抓饼: ");
        Food food1 = new HandCakeFood();
        System.out.println("老板: 好勒, 给你 \"" + food1.description() + "\", 一共 " + food1.price() + "元");

        System.out.println("顾客B: 老板要一份手抓饼, 加个蛋: ");
        Food food2 = new EggDecoratorFood(new HandCakeFood());
        System.out.println("老板: 好勒, 给你 \"" + food2.description() + "\", 一共 " + food2.price() + "元");

        System.out.println("顾客C: 老板要一份手抓饼, 加个蛋再加个鸡肉: ");
        Food food3 = new EggDecoratorFood(new ChickenDecoratorFood(new HandCakeFood()));
        System.out.println("老板: 好勒, 给你 \"" + food3.description() + "\", 一共 " + food3.price() + "元");

        System.out.println("顾客D: 老板要一份手抓饼, 所有的东西都加一遍: ");
        Food food4 = new HamDecoratorFood(new EggDecoratorFood(new ChickenDecoratorFood(new HandCakeFood())));
        System.out.println("老板: 好勒, 给你 \"" + food4.description() + "\", 一共 " + food4.price() + "元");

        System.out.println("顾客E: 老板要一份手抓饼, 要双蛋: ");
        Food food5 = new EggDecoratorFood(new EggDecoratorFood(new HandCakeFood()));
        System.out.println("老板: 好勒, 给你 \"" + food5.description() + "\", 一共 " + food5.price() + "元");
    }
}
