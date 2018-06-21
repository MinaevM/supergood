package com.example.marat.supergood.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marat.supergood.R;
import com.example.marat.supergood.adapter.onasadapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class onas extends Fragment {


    int i = 0,q = 0,w = 0,e = 0,r = 0;
    private Context mservContext;
    private Intent intent;

    private ArrayList onas = new ArrayList();

    //private ArrayList<String> newslink = new ArrayList<String>();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private onasadapter mAdapter;

    class MyTask extends AsyncTask<Void, Void, Void> {

        String title;
        @Override
        protected Void doInBackground(Void... params) {


            try {
                Document doc = Jsoup.connect("http://www.neftcity.ru/index.php?dn=article&to=art&id=1").get();

                Element newsTab = doc.select("div[class=article_block_read]").first();
                Elements arts = newsTab.select("div[class=article_block_read]");

                Iterator<Element> iterator = arts.listIterator();


                while (iterator.hasNext()) {
                    Element element = iterator.next();
                    String value = element.text();
                    title = value;
                    onas.add(i, this.title);
                }
            }catch(IOException e){
                e.printStackTrace();
                title = "Error";
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(mservContext);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new onasadapter(mservContext, onas);
            mRecyclerView.setAdapter(mAdapter);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View q=inflater.inflate(R.layout.onas, container, false);

        //intent = new Intent(getActivity(), newsActivityURL.class);
        mservContext = getActivity();
        mRecyclerView = (RecyclerView) q.findViewById(R.id.my_recycler_onas);

        MyTask mt = new MyTask();
        mt.execute();

        return q;
    }
}