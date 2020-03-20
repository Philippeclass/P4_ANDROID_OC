package com.philippe.mareu.model;

import androidx.annotation.NonNull;

public class Place {



    private String mName;
    private  String mcolor;
    private int i;
    private String peach;
    private String mario;
    private  String luigi;


    /**
     * Construtor

     * @param name
     */
    public Place(String name, String color) {
        this.mName = name;
        this.mcolor = color;
    }

    @NonNull
    @Override
    public String toString() {
        return mName;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getColor() {
        return this.mcolor;
    }

    public void setColor(String color) {
        this.mcolor = color;
    }
}
