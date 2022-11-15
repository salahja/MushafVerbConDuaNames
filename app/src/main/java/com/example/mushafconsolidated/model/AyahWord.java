package com.example.mushafconsolidated.model;

import java.util.ArrayList;

public class AyahWord {
    private ArrayList<Word> word;
    private int chapterno;
    private int verseno;
    private int rukuno;
    private boolean hasProstration;
    private String quranArabic;
    private String quranTranslate;
    private int quranVerseId;
    private String banglaTransalate;
    private String erabDisplayl;
    private String urdutranslate;

    public int getRukuno() {
        return rukuno;
    }

    public void setRukuno(int rukuno) {
        this.rukuno = rukuno;
    }

    public boolean isHasProstration() {
        return hasProstration;
    }

    public void setHasProstration(boolean hasProstration) {
        this.hasProstration = hasProstration;
    }

    public int getQuranVerseId() {
        return quranVerseId;
    }

    public void setQuranVerseId(int quranVerseId) {
        this.quranVerseId = quranVerseId;
    }

    public int getChapterno() {
        return chapterno;
    }

    public void setChapterno(int chapterno) {
        this.chapterno = chapterno;
    }

    public int getVerseno() {
        return verseno;
    }

    public void setVerseno(int verseno) {
        this.verseno = verseno;
    }

    public String getUrdutranslate() {
        return urdutranslate;
    }

    public void setUrdutranslate(String urdutranslate) {
        this.urdutranslate = urdutranslate;
    }

    public String getErabDisplayl() {
        return erabDisplayl;
    }

    public void setErabDisplayl(String erabDisplayl) {
        this.erabDisplayl = erabDisplayl;
    }

    public String getBanglaTransalate() {
        return banglaTransalate;
    }

    public void setBanglaTransalate(String banglaTransalate) {
        this.banglaTransalate = banglaTransalate;
    }

    public ArrayList<Word> getWord() {
        return word;
    }

    public void setWord(ArrayList<Word> word) {
        this.word = word;
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

}
