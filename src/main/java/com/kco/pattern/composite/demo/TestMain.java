package com.kco.pattern.composite.demo;

import java.util.Random;

/**
 * Created by Administrator on 2017/5/17.
 */
public class TestMain {
    public static void main(String[] args) {
        Leader junMoXiao = new Leader("君莫笑");
        junMoXiao.add(new Member("寒烟柔"));
        junMoXiao.add(new Member("风梳烟沐"));
        String[] leaders = {
                "蓝河","车前子","孤饮"
        };
        Random r = new Random();
        for (String leaderName : leaders){
            Leader leader = new Leader(leaderName);
            for (int i = 0; i < r.nextInt(3) + 2; i ++){
                leader.add(new Member(leaderName + "的成员 " + i + "号"));
            }
            junMoXiao.add(leader);
        }
        junMoXiao.display();
    }
}
