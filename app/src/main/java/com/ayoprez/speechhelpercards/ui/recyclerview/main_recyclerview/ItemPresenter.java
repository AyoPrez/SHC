package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import com.ayoprez.speechhelpercards.model.Deck;

import java.util.List;

/**
 * Created by ayo on 09.07.16.
 */
public interface ItemPresenter {

    void setView(ItemView view, int position);
    void loadDeck(Deck deck);
    void deleteItemById(int id);
    List<Deck> getDeckList();
}
