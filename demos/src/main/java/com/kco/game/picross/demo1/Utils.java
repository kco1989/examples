package com.kco.game.picross.demo1;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/5/15.
 */
public final class Utils {
    /**
     * <ul>
     *     <li>0 : 0</li>
     *     <li>1 : 0b1</li>
     *     <li>2 : 0b11</li>
     *     <li>3 : 0b111</li>
     *     <li>4 : 0b1111</li>
     *     <li>......</li>
     * </ul>
     */
    public static int bitFillOne(int count){
        if (count <= 0){
            return 0;
        }
        return Integer.parseInt(StringUtils.leftPad("", count, '1'), 2);
    }
    /**
     * <ul>
     *     <li>0 : 0</li>
     *     <li>1 : 0b1</li>
     *     <li>2 : 0b10</li>
     *     <li>3 : 0b100</li>
     *     <li>4 : 0b1000</li>
     *     <li>5 : 0b10000</li>
     *     <li>......</li>
     * </ul>
     */
    public static int bitSetOne(int count){
        if (count <= 0){
            return 0;
        }
        return Integer.parseInt(StringUtils.rightPad("1", count, '0'), 2);
    }

    /**
     * when count = 5
     * <ul>
     *     <li>0 : 0b01111</li>
     *     <li>1 : 0b10111</li>
     *     <li>2 : 0b11011</li>
     *     <li>3 : 0b11101</li>
     *     <li>4 : 0b11110</li>
     * </ul>
     * @param count
     * @param index
     * @return
     */
    public static int bitSetZero(int count, int index){
        if (count <= 0 || index < 0 || index >= count){
            return 0;
        }
        String temp = StringUtils.rightPad("", count, '1');
        temp = temp.substring(0, index) + "0" + temp.substring(index + 1, temp.length());
        return Integer.parseInt(temp, 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i ++){
            System.out.println(Integer.toBinaryString(bitSetZero(5, i)));
        }
        System.out.println(Integer.toBinaryString(bitSetOne(4)));
    }
}
