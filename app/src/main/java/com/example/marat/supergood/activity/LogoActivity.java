package com.example.marat.supergood.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.marat.supergood.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogoActivity extends AppCompatActivity {



   private String MY_LOG ="myLog";
   private List<Recipe> mListRecipe =new ArrayList<>();
  //  private Intent intent;
  //  private ArrayList<String> newslink = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        new ParseAllRecipe().execute();
    }

    @SuppressLint("StaticFieldLeak")
    class ParseAllRecipe extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {


            String urlHome = "http://neftcity.ru/index.php?dn=photos&to=cat&id=1&langs=rus&p=1";

            try {

                Document document = Jsoup.connect(urlHome).get();
                Elements els = document.select("div[id=content]");
                Elements pages = els.select("div[class=pages]>a");
                Element page = pages.get(pages.size()-3);
                int count = Integer.parseInt(page.text());

                for (int i = 1; i <= count; i++){

                    String url = "http://neftcity.ru/index.php?dn=photos&to=cat&id=1&langs=rus&p=" + i;
                    itemRecipe(url);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent intent = new Intent(LogoActivity.this,ListRecipeActivity.class);
            intent.putParcelableArrayListExtra("recipe",(ArrayList<? extends Parcelable>) mListRecipe);

          //  intent = getIntent();
            startActivity(intent);

            finish();
        }

        private void itemRecipe(String url) {
            try {
                String imgRecipe, nameRecipe, linkRecipe;
                Document document = Jsoup.connect(url).get();
                //Elements elements = document.select("div[class=news-item-wild-left]" );
                Elements elements = document.select("a[class=group]");
                Elements elements2 = document.select("table[border=0]");

                for (Element element : elements){
                    imgRecipe  = "http://neftcity.ru" + element.select("img").attr("src");

                    nameRecipe = element.select("img").attr("alt");
                    //nameRecipe = element.select("div[class=news-item-wild-title] > a").text();

                    linkRecipe = element.select("div[class=simpletitle] > a").attr("href");

                    Log.d(MY_LOG, imgRecipe+ " "+nameRecipe+" "+" "+ linkRecipe);

                  mListRecipe.add(new Recipe(imgRecipe, nameRecipe, linkRecipe));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }}

