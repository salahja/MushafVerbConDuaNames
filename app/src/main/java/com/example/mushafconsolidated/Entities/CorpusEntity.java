package com.example.mushafconsolidated.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "CorpusExpand")
public class CorpusEntity {
    @NonNull
    private final int surah;
    @NonNull
    private final int ayah;
    @NonNull
    private final int wordno;
    @NonNull
    private final int wordcount;
    private final String araone;
    private final String aratwo;
    private final String arathree;
    private final String arafour;
    private final String arafive;
    private final String tagone;
    private final String tagtwo;
    private final String tagthree;
    private final String tagfour;
    private final String tagfive;
    private final String rootaraone;
    private final String rootaratwo;
    private final String rootarathree;
    private final String rootarafour;
    private final String rootarafive;
    private final String lemaraone;
    private final String lemaratwo;
    private final String lemarathree;
    private final String lemarafour;
    private final String lemarafive;
    private final String lemma_b_one;
    private final String form_one;
    private final String form_two;
    private final String form_three;
    private final String form_four;
    private final String form_five;
    private final String detailsone;
    private final String detailstwo;
    private final String detailsthree;
    private final String detailsfour;
    private final String detailsfive;
    private final String lemma_b_two;
    private final String lemma_b_three;
    private final String lemma_b_four;
    private final String lemma_b_five;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private final int id;
    @NonNull
    private int juz;

    public CorpusEntity(int surah, int ayah, int wordno, int wordcount, String araone, String aratwo, String arathree, String arafour, String arafive, String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String rootaraone, String rootaratwo, String rootarathree, String rootarafour, String rootarafive, String lemaraone, String lemaratwo, String lemarathree, String lemarafour, String lemarafive, String lemma_b_one, String form_one, String form_two, String form_three, String form_four, String form_five, String detailsone, String detailstwo, String detailsthree, String detailsfour, String detailsfive, String lemma_b_two, String lemma_b_three, String lemma_b_four, String lemma_b_five, int id, int juz) {
        this.surah = surah;
        this.ayah = ayah;
        this.wordno = wordno;
        this.wordcount = wordcount;
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
        this.rootaraone = rootaraone;
        this.rootaratwo = rootaratwo;
        this.rootarathree = rootarathree;
        this.rootarafour = rootarafour;
        this.rootarafive = rootarafive;
        this.lemaraone = lemaraone;
        this.lemaratwo = lemaratwo;
        this.lemarathree = lemarathree;
        this.lemarafour = lemarafour;
        this.lemarafive = lemarafive;
        this.lemma_b_one = lemma_b_one;
        this.form_one = form_one;
        this.form_two = form_two;
        this.form_three = form_three;
        this.form_four = form_four;
        this.form_five = form_five;
        this.detailsone = detailsone;
        this.detailstwo = detailstwo;
        this.detailsthree = detailsthree;
        this.detailsfour = detailsfour;
        this.detailsfive = detailsfive;
        this.lemma_b_two = lemma_b_two;
        this.lemma_b_three = lemma_b_three;
        this.lemma_b_four = lemma_b_four;
        this.lemma_b_five = lemma_b_five;
        this.id = id;
        this.juz = juz;
    }

    public int getSurah() {
        return surah;
    }

    public int getAyah() {
        return ayah;
    }

    public int getWordno() {
        return wordno;
    }

    public int getWordcount() {
        return wordcount;
    }

    public String getAraone() {
        return araone;
    }

    public String getAratwo() {
        return aratwo;
    }

    public String getArathree() {
        return arathree;
    }

    public String getArafour() {
        return arafour;
    }

    public String getArafive() {
        return arafive;
    }

    public String getTagone() {
        return tagone;
    }

    public String getTagtwo() {
        return tagtwo;
    }

    public String getTagthree() {
        return tagthree;
    }

    public String getTagfour() {
        return tagfour;
    }

    public String getTagfive() {
        return tagfive;
    }

    public String getRootaraone() {
        return rootaraone;
    }

    public String getRootaratwo() {
        return rootaratwo;
    }

    public String getRootarathree() {
        return rootarathree;
    }

    public String getRootarafour() {
        return rootarafour;
    }

    public String getRootarafive() {
        return rootarafive;
    }

    public String getLemaraone() {
        return lemaraone;
    }

    public String getLemaratwo() {
        return lemaratwo;
    }

    public String getLemarathree() {
        return lemarathree;
    }

    public String getLemarafour() {
        return lemarafour;
    }

    public String getLemarafive() {
        return lemarafive;
    }

    public String getLemma_b_one() {
        return lemma_b_one;
    }

    public String getForm_one() {
        return form_one;
    }

    public String getForm_two() {
        return form_two;
    }

    public String getForm_three() {
        return form_three;
    }

    public String getForm_four() {
        return form_four;
    }

    public String getForm_five() {
        return form_five;
    }

    public String getDetailsone() {
        return detailsone;
    }

    public String getDetailstwo() {
        return detailstwo;
    }

    public String getDetailsthree() {
        return detailsthree;
    }

    public String getDetailsfour() {
        return detailsfour;
    }

    public String getDetailsfive() {
        return detailsfive;
    }

    public String getLemma_b_two() {
        return lemma_b_two;
    }

    public String getLemma_b_three() {
        return lemma_b_three;
    }

    public String getLemma_b_four() {
        return lemma_b_four;
    }

    public String getLemma_b_five() {
        return lemma_b_five;
    }

    public int getId() {
        return id;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }
}