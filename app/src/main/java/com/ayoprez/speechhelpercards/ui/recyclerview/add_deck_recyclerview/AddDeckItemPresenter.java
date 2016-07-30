package com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview;

import android.view.View;

/**
 * Created by ayo on 16.07.16.
 */
public interface AddDeckItemPresenter {
    void setView(AddDeckItemView view);
    void loadPlaceHolder(AddDeckImageView view);
    String getTextByPosition(int position);

    int getTotalCards();
}
