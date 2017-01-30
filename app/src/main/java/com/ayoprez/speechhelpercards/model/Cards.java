package com.ayoprez.speechhelpercards.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayo on 30.11.16.
 */

public class Cards extends RealmObject{

    @PrimaryKey
    private int id;
    private int cardsId;
    private String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardsId() {
        return cardsId;
    }

    public void setCardsId(int cardsId) {
        this.cardsId = cardsId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
