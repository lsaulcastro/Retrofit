package com.example.sauld.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by sauld on 28/10/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<ItemsModelo> arrayList;
    Context context;
    public MyAdapter(List<ItemsModelo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.label.setText(arrayList.get( position).getName());
        holder.desc.setText(arrayList.get( position).getDescription());
        Glide.with(context)
                .load(arrayList.get(position).getImageUrl())
                .into((holder.mImageView)   );


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
