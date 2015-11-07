package com.ayoprez.speechhelpcards;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AyoPrez on 3/08/15.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);

        this.textView = (TextView) itemView.findViewById(R.id.textView_recyclerItem);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageView_recyclerItem);
    }
}
