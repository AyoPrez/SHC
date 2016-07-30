package com.ayoprez.speechhelpercards.ui.activity;

import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;

/**
 * Created by ayo on 14.05.16.
 */
public interface MainView {
    int getDeckId();

    void loadDeskRecyclerView(ArrayList<Deck> decksList);
    void showLoading();
    void showError();

    void initFloatingButton( );
}
