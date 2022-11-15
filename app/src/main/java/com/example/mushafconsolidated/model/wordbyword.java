package com.example.mushafconsolidated.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class wordbyword {
    private int word_no;
    private int chapter_no;
    private int verse_no;
    private String root;
    private String translation;
    private int verse_tbl_id;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int word_by_word_translationID;
    private String word;

    @Ignore
    public wordbyword(int word_no, int chapter_no, int verse_no, String root, String translation, int verse_tbl_id, int word_by_word_translationID, String word) {
        this.word_no = word_no;
        this.chapter_no = chapter_no;
        this.verse_no = verse_no;
        this.root = root;
        this.translation = translation;
        this.verse_tbl_id = verse_tbl_id;
        this.word_by_word_translationID = word_by_word_translationID;
        this.word = word;
    }

    public wordbyword(int word_no) {
        this.word_no = word_no;
    }

    public int getWord_no() {
        return word_no;
    }

    public void setWord_no(int word_no) {
        this.word_no = word_no;
    }

    public int getChapter_no() {
        return chapter_no;
    }

    public void setChapter_no(int chapter_no) {
        this.chapter_no = chapter_no;
    }

    public int getVerse_no() {
        return verse_no;
    }

    public void setVerse_no(int verse_no) {
        this.verse_no = verse_no;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getVerse_tbl_id() {
        return verse_tbl_id;
    }

    public void setVerse_tbl_id(int verse_tbl_id) {
        this.verse_tbl_id = verse_tbl_id;
    }

    public int getWord_by_word_translationID() {
        return word_by_word_translationID;
    }

    public void setWord_by_word_translationID(int word_by_word_translationID) {
        this.word_by_word_translationID = word_by_word_translationID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
