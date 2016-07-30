package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayoprez.speechhelpercards.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ayo on 09.07.16.
 */
public class MainRecyclerViewViewHolder extends RecyclerView.ViewHolder implements ItemView {

    private Context context;

    @BindView(R.id.item_recyclerView)
    LinearLayout llItem;

    @BindView(R.id.imageView_recyclerItem)
    ImageView ivRecyclerItem;

    @BindView(R.id.textView_NumberRecyclerItem)
    TextView tvNumberRecyclerItem;

    @BindView(R.id.textView_recyclerItem)
    TextView tvRecyclerItem;

    public MainRecyclerViewViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void displayDeckName(String name) {
        tvRecyclerItem.setText(name);
    }

    @Override
    public void displayDeckImage(int resource) {
        Picasso.with(context).load(resource).into(ivRecyclerItem);
    }

    @Override
    public void displayDeckNumberOfCards(String number) {
        tvNumberRecyclerItem.setText(number);
    }

    @Override
    public void showError() {
        //Show error image
    }

    @Override
    public int getItemPosition() {
        return getAdapterPosition();
    }

}
