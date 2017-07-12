package com.kco.pattern.flyweight.demo;

/**
 * Created by Administrator on 2017/5/11.
 */
public class UserData {
    private Card prince;
    private int princeLevel;
    private Card bombMan;
    private int bombManLevel;

    public void addPrinceCard( int level){
        if (prince == null){
            prince = CardFactory.createCard(CardType.Prince);
        }
        princeLevel = Math.max(level, princeLevel);
    }
    public void addBombManCard(int level){
        if (bombMan == null){
            bombMan = CardFactory.createCard(CardType.BombMan);
        }
        bombManLevel = Math.max(level, bombManLevel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========卡片信息========== \n");
        if (prince != null){
            sb.append("\t名称: " + prince.getName())
                    .append("\t圣水:" + prince.getHolyWater())
                    .append("\t工具目标:" + prince.getAttackTarget())
                    .append("\t移动速度:" + prince.getMoveSpeed())
                    .append("\t攻击速度:" + prince.getAttackSpeed())
                    .append("\t生命值:" + prince.getHealthPoint(princeLevel))
                    .append("\t攻击力:" + prince.getAttack(princeLevel))
                    .append("\t每秒攻击力:" + prince.getAttackPerSecond(princeLevel) + "\n");
        }
        if (bombMan != null){
            sb.append("\t名称: " + bombMan.getName())
                    .append("\t圣水:" + bombMan.getHolyWater())
                    .append("\t工具目标:" + bombMan.getAttackTarget())
                    .append("\t移动速度:" + bombMan.getMoveSpeed())
                    .append("\t攻击速度:" + bombMan.getAttackSpeed())
                    .append("\t生命值:" + bombMan.getHealthPoint(bombManLevel))
                    .append("\t攻击力:" + bombMan.getAttack(bombManLevel))
                    .append("\t每秒攻击力:" + bombMan.getAttackPerSecond(bombManLevel) + "\n");
        }
        return sb.toString();
    }

    public Card getPrince() {
        return prince;
    }

    public Card getBombMan() {
        return bombMan;
    }
}
