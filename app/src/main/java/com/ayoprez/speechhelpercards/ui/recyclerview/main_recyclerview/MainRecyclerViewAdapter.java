package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.dependency_inyection.SHCApplication;
import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.activity.HelperCardsActivity;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ayo on 09.07.16.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewViewHolder>{
    private static final String TAG = MainRecyclerViewAdapter.class.getSimpleName();

    private Context context;

    @Inject
    ItemPresenter presenter;

    private ArrayList<Deck> deckList;

    public MainRecyclerViewAdapter(ArrayList<Deck> deck){
        this.deckList = deck;
    }

    @Override
    public MainRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new MainRecyclerViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MainRecyclerViewViewHolder holder, int position) {
        initAdapterComponents();
        presenter.setView(holder);

        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeck(holder.getItemPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return deckList.size();
    }

    public void initAdapterComponents(){
        ((SHCApplication) context.getApplicationContext()).getAppComponent().inject(this);
    }

    private void openDeck(int position){
        Intent intent = new Intent(context, HelperCardsActivity.class);
        intent.putExtra("id", deckList.get(position).getId());
        context.startActivity(intent);
    }

}
