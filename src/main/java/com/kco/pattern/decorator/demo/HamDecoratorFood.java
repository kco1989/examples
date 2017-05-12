package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class HamDecoratorFood extends DecoratorFood {

    protected HamDecoratorFood(Food food) {
        super(food);
    }

    @Override
    public String description() {
        return "加了火腿的" + food.description();
    }

    @Override
    public double price() {
        return food.price() + 3;
    }
}
