package com.kco.pattern.flyweight.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/11.
 */
public class CardFactory {
    public static final Map<CardType, Card> cardMap = new HashMap<>();
    public static Card createCard(CardType type){
        Card card = cardMap.get(type);
        if (card != null){
            return card;
        }
        switch (type){
            case BombMan:
                card = new BombMan();
                break;
            case Prince:
                card = new Prince();
                break;
            default:
                throw new RuntimeException("never go here");
        }
        cardMap.put(type, card);
        return card;
    }
}
