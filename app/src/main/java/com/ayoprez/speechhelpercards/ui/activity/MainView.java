package com.ayoprez.speechhelpercards.ui.activity;

import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayo on 14.05.16.
 */
public interface MainView {
    void loadDeskRecyclerView(List<Deck> decksList);
    void showError();

    void initFloatingButton( );
}
