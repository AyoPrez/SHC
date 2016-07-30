package com.ayoprez.speechhelpercards.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ayo on 23.07.16.
 */
@Entity
public class Cards{

    @Id
    private int cardsId;
    private String text;


    @Generated(hash = 1012913999)
    public Cards(int cardsId, String text) {
        this.cardsId = cardsId;
        this.text = text;
    }

    @Generated(hash = 1117066976)
    public Cards() {
    }


    public int getId() {
        return cardsId;
    }

    public void setId(int id) {
        this.cardsId = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCardsId() {
        return this.cardsId;
    }

    public void setCardsId(int cardsId) {
        this.cardsId = cardsId;
    }
}
