package com.example.mushafconsolidated.Entities;

import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "qurans", foreignKeys = @ForeignKey(entity = ChaptersAnaEntity.class,
        parentColumns = "chapterid",
        childColumns = "surah",
        onDelete = ForeignKey.CASCADE))
public class QuranEntity {
    @Ignore
    SpannableStringBuilder erabspnabble;
    @PrimaryKey
    @NonNull
    private int docid;
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private String qurantext;
    @NonNull
    private int passage_no;
    @NonNull
    private int has_prostration;
    @NonNull
    private String translation;
    @NonNull
    private String en_transliteration;
    @NonNull
    private String en_jalalayn;
    @NonNull
    private String en_arberry;
    private String ar_irab_two;
    @NonNull
    private String ur_jalalayn;
    @NonNull
    private String ur_junagarhi;
    private String tafsir_kathir;

    public QuranEntity(int docid, int surah, int ayah, @NonNull String qurantext, int passage_no, int has_prostration, @NonNull String translation, @NonNull String en_transliteration, @NonNull String en_jalalayn, @NonNull String en_arberry, String ar_irab_two, @NonNull String ur_jalalayn, @NonNull String ur_junagarhi, String tafsir_kathir) {
        this.docid = docid;
        this.surah = surah;
        this.ayah = ayah;
        this.qurantext = qurantext;
        this.passage_no = passage_no;
        this.has_prostration = has_prostration;
        this.translation = translation;
        this.en_transliteration = en_transliteration;
        this.en_jalalayn = en_jalalayn;
        this.en_arberry = en_arberry;
        this.ar_irab_two = ar_irab_two;
        this.ur_jalalayn = ur_jalalayn;
        this.ur_junagarhi = ur_junagarhi;
        this.tafsir_kathir = tafsir_kathir;
    }

    @NonNull
    public String getEn_arberry() {
        return en_arberry;
    }

    public void setEn_arberry(@NonNull String en_arberry) {
        this.en_arberry = en_arberry;
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
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

    @NonNull
    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(@NonNull String qurantext) {
        this.qurantext = qurantext;
    }

    public int getPassage_no() {
        return passage_no;
    }

    public void setPassage_no(int passage_no) {
        this.passage_no = passage_no;
    }

    public int getHas_prostration() {
        return has_prostration;
    }

    public void setHas_prostration(int has_prostration) {
        this.has_prostration = has_prostration;
    }

    @NonNull
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(@NonNull String translation) {
        this.translation = translation;
    }

    @NonNull
    public String getEn_transliteration() {
        return en_transliteration;
    }

    public void setEn_transliteration(@NonNull String en_transliteration) {
        this.en_transliteration = en_transliteration;
    }

    @NonNull
    public String getEn_jalalayn() {
        return en_jalalayn;
    }

    public void setEn_jalalayn(@NonNull String en_jalalayn) {
        this.en_jalalayn = en_jalalayn;
    }

    public String getAr_irab_two() {
        return ar_irab_two;
    }

    public void setAr_irab_two(String ar_irab_two) {
        this.ar_irab_two = ar_irab_two;
    }

    @NonNull
    public String getUr_jalalayn() {
        return ur_jalalayn;
    }

    public void setUr_jalalayn(@NonNull String ur_jalalayn) {
        this.ur_jalalayn = ur_jalalayn;
    }

    @NonNull
    public String getUr_junagarhi() {
        return ur_junagarhi;
    }

    public void setUr_junagarhi(@NonNull String ur_junagarhi) {
        this.ur_junagarhi = ur_junagarhi;
    }

    public String getTafsir_kathir() {
        return tafsir_kathir;
    }

    public void setTafsir_kathir(String tafsir_kathir) {
        this.tafsir_kathir = tafsir_kathir;
    }

    public SpannableStringBuilder getErabspnabble() {
        return erabspnabble;
    }

    public void setErabspnabble(SpannableStringBuilder erabspnabble) {
        this.erabspnabble = erabspnabble;
    }
}