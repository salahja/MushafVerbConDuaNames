package com.example.mushafconsolidated.Entities;

import android.text.SpannableString;

import androidx.annotation.NonNull;
import androidx.room.Ignore;

import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.mushafconsolidated.model.Word;
import com.example.mushafconsolidated.model.WordSpan;

import java.util.ArrayList;

public class CorpusVerbWbwOccurance {
    @Ignore
    String arabicword;
    @Ignore
    private SpannableString spannedverb;
    @Ignore
    private ArrayList<CorpusWbwWord> corpusWbwWordsword;
    @Ignore
    private ArrayList<Word> word;
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
    @Ignore
    private SpannableString quranversesSpannable;
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
    private String voice;
    private String form;
    private String thulathibab;
    private String tense;
    private String gendernumber;
    private String mood_kananumbers;
    private String kana_mood;
    private String en;
    private String translation;
    private String ur_jalalayn;
    private String en_jalalayn;
    private String en_arberry;
    @Ignore
    private SpannableString verses;
    @Ignore
    private SpannableString spannedarabicverb;

    public CorpusVerbWbwOccurance() {
    }

    public CorpusVerbWbwOccurance(String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String araone,
                                  String aratwo, String arathree, String arafour, String arafive, String arabicword, String translation, String ur_jalalayn, String en_jalalayn, String qurantext, SpannableString quranversesSpannable, String root_a, int surah, int ayah, int wordno, int wordcount, String voice, String form, String thulathibab, String tenseStr, String genderNumberdetails, String mood_kananumbers, String kana_mood, String en, SpannableString setWordSpanNew, String detailsone, String detailstwo, String detailsthree, String detailsfour, String detailsfive) {
        // this.word = word;
        // this.wordspanDark = wordspan;
        this.arabicword = arabicword;
        this.root_a = root_a;
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
        this.quranversesSpannable = quranversesSpannable;
        this.qurantext = qurantext;
        this.translation = translation;
        this.ur_jalalayn = ur_jalalayn;
        this.en_jalalayn = en_jalalayn;
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
        this.voice = voice;
        this.form = form;
        this.thulathibab = thulathibab;
        this.tense = tense;
        this.gendernumber = gendernumber;
        this.mood_kananumbers = mood_kananumbers;
        this.kana_mood = kana_mood;
        this.en = en;
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

    public String getEn_jalalayn() {
        return en_jalalayn;
    }

    public void setEn_jalalayn(String en_jalalayn) {
        this.en_jalalayn = en_jalalayn;
    }

    public SpannableString getSpannedverb() {
        return spannedverb;
    }

    public void setSpannedverb(SpannableString spannedverb) {
        this.spannedverb = spannedverb;
    }

    public ArrayList<CorpusWbwWord> getCorpusWbwWordsword() {
        return corpusWbwWordsword;
    }

    public void setCorpusWbwWordsword(ArrayList<CorpusWbwWord> corpusWbwWordsword) {
        this.corpusWbwWordsword = corpusWbwWordsword;
    }

    public ArrayList<Word> getWord() {
        return word;
    }

    public void setWord(ArrayList<Word> word) {
        this.word = word;
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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Ignore
    public SpannableString getQuranversesSpannable() {
        return quranversesSpannable;
    }

    @Ignore
    public void setQuranversesSpannable(SpannableString quranversesSpannable) {
        this.quranversesSpannable = quranversesSpannable;
    }

    @Ignore
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
    public SpannableString getSpannedarabicverb() {
        return spannedarabicverb;
    }

    @Ignore
    public void setSpannedarabicverb(SpannableString spannedarabicverb) {
        this.spannedarabicverb = spannedarabicverb;
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

    public String getArabicword() {
        return arabicword;
    }

    public void setArabicword(String arabicword) {
        this.arabicword = arabicword;
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

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
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

    public String getTense() {
        return tense;
    }

    public void setTense(String tense) {
        this.tense = tense;
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

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}
