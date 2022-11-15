package com.example.mushafconsolidated.Entities;

import android.text.SpannableString;

public class MousufSifa {
    int surah;
    int ayah;
    int wordno;
    int startindex;
    int endindex;
    int wordfrom, wordto;
    SpannableString verse;
    String translations;
    String phrasetype;
    int disconnected;
    String comment;

    public MousufSifa(int surah, int ayah, int startindex, int endindex, int wordfrom, int wordto, int disconnected, String comment) {
        this.surah = surah;
        this.ayah = ayah;
        this.startindex = startindex;
        this.endindex = endindex;
        this.wordfrom = wordfrom;
        this.wordto = wordto;
        this.disconnected = disconnected;
        this.comment = comment;
    }

    public MousufSifa(int surah, int ayah, int wordno, int startindex, int endindex, SpannableString verse, String translations, String phrasetype, int disconnected, String comment) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.startindex = startindex;
        this.endindex = endindex;
        this.verse = verse;
        this.translations = translations;
        this.phrasetype = phrasetype;
        this.disconnected = disconnected;
        this.comment = comment;
    }

    public MousufSifa(int surah, int ayah, int wordno, int startindex, int endindex, int disconnected, String comment) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.startindex = startindex;
        this.endindex = endindex;
        this.disconnected = disconnected;
        this.comment = comment;
    }

    public MousufSifa() {
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

    public SpannableString getVerse() {
        return verse;
    }

    public void setVerse(SpannableString verse) {
        this.verse = verse;
    }

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
    }

    public String getPhrasetype() {
        return phrasetype;
    }

    public void setPhrasetype(String phrasetype) {
        this.phrasetype = phrasetype;
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
}
