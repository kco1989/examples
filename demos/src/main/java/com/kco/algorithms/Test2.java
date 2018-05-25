package com.kco.algorithms;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.*;

/**
 * Created by 666666 on 2018/5/25.
 */
public class Test2 {
    public static int[] price = { 20, 50, 86, 90, 100, 170, 170, 200, 240, 300};
    public static Map<Integer, Integer> maxMap = new TreeMap<>();
    public static void main(String[] args) {
        int i = maxPrice(6);
        System.out.println(maxMap);
        System.out.println(i);
    }

    private static int maxPrice(int n) {
        if (n == 0){
            return 0;
        }
        int q = Optional.ofNullable(maxMap.get(n)).orElse(-1);
        if (n >= 1 && n <= 10){
            q = price[n - 1];
        }
        maxMap.put(n, q);
        for (int i = 0; i < price.length; i ++){
            int other = n - i - 1;
            if (other > 0){
                q = Math.max(q, price[i] + maxPrice(other));
                maxMap.put(n, q);
            }else{
                break;
            }
        }
        return q;
    }


}
