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
import com.example.marat.supergood.activity.newsActivityK;
import com.example.marat.supergood.adapter.newsIadapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class newsK extends Fragment {

    int i = 0;
    private Context mnewsContext;
    private Intent intent;

    private ArrayList data = new ArrayList();
    private ArrayList gnews = new ArrayList();
    private ArrayList news = new ArrayList();
    private ArrayList<String> newslink = new ArrayList<String>();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private newsIadapter mAdapter;

    class MyTask extends AsyncTask<Void, Void, Void> {

        String newstitle,
                pubDatetitle,
                newselemtitle;
        @Override
        protected Void doInBackground(Void... params) {


            try {
                Document doc = Jsoup.connect("https://www.neft-kultura.com/feed.xml").get();

                Element newselem = doc.select("item").first();
                Elements title = newselem.select("title");
                Elements pubDate = newselem.select("pubDate");
                Elements textelem = newselem.select("description");

                Iterator<Element> iterator = title.listIterator();
                Iterator<Element> iterator1 = pubDate.listIterator();
                Iterator<Element> iterator2 = textelem.listIterator();

                while (iterator.hasNext()) {
                    Element element = iterator.next();
                    Element element1 = iterator1.next();
                    Element element2 = iterator2.next();
                    String title1 = element.text();
                    String pubDate1 = element1.text();
                    String textelem1 = element2.text();
                    this.newstitle = title1;
                    this.newselemtitle = pubDate1;
                    pubDatetitle = textelem1;
                    data.add(i, this.newstitle);
                    gnews.add(i, this.newselemtitle);
                    news.add(i, pubDatetitle);
                    i++;
                }
            }catch(IOException e){
                e.printStackTrace();
                newstitle = "Error";
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(mnewsContext);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new newsIadapter(mnewsContext, data,gnews, news, newslink);
            mRecyclerView.setAdapter(mAdapter);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View q=inflater.inflate(R.layout.newsktab, container, false);

        intent = new Intent(getActivity(), newsActivityK.class);
        mnewsContext = getActivity();
        mRecyclerView = q.findViewById(R.id.my_recycler_newsk);

        MyTask mt = new MyTask();
        mt.execute();

        return q;
    }
}
