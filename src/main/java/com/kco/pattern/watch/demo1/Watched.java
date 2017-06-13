package com.kco.pattern.watch.demo1;

/**
 * 被观察者
 * Created by Administrator on 2017/6/13.
 */
public interface Watched {
    Watched add(Watcher w);
    Watched delete(Watcher w);
    void notifyWatcher(String message);
}
