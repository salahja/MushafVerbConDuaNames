package com.example.mushafconsolidated.Entities;


import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}



public class TameezPOJO {


    @NonNull
    private int surah;

    @NonNull
    private int versescount;

    public int getSurah() {
        return surah;
    }

    public void setSurah(int surah) {
        this.surah = surah;
    }

    public int getVersescount() {
        return versescount;
    }

    public void setVersescount(int versescount) {
        this.versescount = versescount;
    }


    public TameezPOJO(int surah, int versescount) {
        this.surah = surah;
        this.versescount = versescount;
    }
}