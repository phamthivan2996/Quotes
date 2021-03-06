package com.example.phamvan.quotes.QUOTES_DB;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "USER_NOTE".
 */
@Entity
public class UserNote {

    @Id(autoincrement = true)
    private Long id;
    private String sentence;

    @Generated
    public UserNote() {
    }

    public UserNote(Long id) {
        this.id = id;
    }

    @Generated
    public UserNote(Long id, String sentence) {
        this.id = id;
        this.sentence = sentence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

}
