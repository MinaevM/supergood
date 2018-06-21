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

public class grafikadapter extends RecyclerView.Adapter<grafikadapter.ViewHolder> {

private Context context;
private Intent intent;

private ArrayList<String> mDataset;
private ArrayList<String> mDataset1;
private ArrayList<String> mDataset2;
private ArrayList<String> mDataset3;


public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView mTextView, mTextView1, mTextView2, mTextView3;
    public Intent intent;
    public String url;


    public ViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.textView31);
        mTextView1 = (TextView) v.findViewById(R.id.textView32);
        mTextView2 = (TextView) v.findViewById(R.id.textView33);
       mTextView3 = (TextView) v.findViewById(R.id.textView34);
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        //url = String.valueOf(getAdapterPosition());
        //intent = new Intent(view.getContext(), newsActivityURL.class);
        //intent.putExtra("pos", url);
        //view.getContext().startActivity(intent);
    }
}

    public grafikadapter(Context context, ArrayList<String> dataset, ArrayList<String> dataset2, ArrayList<String> dataset3,
                         ArrayList<String> dataset4) {
        this.context = context;
        mDataset = dataset;
        mDataset1 = dataset2;
        mDataset2 = dataset3;
        mDataset3 = dataset4;
    }

    @Override
    public grafikadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grafikres, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mTextView.setText(mDataset.get(position));
        holder.mTextView1.setText(mDataset1.get(position));
        holder.mTextView2.setText(mDataset2.get(position));
        holder.mTextView3.setText(mDataset3.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
