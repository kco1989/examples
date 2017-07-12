package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class ChickenDecoratorFood extends DecoratorFood {

    protected ChickenDecoratorFood(Food food) {
        super(food);
    }

    @Override
    public String description() {
        return "加了鸡肉的" + food.description();
    }

    @Override
    public double price() {
        return food.price() + 5;
    }
}
