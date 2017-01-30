package com.ayoprez.speechhelpercards.model;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayo on 30.11.16.
 */

public class Deck extends RealmObject{

    @PrimaryKey
    private int id;
    private String name;
    private String numberOfCards;
    private int image;
    private RealmList<Cards> cards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(String numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public RealmList<Cards> getCards() {
        return cards;
    }

    public ArrayList<Cards> getArrayCards(){
        return new ArrayList<>(cards);
    }

    public void setCards(RealmList<Cards> cards) {
        this.cards = cards;
    }

    public void setCards(ArrayList<Cards> cards){
        this.cards.addAll(cards);
    }
}
