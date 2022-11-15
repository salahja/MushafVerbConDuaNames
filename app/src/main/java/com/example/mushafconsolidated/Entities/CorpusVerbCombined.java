package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

//"SELECT CorpusExpand.rootaraone || rootaratwo || rootarathree || rootarafour || rootarafive AS root_a,
//       CorpusExpand.surah,
//       CorpusExpand.ayah,
//       CorpusExpand.wordno,
//       CorpusExpand.wordcount,
//       Qurans.translation,
//       CorpusExpand.araone,
//       CorpusExpand.aratwo,
//       CorpusExpand.arathree,
//       CorpusExpand.arafour,
//       CorpusExpand.arafive,
//       CorpusExpand.rootaraone,
//       CorpusExpand.rootaratwo,
//       CorpusExpand.rootarathree,
//       CorpusExpand.rootarafour,
//       CorpusExpand.rootarafive,
//       CorpusExpand.lemaraone,
//       CorpusExpand.lemaratwo,
//       CorpusExpand.lemrathree,
//       CorpusExpand.lemarafour,
//       CorpusExpand.lemarafive,
//            CorpusExpand.form_one,
//       CorpusExpand.form_two,
//       CorpusExpand.form_three,
//       CorpusExpand.form_four,
//       CorpusExpand.form_five,
//       CorpusExpand.tagone,
//       CorpusExpand.tagtwo,
//       CorpusExpand.tagthree,
//       CorpusExpand.tagfour,
//       CorpusExpand.tagfive,
//       CorpusExpand.detailsone,
//       CorpusExpand.detailstwo,
//       CorpusExpand.detailsthree,
//       CorpusExpand.detailsfour,
//       CorpusExpand.detailsfive,
//       wbw.en,
//       wbw.bn,
//       wbw.[in],
//       qurans.qurantext,verbcorpus.tense,verbcorpus.root_a,verbcorpus.form,verbcorpus.thulathibab,
//       verbcorpus.details,verbcorpus.POS,verbcorpus.tense,verbcorpus.voice,
//       verbcorpus.lemma_b,verbcorpus.gendernumber,verbcorpus.mood_kananumbers,verbcorpus.kana_mood,
//       verbcorpus.lemma_a
//  FROM corpusexpand,
//       qurans,
//       wbw,verbcorpus
// WHERE CorpusExpand.surah == "2"AND CorpusExpand.ayah== "3"AND
//       corpusexpand.surah = wbw.surah AND
//       corpusexpand.ayah = wbw.ayah AND
//       corpusexpand.wordno = wbw.wordno AND
//       corpusexpand.surah = qurans.surah AND
//       corpusexpand.ayah = qurans.ayah and
//       corpusexpand.surah=verbcorpus.chapterno and
//       corpusexpand.ayah=verbcorpus.verseno
// ORDER BY corpusexpand.surah,
//          corpusexpand.ayah"
public class CorpusVerbCombined {
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
    private String rootaraone;
    private String rootaratwo;
    private String rootarathree;
    private String rootarafour;
    private String rootarafive;
    private String lemaraone;
    private String lemaratwo;
    private String lemarathree;
    private String lemarafour;
    private String lemarafive;
    private String form_one;
    private String form_two;
    private String form_three;
    private String form_four;
    private String form_five;
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
    private String qurantext;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    public CorpusVerbCombined(String root_a, int surah, int ayah, int wordno, int wordcount, String translation, String araone, String aratwo, String arathree, String arafour, String arafive, String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String detailsone, String detailstwo, String detailsthree, String detailsfour, String detailsfive, String en, String bn, String in) {
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
    }

    public String getQurantext() {
        return qurantext;
    }

    public void setQurantext(String qurantext) {
        this.qurantext = qurantext;
    }

    public String getLemaraone() {
        return lemaraone;
    }

    public void setLemaraone(String lemaraone) {
        this.lemaraone = lemaraone;
    }

    public String getLemaratwo() {
        return lemaratwo;
    }

    public void setLemaratwo(String lemaratwo) {
        this.lemaratwo = lemaratwo;
    }

    public String getLemarathree() {
        return lemarathree;
    }

    public void setLemarathree(String lemarathree) {
        this.lemarathree = lemarathree;
    }

    public String getLemarafour() {
        return lemarafour;
    }

    public void setLemarafour(String lemarafour) {
        this.lemarafour = lemarafour;
    }

    public String getLemarafive() {
        return lemarafive;
    }

    public void setLemarafive(String lemarafive) {
        this.lemarafive = lemarafive;
    }

    public String getForm_one() {
        return form_one;
    }

    public void setForm_one(String form_one) {
        this.form_one = form_one;
    }

    public String getForm_two() {
        return form_two;
    }

    public void setForm_two(String form_two) {
        this.form_two = form_two;
    }

    public String getForm_three() {
        return form_three;
    }

    public void setForm_three(String form_three) {
        this.form_three = form_three;
    }

    public String getForm_four() {
        return form_four;
    }

    public void setForm_four(String form_four) {
        this.form_four = form_four;
    }

    public String getForm_five() {
        return form_five;
    }

    public void setForm_five(String form_five) {
        this.form_five = form_five;
    }

    public String getRootaraone() {
        return rootaraone;
    }

    public void setRootaraone(String rootaraone) {
        this.rootaraone = rootaraone;
    }

    public String getRootaratwo() {
        return rootaratwo;
    }

    public void setRootaratwo(String rootaratwo) {
        this.rootaratwo = rootaratwo;
    }

    public String getRootarathree() {
        return rootarathree;
    }

    public void setRootarathree(String rootarathree) {
        this.rootarathree = rootarathree;
    }

    public String getRootarafour() {
        return rootarafour;
    }

    public void setRootarafour(String rootarafour) {
        this.rootarafour = rootarafour;
    }

    public String getRootarafive() {
        return rootarafive;
    }

    public void setRootarafive(String rootarafive) {
        this.rootarafive = rootarafive;
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
}