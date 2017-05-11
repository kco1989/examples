package com.kco.pattern.flyweight.demo;

/**
 * Created by Administrator on 2017/5/11.
 */
public abstract class Card {
    protected String name;          // 卡片名字
    protected int holyWater;        // 消耗的圣水
    protected float attackRange;    // 攻击范围
    protected float attackSpeed;    // 攻击速度
    protected String moveSpeed;      // 移动速度
    protected int waitTime;         // 等待参战时间
    protected String attackTarget;  // 攻击目标

    public Card(String name, int holyWater, float attackRange, float attackSpeed, String moveSpeed, int waitTime, String attackTarget) {
        this.name = name;
        this.holyWater = holyWater;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.moveSpeed = moveSpeed;
        this.waitTime = waitTime;
        this.attackTarget = attackTarget;
    }

    public String getName() {
        return name;
    }

    public int getHolyWater() {
        return holyWater;
    }

    public float getAttackRange() {
        return attackRange;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public String getMoveSpeed() {
        return moveSpeed;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public String getAttackTarget() {
        return attackTarget;
    }

    abstract int getHealthPoint(int level);
    abstract int getAttack(int level);
    abstract int getAttackPerSecond(int level);
}
