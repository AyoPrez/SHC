package com.ayoprez.newcards;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.ayoprez.speechhelpcards.R;

/**
 * Created by AyoPrez on 8/08/15.
 */
public class NewCardsViewHolder extends RecyclerView.ViewHolder {

    EditText editText;

    public NewCardsViewHolder(View itemView) {
        super(itemView);
        editText = (EditText) itemView.findViewById(R.id.editText_newcards);
    }
}

