package com.example.phamvan.quotes.QUOTES_DB;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "MAN".
 */
@Entity
public class Man {

    @Id(autoincrement = true)
    private Long id;
    private String author;
    private String sentence;
    private String vietnamese;

    @Generated
    public Man() {
    }

    public Man(Long id) {
        this.id = id;
    }

    @Generated
    public Man(Long id, String author, String sentence, String vietnamese) {
        this.id = id;
        this.author = author;
        this.sentence = sentence;
        this.vietnamese = vietnamese;
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