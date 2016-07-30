package com.ayoprez.speechhelpercards.ui.presenter;

import android.view.View;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.activity.MainView;

import java.util.ArrayList;

/**
 * Created by ayo on 14.05.16.
 */
public interface MainPresenter {

        void setView(MainView view);

        void initDeskRecyclerView();

//        Temporal hacking
        void saveDeck(Deck deck);
}
