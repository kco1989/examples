package com.kco.game.picross.demo1;

/**
 * 地图model 一般是都是N * N
 * Created by Administrator on 2017/5/15.
 */
public class MapModel {

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

    // 边长 一般都是 N *
    private int count;
    // mark值
    // 如果count=5,则mark=0b1_1111
    // 如果count=10,则mark=0b11_1111_1111
    private int mark;
    // 地图数据
    // 如果oneRow(oneLine)的bit为1,则说明该位置被确定且需要被填充,bit为0,则该位置不确定
    // 如果zeroRow(zeroLine)的bit为0,则说明该位置被确定且不被填充,bit为1,则该位置不确定
    // 每行填充的数组  默认都0
    private int[] oneRow;       // 标记为1的格子
    // 每列填充的数据 默认都0
    private int[] oneLine;      // 标记为1的格子
    // 每行不填充的数据 默认值为 count 个 1 的二进制
    private int[] zeroRow;      // 标记为0的格子
    // 每列不填充的数据 默认值为 count 个 1 的二进制
    private int[] zeroLine;     // 标记为0的格子
    // 图形map
    private char[][] map;


    public MapModel(int count){
        if (count < MIN_COUNT || count > MAX_COUNT){
            throw new IllegalArgumentException("count参数不能必须在 " + MIN_COUNT + " ~ " + MAX_COUNT + " 的范围之内.");
        }
        this.count = count;
        this.mark = Utils.bitFillOne(this.count);
        oneRow = new int[this.count];
        oneLine = new int[this.count];
        zeroRow = new int[this.count];
        zeroLine = new int[this.count];
        map = new char[this.count][this.count];
        for (int i = 0; i < this.count; i ++){
            oneRow[i] = 0;
            oneLine[i] = 0;
            zeroRow[i] = Utils.bitFillOne(this.count);
            zeroLine[i] = Utils.bitFillOne(this.count);
            map[i] = new char[this.count];
            for (int j = 0; j < this.count; j ++){
                map[i][j] = UNKNOW;
            }
        }
    }

    // 填充1的位置
    public boolean one(boolean isRow, int index, int number){
        System.out.println("one --> isRow: " + isRow + ", index = " + index + ", number = " + Integer.toBinaryString(number));
        if (index < 0 || index >= this.count){
            throw new IllegalArgumentException("index参数越界.");
        }

        int[] array = isRow ? oneRow : oneLine;
        int target = array[index];
        if ((target | (number & this.mark)) == target){
            return true;
        }
        array[index] = target | (number & this.mark);
        onChangeOne(isRow, index);
        return check(isRow, index);
    }

    // 因为 oneRow和 oneLine是互相关联的,如果其中一个发生变化
    // 另外一个也必须被改变
    private void onChangeOne(boolean isRow, int index) {
        int[] array = isRow ? oneRow : oneLine;
        int[] changeArray = isRow ? oneLine : oneRow;
        int target = array[index];
        for (int i = 0; i < this.count; i ++){
            int temp = Utils.bitSetOne(this.count - i);
            changeArray[i] = changeArray[i] | (((target & temp) >> (this.count - i - 1)) << (this.count - index - 1));
        }
    }

    // 合并到标记到0的格子里
    public boolean zero(boolean isRow, int index, int number){
        System.out.println("zero --> isRow: " + isRow + ", index = " + index + ", number = " + Integer.toBinaryString(number));
        if (index < 0 || index >= this.count){
            throw new IllegalArgumentException("index参数越界.");
        }
        int[] array = isRow ? zeroRow : zeroLine;
        int target = array[index];
        if ((target & (number & this.mark)) == target){
            return true;
        }
        array[index] = target & (number & this.mark);
        onChangeZero(isRow, index);
        return check(isRow, index);
    }

    private boolean check(boolean isRow, int index) {
        int[] one = isRow ? oneRow : oneLine;
        int[] zero = isRow ? zeroRow : zeroLine;
        System.out.println("=======================");
        System.out.println(this);
        System.out.println("=======================");
        return (one[index] & zero[index]) == one[index];
    }
    // 因为 zeroRow 和 zeroLine 是互相关联的,如果其中一个发生变化
    // 另外一个也必须被改变
    private void onChangeZero(boolean isRow, int index) {
        int[] array = isRow ? zeroRow : zeroLine;
        int[] changeArray = isRow ? zeroLine : zeroRow;
        int target = array[index];
        for (int i = 0; i < this.count; i ++){
            int temp = Utils.bitSetOne(this.count - i);
            if ((target & temp) == 0){
                changeArray[i] = changeArray[i] & Utils.bitSetZero(this.count, index);
            }
        }
    }
    public int getOne(boolean isRow, int index){
        return isRow ? oneRow[index] : oneLine[index];
    }
    public int getZero(boolean isRow, int index){
        return isRow ? zeroRow[index] : zeroLine[index];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < this.count; i ++){
            int oneTarget = oneRow[i];
            int zeroTarget = zeroRow[i];
            for (int j = 0; j < this.count; j ++){
                if ((Utils.bitSetOne(this.count - j) & oneTarget) != 0){
                    map[i][j] = ONE;
                    sb.append(ONE);
                }else if((Utils.bitSetOne(this.count - j) & zeroTarget) == 0){
                    map[i][j] = ZERO;
                    sb.append(ZERO);
                }else{
                    map[i][j] = UNKNOW;
                    sb.append(UNKNOW);
                }
            }
            sb.append("\n");
        }
//        sb.append("==========\n");
//        sb.append(Arrays.toString(oneRow) + "\n");
//        sb.append(Arrays.toString(oneLine) + "\n");
//        sb.append("==========\n");
//        sb.append(Arrays.toString(zeroRow) + "\n");
//        sb.append(Arrays.toString(zeroLine) + "\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        MapModel model = new MapModel(5);
        model.zero(true, 1, 0b10001);
        System.out.println(model);
    }
}
