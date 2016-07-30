package com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ayoprez.speechhelpercards.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ayo on 24.07.16.
 */
public class AddDeckImageViewHolder  extends RecyclerView.ViewHolder implements AddDeckImageView  {
    private static final String TAG = AddDeckImageViewHolder.class.getSimpleName();

    private Context context;

    @BindView(R.id.iv_addDeck_placeholder)
    ImageView ivPlaceholder;

    @BindView(R.id.ll_placeholder)
    LinearLayout llPlaceholder;

    public AddDeckImageViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void displayPlaceholder(int resource) {
        Picasso.with(context).load(resource).fit().into(ivPlaceholder);
    }

}
