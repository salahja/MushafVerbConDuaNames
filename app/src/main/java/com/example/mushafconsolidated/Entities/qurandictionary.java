package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "qurandictionary")
public class qurandictionary {
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private String rootarabic;
    @NonNull
    private String rootbuckwater;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public qurandictionary(int surah, int ayah, int wordno, @NonNull String rootarabic, @NonNull String rootbuckwater, int id) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.rootarabic = rootarabic;
        this.rootbuckwater = rootbuckwater;
        this.id = id;
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

    @NonNull
    public String getRootarabic() {
        return rootarabic;
    }

    public void setRootarabic(@NonNull String rootarabic) {
        this.rootarabic = rootarabic;
    }

    @NonNull
    public String getRootbuckwater() {
        return rootbuckwater;
    }

    public void setRootbuckwater(@NonNull String rootbuckwater) {
        this.rootbuckwater = rootbuckwater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}