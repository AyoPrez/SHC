package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

/**
 * Created by ayo on 09.07.16.
 */
public interface ItemView {

    int getItemPosition();

    void displayDeckName(String name);
    void displayDeckImage(int resource);
    void displayDeckNumberOfCards(String number);

    void showError();
}
