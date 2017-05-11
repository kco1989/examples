package com.kco.pattern.flyweight.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/11.
 */
public class TestMain {
    public static void main(String[] args) {
        List<UserData> userDatas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i ++){
            UserData userData = new UserData();
            userData.addPrinceCard(random.nextInt(7));
            userData.addBombManCard(random.nextInt(7));
            userDatas.add(userData);
        }
        for (UserData userData : userDatas){
            System.out.println(userData);
        }

        System.out.println("校验每个用户的卡牌信息是否共享的..");
        for (int i = 0; i < 9; i ++){
            int index1 = i;
            int index2 = i + 1;
            System.out.println("玩家 " + index1 +
                    " 与玩家 " + index2 +
                    " 的王子是否为同一个:" +
                    (userDatas.get(index1).getPrince() == userDatas.get(index2).getPrince()));
            System.out.println("玩家 " + index1 +
                    " 与玩家 " + index2 +
                    " 的炸弹人是否为同一个:" +
                    (userDatas.get(index1).getBombMan() == userDatas.get(index2).getBombMan()));
        }
    }
}
