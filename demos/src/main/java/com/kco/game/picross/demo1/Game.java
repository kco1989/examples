package com.kco.game.picross.demo1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Administrator on 2017/5/15.
 */
public class Game {

    private static Gson gson = new Gson();
    private int count;
    private List<String> rowConditions;
    private List<String> lineConditions;
    private List<List<Integer>> rowMaybeValue;
    private List<List<Integer>> lineMaybeValue;
    private MapModel model;


    public Game(String file){
        this(new File(file));
    }

    public Game(File file){
        parseFile(file);
        parseConditions();
        model = new MapModel(this.count);
    }

    /**
     * 解析条件文件
     */
    private void parseFile(File file) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            count = Integer.parseInt(br.readLine());
            rowConditions = new ArrayList<>();
            lineConditions = new ArrayList<>();
            for (int i = 0; i < count; i ++){
                rowConditions.add(br.readLine());
            }
            for (int i = 0; i < count; i ++){
                lineConditions.add(br.readLine());
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 解析每行/每列的所有的条件
     */
    public void parseConditions(){
        if (rowMaybeValue != null && lineMaybeValue != null){
            return;
        }
        rowMaybeValue = new ArrayList<>();
        lineMaybeValue = new ArrayList<>();
        for (int i = 0; i < this.count; i ++){
            rowMaybeValue.add(parseCondition(rowConditions.get(i)));
            lineMaybeValue.add(parseCondition(lineConditions.get(i)));
        }
    }

    /**
     * 解析单个条件
     * @return
     */
    private List<Integer> parseCondition(String condition) {

        String[] split = condition.trim().split(",|\\s+");
        List<Integer> splitIntList = new ArrayList<>();
        int zeroCount = this.count;
        for (String string : split){
            int temp = Integer.parseInt(string);
            splitIntList.add(temp);
            zeroCount -= temp;
            splitIntList.add(0);
            zeroCount -= 1;
        }
        splitIntList.remove(splitIntList.size() - 1);
        zeroCount += 1;
        Set<String> mayBeCombination = new HashSet<>();
        mayBeCombination.add(gson.toJson(splitIntList));
        return guessMaybeValue(mayBeCombination, zeroCount);
    }

    /**
     * 递归猜测有可能的组合
     */
    private List<Integer> guessMaybeValue(Set<String> mayBeCombination, int zeroCount) {
        if (zeroCount <= 0){
            return mayBeCombination2Value(mayBeCombination);
        }
        Set<String> newMayBeCombination = new HashSet<>();
        for (String combination : mayBeCombination){
            List<Integer> list = gson.fromJson(combination, new TypeToken<List<Integer>>() {
            }.getType());
            for (int i = 0; i <= list.size(); i ++){
                List<Integer> temp = new ArrayList<>(list);
                temp.add(i, 0);
                newMayBeCombination.add(gson.toJson(temp));
            }
        }
        return guessMaybeValue(newMayBeCombination, --zeroCount);
    }

    /**
     * 将有可能的组合转化为值
     */
    private List<Integer> mayBeCombination2Value(Set<String> mayBeCombination) {
        List<Integer> result = new ArrayList<>();
        for (String combination : mayBeCombination){
            List<Integer> list = gson.fromJson(combination, new TypeToken<List<Integer>>() {
            }.getType());
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list){
                if (integer != 0){
                    sb.append(StringUtils.leftPad("", integer, '1'));
                }else{
                    sb.append("0");
                }
            }
            result.add(Integer.parseInt(sb.toString(), 2));
        }
        return result;
    }

    // 求解过程
    public void run() {
        boolean isFirst = true;
        while (true) {
            boolean check = check();
            if (isGameOver()) {
                break;
            }
            if (!check) {
                System.out.println("无解");
                break;
            }
            isFirst = false;
        }
    }

    private boolean check() {
        boolean rowCheck = check(true);
        boolean lineCheck = check(false);
        return  rowCheck || lineCheck;
    }

    private boolean check( boolean isRow){
        List<List<Integer>> maybe = isRow ? rowMaybeValue : lineMaybeValue;
        boolean isChange = false;
        for (int i = 0;i < maybe.size(); i ++){
            List<Integer> list = maybe.get(i);
            if (list == null){
                continue;
            }
            int commonOneValue = commonOne(list);
            if (commonOneValue != 0){
                model.one(isRow, i, commonOneValue);
                isChange = true;
            }

            int commonZeroValue = commonZero(list);
            if (commonZeroValue != Utils.bitFillOne(this.count)){
                model.zero(isRow, i, commonZeroValue);
                isChange = true;
            }

            if (list.size() != 1){
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    if ((next & model.getOne(isRow, i)) !=  model.getOne(isRow, i)){
                        iterator.remove();
                    }else if((next | model.getZero(isRow, i)) !=  model.getZero(isRow, i)){
                        iterator.remove();
                    }
                }
            }

            if (list.size() == 1){
                Integer integer = list.get(0);
                model.one(isRow, i, integer);
                model.zero(isRow, i, integer);
                maybe.set(i, null);
                isChange = true;
            }
        }
        return isChange;
    }

    private int commonOne(List<Integer> list) {
        int result = Utils.bitFillOne(this.count);
        for (Integer temp : list){
            result = result & temp;
        }
        return result;
    }
    private int commonZero(List<Integer> list) {
        int result = 0;
        for (Integer temp : list){
            result = result | temp;
        }
        return result;
    }


    public MapModel getModel() {
        return model;
    }

    public static void main(String[] args) {
        Game game = new Game("F:\\testWork\\allExample\\example\\src\\main\\java\\com\\kco\\game\\picross\\demo2.txt");
        game.run();
        System.out.println(game.getModel());
        System.out.println("sd");
    }

    public boolean isGameOver() {
        for (int i = 0; i < this.count; i ++){
            if (rowMaybeValue.get(i) != null){
                return false;
            }
            if (lineMaybeValue.get(i) != null){
                return false;
            }
        }
        return true;
    }
}
