package com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview;

import com.ayoprez.speechhelpercards.R;

import java.util.ArrayList;

/**
 * Created by ayo on 16.07.16.
 */
public class AddDeckItemPresenterImpl implements AddDeckItemPresenter {
    private static final String TAG = AddDeckItemPresenterImpl.class.getSimpleName();

    AddDeckItemView view;
    ArrayList<String> cardsList = new ArrayList<>();

    @Override
    public void setView(AddDeckItemView itemView) {
        this.view = itemView;
    }

    @Override
    public void loadPlaceHolder(AddDeckImageView view) {
        view.displayPlaceholder(R.drawable.ic_add_black_48dp);
    }

    @Override
    public String getTextByPosition(int position){
        return view.getText(position);
    }

    @Override
    public int getTotalCards() { ///This is doing nothing
        return cardsList.size();
    }
}
