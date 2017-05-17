package com.kco.pattern.composite.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 队长
 * Created by Administrator on 2017/5/17.
 */
public class Leader extends GameRole{

    List<GameRole> gameRoles;

    public Leader(String name) {
        super(name);
    }

    public void add(GameRole role){
        if (gameRoles == null){
            gameRoles = new ArrayList<>();
        }
        gameRoles.add(role);
    }

    public void remove(GameRole role){
        if (gameRoles == null){
            return;
        }
        gameRoles.remove(role);
    }

    public boolean contains(GameRole role){
        if (gameRoles == null){
            return false;
        }
        return gameRoles.contains(role);
    }
    public void display(){
        System.out.println("总队长: " + this.name);
        display(1, this.gameRoles);
    }

    private void display(int index, List<GameRole> gameRoles) {
        if (gameRoles == null){
            return;
        }
        String leftPad = StringUtils.leftPad("", index, "\t");
        for (GameRole  role : gameRoles){
            String prefix = role instanceof Leader ? "分队长:" : "成员:";
            System.out.println(leftPad + prefix + role.getName());
            if (role instanceof Leader){
                display(index + 1, ((Leader) role).gameRoles);
            }
        }
    }
}
