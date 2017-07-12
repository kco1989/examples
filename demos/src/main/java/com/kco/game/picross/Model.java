package com.kco.game.picross;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by pc on 2017/5/14.
 */
public class Model {
    private static final int[] MARKS = new int[]{
            0x1f, 0x3ff, 0x7fff, 0xfffff
    };
    private List<Integer> row;  // 行
    private List<Integer> line; // 列

    private int count;
    private int mark;
    public Model(int count){
        if (count <= 0 || count > 20 || count % 5 != 0){
            throw new IllegalArgumentException("参数只能是5,10,15,20.");
        }
        this.count = count;
        this.mark = MARKS[this.count / 5 - 1];
        this.row = new ArrayList<>();
        this.line = new ArrayList<>();
        for (int i = 0; i < count; i ++){
            this.row.add(0);
            this.line.add(0);
        }
    }
    public int get(boolean isRow, int index){
        return isRow ? row.get(index) : line.get(index);
    }
    public void merga(boolean isRow, int index, int number){
        if (index < 0 || index > this.count){
            return;
        }
        List<Integer> temp = isRow ? row : line;
//        index = isRow ? index : count - index - 1;
        Integer integer = temp.get(index);
        integer = integer | (number & mark);
        temp.set(index, integer);
        onChange(isRow, index);
    }

    private void onChange(boolean isRow, int index) {
        int num = isRow ? this.row.get(index) : this.line.get(index);
        List<Integer> tempList = isRow ? line : row;
        for (int i = 0; i < count; i ++){
            int temp = num & (1 << (count - 1 - i));
            int m = (temp >> (count - 1 - i)) << (count - index - 1);
            tempList.set(i, tempList.get(i) | m);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i ++){
            int num = this.row.get(i);
            for (int j = count - 1; j >= 0; j --){
                if((1 << j & num) == 0){
                    sb.append("☆");
                }else{
                    sb.append("★");
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append(row + "," + line + "\n");
//        System.out.println();
        return sb.toString();
    }

    public static void main(String[] args) {
        Model model = new Model(5);
        model.merga(false, 1, 0b11011);
        model.merga(true, 1, 0b11011);
        model.merga(false, 4, 0b10001);
        model.merga(true, 2, 0b00001);
//        model.merga(true, 0, 0b00001);
//        model.merga(false, 2, 0b11011);
//        model.merga(true, 1, 0b10011);
        System.out.println(model);
    }

    public int getMark() {
        return mark;
    }
}
