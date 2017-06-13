package com.kco.pattern.template.demo1;

import com.kco.thread.test3.demo1.Room;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/13.
 */
public abstract class Game {

    private String[] levelName;
    private Random random = new Random();
    public void play(){
        levelName = getLevelName();
        initGame();
        chooseRole();
        int level = 0;
        do{
            playLevel(level);
            level ++;
        }while (!gameOver(level));
    }

    private void playLevel(int level){
        System.out.println("开始关卡 --> " + levelName[level]);
    }

    private boolean gameOver(int level){
        if (levelName == null || level >= levelName.length){
            System.out.println("恭喜你,通关了.");
            return true;
        }
        if (random.nextInt(100) >= 90){
            System.out.println("抱歉,你已经挂了....");
            return true;
        }
        return false;
    }

    protected abstract void chooseRole();

    protected abstract void initGame();

    protected abstract String[] getLevelName() ;
}
