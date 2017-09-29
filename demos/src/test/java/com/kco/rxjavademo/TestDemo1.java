package com.kco.rxjavademo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.junit.Test;

/**
 * Created by 666666 on 2017/9/29.
 */
public class TestDemo1 {

    @Test
    public void test1(){
        Observable<Integer> objectObservable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });
        objectObservable.subscribe(new Observer<Integer>() {
            private Disposable d;
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext --> " + integer);
                if (integer.equals(2)){
                    d.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError --> ");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        objectObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe1");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext1 --> " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1 --> ");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete1");
            }
        });
    }
}
