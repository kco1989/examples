package com.kco.game.picross.demo2;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/5/15.
 */
public class MapData {
    // 地图边长的最小值
    private static final int MIN_COUNT = 5;
    // 地图边长的最小值
    private static final int MAX_COUNT = 30;
    // 填充标记
    private static final char ONE = '★';
    // 不填充标记
    private static final char ZERO = '◇';
    // 未知标志
    private static final char UNKNOW = '☆';
    // 图形map
    private char[][] map;

    private int count;
    private int mark;
    public MapData(int count){
        if (count < MIN_COUNT || count > MAX_COUNT){
            throw new IllegalArgumentException("count参数不能必须在 " + MIN_COUNT + " ~ " + MAX_COUNT + " 的范围之内.");
        }
        this.count = count;
        this.mark = Integer.parseInt(StringUtils.leftPad("", count, '1'), 2);
        map = new char[count][count];
        for (int i = 0; i < count; i ++){
            for (int j = 0; j < count; j ++){
                map[i][j] = UNKNOW;
            }
        }
    }

    public boolean set(boolean isRow,boolean isOne, int index, int number) {
        if (index < 0 || index >= count){
            return false;
        }
        String numStr;
        if (isOne){
            numStr = StringUtils.leftPad(Integer.toBinaryString(number & mark), count, '0');
        }else{
            numStr = StringUtils.leftPad(Integer.toBinaryString((~number) & mark), count, '0');
        }
        char[] chars = numStr.toCharArray();
        char sign = isOne ? ONE : ZERO;
        char unsign = isOne ? ZERO : ONE;
        for (int i = 0; i < count; i++) {
            int row = isRow ? index : i;
            int line = isRow ? i : index;
            if (chars[i] == '1') {
                if (map[row][line] == UNKNOW) {
                    map[row][line] = sign;
                } else if (map[row][line] == unsign) {
                    return false;
                }
            }
        }
        System.out.println("===================");
        display();
        return true;
    }

    public void display(){
        for (int i = 0; i < count; i ++){
            for (int j = 0; j < count; j ++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i ++){
            for (int j = 0; j < count; j ++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean maybeRight(boolean isRow, int index, int number) {
        String numStr = StringUtils.leftPad(Integer.toBinaryString(number & mark), count, '0');
        char[] chars = numStr.toCharArray();
        for (int i = 0; i < count; i ++){
            int row = isRow ? index : i;
            int line = isRow ? i : index;
            if (chars[i] == '1' && map[row][line] == ZERO){
                return false;
            }
        }
        return true;
    }
//    public static void main(String[] args) {
//        MapData mapData = new MapData(5);
//        mapData.set(true, true, 0, 0b11000);
//        mapData.set(false, true,4, 0b11001);
//        mapData.set(false, false,3, 0b11001);
//        mapData.set(false, false,4, 0b10001);
//        mapData.display();
//        System.out.println(Integer.toBinaryString(~0b11110));
//    }
}
