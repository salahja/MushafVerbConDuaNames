package com.example.mushafconsolidated.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "namedetails")
public class AllahNamesDetails {
    @PrimaryKey
    @NotNull
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String summary;
    @NotNull
    private String details;
    private String ref;

    public AllahNamesDetails(int id, @NotNull String title, @NotNull String summary, @NotNull String details, String ref) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.details = details;
        this.ref = ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getSummary() {
        return summary;
    }

    public void setSummary(@NotNull String summary) {
        this.summary = summary;
    }

    @NotNull
    public String getDetails() {
        return details;
    }

    public void setDetails(@NotNull String details) {
        this.details = details;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

