package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class EggDecoratorFood extends DecoratorFood {

    protected EggDecoratorFood(Food food) {
        super(food);
    }

    @Override
    public String description() {
        return "加了鸡蛋的" + food.description();
    }

    @Override
    public double price() {
        return food.price() + 2;
    }
}
