package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//@Entity(indices = {@Index(value = {"chapterid"}, unique = true)})
// @Entity(tableName = "ChaptersAnaEntity",indices = {@Index(value = {"chapterid"}, unique = true)},foreignKeys = @ForeignKey(entity=ChaptersAnaEntity.class, parentColumns="chapterid", childColumns="muqattatid"))

@Entity(tableName = "chaptersana")
public class ChaptersAnaEntity {
    @NonNull
    @ColumnInfo(defaultValue = "0")
    public int revelationnumber;
    @NonNull
    @ColumnInfo(defaultValue = "0")
    public int serialnumber;
    @NonNull
    public String namearabic;
    public String nameurdu;
    @NonNull
    public String nameenglish;
    @NonNull
    @ColumnInfo(defaultValue = "1")
    public int ismakki;
    @NonNull
    @ColumnInfo(defaultValue = "0")
    public int versescount;
    @NonNull
    @ColumnInfo(defaultValue = "0")
    public int rukucount;
    @NonNull
    public String abjadname;
    @NonNull
    public String arahsfall;
    public String versesparahdiv;
    public String sajdaverses;
    @NonNull
    public int cumversescount;
    // @Entity(indices = chapterid)
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int chapterid;
    @NonNull
    private int part_no;

    public ChaptersAnaEntity(int revelationnumber, int serialnumber, @NonNull String namearabic, String nameurdu, String nameenglish, int ismakki, int versescount, int rukucount, @NonNull String abjadname, @NonNull String arahsfall, String versesparahdiv, String sajdaverses, int cumversescount, int chapterid, int part_no) {
        this.revelationnumber = revelationnumber;
        this.serialnumber = serialnumber;
        this.namearabic = namearabic;
        this.nameurdu = nameurdu;
        this.nameenglish = nameenglish;
        this.ismakki = ismakki;
        this.versescount = versescount;
        this.rukucount = rukucount;
        this.abjadname = abjadname;
        this.arahsfall = arahsfall;
        this.versesparahdiv = versesparahdiv;
        this.sajdaverses = sajdaverses;
        this.cumversescount = cumversescount;
        this.chapterid = chapterid;
        this.part_no = part_no;
    }

    public int getRevelationnumber() {
        return revelationnumber;
    }

    public void setRevelationnumber(int revelationnumber) {
        this.revelationnumber = revelationnumber;
    }

    public int getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(int serialnumber) {
        this.serialnumber = serialnumber;
    }

    @NonNull
    public String getNamearabic() {
        return namearabic;
    }

    public void setNamearabic(@NonNull String namearabic) {
        this.namearabic = namearabic;
    }

    public String getNameurdu() {
        return nameurdu;
    }

    public void setNameurdu(String nameurdu) {
        this.nameurdu = nameurdu;
    }

    public String getNameenglish() {
        return nameenglish;
    }

    public void setNameenglish(String nameenglish) {
        this.nameenglish = nameenglish;
    }

    public int getIsmakki() {
        return ismakki;
    }

    public void setIsmakki(int ismakki) {
        this.ismakki = ismakki;
    }

    public int getVersescount() {
        return versescount;
    }

    public void setVersescount(int versescount) {
        this.versescount = versescount;
    }

    public int getRukucount() {
        return rukucount;
    }

    public void setRukucount(int rukucount) {
        this.rukucount = rukucount;
    }

    @NonNull
    public String getAbjadname() {
        return abjadname;
    }

    public void setAbjadname(@NonNull String abjadname) {
        this.abjadname = abjadname;
    }

    @NonNull
    public String getArahsfall() {
        return arahsfall;
    }

    public void setArahsfall(@NonNull String arahsfall) {
        this.arahsfall = arahsfall;
    }

    public String getVersesparahdiv() {
        return versesparahdiv;
    }

    public void setVersesparahdiv(String versesparahdiv) {
        this.versesparahdiv = versesparahdiv;
    }

    public String getSajdaverses() {
        return sajdaverses;
    }

    public void setSajdaverses(String sajdaverses) {
        this.sajdaverses = sajdaverses;
    }

    public int getCumversescount() {
        return cumversescount;
    }

    public void setCumversescount(int cumversescount) {
        this.cumversescount = cumversescount;
    }

    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public int getPart_no() {
        return part_no;
    }

    public void setPart_no(int part_no) {
        this.part_no = part_no;
    }
}





