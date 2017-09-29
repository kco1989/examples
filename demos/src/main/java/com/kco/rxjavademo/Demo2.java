package com.kco.rxjavademo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * Created by 666666 on 2017/9/29.
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        test2();
    }

    private static void test2() throws InterruptedException {
        Observable.range(1, 100)
                .throttleWithTimeout(1, TimeUnit.MICROSECONDS)
                .scan( (x, y) -> {
                    System.out.println(x + ":" + y);
                    return  x + y;
                })
                .subscribe(x -> System.out.println("next:" + x));
    }

    private static void test1() {
        Observable.range(1, 10)
                .subscribe(x -> System.out.println("next:" + x));
    }

}
