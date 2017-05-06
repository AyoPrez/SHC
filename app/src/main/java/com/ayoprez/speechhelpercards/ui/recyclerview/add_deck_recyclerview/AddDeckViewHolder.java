package com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayoprez.speechhelpercards.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ayo on 16.07.16.
 */
public class AddDeckViewHolder extends RecyclerView.ViewHolder implements AddDeckItemView {
    private static final String TAG = AddDeckViewHolder.class.getSimpleName();

    @BindView(R.id.et_addDeck)
    EditText tvAddDeck;

    public AddDeckViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void displayText(String text) {

    }

    @Override
    public String getText(final int position){

        return tvAddDeck.getText().toString();
    }
}
