package com.example.phamvan.quotes.QUOTES_OBJECTS;

import java.io.Serializable;

/**
 * Created by PhamVan on 2/10/2017.
 */
public class QuotesObject implements Serializable {
    private Long id;
    private String author;
    public String sentence;
    private String vietnamese;

    public QuotesObject() {
    }

    public QuotesObject(Long id) {
        this.id = id;
    }

    public QuotesObject(Long id, String author, String sentence, String vietnamese) {
        this.id = id;
        this.author = author;
        this.sentence = sentence;
        this.vietnamese = vietnamese;
    }

    public QuotesObject(Long id, String sentence) {
        this.id = id;
        this.sentence = sentence;
    }

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
