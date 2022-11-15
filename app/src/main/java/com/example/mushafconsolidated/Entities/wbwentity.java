package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wbw")
public class wbwentity {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private int wordcount;
    private String araone;
    private String aratwo;
    private String arathree;
    private String arafour;
    private String arafive;
    @NonNull
    private String en;
    @NonNull
    private String bn;
    @NonNull
    private String in;
    private String ur;
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private int juz;
    public wbwentity(int surah, int ayah, int wordno, int wordcount, String araone, String aratwo, String arathree, String arafour, String arafive, @NonNull String en, @NonNull String bn, @NonNull String in,
                     String ur, int id, int juz) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.araone = araone;
        this.aratwo = aratwo;
        this.arathree = arathree;
        this.arafour = arafour;
        this.arafive = arafive;
        this.en = en;
        this.bn = bn;
        this.in = in;
        this.ur = ur;
        this.id = id;
        this.juz = juz;
    }

    @NonNull
    public String getUr() {
        return ur;
    }

    public void setUr(@NonNull String ur) {
        this.ur = ur;
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

    public int getWordcount() {
        return wordcount;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public String getAraone() {
        return araone;
    }

    public void setAraone(String araone) {
        this.araone = araone;
    }

    public String getAratwo() {
        return aratwo;
    }

    public void setAratwo(String aratwo) {
        this.aratwo = aratwo;
    }

    public String getArathree() {
        return arathree;
    }

    public void setArathree(String arathree) {
        this.arathree = arathree;
    }

    public String getArafour() {
        return arafour;
    }

    public void setArafour(String arafour) {
        this.arafour = arafour;
    }

    public String getArafive() {
        return arafive;
    }

    public void setArafive(String arafive) {
        this.arafive = arafive;
    }

    @NonNull
    public String getEn() {
        return en;
    }

    public void setEn(@NonNull String en) {
        this.en = en;
    }

    @NonNull
    public String getBn() {
        return bn;
    }

    public void setBn(@NonNull String bn) {
        this.bn = bn;
    }

    @NonNull
    public String getIn() {
        return in;
    }

    public void setIn(@NonNull String in) {
        this.in = in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }
}
