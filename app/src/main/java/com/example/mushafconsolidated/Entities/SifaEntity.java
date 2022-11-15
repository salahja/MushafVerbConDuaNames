package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "sifa")
public class SifaEntity {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private int startindex;
    @NonNull
    private int endindex;
    @NonNull
    private String phrasetype;
    @NonNull
    private int ismousufconnected;
    private String comment;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public SifaEntity(int surah, int ayah, int wordno, int startindex, int endindex, @NonNull String phrasetype, int ismousufconnected, String comment, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.startindex = startindex;
        this.endindex = endindex;
        this.phrasetype = phrasetype;
        this.ismousufconnected = ismousufconnected;
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

    public int getWordno() {
        return wordno;
    }

    public void setWordno(int wordno) {
        this.wordno = wordno;
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

    @NonNull
    public String getPhrasetype() {
        return phrasetype;
    }

    public void setPhrasetype(@NonNull String phrasetype) {
        this.phrasetype = phrasetype;
    }

    public int getIsmousufconnected() {
        return ismousufconnected;
    }

    public void setIsmousufconnected(int ismousufconnected) {
        this.ismousufconnected = ismousufconnected;
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



