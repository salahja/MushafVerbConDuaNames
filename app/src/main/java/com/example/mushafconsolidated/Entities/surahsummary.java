package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "surahsummary")
public class surahsummary {
    @NonNull
    private String title;
    @NonNull
    private String summary;
    @NonNull
    private String versesrange;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int surahid;

    public surahsummary(@NonNull String title, @NonNull String summary, @NonNull String versesrange, int surahid) {
        this.title = title;
        this.summary = summary;
        this.versesrange = versesrange;
        this.surahid = surahid;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getSummary() {
        return summary;
    }

    public void setSummary(@NonNull String summary) {
        this.summary = summary;
    }

    @NonNull
    public String getVersesrange() {
        return versesrange;
    }

    public void setVersesrange(@NonNull String versesrange) {
        this.versesrange = versesrange;
    }

    public int getSurahid() {
        return surahid;
    }

    public void setSurahid(int surahid) {
        this.surahid = surahid;
    }
}