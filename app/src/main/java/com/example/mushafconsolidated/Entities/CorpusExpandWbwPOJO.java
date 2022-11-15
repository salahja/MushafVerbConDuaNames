package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

public class CorpusExpandWbwPOJO {
    private String root_a;
    private int surah;
    private int ayah;
    private int wordno;
    private int wordcount;
    private String translation;
    private String araone;
    private String aratwo;
    private String arathree;
    private String arafour;
    private String arafive;
    private String tagone;
    private String tagtwo;
    private String tagthree;
    private String tagfour;
    private String tagfive;
    private String detailsone;
    private String detailstwo;
    private String detailsthree;
    private String detailsfour;
    private String detailsfive;
    private String en;
    private String bn;
    private String in;
    private String ur;
    private String qurantext;
    private int passage_no;
    private String ar_irab_two;
    private String tafsir_kathir;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String en_transliteration;
    private String en_jalalayn;
    private String en_arberry;
    private String ur_jalalayn;
    private String ur_junagarhi;

    public CorpusExpandWbwPOJO(String root_a, int surah, int ayah, int wordno, int wordcount, String translation, String araone, String aratwo, String arathree, String arafour, String arafive, String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String detailsone, String detailstwo, String detailsthree, String detailsfour, String detailsfive, String en, String bn, String in,
                               String ur) {
        this.root_a = root_a;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.translation = translation;
        this.araone = araone;
        this.aratwo = aratwo;
        this.arathree = arathree;
        this.arafour = arafour;
        this.arafive = arafive;
        this.tagone = tagone;
        this.tagtwo = tagtwo;
        this.tagthree = tagthree;
        this.tagfour = tagfour;
        this.tagfive = tagfive;
        this.detailsone = detailsone;
        this.detailstwo = detailstwo;
        this.detailsthree = detailsthree;
        this.detailsfour = detailsfour;
        this.detailsfive = detailsfive;
        this.en = en;
        this.bn = bn;
        this.in = in;
        this.ur = ur;
    }

    public int getPassage_no() {
        return passage_no;
    }

    public void setPassage_no(int passage_no) {
        this.passage_no = passage_no;
    }

    public String getAr_irab_two() {
        return ar_irab_two;
    }

    public void setAr_irab_two(String ar_irab_two) {
        this.ar_irab_two = ar_irab_two;
    }

    public String getTafsir_kathir() {
        return tafsir_kathir;
    }

    public void setTafsir_kathir(String tafsir_kathir) {
        this.tafsir_kathir = tafsir_kathir;
    }

    public String getEn_transliteration() {
        return en_transliteration;
    }

    public void setEn_transliteration(String en_transliteration) {
        this.en_transliteration = en_transliteration;
    }

    public String getEn_jalalayn() {
        return en_jalalayn;
    }

    public void setEn_jalalayn(String en_jalalayn) {
        this.en_jalalayn = en_jalalayn;
    }

    public String getEn_arberry() {
        return en_arberry;
    }

    public void setEn_arberry(String en_arberry) {
        this.en_arberry = en_arberry;
    }

    public String getUr_jalalayn() {
        return ur_jalalayn;
    }

    public void setUr_jalalayn(String ur_jalalayn) {
        this.ur_jalalayn = ur_jalalayn;
    }

    public String getUr_junagarhi() {
        return ur_junagarhi;
    }

    public void setUr_junagarhi(String ur_junagarhi) {
        this.ur_junagarhi = ur_junagarhi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoot_a() {
        return root_a;
    }

    public void setRoot_a(String root_a) {
        this.root_a = root_a;
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

    public int getWordcount() {
        return wordcount;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAraone() {
        return araone;
    }

    public void setAraone(String araone) {
        this.araone = araone;
    }

    public String getAratwo() {
        return aratwo;
    }

    public void setAratwo(String aratwo) {
        this.aratwo = aratwo;
    }

    public String getArathree() {
        return arathree;
    }

    public void setArathree(String arathree) {
        this.arathree = arathree;
    }

    public String getArafour() {
        return arafour;
    }

    public void setArafour(String arafour) {
        this.arafour = arafour;
    }

    public String getArafive() {
        return arafive;
    }

    public void setArafive(String arafive) {
        this.arafive = arafive;
    }

    public String getTagone() {
        return tagone;
    }

    public void setTagone(String tagone) {
        this.tagone = tagone;
    }

    public String getTagtwo() {
        return tagtwo;
    }

    public void setTagtwo(String tagtwo) {
        this.tagtwo = tagtwo;
    }

    public String getTagthree() {
        return tagthree;
    }

    public void setTagthree(String tagthree) {
        this.tagthree = tagthree;
    }

    public String getTagfour() {
        return tagfour;
    }

    public void setTagfour(String tagfour) {
        this.tagfour = tagfour;
    }

    public String getTagfive() {
        return tagfive;
    }

    public void setTagfive(String tagfive) {
        this.tagfive = tagfive;
    }

    public String getDetailsone() {
        return detailsone;
    }

    public void setDetailsone(String detailsone) {
        this.detailsone = detailsone;
    }

    public String getDetailstwo() {
        return detailstwo;
    }

    public void setDetailstwo(String detailstwo) {
        this.detailstwo = detailstwo;
    }

    public String getDetailsthree() {
        return detailsthree;
    }

    public void setDetailsthree(String detailsthree) {
        this.detailsthree = detailsthree;
    }

    public String getDetailsfour() {
        return detailsfour;
    }

    public void setDetailsfour(String detailsfour) {
        this.detailsfour = detailsfour;
    }

    public String getDetailsfive() {
        return detailsfive;
    }

    public void setDetailsfive(String detailsfive) {
        this.detailsfive = detailsfive;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(String qurantext) {
        this.qurantext = qurantext;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

}