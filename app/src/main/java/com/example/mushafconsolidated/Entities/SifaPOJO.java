package com.example.mushafconsolidated.Entities;

import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "sifa")
public class SifaPOJO {
    @Ignore
    SpannableStringBuilder spannedverse;
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
    @NonNull
    private String qurantext;
    @NonNull
    private String translation;

    public SifaPOJO(int surah, int ayah, int wordno, int startindex, int endindex, @NonNull String phrasetype, int ismousufconnected, String comment, int id, @NonNull String qurantext, @NonNull String translation) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.startindex = startindex;
        this.endindex = endindex;
        this.phrasetype = phrasetype;
        this.ismousufconnected = ismousufconnected;
        this.comment = comment;
        this.id = id;
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

    @NonNull
    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(@NonNull String qurantext) {
        this.qurantext = qurantext;
    }

    @NonNull
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(@NonNull String translation) {
        this.translation = translation;
    }

    public SpannableStringBuilder getSpannedverse() {
        return spannedverse;
    }

    public void setSpannedverse(SpannableStringBuilder spannedverse) {
        this.spannedverse = spannedverse;
    }
}



