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
import com.example.marat.supergood.adapter.serveradapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class servis extends Fragment {


    int i = 0,q = 0,w = 0,e = 0;
    private Context mservContext;
    private Intent intent;

    private ArrayList FIO = new ArrayList();
    private ArrayList Dolg = new ArrayList();
    private ArrayList Email = new ArrayList();
   // private ArrayList ir = new ArrayList();
    //private ArrayList<String> newslink = new ArrayList<String>();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private serveradapter mAdapter;

    class MyTask extends AsyncTask<Void, Void, Void> {

        String title;
        @Override
        protected Void doInBackground(Void... params) {


            try {
                Document doc = Jsoup.connect("http://www.neftcity.ru/index.php?dn=article&to=art&id=30").get();

                Element newsTab = doc.select("div[class=text]>table>tbody").first();
                Elements arts = newsTab.select("td");

                Iterator<Element> iterator = arts.listIterator();

                i = 0;
                while (iterator.hasNext()) {
                    Element element = iterator.next();
                    String value = element.text();
                    title = value;
                    i++;
                    if (i == 1) {
                        FIO.add(q, "Ф.И.О.: " + title);
                        q++;
                    }
                    if (i == 2) {
                        Dolg.add(w, "Должность: " + title);
                        w++;
                    }
                    if (i == 3) {
                        Email.add(e, "Телефон / E-mail: " + title);
                        e++;
                        i =0;
                    }
                 /*   if (i == 4) {
                        ir.add(r, "ЮР. ЛИЦО: " + title);
                        r++;
                        i = 0;
                    }*/
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

            mAdapter = new serveradapter(mservContext, FIO, Dolg, Email);
            mRecyclerView.setAdapter(mAdapter);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View q=inflater.inflate(R.layout.servis, container, false);

        //intent = new Intent(getActivity(), newsActivityURL.class);
        mservContext = getActivity();
        mRecyclerView =  q.findViewById(R.id.my_recycler_serv);

        MyTask mt = new MyTask();
        mt.execute();

        return q;
    }
}