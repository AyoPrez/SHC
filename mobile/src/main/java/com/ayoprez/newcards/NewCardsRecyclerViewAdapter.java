package com.ayoprez.newcards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayoprez.speechhelpcards.R;

import java.util.ArrayList;

/**
 * Created by AyoPrez on 8/08/15.
 */

public class NewCardsRecyclerViewAdapter extends RecyclerView.Adapter<NewCardsViewHolder> {

    ArrayList<String> cardsList;

    public NewCardsRecyclerViewAdapter(ArrayList<String> textList){
        cardsList = new ArrayList<>();
        cardsList = textList;
    }

    @Override
    public NewCardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_newcards, viewGroup, false);
        return new NewCardsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewCardsViewHolder newCardsViewHolder, int i) {
        newCardsViewHolder.editText.setText(cardsList.get(i));
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    public void setItemCount(){
        cardsList.add(cardsList.get(0));
        notifyDataSetChanged();
    }
}
