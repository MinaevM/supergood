package com.example.marat.supergood.activity;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.example.marat.supergood.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class newsActivityI extends AppCompatActivity {
    private Context context;
    private android.widget.ImageView ImageView;
    int posint;
    String posclick,url,url1;
    private Intent intent;
    Spanned url2;

    private TextView Text;
    private ArrayList<String> newslink = new ArrayList<String>();
    int i = 0;

    class MyTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect("http://www.neftcity.ru/news").get();

                Element content = doc.select("div[id=content]").first();
                Elements news = content.select("div.news_items_right");
                Elements newsA = news.select("a");

                Iterator<Element> iterator2 = newsA.listIterator();

                while (iterator2.hasNext()) {
                    Element element2 = iterator2.next();
                    String url1 = element2.absUrl("href");

                    newslink.add(i, url1);
                    i++;
                }
                posclick = intent.getStringExtra("pos");
                posint = Integer.valueOf(posclick);
                url = newslink.get(posint);

                Document doc1 = Jsoup.connect(url).get();
                Element LogoTab = doc1.select("a").first();
                Element TextTab = doc1.select("div.news_block_read").first();
                Element img = LogoTab.select("img").first();


                url1 = img.absUrl("src");
                url2 = Html.fromHtml(TextTab.html());

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


            Picasso.get() //передаем контекст приложения
                    .load(url1) //адрес изображения
                   .into(ImageView); //ссылка на ImageView

            Text.setText(url2);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfull);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                 findViewById(R.id.collapsing_toolbar);
        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent = getIntent();
        Text = findViewById(R.id.post);
        ImageView = findViewById(R.id.image);


        MyTask mt = new MyTask();
        mt.execute();
    }
}

