package com.example.mushafconsolidated.Entities;

import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "kana")
public class KanaPOJO {
    @Ignore
    SpannableStringBuilder spannedverse;
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
    private int mahdoof;
    private String comment;
    private String qurantext;
    private String translation;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public KanaPOJO(int surah, int ayah, int indexstart, int indexend, int khabarstart, int khabarend, int ismkanastart, int ismkanaend, int mahdoof, String comment, String qurantext, String translation, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.indexstart = indexstart;
        this.indexend = indexend;
        this.khabarstart = khabarstart;
        this.khabarend = khabarend;
        this.ismkanastart = ismkanastart;
        this.ismkanaend = ismkanaend;
        this.mahdoof = mahdoof;
        this.comment = comment;
        this.qurantext = qurantext;
        this.translation = translation;
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

    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(String qurantext) {
        this.qurantext = qurantext;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public SpannableStringBuilder getSpannedverse() {
        return spannedverse;
    }

    public void setSpannedverse(SpannableStringBuilder spannedverse) {
        this.spannedverse = spannedverse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}