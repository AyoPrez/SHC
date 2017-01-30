package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.activity.AddDeckView;

import java.util.ArrayList;

/**
 * Created by ayo on 16.07.16.
 */
public class AddDeckPresenterImpl implements AddDeckPresenter {
    private static final String TAG = AddDeckPresenterImpl.class.getSimpleName();

    private AddDeckView view;
    private MainRepository mainRepository;
    protected ArrayList<String> cardsList = new ArrayList<>();

    public AddDeckPresenterImpl(MainRepository repository){
        this.mainRepository = repository;
    }

    @Override
    public void setView(AddDeckView view) {
        this.view = view;
    }

    @Override
    public void initRecyclerView() {
        if(view == null){
            throw new ViewNotFoundException();
        }
        view.loadAddDeckRecyclerView();
    }

    @Override
    public void saveDeck(Deck deck) {
        mainRepository.saveDeck(deck);

        view.showDeckSavedMessage();
    }
}
