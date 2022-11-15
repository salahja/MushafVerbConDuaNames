package com.example.mushafconsolidated.Entities;

import android.text.SpannableString;

import androidx.annotation.NonNull;
import androidx.room.Ignore;

import com.example.mushafconsolidated.model.WordSpan;

import java.util.ArrayList;

public class CorpusNounWbwOccurance {
    @Ignore
    SpannableString verses;
    @Ignore
    private ArrayList<WordSpan> wordspan;
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
    private String qurantext;
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
    private String tag;
    private String propone;
    private String proptwo;
    private String form;
    private String gendernumber;
    private String type;
    private String cases;
    private String en;
    private String translation;
    private String ur_jalalayn;
    private String en_jalalayn;
    private String en_arberry;
    @Ignore
    private SpannableString spannableNoun;
    @Ignore
    private String lemma;
    @Ignore
    private int lemmacount;
    @Ignore
    private String arabicword;
    public CorpusNounWbwOccurance() {
    }
    public CorpusNounWbwOccurance(@NonNull String root_a, int surah, int ayah, int wordno, int wordcount, String translation, String ur_jalalayn, String en_jalalayn, String qurantext, String araone, String aratwo, String arathree, String arafour, String arafive, String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String detailsone, String detailstwo, String detailsthree, String detailsfour, String detailsfive, String tag, String propone, String proptwo, String form, String gendernumber, String type, String cases, String en) {
        this.root_a = root_a;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.translation = translation;
        this.ur_jalalayn = ur_jalalayn;
        this.en_jalalayn = en_jalalayn;
        this.qurantext = qurantext;
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
        this.tag = tag;
        this.propone = propone;
        this.proptwo = proptwo;
        this.form = form;
        this.gendernumber = gendernumber;
        this.type = type;
        this.cases = cases;
        this.en = en;
    }
    @Ignore
    public CorpusNounWbwOccurance(String araone, String aratwo, String arathree, String arafour, String arafive,
                                  String tagone, String tagtwo, String tagthree, String tagfour, String tagfive,
                                  String translation, String qurantext,
                                  SpannableString verses, String root_a, int surah, int ayah, int wordno, int wordcount,
                                  SpannableString spannableNoun,
                                  String tag, String propone, String proptwo, String form, String gendernumber,
                                  String type, String cases, String en) {
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
        this.translation = translation;
        this.qurantext = qurantext;
        this.verses = verses;
        this.root_a = root_a;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.spannableNoun = spannableNoun;
        this.tag = tag;
        this.propone = propone;
        this.proptwo = proptwo;
        this.form = form;
        this.gendernumber = gendernumber;
        this.type = type;
        this.cases = cases;
        this.en = en;

    }
    @Ignore
    public CorpusNounWbwOccurance(@NonNull String root_a, int surah, int ayah, int wordno, int wordcount, String lemma, int lemmacount, String arabicword, String en) {
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

    public ArrayList<WordSpan> getWordspan() {
        return wordspan;
    }

    public void setWordspan(ArrayList<WordSpan> wordspan) {
        this.wordspan = wordspan;
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

    public String getUr_jalalayn() {
        return ur_jalalayn;
    }

    public void setUr_jalalayn(String ur_jalalayn) {
        this.ur_jalalayn = ur_jalalayn;
    }

    public String getEn_arberry() {
        return en_arberry;
    }

    public void setEn_arberry(String en_arberry) {
        this.en_arberry = en_arberry;
    }

    public String getEn_jalalayn() {
        return en_jalalayn;
    }

    public void setEn_jalalayn(String en_jalalayn) {
        this.en_jalalayn = en_jalalayn;
    }

    @Ignore
    public String getLemma() {
        return lemma;
    }

    @Ignore
    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    @Ignore
    public int getLemmacount() {
        return lemmacount;
    }

    @Ignore
    public void setLemmacount(int lemmacount) {
        this.lemmacount = lemmacount;
    }

    @Ignore
    public String getArabicword() {
        return arabicword;
    }

    @Ignore
    public void setArabicword(String arabicword) {
        this.arabicword = arabicword;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public SpannableString getVerses() {
        return verses;
    }

    @Ignore
    public void setVerses(SpannableString verses) {
        this.verses = verses;
    }

    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(String qurantext) {
        this.qurantext = qurantext;
    }

    @Ignore
    public SpannableString getSpannableNoun() {
        return spannableNoun;
    }

    @Ignore
    public void setSpannableNoun(SpannableString spannableNoun) {
        this.spannableNoun = spannableNoun;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
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