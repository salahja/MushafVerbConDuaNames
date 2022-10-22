package com.example.mushafconsolidated.Entities;


import android.content.Context;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
//primaryKeys ={"translation_id","verse_id"}


@Entity(tableName = "tameez")
public class TameezEnt {



    @NonNull
    private int     surah ;
    @NonNull
    private int     ayah;
    @NonNull
    private int      wordno  ;


    @NonNull
    private String    word ;

    @PrimaryKey(autoGenerate = true)
    @NonNull

    private int id;

    public int getSurah() {
        return surah;
    }

    public void setSurah(int surah) {
        this.surah = surah;
    }

    public int getAyah() {
        return ayah;
    }

    public void setAyah(int ayah) {
        this.ayah = ayah;
    }

    public int getWordno() {
        return wordno;
    }

    public void setWordno(int wordno) {
        this.wordno = wordno;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TameezEnt(int surah, int ayah, int wordno, @NonNull String word, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.word = word;
        this.id = id;
    }
}