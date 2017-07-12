package com.kco.pattern.flyweight.demo;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Prince extends Card{

    private static final int[] HEALTH_POINT = new int[]{
        1100, 1200, 1331, 1463, 1606, 1760, 1936
    };
    private static final int[] ATTACK = new int[]{
        220, 242, 266, 292, 321, 352, 387
    };
    private static final int[] ATTACK_PER_SECOND = new int[]{
        146, 161, 177, 194, 214, 234, 258
    };
    public Prince() {
        super("王子", 5, 2.5f, 1.5f, "中等", 1, "地面");
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
