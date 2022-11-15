package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "newkana")
public class NewKanaEntity {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int indexstart;
    @NonNull
    private int indexend;
    @NonNull
    private int khabarstart;
    @NonNull
    private int khabarend;
    @NonNull
    private int ismkanastart;
    @NonNull
    private int ismkanaend;
    @NonNull
    private int harfwordno;
    @NonNull
    private int ismwordo;
    @NonNull
    private int ismendword;
    @NonNull
    private int khabarstartwordno;
    @NonNull
    private int khabarendwordno;
    @NonNull
    private int mahdoof;
    private String comment;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public NewKanaEntity(int surah, int ayah, int indexstart, int indexend, int khabarstart, int khabarend, int ismkanastart, int ismkanaend, int harfwordno, int ismwordo, int ismendword, int khabarstartwordno, int khabarendwordno, int mahdoof, String comment, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.indexstart = indexstart;
        this.indexend = indexend;
        this.khabarstart = khabarstart;
        this.khabarend = khabarend;
        this.ismkanastart = ismkanastart;
        this.ismkanaend = ismkanaend;
        this.harfwordno = harfwordno;
        this.ismwordo = ismwordo;
        this.ismendword = ismendword;
        this.khabarstartwordno = khabarstartwordno;
        this.khabarendwordno = khabarendwordno;
        this.mahdoof = mahdoof;
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

    public int getKhabarstart() {
        return khabarstart;
    }

    public void setKhabarstart(int khabarstart) {
        this.khabarstart = khabarstart;
    }

    public int getKhabarend() {
        return khabarend;
    }

    public void setKhabarend(int khabarend) {
        this.khabarend = khabarend;
    }

    public int getIsmkanastart() {
        return ismkanastart;
    }

    public void setIsmkanastart(int ismkanastart) {
        this.ismkanastart = ismkanastart;
    }

    public int getIsmkanaend() {
        return ismkanaend;
    }

    public void setIsmkanaend(int ismkanaend) {
        this.ismkanaend = ismkanaend;
    }

    public int getHarfwordno() {
        return harfwordno;
    }

    public void setHarfwordno(int harfwordno) {
        this.harfwordno = harfwordno;
    }

    public int getIsmwordo() {
        return ismwordo;
    }

    public void setIsmwordo(int ismwordo) {
        this.ismwordo = ismwordo;
    }

    public int getIsmendword() {
        return ismendword;
    }

    public void setIsmendword(int ismendword) {
        this.ismendword = ismendword;
    }

    public int getKhabarstartwordno() {
        return khabarstartwordno;
    }

    public void setKhabarstartwordno(int khabarstartwordno) {
        this.khabarstartwordno = khabarstartwordno;
    }

    public int getKhabarendwordno() {
        return khabarendwordno;
    }

    public void setKhabarendwordno(int khabarendwordno) {
        this.khabarendwordno = khabarendwordno;
    }

    public int getMahdoof() {
        return mahdoof;
    }

    public void setMahdoof(int mahdoof) {
        this.mahdoof = mahdoof;
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