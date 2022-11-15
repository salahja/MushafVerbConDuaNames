package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "jumlahaliy")
public class HalEnt {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int status;
    @NonNull
    private String text;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public HalEnt(int surah, int ayah, int status, @NonNull String text, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.status = status;
        this.text = text;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}