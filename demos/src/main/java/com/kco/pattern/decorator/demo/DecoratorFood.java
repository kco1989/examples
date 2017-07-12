package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class DecoratorFood implements Food{

    protected Food food;
    protected DecoratorFood(Food food){
        this.food = food;
    }
    @Override
    public String description() {
        return food.description();
    }

    @Override
    public double price() {
        return food.price();
    }
}
