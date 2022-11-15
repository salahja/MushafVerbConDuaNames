package com.example.mushafconsolidated.Entities;

import android.text.SpannableStringBuilder;

import androidx.room.Ignore;
//primaryKeys ={"translation_id","verse_id"}

public class SifaEntityPojo {
    private int surah;
    private int ayah;
    private int wordno;
    private int startindex;
    private int endindex;
    private String phrasetype;
    private String qurantext;
    @Ignore
    private SpannableStringBuilder spannedVerse;
    private String translation;

    public SifaEntityPojo(int surah, int ayah, int wordno, int startindex, int endindex, String phrasetype, String qurantext, String translation) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.startindex = startindex;
        this.endindex = endindex;
        this.phrasetype = phrasetype;
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

    public String getPhrasetype() {
        return phrasetype;
    }

    public void setPhrasetype(String phrasetype) {
        this.phrasetype = phrasetype;
    }

    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(String qurantext) {
        this.qurantext = qurantext;
    }

    public SpannableStringBuilder getSpannedVerse() {
        return spannedVerse;
    }

    public void setSpannedVerse(SpannableStringBuilder spannedVerse) {
        this.spannedVerse = spannedVerse;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}