package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "shart")
public class ShartEntity {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int indexstart;
    @NonNull
    private int indexend;
    @NonNull
    private int shartindexstart;
    @NonNull
    private int shartindexend;
    @NonNull
    private int jawabshartindexstart;
    @NonNull
    private int jawabshartindexend;
    @NonNull
    private String sharttype;
    private String comment;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public ShartEntity(int surah, int ayah, int indexstart, int indexend, int shartindexstart, int shartindexend, int jawabshartindexstart, int jawabshartindexend, @NonNull String sharttype, String comment, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.indexstart = indexstart;
        this.indexend = indexend;
        this.shartindexstart = shartindexstart;
        this.shartindexend = shartindexend;
        this.jawabshartindexstart = jawabshartindexstart;
        this.jawabshartindexend = jawabshartindexend;
        this.sharttype = sharttype;
        this.comment = comment;
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

    public int getIndexstart() {
        return indexstart;
    }

    public void setIndexstart(int indexstart) {
        this.indexstart = indexstart;
    }

    public int getIndexend() {
        return indexend;
    }

    public void setIndexend(int indexend) {
        this.indexend = indexend;
    }

    public int getShartindexstart() {
        return shartindexstart;
    }

    public void setShartindexstart(int shartindexstart) {
        this.shartindexstart = shartindexstart;
    }

    public int getShartindexend() {
        return shartindexend;
    }

    public void setShartindexend(int shartindexend) {
        this.shartindexend = shartindexend;
    }

    public int getJawabshartindexstart() {
        return jawabshartindexstart;
    }

    public void setJawabshartindexstart(int jawabshartindexstart) {
        this.jawabshartindexstart = jawabshartindexstart;
    }

    public int getJawabshartindexend() {
        return jawabshartindexend;
    }

    public void setJawabshartindexend(int jawabshartindexend) {
        this.jawabshartindexend = jawabshartindexend;
    }

    @NonNull
    public String getSharttype() {
        return sharttype;
    }

    public void setSharttype(@NonNull String sharttype) {
        this.sharttype = sharttype;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}