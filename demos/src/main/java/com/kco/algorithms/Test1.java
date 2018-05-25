package com.kco.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 666666 on 2018/5/25.
 */
public class Test1 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        };
        TreeMap<String, Integer> map = new TreeMap<>();
        int i = maxSum1(array, 0, 0);
        System.out.println(map);
        System.out.println(i);
    }


//    private static int maxSum(int[][] array, int i, int j, Map<String, Integer> map) {
//        System.out.println("---");
//        if (i == array.length - 1){
//            map.put(i + "->" + j, array[i][j]);
//            System.out.println(map);
//            return array[i][j];
//        }
//        Integer x = map.get((i + 1) + "->" + j);
//        Integer y = map.get((i + 1) + "->" + (j + 1));
//        if (x == null){
//            x = maxSum(array, i + 1, j, map);
//        }
//        if (y == null){
//            y = maxSum(array, i + 1, j + 1, map);
//        }
//        map.put(i + "->" + j, Math.max(x, y) + array[i][j]);
//        return Math.max(x, y) + array[i][j];
//    }

    private static int maxSum1(int[][] array, int i, int j) {
        System.out.println("---");
        if (i == array.length - 1){
            return array[i][j];
        }
        int x = maxSum1(array, i + 1, j);
        int y = maxSum1(array, i + 1, j + 1);
        return Math.max(x, y) + array[i][j];
    }
}
