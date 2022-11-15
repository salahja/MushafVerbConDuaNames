package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rules")
public class GrammarRules {
    @NonNull
    private String harf;
    private String worddetails;
    @NonNull
    private String detailsrules;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public GrammarRules(String harf, String worddetails, String detailsrules, int id) {
        this.harf = harf;
        this.worddetails = worddetails;
        this.detailsrules = detailsrules;
        this.id = id;
    }

    public String getHarf() {
        return harf;
    }

    public void setHarf(String harf) {
        this.harf = harf;
    }

    public String getWorddetails() {
        return worddetails;
    }

    public void setWorddetails(String worddetails) {
        this.worddetails = worddetails;
    }

    public String getDetailsrules() {
        return detailsrules;
    }

    public void setDetailsrules(String detailsrules) {
        this.detailsrules = detailsrules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}