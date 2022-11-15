package com.example.mushafconsolidated.Entities;

import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Ignore;
//primaryKeys ={"translation_id","verse_id"}

public class TameezPojoList {
    @Ignore
    SpannableStringBuilder spannedverse;
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private String word;
    private String qurantext;
    private String translation;

    public TameezPojoList(int surah, int ayah, int wordno, @NonNull String word, String qurantext, String translation) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.word = word;
        this.qurantext = qurantext;
        this.translation = translation;
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
}