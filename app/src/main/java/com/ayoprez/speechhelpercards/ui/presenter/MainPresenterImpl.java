package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.activity.MainView;

import java.util.ArrayList;

/**
 * Created by ayo on 14.05.16.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private MainRepository repository;
    private Deck deck;

    //This presenter interact with the view and the model (interactor)
    //The interactor will take the data from database
    //The view will present the data

    //The presenter and interactor should be POJO. Nothing from Android Java


    public MainPresenterImpl(MainRepository mainRepository){
        this.repository = mainRepository;
    }

    @Override
    public void setView(MainView view) {
        this.mainView = view;
    }

    @Override
    public void initDeskRecyclerView() {
        if(mainView == null){
            throw new ViewNotFoundException();
        }
        mainView.loadDeskRecyclerView(repository.getAllDecks());
    }

    @Override
    public void saveDeck(Deck deck) {
        repository.saveDeck(deck);
    }


}
