package com.kco.game.picross;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/5/15.
 */
public class TestMain {
    public static void main(String[] args) {
        String s = StringUtils.leftPad("", 5, '0');
        System.out.println(1 << 0);
        System.out.println(1 >> 0);
        System.out.println(s);
    }
}
