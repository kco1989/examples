package com.kco.spring.demo3;

/**
 * Created by Administrator on 2017/7/28.
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
