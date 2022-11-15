package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;

public class CorpusNounWbwGrouping {
    private String wordtype;
    @NonNull
    private String root_a;
    @NonNull
    private int surah;
    @NonNull
    private int ayah;
    @NonNull
    private int wordno;
    @NonNull
    private int wordcount;
    private String lemma;
    private int lemmacount;
    private String arabicword;
    private String en;
    public CorpusNounWbwGrouping(String wordtype, @NonNull String root_a, int surah, int ayah, int wordno, int wordcount, String lemma, int lemmacount, String arabicword, String en) {
        this.wordtype = wordtype;
        this.root_a = root_a;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.lemma = lemma;
        this.lemmacount = lemmacount;
        this.arabicword = arabicword;
        this.en = en;
    }

    public String getWordtype() {
        return wordtype;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype;
    }

    @NonNull
    public String getRoot_a() {
        return root_a;
    }

    public void setRoot_a(@NonNull String root_a) {
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

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public int getLemmacount() {
        return lemmacount;
    }

    public void setLemmacount(int lemmacount) {
        this.lemmacount = lemmacount;
    }

    public String getArabicword() {
        return arabicword;
    }

    public void setArabicword(String arabicword) {
        this.arabicword = arabicword;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}

/*
SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive,
       CorpusExpand.surah,
       CorpusExpand.ayah,
       CorpusExpand.wordno,
       CorpusExpand.wordcount,
       CorpusExpand.form_one || form_two || form_three || form_four || form_five,
       CorpusExpand.araone,
       CorpusExpand.aratwo,
       CorpusExpand.arathree,
       CorpusExpand.arafour,
       CorpusExpand.arafive,
       CorpusExpand.tagone,
       CorpusExpand.tagtwo,
       CorpusExpand.tagthree,
       CorpusExpand.tagfour,
       CorpusExpand.tagfive,
       nouncorpus.tag,
       nouncorpus.propone,
       nouncorpus.proptwo,
       nouncorpus.form,
       nouncorpus.gendernumber,
       nouncorpus.type,
       nouncorpus.cases,
       wbw.en
      FROM corpusexpand,nouncorpus,
       wbw
 WHERE corpusexpand.tagone="ADJ" and
       CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive LIKE "عبد" AND
       corpusexpand.surah = wbw.surah AND  corpusexpand.surah = nouncorpus.surah AND
       corpusexpand.ayah = wbw.ayah AND      corpusexpand.ayah = nouncorpus.ayah AND
       corpusexpand.wordno = wbw.wordno   AND  corpusexpand.wordno = nouncorpus.wordno order by corpusexpand.surah,
       corpusexpand.ayah

 */