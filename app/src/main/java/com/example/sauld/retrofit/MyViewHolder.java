package com.example.sauld.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sauld on 28/10/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView label;
    TextView desc;
    ImageView mImageView;
    public MyViewHolder(View itemView) {
        super(itemView);
        label = itemView.findViewById(R.id.prio);
        desc = itemView.findViewById(R.id.desc);
        mImageView= itemView.findViewById(R.id.imageview);
    }
}
