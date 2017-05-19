package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.ui.activity.HelperCardsView;

/**
 * Created by ayo on 16.07.16.
 */
public interface HelperCardsPresenter {

    void setView(HelperCardsView view);
    void loadCardsTexts(int id);
    void pushedMoreButton();
    void pushedLessButton();
    void goBackToLastCard();

}
