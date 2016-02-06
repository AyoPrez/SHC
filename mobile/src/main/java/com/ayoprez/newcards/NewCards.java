package com.ayoprez.newcards;

/**
 * Created by AyoPrez on 11/08/15.
 */
public class NewCards {

    private String card_text;
    private int card_position;
    private String group_name;
    private int amount_cards;
    private int id_c;
    private int id_g;

    public NewCards(int id_c, int id_g, int amount_cards, String card_text, int card_position, String group_name){
        this.id_c = id_c;
        this.id_g = id_g;
        this.amount_cards = amount_cards;
        this.card_text = card_text;
        this.card_position = card_position;
        this.group_name = group_name;
    }

    public String getCard_text() {
        return card_text;
    }

    public void setCard_text(String card_text) {
        this.card_text = card_text;
    }

    public int getCard_position() {
        return card_position;
    }

    public void setCard_position(int card_position) {
        this.card_position = card_position;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getAmount_cards() {
        return amount_cards;
    }

    public void setAmount_cards(int amount_cards) {
        this.amount_cards = amount_cards;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getId_g() {
        return id_g;
    }

    public void setId_g(int id_g) {
        this.id_g = id_g;
    }
}
