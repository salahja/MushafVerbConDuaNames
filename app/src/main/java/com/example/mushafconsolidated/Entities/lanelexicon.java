package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "laneslexicon")
public class lanelexicon {
    @NonNull
    private String rootword;
    @NonNull
    private String word;
    @NonNull
    private int parentid;
    @NonNull
    private String definition;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public lanelexicon(@NonNull String rootword, @NonNull String word, int parentid, @NonNull String definition, int id) {
        this.rootword = rootword;
        this.word = word;
        this.parentid = parentid;
        this.definition = definition;
        this.id = id;
    }

    @NonNull
    public String getRootword() {
        return rootword;
    }

    public void setRootword(@NonNull String rootword) {
        this.rootword = rootword;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    @NonNull
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(@NonNull String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "lanelexicon{" +
                "rootword='" + rootword + '\'' +
                ", word='" + word + '\'' +
                ", parentid=" + parentid +
                ", definition='" + definition + '\'' +
                ", id=" + id +
                '}';
    }
}