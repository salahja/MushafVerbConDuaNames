package com.example.mushafconsolidated.Activity;

import android.content.Context;

import com.example.mushafconsolidated.model.Word;

import java.util.ArrayList;

public class SplitQuranVerses {
    // --Commented out by Inspection (26/04/22, 12:48 AM):private List<CorpusAyahWord> corpusayahWordArrayList;

    public SplitQuranVerses(Context context) {
    }

    public   ArrayList<Word> splitSingleVerse(String quraverses) {


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

    public   ArrayList<Word> splitSingleVerse(String quraverses,int surah,int ayah,int startwordno) {


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
    public   ArrayList<Word> splitSingleVerse(String quraverses,int surah,int ayah) {


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
// --Commented out by Inspection START (26/04/22, 12:48 AM):
//    public ArrayList<AyahWord> newwordbywordSplitQuran(List<QuranEntity> quraverses) {
//
//
//        ArrayList<AyahWord> ayahWordArrayList = new ArrayList<AyahWord>();
//
//
//        ArrayList<Word> wordArrayList;
//
//
//        // ArrayList<AyahWord> wordbywords = new ArrayList<>();
//        for (QuranEntity vers : quraverses) {
//
//            AyahWord ayahWord = new AyahWord();
//            wordArrayList = new ArrayList<Word>();
//            String[] s = vers.getQurantext().split(" ");
//
//            for (int i = 0; i < s.length; i++) {
//                Word word = new Word();
//                word.setWordsAr(s[i]);
//                word.setSurahId(vers.getSurah());
//                word.setVerseId(vers.getAyah());
//                word.setWordno(i + 1);
//                wordArrayList.add(word);
//            }
//            ayahWord.setWord(wordArrayList);
//            ayahWord.setQuranArabic(vers.getQurantext());
//
//
//            ayahWordArrayList.add(ayahWord);
//        }
//
//
//        return ayahWordArrayList;
//
//        //     return ayahWords;
//    }
// --Commented out by Inspection STOP (26/04/22, 12:48 AM)


// --Commented out by Inspection START (26/04/22, 12:49 AM):
//    public ArrayList<CorpusVerbWbwOccurance> newwordbywordSplitQuran(ArrayList<CorpusVerbWbwOccurance> verblist) {
//        ArrayList<CorpusVerbWbwOccurance> ayahWordArrayList = new ArrayList<CorpusVerbWbwOccurance>();
//        ArrayList<Word> wordArrayList;
//
//        for (CorpusVerbWbwOccurance vers : verblist) {
//            CorpusVerbWbwOccurance ayahword=new CorpusVerbWbwOccurance();
//         //   AyahWord ayahWord = new AyahWord();
//            wordArrayList = new ArrayList<Word>();
//            String[] s = vers.getQurantext().split(" ");
//
//
//            for (int i = 0; i < s.length; i++) {
//                Word word = new Word();
//                word.setWordsAr(s[i]);
//                word.setSurahId(vers.getSurah());
//                word.setVerseId(vers.getAyah());
//                word.setWordno(i + 1);
//                wordArrayList.add(word);
//            }
//
//            ayahword.setWord(wordArrayList);
//
//            ayahword.setForm(vers.getForm());
//            ayahword.setEn(vers.getEn());
//            ayahword.setGendernumber(vers.getGendernumber());
//            ayahword.setMood_kananumbers(vers.getKana_mood());
//            ayahword.setKana_mood(vers.getMood_kananumbers());
//            ayahword.setRoot_a(vers.getRoot_a());
//
//            ayahword.setSpannedarabicverb(vers.getSpannedarabicverb());
//            ayahword.setSurah( (vers.getSurah()));
//
//
//            ayahword.setTense(vers.getTense());
//            ayahword.setThulathibab(vers.getThulathibab());
//            ayahword.setTranslation(vers.getTranslation());
//           ayahword.setVerses(vers.getVerses());
//           ayahword.setVoice(vers.getVoice());
//            ayahword.setWordcount( (vers.getWordcount()));
//            ayahword.setWordno((vers.getWordno()));
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//            ayahWordArrayList.add(ayahword);
//        }
//
//
//
//
//        return ayahWordArrayList;
//    }
// --Commented out by Inspection STOP (26/04/22, 12:49 AM)

// --Commented out by Inspection START (26/04/22, 12:49 AM):
//    public ArrayList<CorpusVerbWbwOccurance> spanablelenewwordbywordSplitQuran(ArrayList<CorpusVerbWbwOccurance> verblist) {
//        ArrayList<CorpusVerbWbwOccurance> ayahWordArrayList = new ArrayList<CorpusVerbWbwOccurance>();
//        ArrayList<WordSpan> wordArrayList;
//        CorpusUtilityorig versespannable=new CorpusUtilityorig(context);
//
//        for (CorpusVerbWbwOccurance vers : verblist) {
//            CorpusVerbWbwOccurance ayahword=new CorpusVerbWbwOccurance();
//            //   AyahWord ayahWord = new AyahWord();
//            wordArrayList = new ArrayList<WordSpan>();
//            SpannableString spannable = vers.getQuranversesSpannable();
//            String[] s = vers.getQurantext().split(" ");
//
//
//            for (int i = 0; i < s.length; i++) {
//                WordSpan word = new WordSpan();
//                if(s[i].equals(vers.getArabicword()))  {
//                    int firstcolortat= Constant.BYELLOW;
//                    SpannableStringBuilder str=new SpannableStringBuilder(vers.getArabicword());
//
//                    str.setSpan(new ForegroundColorSpan(firstcolortat), 0, vers.getArabicword().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                     word.setWordsAr( CorpusUtilityorig.NewSetWordSpan(  vers.getTagone(), vers.getTagtwo(), vers.getTagthree(), vers.getTagfour(), vers.getTagfive(),
//                             vers.getAraone(), vers.getAratwo(), vers.getArathree(), vers.getArafour(), vers.getArafive()));
//
//                }else {
//                    word.setWordsAr(SpannableString.valueOf(s[i]));
//                }
//                word.setSurahId(vers.getSurah());
//                word.setVerseId(vers.getAyah());
//                word.setWordno(i + 1);
//
//
//
//
//                wordArrayList.add(word);
//            }
//
//            ayahword.setWordspan(wordArrayList);
//
//            ayahword.setForm(vers.getForm());
//            ayahword.setEn(vers.getEn());
//            ayahword.setGendernumber(vers.getGendernumber());
//            ayahword.setMood_kananumbers(vers.getKana_mood());
//            ayahword.setKana_mood(vers.getMood_kananumbers());
//            ayahword.setRoot_a(vers.getRoot_a());
//
//            ayahword.setSpannedarabicverb(vers.getSpannedarabicverb());
//            ayahword.setSurah( (vers.getSurah()));
//            ayahword.setAyah(vers.getAyah());
//
//
//            ayahword.setTense(vers.getTense());
//            ayahword.setThulathibab(vers.getThulathibab());
//            ayahword.setTranslation(vers.getTranslation());
//            ayahword.setVerses(vers.getVerses());
//            ayahword.setVoice(vers.getVoice());
//            ayahword.setWordcount( (vers.getWordcount()));
//            ayahword.setWordno((vers.getWordno()));
//            ayahword.setSpannedverb( CorpusUtilityorig.NewSetWordSpan(  vers.getTagone(), vers.getTagtwo(), vers.getTagthree(), vers.getTagfour(), vers.getTagfive(),
//                  vers.getAraone(), vers.getAratwo(), vers.getArathree(), vers.getArafour(), vers.getArafive()));
//
//
//            ayahWordArrayList.add(ayahword);
//        }
//
//
//
//
//        return ayahWordArrayList;
//    }
// --Commented out by Inspection STOP (26/04/22, 12:49 AM)
// --Commented out by Inspection START (26/04/22, 12:48 AM):
//    public ArrayList<CorpusNounWbwOccurance> NounspanablelenewwordbywordSplitQuran(ArrayList<CorpusNounWbwOccurance> verblist) {
//        ArrayList<CorpusNounWbwOccurance> ayahWordArrayList = new ArrayList<CorpusNounWbwOccurance>();
//        ArrayList<WordSpan> wordArrayList;
//      //  CorpusUtility versespannable=new CorpusUtility(context );
//        WordMorphologyDetails wm=new WordMorphologyDetails();
//        for (CorpusNounWbwOccurance vers : verblist) {
//            CorpusNounWbwOccurance ayahword= new CorpusNounWbwOccurance();
//            //   AyahWord ayahWord = new AyahWord();
//            wordArrayList = new ArrayList<WordSpan>();
//
//
//
//            String[] s = vers.getQurantext().split(" ");
//
//
//            for (int i = 0; i < s.length; i++) {
//                WordSpan word = new WordSpan();
//                if(s[i].equals(vers.getArabicword()))  {
//                    int firstcolortat= Constant.BYELLOW;
//                    SpannableStringBuilder str=new SpannableStringBuilder(vers.getArabicword());
//
//                    str.setSpan(new ForegroundColorSpan(firstcolortat), 0, vers.getArabicword().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                    word.setWordsAr( CorpusUtilityorig.NewSetWordSpan(  vers.getTagone(), vers.getTagtwo(), vers.getTagthree(), vers.getTagfour(), vers.getTagfive(),
//                            vers.getAraone(), vers.getAratwo(), vers.getArathree(), vers.getArafour(), vers.getArafive()));
//
//                }else {
//                    word.setWordsAr(SpannableString.valueOf(s[i]));
//                }
//                word.setSurahId(vers.getSurah());
//                word.setVerseId(vers.getAyah());
//                word.setWordno(i + 1);
//
//
//
//
//                wordArrayList.add(word);
//            }
//
//            ayahword.setWordspan(wordArrayList);
//           ayahword.setPropone(vers.getPropone());ayahword.setProptwo(vers.getProptwo());
//            ayahword.setForm(vers.getForm());
//            ayahword.setCases(vers.getCases());
//            ayahword.setEn(vers.getEn());
//            StringBuilder genderNumberdetails = wm.getGenderNumberdetails(vers.getGendernumber());
//            ayahword.setGendernumber(genderNumberdetails.toString());
//                  ayahword.setRoot_a(vers.getRoot_a());
//          //  ayahword.setSpannableNoun(vers.getSpannableNoun());
//            ayahword.setSurah( (vers.getSurah()));
//            ayahword.setAyah(vers.getAyah());
//
//
//           // ayahword.setTense(vers.getTense());
//           // ayahword.setThulathibab(vers.getThulathibab());
//            ayahword.setForm(vers.getForm());
//            ayahword.setTranslation(vers.getTranslation());
//            ayahword.setVerses(SpannableString.valueOf(vers.getQurantext()));
//          //  ayahword.setVoice(vers.getVoice());
//            ayahword.setWordcount( (vers.getWordcount()));
//            ayahword.setWordno((vers.getWordno()));
//            ayahword.setSpannableNoun( CorpusUtilityorig.NewSetWordSpan(  vers.getTagone(), vers.getTagtwo(), vers.getTagthree(), vers.getTagfour(), vers.getTagfive(),
//                  vers.getAraone(), vers.getAratwo(), vers.getArathree(), vers.getArafour(), vers.getArafive()));
//
//
//            ayahWordArrayList.add(ayahword);
//        }
//
//
//
//
//        return ayahWordArrayList;
//    }
// --Commented out by Inspection STOP (26/04/22, 12:48 AM)

}