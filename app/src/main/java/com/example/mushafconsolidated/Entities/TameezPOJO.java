package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
//primaryKeys ={"translation_id","verse_id"}

public class TameezPOJO {
    @NonNull
    private int surah;
    @NonNull
    private int versescount;

    public TameezPOJO(int surah, int versescount) {
        this.surah = surah;
        this.versescount = versescount;
    }

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
}