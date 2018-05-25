package com.kco.algorithms;

import org.apache.log4j.lf5.viewer.configure.MRUFileManager;

import java.util.Arrays;
import java.util.Random;


/**
 * 插入排序
 * Created by 666666 on 2018/5/24.
 */
public class Sort {
    public static void main(String[] args) {
        Random random = new Random();

        int size = 10;
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arrays));
        long time1 = System.currentTimeMillis();
//        insertSort(arrays);
        int[] ints = mergeSort(arrays, 2);
        long time2 = System.currentTimeMillis();
        System.out.println(size + "->" + (time2 - time1));
        System.out.println(Arrays.toString(ints));

    }

    private static void insertSort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int num = arrays[i];
            int j = i - 1;
            while (j >= 0 && arrays[j] > num) {
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = num;
        }
    }

    private static int[] mergeSort(int[] arrays, int r) {
        int mid = arrays.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arrays.length - mid];
        for (int i = 0; i < mid; i ++){
            left[i] = arrays[i];
        }
        for (int i = 0; i < arrays.length - mid; i ++){
            right[i] = arrays[mid + i];
        }
        if (left.length > r){
            mergeSort(left, r);
        }else{
            insertSort(left);
        }
        if (right.length > r){
            mergeSort(right, r);
        }else {
            insertSort(right);
        }
        return mergeSort0(left, right);
    }

    private static int[] mergeSort0(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, index = 0; i < left.length || j < right.length; index ++){
            if (i >= left.length){
                result[index] = right[j];
                j ++;
                continue;
            }
            if (j >= right.length){
                result[index] = left[i];
                i ++;
                continue;
            }
            if (left[i] > right[j]){
                result[index] = right[j];
                j ++;
            }else{
                result[index] = left[i];
                i ++;
            }
        }
        return result;
    }

}
