package com.kco.rxjavademo;

import com.sun.org.apache.regexp.internal.RE;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

import java.util.Random;

/**
 * Created by 666666 on 2017/9/29.
 */
public class Demo1 {
    public static void main(String[] args) {
        test6();
    }

    private static void test6() {
        Random random = new Random();
        Observable<Integer> ob1 = Observable.create(emitter -> {
            new Thread(()->{
                for (int i = 0; i < 8; i ++){
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ob1 ==> " + i);
                    emitter.onNext(i);
                }
                emitter.onComplete();
            }).start();

        });

        Observable<String> ob2 = Observable.create(emitter -> {
            new Thread(() ->{
                for (int i = 0; i < 4; i ++){
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    char ch = (char) ('A' + i);
                    System.out.println("ob2 ==> " + ch);
                    emitter.onNext(ch + "");
                }
                emitter.onComplete();
            }).start();

        });
        Observable.zip(ob1, ob2, (integer, s) -> integer + " : " + s)
                .subscribe(x -> System.out.println("next -->" + x));
    }

    private static void test5() {

        Observable.<Integer>create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
        }).concatMap(x -> {
            return observer -> {
                for (int i = 0; i < 5; i ++){
                    observer.onNext( x + ":" + i);
                }
            };
        }).subscribe(x -> System.out.println("next -> " + x));
    }
    private static void test4() {

        Observable.<Integer>create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
        }).flatMap(x -> {
            return observer -> {
                for (int i = 0; i < 5; i ++){
                    observer.onNext( x + ":" + i);
                }
            };
        }, true).subscribe(x -> System.out.println("next -> " + x));
    }

    private static void test3() {
        Observable.<Integer>create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
        }).map(x -> x.toString() + "ab")
           .subscribe(x -> System.out.println("next -> " + x));
    }

    private static void test2() {
       Observable.<Integer>create(emitter ->{
            new Thread(() -> emitter.onNext(4)).start();
            new Thread(() -> emitter.onNext(5)).start();
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onError(new NullPointerException("ha ha"));
            emitter.onComplete();
           emitter.onNext(4);
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(Thread.currentThread() + " onNext --> " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError --> " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    private static void test1() {
        Observable<Integer> observable = Observable.create(emitter ->{
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);
    }
}
