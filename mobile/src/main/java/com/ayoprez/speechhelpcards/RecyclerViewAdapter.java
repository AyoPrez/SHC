package com.ayoprez.speechhelpcards;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by AyoPrez on 3/08/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<?> mDataSet;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageView.setImageResource(R.drawable.cards_icon);
        holder.textView.setText(R.string.app_name);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBehavior(v);
            }
        });
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickBehavior(v, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private void onClickBehavior(View v){
        Intent intent = new Intent(v.getContext(), CardsActivity.class);
        v.getContext().startActivity(intent);
    }

    private void onLongClickBehavior(View v, int position){
        removeAt(position);
    }

    //TODO complete
    public void removeAt(int position) {
        mDataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataSet.size());
    }

}