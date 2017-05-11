package com.kco.pattern.flyweight.demo;

/**
 * Created by Administrator on 2017/5/11.
 */
public class BombMan extends Card{

    private static final int[] HEALTH_POINT = new int[]{
        150, 165, 181, 199, 219, 240, 264
    };
    private static final int[] ATTACK = new int[]{
        100, 110, 121, 133, 146, 160, 176
    };
    private static final int[] ATTACK_PER_SECOND = new int[]{
        50, 55, 60, 66, 73, 80, 88
    };
    public BombMan() {
        super("炸弹人", 3, 5f, 2f, "中等", 1, "地面");
    }
    @Override
    int getHealthPoint(int level) {
        if (level <= 0){
            return HEALTH_POINT[0];
        }
        if (level >= HEALTH_POINT.length){
            return HEALTH_POINT[HEALTH_POINT.length - 1];
        }
        return HEALTH_POINT[level];
    }

    @Override
    int getAttack(int level) {
        if (level <= 0){
            return ATTACK[0];
        }
        if (level >= ATTACK.length){
            return ATTACK[ATTACK.length - 1];
        }
        return ATTACK[level];
    }

    @Override
    int getAttackPerSecond(int level) {
        if (level <= 0){
            return ATTACK_PER_SECOND[0];
        }
        if (level >= ATTACK_PER_SECOND.length){
            return ATTACK_PER_SECOND[ATTACK_PER_SECOND.length - 1];
        }
        return ATTACK_PER_SECOND[level];
    }
}
