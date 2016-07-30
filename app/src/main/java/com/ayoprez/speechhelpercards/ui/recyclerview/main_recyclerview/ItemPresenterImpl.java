package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.presenter.ViewNotFoundException;

/**
 * Created by ayo on 09.07.16.
 */
public class ItemPresenterImpl implements ItemPresenter {

    protected ItemView view;
    protected Deck deck;
    protected MainRepository repository;

    public ItemPresenterImpl(MainRepository mainRepository){
        this.repository = mainRepository;
    }

    @Override
    public void setView(ItemView view) {
        this.view = view;
        loadDeck();
    }

    @Override
    public void loadDeck() {
        //Consult database
        //OnSucess call show content
        //OnError call show error
        if(view == null){
            throw new ViewNotFoundException();
        }

        int deckPosition = view.getItemPosition();
        deck = repository.getDeck(deckPosition);
        if(deck == null){
            view.showError();
        }else{
            view.displayDeckName(deck.getName());
            view.displayDeckImage(deck.getImage());
            view.displayDeckNumberOfCards(deck.getNumberOfCards());
        }
    }

}
