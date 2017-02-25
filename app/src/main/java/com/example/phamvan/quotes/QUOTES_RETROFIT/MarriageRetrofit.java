
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarriageRetrofit {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("sentence")
    @Expose
    private String sentence;
    @SerializedName("vietnamese")
    @Expose
    private String vietnamese;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

}
