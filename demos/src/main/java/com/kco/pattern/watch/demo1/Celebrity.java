package com.kco.pattern.watch.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public class Celebrity implements Watched{
    private String name;
    private List<Watcher> watcherList;
    public Celebrity(String name) {
        this.name = name;
        watcherList = new ArrayList<>();
    }

    @Override
    public Watched add(Watcher w) {
        if (w != null && !watcherList.contains(w)){
            watcherList.add(w);
        }
        return this;
    }

    @Override
    public Watched delete(Watcher w) {
        if (w != null){
            watcherList.remove(w);
        }
        return this;
    }

    @Override
    public void notifyWatcher(String message) {
        for (Watcher w : watcherList){
            w.update(name + " " + message);
        }
    }
}
