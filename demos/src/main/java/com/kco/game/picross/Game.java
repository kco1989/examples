package com.kco.game.picross;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kco.pattern.bridge.demo1.Face;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Created by pc on 2017/5/14.
 */
public class Game {

    private  Gson gson = new Gson();
    private int count;
    private File inputFile;
    private List<String> rowCondition;
    private List<String> lineCondition;
    private List<List<Integer>> rowMaybeValue;
    private List<List<Integer>> lineMaybeValue;
    private Model model;
    private boolean isGame = false;

    public Game(String inputFile) throws IOException {
        this(new File(inputFile));
    }
    public Game(File inputFile) throws IOException {
        this.inputFile = inputFile;
        parseInputFile();
    }

    private void parseInputFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.inputFile));
        this.count = Integer.parseInt(br.readLine());
        rowCondition = new ArrayList<>();
        lineCondition = new ArrayList<>();
        for (int i = 0; i < this.count; i ++){
            rowCondition.add(br.readLine().trim());
        }
        for (int i = 0; i < this.count; i ++){
            lineCondition.add(br.readLine().trim());
        }
        model = new Model(this.count);
        rowMaybeValue = new ArrayList<>();
        for (String condition : rowCondition){
            rowMaybeValue.add(parseConditionToList(condition));
        }
        lineMaybeValue = new ArrayList<>();
        for (String condition : lineCondition){
            lineMaybeValue.add(parseConditionToList(condition));
        }
    }

    public void run(){
        check(true, true);
        check(false, true);
        while (true){
            boolean checkRow = check(true, false);
            boolean checkLine = check(false, false);
            if (gameOver()){
                break;
            }
            if (!checkRow && !checkLine){
                System.out.println(lineMaybeValue + "," + rowMaybeValue);
                System.out.println("无解");
                break;
            }
        }
    }

    private boolean gameOver() {
        for (int i = 0; i < count; i ++){
            if (rowMaybeValue.get(i) != null){
                return false;
            }
            if (lineMaybeValue.get(i) != null){
                return false;
            }
        }
        return true;
    }

    private boolean check(boolean isRow, boolean isFrist) {
        List<List<Integer>> tempMaybeValue = isRow ? rowMaybeValue : lineMaybeValue;
        boolean isChange = false;
        for (int i = 0; i < count; i ++){
            List<Integer> list = tempMaybeValue.get(i);
            if (list == null){
                continue;
            }
            if (isFrist){
                int commonValue = common(tempMaybeValue.get(i));
                if (commonValue != 0){
                    isChange = true;
                    model.merga(isRow, i, commonValue);
                }
            }
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                Integer next = iterator.next();
                if ((next | model.get(isRow, i)) != next){
                    iterator.remove();
                    isChange = true;
                }
            }

            if (list.size() == 1){
                Integer integer = list.get(0);
                model.merga(isRow, i, integer);
                tempMaybeValue.set(i, null);
                isChange = true;
            }
        }
        return isChange;
    }


    private int common(List<Integer> maybeValue) {
        int result = 0xffffffff & model.getMark();
        for (Integer temp : maybeValue){
            result = result & temp;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Game game = new Game("E:\\git\\examples\\src\\main\\java\\com\\kco\\game\\picross\\test1.txt");
        game.run();
        System.out.println(game.model);
    }

    private List<Integer> parseConditionToList(String condition){
        Set<String> set = parseCondition(condition);
        List<Integer> result = new ArrayList<>();
        for (String temp : set){
            result.add(parseListStringToInteger(temp));
        }
        return result;
    }

    private Integer parseListStringToInteger(String listString) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = gson.fromJson(listString,  new TypeToken<List<Integer>>() {}.getType());
        for (Integer temp : list){
            if (temp == 0){
                sb.append("0");
            }else{
                for (int i = 0; i < temp; i ++){
                    sb.append("1");
                }
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private Set<String> parseCondition(String condition) {
        String[] split = condition.split(",|\\s+");
        List<Integer> list = new ArrayList<>();
        int zeroCount = count;
        for (String temp : split){
            int tempNum = Integer.parseInt(temp.trim());
            list.add(tempNum);
            zeroCount = zeroCount - tempNum;
            list.add(0);
            zeroCount --;
        }
        list.remove(list.size() - 1);
        zeroCount ++;
        Set<String> result = new HashSet<>();
        result.add(gson.toJson(list));
        result = addZero(result, zeroCount);
        return result;
    }

    private Set<String> addZero(Set<String> result, int zeroCount) {
        if (zeroCount <= 0){
            return result;
        }
        Set<String> resultSet = new HashSet<>();
        for (String temp : result){
            List<Integer> list = gson.fromJson(temp,  new TypeToken<List<Integer>>() {}.getType());
            for (int i = 0; i <= list.size(); i ++){
                List<Integer> listTemp = new ArrayList<>(list);
                listTemp.add(i, 0);
                resultSet.add(gson.toJson(listTemp));
            }
        }
        return addZero(resultSet, --zeroCount);
    }

}
