package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "buckwater")
public class BuckWater {
    @PrimaryKey
    @NonNull
    public int decimel;
    @NonNull
    public String hex;
    @NonNull
    public String ascii;
    @NonNull
    public String orthography;
    public String arabic;

    public BuckWater(int decimel, @NonNull String hex, @NonNull String ascii, @NonNull String orthography, String arabic) {
        this.decimel = decimel;
        this.hex = hex;
        this.ascii = ascii;
        this.orthography = orthography;
        this.arabic = arabic;
    }

    public int getDecimel() {
        return decimel;
    }

    public void setDecimel(int decimel) {
        this.decimel = decimel;
    }

    @NonNull
    public String getHex() {
        return hex;
    }

    public void setHex(@NonNull String hex) {
        this.hex = hex;
    }

    @NonNull
    public String getAscii() {
        return ascii;
    }

    public void setAscii(@NonNull String ascii) {
        this.ascii = ascii;
    }

    @NonNull
    public String getOrthography() {
        return orthography;
    }

    public void setOrthography(@NonNull String orthography) {
        this.orthography = orthography;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }
}
