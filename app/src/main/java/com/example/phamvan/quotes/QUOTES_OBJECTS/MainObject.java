package com.example.phamvan.quotes.QUOTES_OBJECTS;

/**
 * Created by PhamVan on 1/27/2017.
 */
public class MainObject {
    private int srcDrawableImTopic;
    private String tvNameTopic;
    public MainObject(int imTopic,String tvNameTopic) {
        this.srcDrawableImTopic = imTopic;
        this.tvNameTopic = tvNameTopic;
    }
    public void setImageIDTopic(int imTopic) {
        this.srcDrawableImTopic = imTopic;
    }
    public int getImageIDTopic(){
        return srcDrawableImTopic;
    }
    public void setTvNameTopic(String tvNameTopic) {
        this.tvNameTopic = tvNameTopic;
    }
    public String getTvNameTopic(){
        return tvNameTopic;
    }
}
