package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "newmudhaf")
public class NewMudhafEntity {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int startindex;
    @NonNull
    private int endindex;
    @NonNull
    private int wordfrom;
    @NonNull
    private int wordto;
    @NonNull
    private int disconnected;
    private String comment;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public NewMudhafEntity(int surah, int ayah, int startindex, int endindex, int wordfrom, int wordto, int disconnected, String comment, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.startindex = startindex;
        this.endindex = endindex;
        this.wordfrom = wordfrom;
        this.wordto = wordto;
        this.disconnected = disconnected;
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

    public int getStartindex() {
        return startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }

    public int getEndindex() {
        return endindex;
    }

    public void setEndindex(int endindex) {
        this.endindex = endindex;
    }

    public int getWordfrom() {
        return wordfrom;
    }

    public void setWordfrom(int wordfrom) {
        this.wordfrom = wordfrom;
    }

    public int getWordto() {
        return wordto;
    }

    public void setWordto(int wordto) {
        this.wordto = wordto;
    }

    public int getDisconnected() {
        return disconnected;
    }

    public void setDisconnected(int disconnected) {
        this.disconnected = disconnected;
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



