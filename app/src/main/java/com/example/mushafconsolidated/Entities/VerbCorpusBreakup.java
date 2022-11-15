package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class VerbCorpusBreakup {
    private int count;
    @NonNull
    private int chapterno;
    @NonNull
    private int verseno;
    @NonNull
    private int wordno;
    @NonNull
    private int token;
    private String root_a;
    private String form;
    private String thulathibab;
    private String tag;
    private String details;
    private String POS;
    private String tense;
    private String voice;
    private String lemma_b;
    private String root_b;
    private String gendernumber;
    private String mood_kananumbers;
    private String kana_mood;
    private String lemma_a;
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    public VerbCorpusBreakup(int count, int chapterno, int verseno, int wordno, int token, String root_a, String form, String thulathibab, String tag, String details, String POS, String tense, String voice, String lemma_b, String root_b, String gendernumber, String mood_kananumbers, String kana_mood, String lemma_a, int id) {
        this.count = count;
        this.chapterno = chapterno;
        this.verseno = verseno;
        this.wordno = wordno;
        this.token = token;
        this.root_a = root_a;
        this.form = form;
        this.thulathibab = thulathibab;
        this.tag = tag;
        this.details = details;
        this.POS = POS;
        this.tense = tense;
        this.voice = voice;
        this.lemma_b = lemma_b;
        this.root_b = root_b;
        this.gendernumber = gendernumber;
        this.mood_kananumbers = mood_kananumbers;
        this.kana_mood = kana_mood;
        this.lemma_a = lemma_a;
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getWordno() {
        return wordno;
    }

    public void setWordno(int wordno) {
        this.wordno = wordno;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getRoot_a() {
        return root_a;
    }

    public void setRoot_a(String root_a) {
        this.root_a = root_a;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getThulathibab() {
        return thulathibab;
    }

    public void setThulathibab(String thulathibab) {
        this.thulathibab = thulathibab;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public String getTense() {
        return tense;
    }

    public void setTense(String tense) {
        this.tense = tense;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getLemma_b() {
        return lemma_b;
    }

    public void setLemma_b(String lemma_b) {
        this.lemma_b = lemma_b;
    }

    public String getRoot_b() {
        return root_b;
    }

    public void setRoot_b(String root_b) {
        this.root_b = root_b;
    }

    public String getGendernumber() {
        return gendernumber;
    }

    public void setGendernumber(String gendernumber) {
        this.gendernumber = gendernumber;
    }

    public String getMood_kananumbers() {
        return mood_kananumbers;
    }

    public void setMood_kananumbers(String mood_kananumbers) {
        this.mood_kananumbers = mood_kananumbers;
    }

    public String getKana_mood() {
        return kana_mood;
    }

    public void setKana_mood(String kana_mood) {
        this.kana_mood = kana_mood;
    }

    public String getLemma_a() {
        return lemma_a;
    }

    public void setLemma_a(String lemma_a) {
        this.lemma_a = lemma_a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
