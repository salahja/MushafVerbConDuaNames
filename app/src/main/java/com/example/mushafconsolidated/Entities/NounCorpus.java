package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "nouncorpus")
public class NounCorpus {
    @Ignore
    private int count;
    private String root_a;
    private String lemma_a;
    private String araword;
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private int token;
    private String words;
    @NonNull
    private String tag;
    private String propone;
    private String proptwo;
    private String form;
    private String lemma;
    private String root;
    private String gendernumber;
    private String type;
    private String cases;
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String details;

    public NounCorpus(String root_a, String lemma_a, String araword, int surah, int ayah, int wordno, int token, String words, @NonNull String tag, String propone, String proptwo, String form, String lemma, String root, String gendernumber, String type, String cases, int id, @NonNull String details) {
        this.root_a = root_a;
        this.lemma_a = lemma_a;
        this.araword = araword;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.token = token;
        this.words = words;
        this.tag = tag;
        this.propone = propone;
        this.proptwo = proptwo;
        this.form = form;
        this.lemma = lemma;
        this.root = root;
        this.gendernumber = gendernumber;
        this.type = type;
        this.cases = cases;
        this.id = id;
        this.details = details;
    }

    @Ignore
    public NounCorpus(int count, String root_a, String lemma_a, String araword, int surah, int ayah, int wordno, int token, String words, @NonNull String tag, String propone, String proptwo, String form, String lemma, String root, String gendernumber, String type, String cases, int id, @NonNull String details) {
        this.count = count;
        this.root_a = root_a;
        this.lemma_a = lemma_a;
        this.araword = araword;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.token = token;
        this.words = words;
        this.tag = tag;
        this.propone = propone;
        this.proptwo = proptwo;
        this.form = form;
        this.lemma = lemma;
        this.root = root;
        this.gendernumber = gendernumber;
        this.type = type;
        this.cases = cases;
        this.id = id;
        this.details = details;
    }

    public String getRoot_a() {
        return root_a;
    }

    public void setRoot_a(String root_a) {
        this.root_a = root_a;
    }

    public String getLemma_a() {
        return lemma_a;
    }

    public void setLemma_a(String lemma_a) {
        this.lemma_a = lemma_a;
    }

    public String getAraword() {
        return araword;
    }

    public void setAraword(String araword) {
        this.araword = araword;
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

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @NonNull
    public String getTag() {
        return tag;
    }

    public void setTag(@NonNull String tag) {
        this.tag = tag;
    }

    public String getPropone() {
        return propone;
    }

    public void setPropone(String propone) {
        this.propone = propone;
    }

    public String getProptwo() {
        return proptwo;
    }

    public void setProptwo(String proptwo) {
        this.proptwo = proptwo;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getGendernumber() {
        return gendernumber;
    }

    public void setGendernumber(String gendernumber) {
        this.gendernumber = gendernumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDetails() {
        return details;
    }

    public void setDetails(@NonNull String details) {
        this.details = details;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
