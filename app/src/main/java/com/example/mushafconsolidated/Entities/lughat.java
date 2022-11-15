package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "onlylugat")
public class lughat {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private String surahname;
    @NonNull
    private int wordno;
    @NonNull
    private String rootword;
    private String hansweir;
    @NonNull
    private String arabicword;
    @NonNull
    private String ur_lughat;
    @NonNull
    private String meaning;
    @NonNull
    private String letter;
    @NonNull
    private String en_lughat;
    private String comments;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public lughat(int surah, int ayah, @NonNull String surahname, int wordno, @NonNull String rootword, String hansweir, @NonNull String arabicword, @NonNull String ur_lughat, @NonNull String meaning, @NonNull String letter, @NonNull String en_lughat, String comments, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.surahname = surahname;
        this.wordno = wordno;
        this.rootword = rootword;
        this.hansweir = hansweir;
        this.arabicword = arabicword;
        this.ur_lughat = ur_lughat;
        this.meaning = meaning;
        this.letter = letter;
        this.en_lughat = en_lughat;
        this.comments = comments;
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

    @NonNull
    public String getSurahname() {
        return surahname;
    }

    public void setSurahname(@NonNull String surahname) {
        this.surahname = surahname;
    }

    public int getWordno() {
        return wordno;
    }

    public void setWordno(int wordno) {
        this.wordno = wordno;
    }

    @NonNull
    public String getRootword() {
        return rootword;
    }

    public void setRootword(@NonNull String rootword) {
        this.rootword = rootword;
    }

    public String getHansweir() {
        return hansweir;
    }

    public void setHansweir(String hansweir) {
        this.hansweir = hansweir;
    }

    @NonNull
    public String getArabicword() {
        return arabicword;
    }

    public void setArabicword(@NonNull String arabicword) {
        this.arabicword = arabicword;
    }

    @NonNull
    public String getUr_lughat() {
        return ur_lughat;
    }

    public void setUr_lughat(@NonNull String ur_lughat) {
        this.ur_lughat = ur_lughat;
    }

    @NonNull
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(@NonNull String meaning) {
        this.meaning = meaning;
    }

    @NonNull
    public String getLetter() {
        return letter;
    }

    public void setLetter(@NonNull String letter) {
        this.letter = letter;
    }

    @NonNull
    public String getEn_lughat() {
        return en_lughat;
    }

    public void setEn_lughat(@NonNull String en_lughat) {
        this.en_lughat = en_lughat;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}