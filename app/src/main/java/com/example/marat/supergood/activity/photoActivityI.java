package com.example.marat.supergood.activity;

/*
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.marat.supergood.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class photoActivityI extends AppCompatActivity {
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
                Document doc = Jsoup.connect("http://neftcity.ru/index.php?dn=photos").get();

                Element newsTab = doc.select("table[bgcolor=#ffffff]>tbody").first();
                Elements arts = newsTab.select("tr>td[align=left]>b");
                Elements arts2 = arts.select("a");

                Iterator<Element> iterator2 = arts2.listIterator();

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
                Element newsTab1 = doc1.select("a[class=group]").first();
                Element newsTab2 = doc1.select("div[class=simpletitle]").first();
           //     Element newsTab3 = doc1.select("table").first();
                Element arts1 = newsTab1.select("img").first();


                url1 = arts1.absUrl("src");
                url2 = Html.fromHtml(newsTab2.html());
              //  url3 = Html.fromHtml(newsTab3.html());

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
                //    .placeholder(R.drawable.ic_loop_black_24dp)
                 //   .error(R.drawable.adm)
                    .into(ImageView); //ссылка на ImageView

            Text.setText(url2);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photofull);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                 findViewById(R.id.collapsing_toolbar);

        context = this;



        intent = getIntent();
        Text = findViewById(R.id.post);
        ImageView = findViewById(R.id.image);


        MyTask mt = new MyTask();
        mt.execute();
    }
}

*/