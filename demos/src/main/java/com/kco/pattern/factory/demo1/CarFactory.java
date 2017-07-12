package com.kco.pattern.factory.demo1;

/**
 * Created by Administrator on 2017/5/10.
 */
public class CarFactory {

    public static Car createCar(String type){
        switch (type.toUpperCase()){
            case "BMW":
                return new BmwCar();
            case "BYD":
                return new BydCar();
            case "MAZDA":
                return new MazdaCar();
            default:
                return null;
        }
    }
}
