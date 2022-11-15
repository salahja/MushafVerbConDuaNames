package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "quranexplorer")
public class quranexplorer {
    @NonNull
    private String title;
    private String ayahref;
    @Ignore
    private boolean isSelected = false;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    public quranexplorer(@NonNull String title, String ayahref, int id) {
        this.title = title;
        this.ayahref = ayahref;
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getAyahref() {
        return ayahref;
    }

    public void setAyahref(String ayahref) {
        this.ayahref = ayahref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}