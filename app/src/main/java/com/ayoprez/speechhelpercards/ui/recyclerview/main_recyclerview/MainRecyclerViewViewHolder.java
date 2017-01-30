package com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.ui.Utils;
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
        if(resource != 0) {
            Picasso.with(context).load(resource).into(ivRecyclerItem);
        }else{
            Log.e("LOG_TAG", "Resource was zero");
        }
    }

    @Override
    public void displayDeckNumberOfCards(String number) {
        tvNumberRecyclerItem.setText(number);
    }

    @Override
    public void displayDeletedItemDialog() {
        Utils.showAlertDialog(context, "Item deleted", "You have deleted the deck sucessfully", "Ok");
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
