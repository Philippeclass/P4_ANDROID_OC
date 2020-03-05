package com.philippe.mareu.model;

public class Place {


    private int mId;
    private String mName;


    /**
     * Construtor

     * @param id
     * @param name
     */
    public Place(int id, String name) {
        this.mId = id;
        this.mName = name;
    }


    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
