package com.example.marat.supergood.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marat.supergood.R;

import java.util.ArrayList;

public class onasadapter extends RecyclerView.Adapter<onasadapter.ViewHolder> {

private Context context;
private Intent intent;

private ArrayList<String> mDataset;



public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView mTextView;
    public Intent intent;
    public String url;


    public ViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.textView55);

        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

    }
}

    public onasadapter(Context context, ArrayList<String> dataset) {
        this.context = context;
        mDataset = dataset;

    }

    @Override
    public onasadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.onasres, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mTextView.setText(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
