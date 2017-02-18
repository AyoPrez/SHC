package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.activity.HelperCardsView;

/**
 * Created by ayo on 16.07.16.
 */
public class HelperCardsPresenterImpl implements HelperCardsPresenter{
    private static final String TAG = HelperCardsPresenterImpl.class.getSimpleName();

    protected MainRepository mainRepository;
    protected HelperCardsView helperCardsView;

    public HelperCardsPresenterImpl(MainRepository repository){
        this.mainRepository = repository;
    }

    @Override
    public void setView(HelperCardsView view) {
        this.helperCardsView = view;
    }

    @Override
    public void loadCardsTexts(int id) {
        if (helperCardsView == null){
            throw  new ViewNotFoundException();
        }

        helperCardsView.showText(mainRepository.getAllDeckCardsText(id));
    }

    @Override
    public void pushedMoreButton() {
        helperCardsView.increaseTextSize();
    }

    @Override
    public void pushedLessButton() {
        helperCardsView.decreaseTextSize();
    }
}
