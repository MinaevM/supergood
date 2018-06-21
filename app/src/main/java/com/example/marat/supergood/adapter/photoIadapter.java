package com.example.marat.supergood.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marat.supergood.R;
import com.example.marat.supergood.activity.LogoActivity;
//import com.example.marat.supergood.activity.photoActivityI;

import java.util.ArrayList;

public class photoIadapter extends RecyclerView.Adapter<photoIadapter.ViewHolder> {

    private Context context;
    private Intent intent;

    private ArrayList<String> mDataset;
    private ArrayList<String> mDataset1;
    private ArrayList<String> mDataset2;
    private ArrayList<String> mDataset3;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView, mTextView1, mTextView2;
        public Intent intent;
        public String url;

        public ViewHolder(View v) {
            super(v);
        //    mTextView =  v.findViewById(R.id.textView20);
            mTextView1 =  v.findViewById(R.id.textView71);
          //  mTextView2 =  v.findViewById(R.id.textView22);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            url = String.valueOf(getAdapterPosition());
            intent = new Intent(view.getContext(), LogoActivity.class);
            intent.putExtra("pos", url);
            view.getContext().startActivity(intent);
        }
    }

    public photoIadapter(Context context, ArrayList<String> dataset, ArrayList<String> dataset2, ArrayList<String> dataset3,
                         ArrayList<String> dataset4) {
        this.context = context;
        mDataset = dataset;
        mDataset1 = dataset2;
        mDataset2 = dataset3;
        mDataset3 = dataset4;
    }

    @Override
    public photoIadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

      //  holder.mTextView.setText(mDataset1.get(position));
        holder.mTextView1.setText(mDataset.get(position));
     //   holder.mTextView2.setText(mDataset2.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
