package com.example.mushafconsolidated.model;

import android.text.SpannableString;

import java.util.ArrayList;

public class CorpusAyahWord {
    private ArrayList<CorpusWbwWord> word;
    private boolean hasProstration;
    private String quranArabic;
    private String quranTranslate;
    private SpannableString spannableverse;
    private String ar_irab_two;
    private String tafsir_kathir;
    private String topictitle;
    private String has_prostration;
    private String en_transliteration;
    private String en_jalalayn;
    private String en_arberry;
    private String ur_jalalayn;
    private String ur_junagarhi;
    private int passage_no;

    public CorpusAyahWord() {
    }

    public CorpusAyahWord(ArrayList<CorpusWbwWord> word, boolean hasProstration, String quranArabic, String quranTranslate, SpannableString spannableverse) {
        this.word = word;
        this.hasProstration = hasProstration;
        this.quranArabic = quranArabic;
        this.quranTranslate = quranTranslate;
        this.spannableverse = spannableverse;
    }

    public String getTopictitle() {
        return topictitle;
    }

    public void setTopictitle(String topictitle) {
        this.topictitle = topictitle;
    }

    public String getHas_prostration() {
        return has_prostration;
    }

    public void setHas_prostration(String has_prostration) {
        this.has_prostration = has_prostration;
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

    public int getPassage_no() {
        return passage_no;
    }

    public void setPassage_no(int passage_no) {
        this.passage_no = passage_no;
    }

    public ArrayList<CorpusWbwWord> getWord() {
        return word;
    }

    public void setWord(ArrayList<CorpusWbwWord> word) {
        this.word = word;
    }

    public boolean isHasProstration() {
        return hasProstration;
    }

    public void setHasProstration(boolean hasProstration) {
        this.hasProstration = hasProstration;
    }

    public String getQuranArabic() {
        return quranArabic;
    }

    public void setQuranArabic(String quranArabic) {
        this.quranArabic = quranArabic;
    }

    public String getQuranTranslate() {
        return quranTranslate;
    }

    public void setQuranTranslate(String quranTranslate) {
        this.quranTranslate = quranTranslate;
    }

    public SpannableString getSpannableverse() {
        return spannableverse;
    }

    public void setSpannableverse(SpannableString spannableverse) {
        this.spannableverse = spannableverse;
    }
}
