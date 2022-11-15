package com.example.mushafconsolidated.Activity;

import android.content.Context;

import com.example.mushafconsolidated.model.Word;

import java.util.ArrayList;

public class SplitQuranVerses {
    // --Commented out by Inspection (26/04/22, 12:48 AM):private List<CorpusAyahWord> corpusayahWordArrayList;

    public SplitQuranVerses(Context context) {
    }

    public ArrayList<Word> splitSingleVerse(String quraverses) {
        ArrayList<Word> ayahWordArrayList = new ArrayList<>();
        String[] s = quraverses.split(" ");
        for (int i = 0; i < s.length; i++) {
            Word word = new Word();
            word.setWordsAr(s[i]);
            word.setWordno(i + 1);
            ayahWordArrayList.add(word);
        }
        return ayahWordArrayList;
        //     return ayahWords;
    }

    public ArrayList<Word> splitSingleVerse(String quraverses, int surah, int ayah, int startwordno) {
        ArrayList<Word> ayahWordArrayList = new ArrayList<>();
        String[] s = quraverses.split(" ");
        for (int i = 0; i < s.length; i++) {
            Word word = new Word();
            word.setWordsAr(s[i]);
            word.setWordno(i + 1);
            word.setSurahId(surah);
            word.setVerseId(ayah);
            word.setWordcount(startwordno);
            word.setTranslate(quraverses);
            ayahWordArrayList.add(word);
        }
        return ayahWordArrayList;
        //     return ayahWords;
    }

    public ArrayList<Word> splitSingleVerse(String quraverses, int surah, int ayah) {
        ArrayList<Word> ayahWordArrayList = new ArrayList<>();
        String[] s = quraverses.split(" ");
        for (int i = 0; i < s.length; i++) {
            Word word = new Word();
            word.setWordsAr(s[i]);
            word.setWordno(i + 1);
            word.setSurahId(surah);
            word.setVerseId(ayah);
            ayahWordArrayList.add(word);
        }
        return ayahWordArrayList;
        //     return ayahWords;
    }


}