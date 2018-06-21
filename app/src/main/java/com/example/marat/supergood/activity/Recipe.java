package com.example.marat.supergood.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {

    private String mLinkImage;
    private String mNameRecipe;
    private String mLinkPageRecipe;



    public Recipe(String linkImage, String nameRecipe, String linkPageRecipe) {

        mLinkImage = linkImage;
        mNameRecipe = nameRecipe;
        mLinkPageRecipe = linkPageRecipe;
    }

    protected Recipe(Parcel in) {
        String [] data = new String[3];
        in.readStringArray(data);
        mLinkImage =data[0];
        mNameRecipe = data[1];
        mLinkPageRecipe = data[2];

    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getLinkImage() {
        return mLinkImage;
    }

    public void
    setLinkImage(String linkImage) {
        mLinkImage = linkImage;
    }

    public String getNameRecipe() {
        return mNameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        mNameRecipe = nameRecipe;
    }

    public String getLinkPageRecipe() {
        return mLinkPageRecipe;
    }

    public void setLinkPageRecipe(String linkPageRecipe) {
        mLinkPageRecipe = linkPageRecipe;
    }




    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{mLinkImage, mNameRecipe, mLinkPageRecipe});
    }
}
