package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.presenter.ViewNotFoundException;

import java.util.List;

/**
 * Created by ayo on 09.07.16.
 */
public class ItemPresenterImpl implements ItemPresenter {

    protected ItemView view;
    protected MainRepository repository;

    public ItemPresenterImpl(MainRepository mainRepository){
        this.repository = mainRepository;
    }

    @Override
    public void setView(ItemView view, int position) {
        this.view = view;

        loadDeck(getDeckList().get(position));
    }

    @Override
    public void loadDeck(Deck deck) {
        //Consult database
        //OnSucess call show content
        //OnError call show error
        if(view == null){
            throw new ViewNotFoundException();
        }

        if(deck == null){
            view.showError();
        }else{
            view.displayDeckName(deck.getName());
            view.displayDeckImage(deck.getImage());
            view.displayDeckNumberOfCards(deck.getNumberOfCards());
        }
    }

    @Override
    public void deleteItemById(int id) {
        repository.deleteDeck(id);
        view.displayDeletedItemDialog();
    }

    @Override
    public List<Deck> getDeckList() {
        return repository.getAllDecks();
    }

}
