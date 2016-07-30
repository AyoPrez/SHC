package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.activity.AddDeckView;

/**
 * Created by ayo on 16.07.16.
 */
public interface AddDeckPresenter {

    void setView(AddDeckView view);
    void initRecyclerView();
    void saveDeck(Deck deck);
}
