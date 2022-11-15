package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "mutlaqword")
public class MafoolMutlaqEnt {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private String word;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public MafoolMutlaqEnt(int surah, int ayah, int wordno, @NonNull String word, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.word = word;
        this.id = id;
    }

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
}