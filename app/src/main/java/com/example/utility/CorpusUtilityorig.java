package com.example.utility;

import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.YELLOW;
import static com.example.Constant.AYAH_ID;
import static com.example.Constant.BBLUE;
import static com.example.Constant.BCYAN;
import static com.example.Constant.CHAPTER;
import static com.example.Constant.CYANLIGHTEST;
import static com.example.Constant.FORESTGREEN;
import static com.example.Constant.GOLD;
import static com.example.Constant.GREENDARK;
import static com.example.Constant.GREENYELLOW;
import static com.example.Constant.MIDNIGHTBLUE;
import static com.example.Constant.ORANGE400;
import static com.example.Constant.OVAL;
import static com.example.Constant.RECKT;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.WBURNTUMBER;
import static com.example.Constant.WHOTPINK;
import static com.example.Constant.adjectivespanDark;
import static com.example.Constant.adjectivespanLight;
import static com.example.Constant.ammendedparticle;
import static com.example.Constant.answerspanDark;
import static com.example.Constant.answerspanLight;
import static com.example.Constant.certainityspanDark;
import static com.example.Constant.certainityspanLight;
import static com.example.Constant.deepburnsienna;
import static com.example.Constant.demonstrativespanDark;
import static com.example.Constant.demonstrativespanLight;
import static com.example.Constant.determinerspanDark;
import static com.example.Constant.determinerspanLight;
import static com.example.Constant.emphspanDark;
import static com.example.Constant.emphspanLight;
import static com.example.Constant.eqspanlight;
import static com.example.Constant.halspanDark;
import static com.example.Constant.harfinnaspanDark;
import static com.example.Constant.harfismspanDark;
import static com.example.Constant.harfkhabarspanDark;
import static com.example.Constant.harfsababiaspanDark;
import static com.example.Constant.harfsababiaspanLight;
import static com.example.Constant.harfshartspanDark;
import static com.example.Constant.inceptivepartile;
import static com.example.Constant.interrogativespanDark;
import static com.example.Constant.interrogativespanLight;
import static com.example.Constant.jawabshartspanDark;
import static com.example.Constant.lamimpvspanDark;
import static com.example.Constant.lamimpvspanLight;
import static com.example.Constant.lamtaleelspandDark;
import static com.example.Constant.lamtaleelspandLight;
import static com.example.Constant.locationadverspanDark;
import static com.example.Constant.locationadverspanLight;
import static com.example.Constant.masdariaspanDark;
import static com.example.Constant.masdariaspanLight;
import static com.example.Constant.mudhafspansDark;
import static com.example.Constant.nasabspanDark;
import static com.example.Constant.nasabspanLight;
import static com.example.Constant.negativespanDark;
import static com.example.Constant.negativespanLight;
import static com.example.Constant.nounspanDark;
import static com.example.Constant.nounspanLight;
import static com.example.Constant.particlespanDark;
import static com.example.Constant.particlespanLight;
import static com.example.Constant.prepositionspanDark;
import static com.example.Constant.prepositionspanLight;
import static com.example.Constant.prohibitionspanDark;
import static com.example.Constant.prohibitionspanLight;
import static com.example.Constant.pronounspanDark;
import static com.example.Constant.pronounspanLight;
import static com.example.Constant.propernounspanDark;
import static com.example.Constant.propernounspanLight;
import static com.example.Constant.prussianblue;
import static com.example.Constant.relativespanDark;
import static com.example.Constant.relativespanLight;
import static com.example.Constant.restrictivespanDark;
import static com.example.Constant.restrictivespanLight;
import static com.example.Constant.resultparticlespanDark;
import static com.example.Constant.resultparticlespanLight;
import static com.example.Constant.resumtionspanDark;
import static com.example.Constant.shartspanDark;
import static com.example.Constant.sifaspansDark;
import static com.example.Constant.supplementspanLight;
import static com.example.Constant.supplementspoanDark;
import static com.example.Constant.surprisespanDark;
import static com.example.Constant.surprisespanLight;
import static com.example.Constant.timeadverbspanDark;
import static com.example.Constant.timeadverbspanLight;
import static com.example.Constant.verbalnounspanDark;
import static com.example.Constant.verbalnounspanLight;
import static com.example.Constant.verbspanDark;
import static com.example.Constant.verbspanLight;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.Constant;
import com.example.JustJava.FrameSpan;
import com.example.JustJava.TextBorderSpan;
import com.example.mushafconsolidated.Entities.MousufSifa;
import com.example.mushafconsolidated.Entities.NewKanaEntity;
import com.example.mushafconsolidated.Entities.NewMudhafEntity;
import com.example.mushafconsolidated.Entities.NewNasbEntity;
import com.example.mushafconsolidated.Entities.NewShartEntity;
import com.example.mushafconsolidated.Entities.SifaEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.model.CorpusAyahWord;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CorpusUtilityorig {


// --Commented out by Inspection START (26/04/22, 1:04 AM):
//    public int getSuracounter() {
//        return suracounter;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:04 AM)

// --Commented out by Inspection START (26/04/22, 1:04 AM):
//    public boolean isIsmausoofbrokenplural() {
//        return ismausoofbrokenplural;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:04 AM)

 /*
    public void setIsmausoofbrokenplural(boolean ismausoofbrokenplural) {
        this.ismausoofbrokenplural = ismausoofbrokenplural;
    }

  */
   /*
    public boolean isIsmousoofsifa() {
        return ismousoofsifa;
    }

    */
// --Commented out by Inspection START (26/04/22, 1:17 AM):
//    public void setIsmousoofsifa(boolean ismousoofsifa) {
//        this.ismousoofsifa = ismousoofsifa;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:17 AM)

    public void setSuracounter(int suracounter) {
        this.suracounter = suracounter;
    }

    private final String preferences;
    int suracounter;
    private final Context context;

    int surahid, ayahid;
    final ArrayList<MousufSifa> NEWmousufSifaArrayList = new ArrayList<>();

// --Commented out by Inspection START (26/04/22, 1:17 AM):
//    public void setAyahid(int ayahid) {
//        this.ayahid = ayahid;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:17 AM)

// --Commented out by Inspection START (26/04/22, 1:16 AM):
//    public int getSurahid() {
//        return surahid;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:16 AM)

    public void setSurahid(int surahid) {
        this.surahid = surahid;
    }

    public int getAyahid() {
        return ayahid;
    }

    public int getSuraid() {
        return suraid;
    }

    public void setSuraid(int suraid) {
        this.suraid = suraid;
    }

    public int suraid;


    public CorpusUtilityorig(Context context) {
        this.context = context;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        preferences = prefs.getString("theme", "dark");


    }

    public static HashMap<String, String> getpreferences() {
        HashMap<String, String> lastread = new HashMap<>();
        SharedPreferences pref = QuranGrammarApplication.getContext().getSharedPreferences("lastread", MODE_PRIVATE);


        int surah = pref.getInt(CHAPTER, 1);
        int ayah = pref.getInt(AYAH_ID, 1);
        String surahname = pref.getString(SURAH_ARABIC_NAME, "");
        lastread.put(CHAPTER, String.valueOf(surah));
        lastread.put(AYAH_ID, String.valueOf(ayah));
        lastread.put(SURAH_ARABIC_NAME, surahname);
        return lastread;


    }

    public static SpannableString NewSetWordSpanTag(String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String arafive, String arafour, String arathree, String aratwo, String araone) {
        SpannableString str = null;
        int tagcounter = 0;
        boolean b = tagone.length() > 0;
        boolean bb = tagtwo.length() > 0;

        boolean bbb = tagthree.length() > 0;
        boolean bbbb = tagfour.length() > 0;
        boolean bbbbb = tagfive.length() > 0;
        if (b && (!bb && !bbb && !bbbb && !bbbbb)) {
            tagcounter = 1;
        } else if (b && bb && (!bbb && !bbbb && !bbbbb)) {
            tagcounter = 2;
        } else if (b && bb && bbb && (!bbbb && !bbbbb)) {
            tagcounter = 3;
        } else if (b && bb && bbb && bbbb && (!bbbbb)) {
            tagcounter = 4;
        } else if (b && bb && bbb && bbbb && bbbbb) {
            tagcounter = 5;
        }
//
//
        araone = araone.trim();
        aratwo = aratwo.trim();
        arathree = arathree.trim();
        arafour = arafour.trim();
        arafive = arafive.trim();
//
        Map<String, ForegroundColorSpan> spanhash;
        spanhash = getStringForegroundColorSpanMap();
        if (tagcounter == 1) {
         //   Set<String> strings = spanhash.keySet();

            str = new SpannableString(araone.trim() + aratwo.trim() + arathree.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 2) {


            //  str = new SpannableString(aratwo.trim() + araone.trim());
            str = new SpannableString(aratwo.concat(" ") + araone);
            str.setSpan(spanhash.get(tagtwo), 0, aratwo.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagone), aratwo.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else if (tagcounter == 3) {

            spanhash.get(tagone);

            //   str = new SpannableString(arathree.trim() + aratwo.trim() + araone.trim());
            str = new SpannableString(arathree.concat(" ") + aratwo.concat(" ") + araone);


            str.setSpan(spanhash.get(tagthree), 0, arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), arathree.length(), aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagone), arathree.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 4) {

            //  str = new SpannableString(arafour.trim() + arathree.trim() + aratwo.trim() + araone.trim());
            str = new SpannableString(arafour.concat(" ") + arathree.concat(" ") + aratwo.concat(" ") + araone);
            str.setSpan(spanhash.get(tagfour), 0, arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), arafour.length(), arathree.length() + arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), arathree.length() + arafour.length(), aratwo.length() + arathree.length() + arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagone), arafour.length() + arathree.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length() + arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 5) {


            int five = arafive.trim().length();
            int four = arafour.trim().length();
            int three = arathree.trim().length();
            int two = aratwo.trim().length();
            int one = araone.trim().length();

            str = new SpannableString(arafive.trim() + arafour.trim() + arathree.trim() + aratwo.trim() + araone.trim());
            str.setSpan(spanhash.get(tagfive), two + three + four + five, one + two + three + four + five, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfour), three + four + five, two + three + four + five, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //     str.setSpan(resultparticlespanDark, two + three + four, one + two + three + four, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), four + five, three + four + five, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), five, four + five, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagone), 0, five, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }


        return str;
    }

    StyleSpan style = new StyleSpan(Typeface.BOLD);

    public static SpannableString ColorizeRootword(String tagone, String tagtwo, String tagthree, String tagfour, String tagfive,
                                                   String rootword) {


        SpannableString str = null;
        int tagcounter = 0;
        boolean b = tagone.length() > 0;
        boolean bb = tagtwo.length() > 0;

        boolean bbb = tagthree.length() > 0;
        boolean bbbb = tagfour.length() > 0;
        boolean bbbbb = tagfive.length() > 0;

        if (b && (!bb && !bbb && !bbbb && !bbbbb)) {
            tagcounter = 1;
        } else if (b && bb && (!bbb && !bbbb && !bbbbb)) {
            tagcounter = 2;
        } else if (b && bb && bbb && (!bbbb && !bbbbb)) {
            tagcounter = 3;
        } else if (b && bb && bbb && bbbb && (!bbbbb)) {
            tagcounter = 4;
        } else if (b && bb && bbb && bbbb && bbbbb) {
            tagcounter = 5;
        }


        Map<String, ForegroundColorSpan> spanhash;
        //   SharedPreferences sharedPreferences =
        //      androidx.preference.PreferenceManager.getDefaultSharedPreferences(DarkThemeApplication.getContext());
        //   String isNightmode = sharedPreferences.getString("themepref", "dark" );
        //   if (isNightmode.equals("dark")||isNightmode.equals("blue")) {
        spanhash = getStringForegroundColorSpanMap();
        //  }else{
        //   spanhash = getColorSpanforPhrasesLight();
        //  }


        if (tagcounter == 1) {
            Set<String> strings = spanhash.keySet();
            str = new SpannableString(rootword.trim());
            str.setSpan(spanhash.get(tagone), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 2) {
            if (tagone.equals("N") || tagone.equals("ADJ") || tagone.equals("PN") || tagone.equals("V")) {
                str = new SpannableString(rootword.trim());
                str.setSpan(spanhash.get(tagone), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            } else if (tagtwo.equals("N") || tagtwo.equals("ADJ") || tagtwo.equals("PN") || tagtwo.equals("V")) {
                str = new SpannableString(rootword.trim());
                str.setSpan(spanhash.get(tagtwo), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

        } else if (tagcounter == 3) {
            if (tagone.equals("N") || tagone.equals("ADJ") || tagone.equals("PN") || tagone.equals("V")) {
                str = new SpannableString(rootword.trim());
                str.setSpan(spanhash.get(tagone), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            } else if (tagtwo.equals("N") || tagtwo.equals("ADJ") || tagtwo.equals("PN") || tagtwo.equals("V")) {
                str = new SpannableString(rootword.trim());
                str.setSpan(spanhash.get(tagtwo), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            } else if (tagthree.equals("N") || tagthree.equals("ADJ") || tagthree.equals("PN") || tagthree.equals("V")) {
                str = new SpannableString(rootword.trim());
                str.setSpan(spanhash.get(tagthree), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
        }else if (tagcounter == 4) {
                if (tagone.equals("N") || tagone.equals("ADJ") || tagone.equals("PN") || tagone.equals("V")) {
                    str = new SpannableString(rootword.trim());
                    str.setSpan(spanhash.get(tagone), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } else if (tagtwo.equals("N") || tagtwo.equals("ADJ") || tagtwo.equals("PN") || tagtwo.equals("V")) {
                    str = new SpannableString(rootword.trim());
                    str.setSpan(spanhash.get(tagtwo), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } else if (tagthree.equals("N") || tagthree.equals("ADJ") || tagthree.equals("PN") || tagthree.equals("V")) {
                    str = new SpannableString(rootword.trim());
                    str.setSpan(spanhash.get(tagthree), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } else if (tagfour.equals("N") || tagfour.equals("ADJ") || tagfour.equals("PN") || tagfour.equals("V")) {
                    str = new SpannableString(rootword.trim());
                    str.setSpan(spanhash.get(tagthree), 0, rootword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                }


        }

        return str;
    }


    public static SpannableString NewSetWordSpan(String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String araone, String aratwo, String arathree, String arafour, String arafive) {



        SpannableString str;

      /* for rukus render
      //  boolean istagnull=tagone==null || tagtwo==null || tagthree==null||tagfour==null||tagfive==null;
        if(istagnull){
            return str = new SpannableString(araone);
        }
       */
        int tagcounter = 0;
        boolean b = tagone.length() > 0;
        boolean bb = tagtwo.length() > 0;

        boolean bbb = tagthree.length() > 0;
        boolean bbbb = tagfour.length() > 0;
        boolean bbbbb = tagfive.length() > 0;
        if (b && (!bb && !bbb && !bbbb && !bbbbb)) {
            tagcounter = 1;
        } else if (b && bb && (!bbb && !bbbb && !bbbbb)) {
            tagcounter = 2;
        } else if (b && bb && bbb && (!bbbb && !bbbbb)) {
            tagcounter = 3;
        } else if (b && bb && bbb && bbbb && (!bbbbb)) {
            tagcounter = 4;
        } else if (b && bb && bbb && bbbb && bbbbb) {
            tagcounter = 5;
        }


        araone = araone.trim();
        aratwo = aratwo.trim();
        arathree = arathree.trim();
        arafour = arafour.trim();
        arafive = arafive.trim();
        Map<String, ForegroundColorSpan> spanhash;
        //   SharedPreferences sharedPreferences =
        //      androidx.preference.PreferenceManager.getDefaultSharedPreferences(DarkThemeApplication.getContext());
        //   String isNightmode = sharedPreferences.getString("themepref", "dark" );
        //   if (isNightmode.equals("dark")||isNightmode.equals("blue")) {
        spanhash = getStringForegroundColorSpanMap();
        //  }else{
        //   spanhash = getColorSpanforPhrasesLight();
        //  }


        if (tagcounter == 1) {
            Set<String> strings = spanhash.keySet();
            str = new SpannableString(araone.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 2) {
            str = new SpannableString(araone.trim() + aratwo.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else if (tagcounter == 3) {

            spanhash.get(tagone);
            str = new SpannableString(araone.trim() + aratwo.trim() + arathree.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 4) {


            str = new SpannableString(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfour), araone.length() + aratwo.length() + arathree.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //    str.setSpan(attachedpronoun, araone.length() + aratwo.length() + arathree.length() + arafour.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length() + arafive.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else if (tagcounter == 5) {


            str = new SpannableString(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim() + arafive.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfour), araone.length() + aratwo.length() + arathree.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfive), araone.length() + aratwo.length() + arathree.length() + arafour.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length() + arafive.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        } else {
            str = new SpannableString(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim() + arafive.trim());
        }


        return str;
    }

    @NonNull
    public static Map<String, ForegroundColorSpan> getStringForegroundColorSpanMap() {
        Map<String, ForegroundColorSpan> spanhash = new HashMap<>();
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = sharedPreferences.getString("themepref", "dark");
        if (isNightmode.equals("dark") || isNightmode.equals("blue") || isNightmode.equals("white")) {
            spanhash.put("PN", propernounspanDark);
            spanhash.put("REL", relativespanDark);
            spanhash.put("DEM", demonstrativespanDark);
            spanhash.put("N", nounspanDark);
            spanhash.put("PRON", pronounspanDark);
            spanhash.put("DET", determinerspanDark);
            spanhash.put("V", verbspanDark);
            spanhash.put("P", prepositionspanDark);
            spanhash.put("T", timeadverbspanDark);
            spanhash.put("LOC", locationadverspanDark);
            spanhash.put("ADJ", adjectivespanDark);
            spanhash.put("VN", verbalnounspanDark);
            spanhash.put("EMPH", emphspanDark);// "Emphatic lām prefix(لام التوكيد) ",
            spanhash.put("IMPV", lamimpvspanDark);// "Imperative lāmprefix(لام الامر)",
            spanhash.put("PRP", lamtaleelspandDark);// "Purpose lāmprefix(لام التعليل)",
            spanhash.put("SUB", masdariaspanDark);// "	Subordinating conjunction(حرف مصدري)",
            spanhash.put("ACC", nasabspanDark);// "	Accusative particle(حرف نصب)",
            spanhash.put("ANS", answerspanDark);// "	Answer particle	(حرف جواب)",
            spanhash.put("CAUS", harfsababiaspanDark);// "Particle of cause	(حرف سببية)",
            spanhash.put("CERT", certainityspanDark);// "Particle of certainty	(حرف تحقيق)",
            spanhash.put("CIRC", halspanDark);// "Circumstantial particle	(حرف حال)",

            spanhash.put("CONJ", particlespanDark);// "Coordinating conjunction(حرف عطف)",
            spanhash.put("COND", harfshartspanDark);// "Conditional particle(حرف شرط)",
            spanhash.put("AMD", particlespanDark);// "	Amendment particle(حرف استدراك)	",
            spanhash.put("AVR", particlespanDark);// "	Aversion particle	(حرف ردع)",
            spanhash.put("COM", particlespanDark);// "	Comitative particle	(واو المعية)",
            spanhash.put("EQ", particlespanDark);// "	Equalization particle(حرف تسوية)",
            spanhash.put("EXH", particlespanDark);// "	Exhortation particle(حرف تحضيض)",
            spanhash.put("EXL", particlespanDark);// "	Explanation particle(حرف تفصيل)",
            spanhash.put("EXP", particlespanDark);// "	Exceptive particle	(أداة استثناء)",
            spanhash.put("FUT", particlespanDark);// "	Future particle	(حرف استقبال)",
            spanhash.put("INC", particlespanDark);// "	Inceptive particle	(حرف ابتداء)",
            spanhash.put("INT", particlespanDark);// "	Particle of interpretation(حرف تفسير)",
            spanhash.put("RET", particlespanDark);// "	Retraction particle	(حرف اضراب)",
            spanhash.put("PREV", particlespanDark);// "Preventive particle	(حرف كاف)",
            spanhash.put("VOC", particlespanDark);// "	Vocative particle	(حرف نداء)",
            spanhash.put("INL", particlespanDark);// "	Quranic initials(	(حروف مقطعة	";

            spanhash.put("INTG", interrogativespanDark);// "Interogative particle	(حرف استفهام)",
            spanhash.put("NEG", negativespanDark);// "	Negative particle(حرف نفي)",

            spanhash.put("PRO", prohibitionspanDark);// "	Prohibition particle(حرف نهي)",
            spanhash.put("REM", resumtionspanDark);// "	Resumption particle	(حرف استئنافية)",
            spanhash.put("RES", restrictivespanDark);// "	Restriction particle(أداة حصر)",

            spanhash.put("RSLT", resultparticlespanDark);// "Result particle(حرف واقع في جواب الشرط)",
            spanhash.put("SUP", supplementspoanDark);// "	Supplemental particle	(حرف زائد)",
            spanhash.put("SUR", surprisespanDark);// "	Surprise particle	(حرف فجاءة)",
        } else {

            spanhash.put("PN", propernounspanLight);
            spanhash.put("REL", relativespanLight);
            spanhash.put("DEM", demonstrativespanLight);
            spanhash.put("N", nounspanLight);
            spanhash.put("PRON", pronounspanLight);
            spanhash.put("DET", determinerspanLight);
            spanhash.put("V", verbspanLight);
            spanhash.put("P", prepositionspanLight);
            spanhash.put("T", timeadverbspanLight);
            spanhash.put("LOC", locationadverspanLight);
            spanhash.put("ADJ", adjectivespanLight);
            spanhash.put("VN", verbalnounspanLight);
            spanhash.put("EMPH", emphspanLight);// "Emphatic lām prefix(لام التوكيد) ",
            spanhash.put("IMPV", lamimpvspanLight);// "Imperative lāmprefix(لام الامر)",
            spanhash.put("PRP", lamtaleelspandLight);// "Purpose lāmprefix(لام التعليل)",
            spanhash.put("SUB", masdariaspanLight);// "	Subordinating conjunction(حرف مصدري)",
            spanhash.put("ACC", nasabspanLight);// "	Accusative particle(حرف نصب)",
            spanhash.put("ANS", answerspanLight);// "	Answer particle	(حرف جواب)",
            spanhash.put("CAUS", harfsababiaspanLight);// "Particle of cause	(حرف سببية)",
            spanhash.put("CERT", certainityspanLight);// "Particle of certainty	(حرف تحقيق)",
            spanhash.put("CIRC", particlespanLight);// "Circumstantial particle	(حرف حال)",

            spanhash.put("CONJ", particlespanLight);// "Coordinating conjunction(حرف عطف)",
            spanhash.put("COND", eqspanlight);// "Conditional particle(حرف شرط)",
            spanhash.put("AMD", ammendedparticle);// "	Amendment particle(حرف استدراك)	",
            spanhash.put("AVR", particlespanLight);// "	Aversion particle	(حرف ردع)",
            spanhash.put("COM", particlespanLight);// "	Comitative particle	(واو المعية)",
            spanhash.put("EQ", particlespanLight);// "	Equalization particle(حرف تسوية)",
            spanhash.put("EXH", particlespanLight);// "	Exhortation particle(حرف تحضيض)",
            spanhash.put("EXL", particlespanLight);// "	Explanation particle(حرف تفصيل)",
            spanhash.put("EXP", particlespanLight);// "	Exceptive particle	(أداة استثناء)",
            spanhash.put("FUT", particlespanLight);// "	Future particle	(حرف استقبال)",
            spanhash.put("INC", nasabspanLight);// "	Inceptive particle	(حرف ابتداء)",
            spanhash.put("INT", particlespanLight);// "	Particle of interpretation(حرف تفسير)",
            spanhash.put("RET", particlespanLight);// "	Retraction particle	(حرف اضراب)",
            spanhash.put("PREV", inceptivepartile);// "Preventive particle	(حرف كاف)",
            spanhash.put("VOC", particlespanLight);// "	Vocative particle	(حرف نداء)",
            spanhash.put("INL", particlespanLight);// "	Quranic initials(	(حروف مقطعة	";

            spanhash.put("INTG", interrogativespanLight);// "Interogative particle	(حرف استفهام)",
            spanhash.put("NEG", negativespanLight);// "	Negative particle(حرف نفي)",

            spanhash.put("PRO", prohibitionspanLight);// "	Prohibition particle(حرف نهي)",
            spanhash.put("REM", particlespanLight);// "	Resumption particle	(حرف استئنافية)",
            spanhash.put("RES", restrictivespanLight);// "	Restriction particle(أداة حصر)",

            spanhash.put("RSLT", resultparticlespanLight);// "Result particle(حرف واقع في جواب الشرط)",
            spanhash.put("SUP", supplementspanLight);// "	Supplemental particle	(حرف زائد)",
            spanhash.put("SUR", surprisespanLight);// "	Surprise particle	(حرف فجاءة)",
        }


        return spanhash;
    }


    public void SetMousufSifaDB(ArrayList<CorpusAyahWord> corpusayahWordArrayList, int surah_id) {
        Utils utils = new Utils(QuranGrammarApplication.getContext());
        final ArrayList<SifaEntity> surah = utils.getSifabySurah(surah_id);
      //  SpannableStringBuilder spannableverse = null;
       // SpannableString spannableString = null;
//todo 2 188 iza ahudu
        //todo 9;92 UNCERTAIN
        //TODO 9:94 JAWABHARMAHDOOF 9 95 JAWABHSARMAHODFF
        //TO 9;118 IZA IN THE MEANING OF HEENA AND 9 122 IZA AS HEENA


        for (SifaEntity sifaEntity : surah) {

            int indexstart = sifaEntity.getStartindex();
            int indexend = sifaEntity.getEndindex();
            //  sifaspans = new BackgroundColorSpan(WBURNTUMBER);
            FrameSpan frameshartharf = new FrameSpan(GREEN, 2, RECKT);
            FrameSpan frameshart = new FrameSpan(CYAN, 2f, RECKT);
      //      FrameSpan framejawabshart = new FrameSpan(YELLOW, 2f, RECKT);

          //  boolean iscolored = true;

            SifaSpansSetup(true, frameshartharf, frameshart, corpusayahWordArrayList, sifaEntity, indexstart, indexend);


        }
    }

    private void SifaSpansSetup(boolean iscolored, FrameSpan frameshartharf, FrameSpan frameshart, ArrayList<CorpusAyahWord> corpusayahWordArrayList, SifaEntity sifaEntity, int indexstart, int indexend) {
        SpannableString spannableverse;
        SpannableString spannableString;
        try {
            spannableverse = corpusayahWordArrayList.get(sifaEntity.getAyah() - 1).getSpannableverse();


            //spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(sifaEntity.getAyah() - 1).getSpannableverse());
            try {

                if (indexstart == 0 || indexstart > 0) {
                    if (iscolored) {
                        //   sifaspansDark = getSpancolor(preferences, false);
                    
                        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white"))  {
                            sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
                        } else {
                            sifaspansDark = new BackgroundColorSpan(CYANLIGHTEST);
                        }


                        spannableverse.setSpan(sifaspansDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        //   spannableverse.setSpan(new UnderlineSpan(),indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    } else
                        spannableverse.setSpan(frameshartharf, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                }


            } catch (IndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
            }

        } catch (IndexOutOfBoundsException e) {
            //System.out.println(e.getMessage());
        }

    }


    public static BackgroundColorSpan getSpancolor(String preferences, boolean b) {
        BackgroundColorSpan sifaspansDark = Constant.sifaspansDark;
        BackgroundColorSpan mudhafspansDark = Constant.mudhafspansDark;
        if (b) {

            if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white")) {
                Constant.mudhafspansDark = new BackgroundColorSpan(MIDNIGHTBLUE);
            } else {
                Constant.mudhafspansDark = new BackgroundColorSpan(GREENYELLOW);
            }
            return mudhafspansDark;

        } else {

        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white")) {
                Constant.sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
            } else {
                Constant.sifaspansDark = new BackgroundColorSpan(CYANLIGHTEST);
            }
            return sifaspansDark;
        }


    }


    public void newnewHarfNasbDb(ArrayList<CorpusAyahWord> corpusayahWordArrayList, int surah_id) {


        Utils utils = new Utils(QuranGrammarApplication.getContext());

        final ArrayList<NewNasbEntity> harfnasb = utils.getHarfNasbIndexesnew(surah_id);
//TODO SURA10 7 INNA ISM INNALIZINA(0,5,6,9 AND KHABR IN 10;8 oolika(0,12,len33)
        if (surah_id == 2 || surah_id == 3 || surah_id == 4 || surah_id == 5 || surah_id == 6 || surah_id == 7 ||
                surah_id == 8 || surah_id == 9 || surah_id == 10 || surah_id == 59 || surah_id == 60 || surah_id == 61 || surah_id == 62 || surah_id == 63
                || surah_id == 64 || surah_id == 65 || surah_id == 66 || surah_id == 67 || surah_id == 68
                || surah_id == 69 || surah_id == 70 || surah_id == 71 || surah_id == 72 || surah_id == 73


                || surah_id == 74 || surah_id == 75 || surah_id == 76 || surah_id == 77 || surah_id == 78
                || surah_id > 78 && surah_id <= 114


        ) {
            SpannableString spannableverse;

            ArrayList<String> err = new ArrayList<>();
            for (NewNasbEntity nasb : harfnasb) {


                int indexstart = nasb.getIndexstart();
                int indexend = nasb.getIndexend();
                int ismstartindex = nasb.getIsmstart();
                int ismendindex = nasb.getIsmend();
                int khabarstart = nasb.getKhabarstart();
                int khabarend = nasb.getKhabarend();

                spannableverse = corpusayahWordArrayList.get(nasb.getAyah() - 1).getSpannableverse();


                try {
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                        harfinnaspanDark = new ForegroundColorSpan(GREEN);
                    } else {
                        harfinnaspanDark = new ForegroundColorSpan(GREENDARK);
                    }

                    //  harfinnaspanDark=new ForegroundColorSpan(GREEN);
                    spannableverse.setSpan(harfinnaspanDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } catch (IndexOutOfBoundsException e) {
                    //    System.out.println(nasb.getSurah() + ":" + nasb.getAyah());
                    err.add(nasb.getSurah() + ":" + nasb.getAyah());
                }


                try {
                    //    spannableverse.setSpan(new ForegroundColorSpan(GOLD), ismindexone, ismindexone + lenism1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                        harfismspanDark = new ForegroundColorSpan(BCYAN);
                    } else {
                        harfismspanDark = new ForegroundColorSpan(prussianblue);
                    }


                    spannableverse.setSpan(harfismspanDark, ismstartindex, ismendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } catch (IndexOutOfBoundsException e) {
                    //     System.out.println(nasb.getSurah() + ":" + nasb.getAyah());
                    err.add(nasb.getSurah() + ":" + nasb.getAyah());
                }

                try {
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                        harfkhabarspanDark = new ForegroundColorSpan(YELLOW);
                    } else {
                        harfkhabarspanDark = new ForegroundColorSpan(deepburnsienna);
                    }


                    spannableverse.setSpan(harfkhabarspanDark, khabarstart, khabarend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                } catch (IndexOutOfBoundsException e) {
                    //   System.out.println(nasb.getSurah() + ":" + nasb.getAyah());
                    err.add(nasb.getSurah() + ":" + nasb.getAyah());
                }


            }


        }

    }


    public void setMudhafFromDB(ArrayList<CorpusAyahWord> corpusayahWordArrayList, int surah_id) {
        Utils utils = new Utils(QuranGrammarApplication.getContext());

        final ArrayList<NewMudhafEntity> surah = utils.getMudhafSurahNew(surah_id);
        SpannableStringBuilder spannableverse = null;
        SpannableString spannableString = null;
//todo 2 188 iza ahudu
        //todo 9;92 UNCERTAIN
        //TODO 9:94 JAWABHARMAHDOOF 9 95 JAWABHSARMAHODFF
        //TO 9;118 IZA IN THE MEANING OF HEENA AND 9 122 IZA AS HEENA


        for (NewMudhafEntity mudhafen : surah) {

            int indexstart = mudhafen.getStartindex();
            int indexend = mudhafen.getEndindex();

            FrameSpan frameshartharf = new FrameSpan(GREEN, 2, RECKT);
            FrameSpan frameshart = new FrameSpan(CYAN, 2f, RECKT);
            FrameSpan framejawabshart = new FrameSpan(YELLOW, 2f, RECKT);
          //  boolean iscolored = true;

            MudhafSpansSetup(true, frameshartharf, corpusayahWordArrayList, mudhafen, indexstart, indexend);

        }


    }

    private void MudhafSpansSetup(boolean iscolored, FrameSpan frameshartharf, ArrayList<CorpusAyahWord> corpusayahWordArrayList, NewMudhafEntity mudhafen, int indexstart, int indexend) {
        SpannableString spannableverse;
      //  SpannableString spannableString;
        try {
            spannableverse = corpusayahWordArrayList.get(mudhafen.getAyah() - 1).getSpannableverse();


            // spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(mudhafen.getAyah() - 1).getSpannableverse());
            try {

                if (indexstart == 0 || indexstart > 0) {
                    if (iscolored) {

                        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                            mudhafspansDark = new BackgroundColorSpan(MIDNIGHTBLUE);

                        } else {
                            mudhafspansDark = new BackgroundColorSpan(GREENYELLOW);

                        }

                        spannableverse.setSpan(mudhafspansDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        //   spannableverse.setSpan(new UnderlineSpan(),indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    } else
                        spannableverse.setSpan(frameshartharf, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                }


            } catch (IndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
            }

        } catch (IndexOutOfBoundsException e) {
            //System.out.println(e.getMessage());
        }

    }

    public void setShart(ArrayList<CorpusAyahWord> corpusayahWordArrayList, int surah_id) {
        Utils utils = new Utils(QuranGrammarApplication.getContext());
        final ArrayList<NewShartEntity> surah = utils.getShartSurahNew(surah_id);
        //  final ArrayList<ShartEntity> surah = utils.getShartSurah(surah_id);
        SpannableStringBuilder spannableverse = null;
        SpannableString spannableString = null;
//todo 2 188 iza ahudu
        //todo 9;92 UNCERTAIN
        //TODO 9:94 JAWABHARMAHDOOF 9 95 JAWABHSARMAHODFF
        //TO 9;118 IZA IN THE MEANING OF HEENA AND 9 122 IZA AS HEENA
        if (surah_id > 1 && surah_id <= 10 || surah_id > 57 && surah_id <= 114) {

            for (NewShartEntity shart : surah) {

                int indexstart = shart.getIndexstart();
                int indexend = shart.getIndexend();
                int shartsindex = shart.getShartindexstart();
                int sharteindex = shart.getShartindexend();
                int jawabstartindex = shart.getJawabshartindexstart();
                int jawabendindex = shart.getJawabshartindexend();
                FrameSpan frameshartharf = new FrameSpan(GREEN, 2, RECKT);
                FrameSpan frameshart = new FrameSpan(CYAN, 2f, RECKT);
                FrameSpan framejawabshart = new FrameSpan(YELLOW, 2f, RECKT);

                corpusayahWordArrayList.get(shart.getSurah());
         //       boolean iscolored = true;
                try {
                    spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(shart.getSurah()+" "+shart.getAyah() );
                }
                BackgroundColorSpan spanDark = new BackgroundColorSpan(BBLUE);

                //   spanIt(SpanType.BGCOLOR,spannableString, shart, indexstart, indexend, shartsindex, sharteindex, jawabstartindex, jawabendindex);
                ColoredShart(true, frameshartharf, frameshart, framejawabshart, corpusayahWordArrayList, shart, indexstart, indexend, shartsindex, sharteindex, jawabstartindex, jawabendindex);

            }

        }
    }


    private void ColoredShart(boolean iscolored, FrameSpan frameshartharf, FrameSpan frameshart, FrameSpan framejawabshart, ArrayList<CorpusAyahWord> corpusayahWordArrayList, NewShartEntity shart, int indexstart, int indexend, int shartsindex, int sharteindex, int jawabstartindex, int jawabendindex) {
        SpannableString spannableverse;


        try {
            spannableverse = corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse();


            //   spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse());
            try {

                if (indexstart == 0 || indexstart > 0) {
                    if (iscolored) {
                        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                            harfshartspanDark = new ForegroundColorSpan(GOLD);
                        } else {
                            harfshartspanDark = new ForegroundColorSpan(FORESTGREEN);
                        }
                        spannableverse.setSpan(harfshartspanDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableverse.setSpan(new UnderlineSpan(), indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    } else
                        spannableverse.setSpan(frameshartharf, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                }

                if (shartsindex == 0 || shartsindex > 0) {
                    if (iscolored) {
                        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                            shartspanDark = new ForegroundColorSpan(ORANGE400);
                        } else {
                            shartspanDark = new ForegroundColorSpan(GREENDARK);
                        }
                        spannableverse.setSpan(shartspanDark, shartsindex, sharteindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableverse.setSpan(new UnderlineSpan(), shartsindex, sharteindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    } else {
                        spannableverse.setSpan(frameshart, shartsindex, sharteindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    }
                }


                if (jawabstartindex == 0 || jawabstartindex > 0) {


                    Drawable myDrawable = AppCompatResources.getDrawable(context, R.drawable.oval_circle);
                    myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());


                    if (iscolored) {
                             if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
                            jawabshartspanDark = new ForegroundColorSpan(CYAN);
                        } else {
                            jawabshartspanDark = new ForegroundColorSpan(WHOTPINK);
                        }
                        spannableverse.setSpan(jawabshartspanDark, jawabstartindex, jawabendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableverse.setSpan(new UnderlineSpan(), jawabstartindex, jawabendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    } else {
                        spannableverse.setSpan(framejawabshart, jawabstartindex, jawabendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


                    }

                }


            } catch (IndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
            }

        } catch (IndexOutOfBoundsException e) {
            //System.out.println(e.getMessage());
        }
    }

    public void setKana(ArrayList<CorpusAyahWord> corpusayahWordArrayList, int surah_id) {
        Utils utils = new Utils(context.getApplicationContext());
        ArrayList<NewKanaEntity> kanalist = utils.getKananew(surah_id);
        if (surah_id > 1 && surah_id <= 10 || surah_id > 58 && surah_id <= 114) {

            for (NewKanaEntity kana : kanalist) {

                int indexstart = kana.getIndexstart();
                int indexend = kana.getIndexend();
                int shartsindex = kana.getKhabarstart();
                int sharteindex = kana.getKhabarend();
                int jawabstartindex = kana.getIsmkanastart();
                int jawabendindex = kana.getIsmkanaend();
                FrameSpan frameshartharf = new FrameSpan(GREEN, 2, OVAL);
                FrameSpan frameshart = new FrameSpan(CYAN, 2f, OVAL);
                FrameSpan framejawabshart = new FrameSpan(YELLOW, 2f, OVAL);
                TextBorderSpan tb = new TextBorderSpan();
                boolean iscolored = false;
                SpannableString spannableverse = corpusayahWordArrayList.get(kana.getAyah() - 1).getSpannableverse();
                try {


                    spannableverse.setSpan(new ForegroundColorSpan(GOLD), kana.getIndexstart(), kana.getIndexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    //    shart.setSpannedverse(spannableverse);


                    spannableverse.setSpan(new ForegroundColorSpan(CYAN), kana.getKhabarstart(), kana.getKhabarend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    //   shart.setSpannedverse(spannableverse);


                    spannableverse.setSpan(new ForegroundColorSpan(GREENDARK), kana.getIsmkanastart(), kana.getIsmkanaend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    //   shart.setSpannedverse(spannableverse);


                } catch (IndexOutOfBoundsException e) {
                    //System.out.println(e.getMessage());
                }


            }

        }
    }


    public static Spannable getSpannableVerses(String arabicword, String quranverses) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String preferences = prefs.getString("theme", "dark");

        int wordlen = arabicword.length();
        SpannableString str;


        int indexOf = quranverses.indexOf(arabicword);
        if (indexOf != -1) {
            str = new SpannableString(quranverses);
                 if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {

                str.setSpan(new ForegroundColorSpan(CYAN), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                str.setSpan(new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.midnightblue)), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

        } else {
            str = new SpannableString(quranverses);
        }


        return str;


    }






    private void SetMousufSpan(CorpusAyahWord ayahWord, int indexv, SpannableString verse,
                               String translations, int wordlen, int indexOf) {
        MousufSifa mousufSifa = new MousufSifa();
        int sid = getSuraid();
        int vid = getAyahid();
        int wid = ayahWord.getWord().get(indexv).getWordno();
        //    mousufSifa.setVerse(verse);
        mousufSifa.setStartindex(indexOf);
        mousufSifa.setEndindex(indexOf + wordlen);

        mousufSifa = new MousufSifa(sid, vid, wid, indexOf, indexOf + wordlen, verse, translations, "mousuuf", 0, "blank");
        NEWmousufSifaArrayList.add(mousufSifa);
    }



 /*
    private class GetMousoofSifaValidation {
        private final String araword;
        private final String prevdetailsone;
        private final String currentdetailsone;
        private boolean caseone;
        private boolean casetwo;
        private boolean caseacc;
        private boolean typeindef;
        private boolean fcurrentFem;
        private boolean fcurrentDual;
        private boolean fcurrentSin;
        private boolean fcurrentPlural;
        private boolean mcurrentMas;
        private boolean mcurrentDual;
        private boolean mcurrentSin;
        private boolean mcurrentPlural;
        private boolean isgenderpresent;

        public GetMousoofSifaValidation(String prevdetailsone, String currentdetailsone, String araword) {
            this.prevdetailsone = prevdetailsone;
            this.currentdetailsone = currentdetailsone;
            this.araword = araword;
        }


        public boolean isCaseone() {
            return caseone;
        }

        public boolean isCasetwo() {
            return casetwo;
        }

        public boolean isCasethree() {
            return caseacc;
        }

        public boolean isTypeindef() {
            return typeindef;
        }

        public boolean isFcurrentFem() {
            if (currentdetailsone.contains("|F|") || currentdetailsone.contains("|FP|") || currentdetailsone.contains("|FS")) {

                ValidateBrokenPlurals vbp = new ValidateBrokenPlurals();
                boolean broken = vbp.getBrokenPluralStatus(araword);
                if (broken) {
                    setIsmausoofbrokenplural(true);
                    fcurrentFem = broken;
                } else {
                    setIsmausoofbrokenplural(false);
                }


            } else {


                fcurrentFem = prevdetailsone.contains("|F|") && currentdetailsone.contains("|F|");
                fcurrentDual = prevdetailsone.contains("|FD|") && currentdetailsone.contains("|FD|");
                fcurrentSin = (prevdetailsone.contains("|FS|") && currentdetailsone.contains("|FS|"));
            }
            return fcurrentFem;
        }

        public boolean isFcurrentDual() {
            return fcurrentDual;
        }

        public boolean isFcurrentSin() {
            return fcurrentSin;
        }

        public boolean isFcurrentPlural() {
            return fcurrentPlural;
        }

        public boolean isMcurrentMas() {
            return mcurrentMas;
        }

        public boolean isMcurrentDual() {
            return mcurrentDual;
        }

        public boolean isMcurrentSin() {
            return mcurrentSin;
        }

        public boolean isMcurrentPlural() {
            mcurrentPlural = (prevdetailsone.contains("|MP|") && currentdetailsone.contains("|MP|") ||
                    (prevdetailsone.contains("|M|") && currentdetailsone.contains("|MP|")));
            return mcurrentPlural;
        }

        public GetMousoofSifaValidation invoke() {
            try {
                caseone = prevdetailsone.contains("NOM") && currentdetailsone.contains("NOM");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            casetwo = prevdetailsone.contains("GEN") && currentdetailsone.contains("GEN");
            caseacc = prevdetailsone.contains("ACC") && currentdetailsone.contains("ACC");
            if (prevdetailsone.contains("INDEF") && currentdetailsone.contains("INDEF")) {
                typeindef = true;
            } else if (!prevdetailsone.contains("INDEF") && !currentdetailsone.contains("INDEF")) {
                typeindef = true;

            } else if (ismausoofbrokenplural) {

                typeindef = true;
            } else {
                typeindef = false;
            }
            //     typeindef = prevdetailsone.contains("INDEF") && currentdetailsone.contains("INDEF");


            fcurrentFem = prevdetailsone.contains("|F|") && currentdetailsone.contains("|F|");
            fcurrentDual = prevdetailsone.contains("|FD|") && currentdetailsone.contains("|FD|");
            fcurrentSin = (prevdetailsone.contains("|FS|") && currentdetailsone.contains("|FS|") ||

                    (prevdetailsone.contains("|F|") && currentdetailsone.contains("|FS|") ||
                            (prevdetailsone.contains("|FS|") && currentdetailsone.contains("|F|")

                            )));
            fcurrentPlural = prevdetailsone.contains("|FP|") && currentdetailsone.contains("|FP|");

            mcurrentMas = prevdetailsone.contains("|M|") && currentdetailsone.contains("|M|");
            mcurrentDual = prevdetailsone.contains("|MD|") && currentdetailsone.contains("|MD|");
            mcurrentSin = (prevdetailsone.contains("|MS|") && currentdetailsone.contains("|MS|") ||
                    (prevdetailsone.contains("|M|") && currentdetailsone.contains("|MS|") ||


                            (prevdetailsone.contains("|MS|") && currentdetailsone.contains("|M|"))));

            return this;
        }

        public boolean isgenderpresent() {
            if (prevdetailsone.contains("|F|") || currentdetailsone.contains("|F|") ||
                    prevdetailsone.contains("|FD|") && currentdetailsone.contains("|FD|") ||
                    prevdetailsone.contains("|FS|") && currentdetailsone.contains("|FS|") ||
                    prevdetailsone.contains("|FS|") && currentdetailsone.contains("|F|") ||
                    prevdetailsone.contains("|F|") && currentdetailsone.contains("|FS|") ||
                    prevdetailsone.contains("|FP|") && currentdetailsone.contains("|FP|") ||

                    prevdetailsone.contains("|M|") && currentdetailsone.contains("|M|") ||

                    prevdetailsone.contains("|MD|") && currentdetailsone.contains("|MD|") ||


                    prevdetailsone.contains("|MS|") && currentdetailsone.contains("|MS|") ||
                    prevdetailsone.contains("|M|") && currentdetailsone.contains("|MS|") ||


                    prevdetailsone.contains("|MS|") && currentdetailsone.contains("|M|")) {

                isgenderpresent = true;
            } else {
                isgenderpresent = false;
            }
            return isgenderpresent;
        }


        private class ValidateBrokenPlurals {
            final int ALIFHAMZAABOVE = 1571;

            final int Fathatan = 1611;
            final int Dammatan = 1612;
            final int Kasratan = 1613;
            final int Fatha = 1614;
            final int Damma = 1615;
            final int Kasra = 1616;
            final int Shadda = 1617;
            final int Sukun = 1618;
            final int AlifKhanjareeya = 1648;
            final int Alif = 1575;
            final int Maddah = 1619;


            //FATHA/FATHA/ALIF/KASRA/DAMMA


            final ArrayList<String> bp = new ArrayList<>();


            public boolean getBrokenPluralStatus(String araword) {
                boolean isbroken = false;
                Character[] quranword = new Character[10];
                char[] chars = araword.toCharArray();
                int counter = 0;
                for (Character ch : araword.toCharArray()) {

                    int castAscii = (int) ch;
                    if (castAscii == ALIFHAMZAABOVE || castAscii == Alif || castAscii == Damma
                            || castAscii == Fatha || castAscii == Kasra || castAscii == Shadda || castAscii == Sukun
                            || castAscii == AlifKhanjareeya || castAscii == Dammatan || castAscii == Fathatan ||
                            castAscii == Kasratan || castAscii == Maddah) {
                        quranword[counter++] = ch;
                    }

                }
                String AFAALUNTWO = "أَفْعَٰلٌ";
                bp.add(AFAALUNTWO);
                String AFAALANNTWO = "أَفْعَٰلً";
                bp.add(AFAALANNTWO);
                String AFAALINNTWO = "أَفْعَٰلٍ";
                bp.add(AFAALINNTWO);
                String AYYAMINN = "أَيَّامٍ";
                bp.add(AYYAMINN);
                String AYYAMANN = "أَيَّامً";
                bp.add(AYYAMANN);

                String AYYAMUN = "أَيَّامٌ";
                bp.add(AYYAMUN);
                //ALIFHAMA,SUKUN,FATHA,ALIF,DAMMATTAN**
                String AFAALUN = "أَفْعَالٌ";
                bp.add(AFAALUN);
                //DAMMA,SHADDA,FATHA,ALIF,DAMMATAN&&FATHATAN&&KASRATAN
                String TULLABUN = "فُعَّالٌ";
                bp.add(TULLABUN);
                String TULLABANN = "فُعَّالً";
                bp.add(TULLABANN);
                String TULLABINN = "فُعَّالٍ";
                bp.add(TULLABINN);

                //KASRA//FATHA//ALIF/DAMMATAN&&FATHATHAN&KASRATAN
                String RIJALUNN = "فِعَالٌ";
                bp.add(RIJALUNN);
                String RIJALANN = "فِعَالً";
                bp.add(RIJALANN);
                String RIJALINN = "فِعَالٍ";
                bp.add(RIJALINN);

                //ALIFHAMZAABOVE,FATHA,SUKUN,FATHA,DAMMATAN&FATHATAN&KASRATAN
                String AQLAMUNN = "أَفْعَٰمٌ";
                bp.add(AQLAMUNN);
                String AQLAMANN = "أَفْعَٰمً";
                bp.add(AQLAMANN);
                String AQLAMINN = "أَفْعَٰمٍ";
                bp.add(AQLAMINN);

                //DAMMA/DAMMA/SUKUN/DAMMATAN&&FATHATHAN&KASRATAN
                String QULUBUNN = "فُعُوْلٌ";
                bp.add(QULUBUNN);
                String QULUBANN = "فُعُوْلً";
                bp.add(QULUBANN);

                String QULUBINN = "فُعُوْلٍ";
                bp.add(QULUBINN);


                //KASRA/SUKUN/FATHA/DAMMATTAN&&FATHATHAN&KASRATAN
                String FIYATUN = "فِعْلَةٌ";
                bp.add(FIYATUN);
                String FIYATANN = "فِعْلَةً";
                bp.add(FIYATANN);
                String FIYATINN = "فِعْلَةٍ";
                bp.add(FIYATINN);


                //DAMMA/DAMMA/DAMMTTAN&FATHATHAN&KASRATAN
                String JUDUDUNN = "فُعُلٌ";
                bp.add(JUDUDUNN);
                String JUDUDANN = "فُعُلً";
                bp.add(JUDUDANN);
                String JUDUDINN = "فُعُلٍ";
                bp.add(JUDUDINN);

                //ALIFABOVEHAMZA,FATHA,SUKUN,KASRA,FATHA,DAMMATTAN&&
                String ASILATUNN = "أَفْعِلَةٌ";
                bp.add(ASILATUNN);
                String ASILATANN = " أَفْعِلَةً";
                bp.add(ASILATANN);
                String ASILATINN = " أَفْعِلَةٍ";
                bp.add(ASILATINN);

                //ALIFHAMZA,SUKUN,DAMMA,DAMMATTAN**
                String ASHURUNN = "أَفْعُلٌ";
                bp.add(ASHURUNN);
                String ASHURANN = "أَفْعُلً";
                bp.add(ASHURANN);
                String ASHRINN = "أَفْعُلٍ";
                bp.add(ASHRINN);


                //MAMNN);ON MIN ALSARAF
                //MAMNOON MIN ALSARAF
                //DAMMA/FATHA,ALIF,FATHA,DAMMA
                String ULMAUU = "فُعَلاَءُ";
                bp.add(ULMAUU);

                //ALIFABOVEHAAZA/SUKUN/KASRA/ALIF/FATHA//DAMMA
                String AGHNIYAUU = "أَفْعِلاَءُ";
                bp.add(AGHNIYAUU);

                String MAKATIBU = "مَفَاعِلُ";
                bp.add(MAKATIBU);
                //FATHA/FATHA/ALIF/KASRA/SUKUN/DAMMA
                String MAFATIH = "مَفَاعِيْلُ";
                bp.add(MAFATIH);
                String AFAALANN = "أَفْعَالً";
                bp.add(AFAALANN);
                String AFAALINN = "أَفْعَالٍ";
                bp.add(AFAALINN);


                for (String pat : bp) {
                    Character[] pattern = new Character[10];
                    counter = 0;
                    for (Character ch : pat.toCharArray()) {

                        int castAscii = (int) ch;
                        if (castAscii == ALIFHAMZAABOVE || castAscii == Alif || castAscii == Damma
                                || castAscii == Fatha || castAscii == Kasra || castAscii == Shadda || castAscii == Sukun
                                || castAscii == AlifKhanjareeya || castAscii == Dammatan || castAscii == Fathatan ||
                                castAscii == Kasratan || castAscii == Maddah) {
                            pattern[counter++] = ch;
                        }

                    }
                    boolean equals = Arrays.equals(quranword, pattern);
                    if (equals) {
                        isbroken = true;
                        break;
                    }


                }


                return isbroken;
            }
        }
    }
    public ArrayList<CorpusAyahWord> NewMAOUSOOFSIFA(ArrayList<CorpusAyahWord> corpusayahWordArrayList) {
        //TODO 8:42:6 (ALUDWATUL ALQUSWA///
        //TODO 7:12   *iz amartuk
        //TOTO 7;19 haithu shituma
        //  SpannableStringBuilder strs = new SpannableStringBuilder();
        String prevaraone = "";
        String prevaratwo = "";
        String prevarathree = "";
        String prevarafour = "";
        String prevarafive = "";
        String prevtagone = "";
        String prevtagtwo = "";
        String prevprevtagone = "";
        String prevprevtagtwo = "";
        String prevprevtagthree = "";
        String prevtagthree = "";
        String prevtagfour = "";
        String prevtagfive = "";

        String prequranverses = "";
        String arabicwordtwo = "";
        String prevcases = "";

        String prevgendernumber = "";
        String prevtype = "";
        String arabicword = "";


        String cases = "";
        String gendernumber = "";
        String type = "";


        String arabicwod = "";
        int wordno;
        String currenttagone = "";
        String currenttagtwo = "";
        String currenttagthree = "";
        String currenttagfour = "";
        String currenttagfive = "";
        String currentaraone = "";
        String currentaratwo = "";
        String currentarathree = "";
        String currentarafour = "";
        String currentarafive = "";

        String prevdetailsone = "";
        String prevdetailstwo = "";
        String prevdetailsthree = "";
        String prevdetailsfour = "";
        String prevdetailsfive = "";


        String currentdetailsone = "";
        String currentdetailstwo = "";
        String currentdetailsthree = "";
        String currentdetailsfour = "";
        String currentdetailsfive = "";


        String prevprevdetailsone = "";
        String prevprevdetailstwo = "";
        String prevprevdetailsthree = "";
        String prevthirdaraone = "";
        String prefouraraone = "";
        String prevprevaraone = "";
        String prevprevaratwo = "";
        String prevprevarathree = "";
        boolean pp = false;
        boolean ppp = false;
        boolean pppp = false;
        boolean ppppp = false;
             if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white") ) {
            sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
        } else {
            sifaspansDark = new BackgroundColorSpan(CYANLIGHTEST);
        }

        boolean ptaglength = false;


        SpannableStringBuilder str = null;

        HashMap<Integer, Integer> indexes = new HashMap<>();
        // CorpusAyahWord[] corpusayahWordArrayList = new CorpusAyahWord[0];
        for (CorpusAyahWord ayahWord : corpusayahWordArrayList) {


            //  HashMap<Integer, Integer> indexes = new HashMap<>();
            int size = ayahWord.getWord().size();
            for (int indexv = 0; indexv < size; indexv++) {
                // SpannableStringBuilder verse = ayahWord.getWord().get(indexv).getCorpusSpnnableQuranverse();
                SpannableString verse = ayahWord.getSpannableverse();
                String translations = ayahWord.getWord().get(indexv).getTranslations();

                if (indexv >= 3) {
                    prevthirdaraone = ayahWord.getWord().get(indexv - 3).getAraone();

                }
                setSuraid(ayahWord.getWord().get(indexv).getSurahId());
                setAyahid(ayahWord.getWord().get(indexv).getVerseId());

                if (indexv != 0) {
                    prevtagone = ayahWord.getWord().get(indexv - 1).getTagone();
                    prevtagtwo = ayahWord.getWord().get(indexv - 1).getTagtwo();

                    prevtagthree = ayahWord.getWord().get(indexv - 1).getTagthree();
                    prevtagfour = ayahWord.getWord().get(indexv - 1).getTagfour();
                    prevtagfive = ayahWord.getWord().get(indexv - 1).getTagfour();

                    prevaraone = ayahWord.getWord().get(indexv - 1).getAraone();
                    prevaratwo = ayahWord.getWord().get(indexv - 1).getAratwo();
                    prevarathree = ayahWord.getWord().get(indexv - 1).getArathree();
                    prevarafour = ayahWord.getWord().get(indexv - 1).getArafour();
                    prevarafive = ayahWord.getWord().get(indexv - 1).getArafive();

                    prevdetailsone = ayahWord.getWord().get(indexv - 1).getDetailsone();
                    prevdetailstwo = ayahWord.getWord().get(indexv - 1).getDetailstwo();

                    prevdetailsthree = ayahWord.getWord().get(indexv - 1).getDetailsthree();
                    prevdetailsfour = ayahWord.getWord().get(indexv - 1).getDetailsfour();
                    prevdetailsfive = ayahWord.getWord().get(indexv - 1).getDetailsfive();
                    if (indexv >= 2) {
                        prevprevtagone = ayahWord.getWord().get(indexv - 2).getTagone();
                        prevprevtagtwo = ayahWord.getWord().get(indexv - 2).getTagone();
                        prevprevtagthree = ayahWord.getWord().get(indexv - 2).getTagone();
                        prevprevdetailsone = ayahWord.getWord().get(indexv - 2).getDetailsone();
                        prevprevdetailstwo = ayahWord.getWord().get(indexv - 2).getDetailstwo();
                        prevprevdetailsthree = ayahWord.getWord().get(indexv - 2).getDetailsthree();

                        prevprevaraone = ayahWord.getWord().get(indexv - 2).getAraone();
                        prevprevaratwo = ayahWord.getWord().get(indexv - 2).getAratwo();
                        prevprevarathree = ayahWord.getWord().get(indexv - 2).getArathree();
                    }

                    if (indexv >= 3) {
                        prevthirdaraone = ayahWord.getWord().get(indexv - 3).getAraone();

                    }

                    if (indexv >= 4) {
                        prefouraraone = ayahWord.getWord().get(indexv - 4).getAraone();

                    }


                    pp = prevtagtwo.length() == 0;
                    ppp = prevtagthree.length() == 0;
                    pppp = prevtagfour.length() == 0;
                    ppppp = prevtagfive.length() == 0;
                    ptaglength = pp && ppp & pppp & ppppp;


                }

                boolean LAFDHJALALA = prevprevaratwo.equals("ٱللَّهِ") || prevprevaratwo.equals("ٱللَّهَ") || prevprevaratwo.equals("ٱللَّهُ")
                        || prevprevaraone.equals("ٱللَّهِ") || prevprevaraone.equals("ٱللَّهَ") || prevprevaraone.equals("ٱللَّهُ");

                boolean LAFDHJALLALA = prevaratwo.equals("ٱللَّهِ") || prevaratwo.equals("ٱللَّهَ") || prevaratwo.equals("ٱللَّهُ")
                        || prevaraone.equals("ٱللَّهِ") || prevaraone.equals("ٱللَّهَ") || prevaraone.equals("ٱللَّهُ");
                currenttagone = ayahWord.getWord().get(indexv).getTagone();
                currenttagtwo = ayahWord.getWord().get(indexv).getTagtwo();
                currenttagthree = ayahWord.getWord().get(indexv).getTagthree();
                currenttagfour = ayahWord.getWord().get(indexv).getTagfour();
                currenttagfive = ayahWord.getWord().get(indexv).getTagfive();


                currentdetailsone = ayahWord.getWord().get(indexv).getDetailsone();
                currentdetailstwo = ayahWord.getWord().get(indexv).getDetailstwo();
                currentdetailsthree = ayahWord.getWord().get(indexv).getDetailsthree();
                currentdetailsfour = ayahWord.getWord().get(indexv).getDetailsfour();
                currentdetailsfive = ayahWord.getWord().get(indexv).getDetailsfive();


                currentaraone = ayahWord.getWord().get(indexv).getAraone();
                currentaratwo = ayahWord.getWord().get(indexv).getAratwo();
                currentarathree = ayahWord.getWord().get(indexv).getArathree();
                currentarafour = ayahWord.getWord().get(indexv).getArafour();
                currentarafive = ayahWord.getWord().get(indexv).getArafive();
                boolean b = currenttagone.length() == 0;
                boolean cc = currenttagtwo.length() == 0;
                boolean ccc = currenttagthree.length() == 0;
                boolean cccc = currenttagfour.length() == 0;
                boolean ccccc = currenttagfive.length() == 0;

                boolean ctaglength = cc && ccc & cccc & ccccc;
                boolean prevfirsttagnotnoun = !prevtagone.equals("N") || !prevtagone.equals("ADJ") || !prevtagone.equals("PN") || !prevtagone.equals("VN");

                boolean prevsecondtagnotnoung = !prevtagtwo.equals("N") || !prevtagtwo.equals("ADJ") || !prevtagtwo.equals("PN") || !prevtagtwo.equals("VN");
                boolean currentsecondtagnotnoun = !currenttagtwo.equals("N") || !currenttagtwo.equals("ADJ") || !currenttagtwo.equals("PN") || !currenttagtwo.equals("VN");
                boolean currentfirsttagnotnoun = !currenttagone.equals("N") || !currenttagtwo.equals("ADJ") || !currenttagthree.equals("PN") || !currenttagthree.equals("VN");


                boolean prevtagonenoun = prevtagone.equals("T") || prevtagone.equals("N") || prevtagone.equals("ADJ") || prevtagone.equals("PN") || prevtagone.equals("VN");
                boolean prevtagtwonoun = prevtagtwo.equals("T") || prevtagtwo.equals("N") || prevtagtwo.equals("ADJ") || prevtagtwo.equals("PN") || prevtagtwo.equals("VN");
                boolean prevtagthreenoun = prevtagthree.equals("T") || prevtagthree.equals("N") || prevtagthree.equals("ADJ") ||
                        prevtagthree.equals("PN") || prevtagthree.equals("VN");
                boolean prevtagfournoun = prevtagfour.equals("T") || prevtagfour.equals("N") || prevtagfour.equals("ADJ") || prevtagfour.equals("PN") || prevtagfour.equals("VN");
                boolean prevtagfivenoun = prevtagfive.equals("T") || prevtagfive.equals("N") || prevtagfive.equals("ADJ") || prevtagfive.equals("PN") || prevtagfive.equals("VN");

                //amended curenttagonenour removed noun d
                //  boolean currenttagonenoun =  tagone.equals("ADJ") || tagone.equals("PN") || tagone.equals("VN");
                //   boolean currenttagonenoun = tagone.equals("ADJ") || tagone.equals("PN") || tagone.equals("VN");
                boolean currenttagonenoun = currenttagone.equals("ADJ") || currenttagone.equals("PN") || currenttagone.equals("N") || currenttagone.equals("VN");

                boolean currenttagtwonoun = currenttagtwo.equals("ADJ") || currenttagtwo.equals("PN") || currenttagtwo.equals("VN");
                boolean currenttagthreenoun = currenttagthree.equals("ADJ") || currenttagthree.equals("PN") || currenttagthree.equals("VN");
                boolean currenttagfournoun = currenttagfour.equals("ADJ") || currenttagfour.equals("PN") || currenttagfour.equals("VN");
                boolean currenttagfivenoun = currenttagfive.equals("ADJ") || currenttagfive.equals("PN") || currenttagfive.equals("VN");
                boolean currenttagoneADJ = currenttagone.equals("ADJ");


                boolean currenttagtwoADJ = currenttagtwo.equals("ADJ");
                boolean currenttagthreeADJ = currenttagthree.equals("ADJ");
                boolean currenttagfourADJ = currenttagfour.equals("ADJ");
                boolean currenttagfiveADJ = currenttagfive.equals("ADJ");

                if (ayahWord.getWord().get(indexv).getSurahId() == 111
                        && ayahWord.getWord().get(indexv).getVerseId() == 3
                        && ayahWord.getWord().get(indexv).getWordno() == 4) {

                    System.out.println("check");
                }
                if (ayahWord.getWord().get(indexv).getSurahId() == 15
                        && ayahWord.getWord().get(indexv).getVerseId() == 1
                        && ayahWord.getWord().get(indexv).getWordno() == 6) {

                    System.out.println("check");
                }

                if (ayahWord.getWord().get(indexv).getSurahId() == 9
                        && ayahWord.getWord().get(indexv).getVerseId() == 20
                        && ayahWord.getWord().get(indexv).getWordno() == 10) {

                    continue;
                }

                if (ayahWord.getWord().get(indexv).getSurahId() == 9
                        && ayahWord.getWord().get(indexv).getVerseId() == 38
                        && ayahWord.getWord().get(indexv).getWordno() == 24) {

                    System.out.println("check");
                }

                boolean hua = false;
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
                //   preferences = prefs.getString("themePref", "dark");

                int mausofColoragainstBlack;
                mausofColoragainstBlack = prefs.getInt("mausoofblack", Color.RED);
                if (ayahWord.getWord().get(indexv).getSurahId() == 2
                        && ayahWord.getWord().get(indexv).getVerseId() == 101
                        && ayahWord.getWord().get(indexv).getWordno() == 7) {
                    ColoredShart(ayahWord, indexv, currentaraone, prefouraraone, verse, translations);


                } else if (ayahWord.getWord().get(indexv).getSurahId() == 2
                        && ayahWord.getWord().get(indexv).getVerseId() == 217
                        && ayahWord.getWord().get(indexv).getWordno() == 10) {
                    ColoredShart(ayahWord, indexv, currentaraone, prevprevaraone, verse, translations);


                } else if (ayahWord.getWord().get(indexv).getSurahId() == 2
                        && ayahWord.getWord().get(indexv).getVerseId() == 68
                        && ayahWord.getWord().get(indexv).getWordno() == 13) {


                    setIndexesExceptions(ayahWord, indexv, currentaraone, verse, translations);
                } else if (ayahWord.getWord().get(indexv).getSurahId() == 2
                        && ayahWord.getWord().get(indexv).getVerseId() == 71
                        && ayahWord.getWord().get(indexv).getWordno() == 5) {


                    setIndexesExceptions(ayahWord, indexv, currentaraone, verse, translations);
                } else if (currenttagoneADJ || currenttagtwoADJ || currenttagthreeADJ) {

                    //   } else if (currenttagoneADJ || currenttagtwoADJ || currenttagthreeADJ||currenttagonenoun||currenttagtwonoun||currenttagthreenoun) {

                    if (LAFDHJALLALA) {
                        continue;
                    }

                    if (ayahWord.getWord().get(indexv).getSurahId() == 2
                            && ayahWord.getWord().get(indexv).getVerseId() == 49
                            && ayahWord.getWord().get(indexv).getWordno() == 18) {
                        ColoredShart(ayahWord, indexv, currentaraone, prevthirdaraone, verse, translations);


                    } else if (prevtagonenoun || prevtagtwonoun || prevtagthreenoun || prevtagfournoun || prevtagfivenoun) {
                        setMainindexes(ayahWord, indexv, prevaraone, prevaratwo, prevarathree, prevarafour, prevarafive, currentaraone, currentaratwo, currentarathree, currentarafour, currentarafive, verse, translations);

                    } else if (!prevtagonenoun && currenttagoneADJ) {
                        setIndexesExceptions(ayahWord, indexv, currentaraone, verse, translations);

                    }


                } else if (currenttagonenoun || currenttagtwonoun || currenttagthreenoun) {
                    if (ayahWord.getWord().get(indexv).getSurahId() == 1
                            && ayahWord.getWord().get(indexv).getVerseId() == 4
                            && ayahWord.getWord().get(indexv).getWordno() == 2) {
                        continue;


                    } else if (ayahWord.getWord().get(indexv).getSurahId() == 1
                            && ayahWord.getWord().get(indexv).getVerseId() == 4
                            && ayahWord.getWord().get(indexv).getWordno() == 1) {
                        setIndexesExceptions(ayahWord, indexv, currentaraone, verse, translations);


                    } else {

                        String prevdetails = "";
                        if (!prevdetailsone.contains("PREFIX")) {
                            prevdetails = prevdetailsone;
                        } else if (!prevdetailstwo.contains("PREFIX")) {
                            prevdetails = prevdetailstwo;
                        }
                        boolean contains = prevdetails.contains("POS:ADJ");
                        //      if(!prevdetails.contains("POS:ADJ")) {
                        if (!contains) {


                            GetMousoofSifaValidation getMousoofSifaValidation = new GetMousoofSifaValidation(prevdetails, currentdetailsone, "").invoke();
                            boolean caseone = getMousoofSifaValidation.isCaseone();
                            boolean casetwo = getMousoofSifaValidation.isCasetwo();
                            boolean casethree = getMousoofSifaValidation.isCasethree();

                            boolean fcurrentFem = getMousoofSifaValidation.isFcurrentFem();
                            boolean fcurrentDual = getMousoofSifaValidation.isFcurrentDual();
                            boolean fcurrentSin = getMousoofSifaValidation.isFcurrentSin();
                            boolean fcurrentPlural = getMousoofSifaValidation.isFcurrentPlural();
                            boolean mcurrentMas = getMousoofSifaValidation.isMcurrentMas();
                            boolean mcurrentDual = getMousoofSifaValidation.isMcurrentDual();
                            boolean mcurrentSin = getMousoofSifaValidation.isMcurrentSin();
                            boolean mcurrentPlural = getMousoofSifaValidation.isMcurrentPlural();
                            boolean typeindef = getMousoofSifaValidation.isTypeindef();
                            setIsmousoofsifa(false);

                            if ((caseone || casetwo || casethree) && typeindef && (fcurrentFem || fcurrentDual || fcurrentSin || fcurrentPlural
                                    || mcurrentMas || mcurrentDual || mcurrentSin || mcurrentPlural)) {


                                StringBuilder pprevarasb = new StringBuilder();

                                pprevarasb.append(prevaraone).append(prevaratwo).append(prevarathree).append(prevarafour).append(prevarafive).append(" ");

                                //  String prevarasb = prevaraone + prevaratwo + prevarathree + prevarafour + prevarafive + " " +
                                //       araone + aratwo + arathree + arafour + arafive;
                                String prevarasb = prevaraone + prevaratwo + prevarathree + prevarafour + prevarafive
                                        + " " + currentaraone + currentaratwo + currentarathree + currentarafour + currentarafive;


                                str = new SpannableStringBuilder(prevarasb);

                                int wordlen = str.length();
                                int indexOf;
                                //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
                                indexOf = ayahWord.getWord().get(indexv).getQuranversestr().indexOf(String.valueOf(str));


                                //    verse = new SpannableStringBuilder();
                                //todo error due to change quranverses from corpusexpand to qurans qurantext
                                if (indexOf != -1) {
                                    //   verse = ayahWord.getWord().get(indexv).getCorpusSpnnableQuranverse();
                                    indexes.put(indexOf, indexOf + wordlen);
                                    try {
                                        verse.setSpan(sifaspansDark, indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        //     verse.setSpan(new ForegroundColorSpan(mausofColoragainstBlack), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println(e.getMessage());
                                    }

                                    //   ayahWord.getWord().get(indexv).setCorpusSpnnableQuranverse(verse);
                                    //   ayahWord.setSpannableverse(verse);


                                }

                            }
                        }
                    }

                } else if (currenttagone.equals("ADJ") || currenttagtwo.equals("ADJ") || currenttagthree.equals("ADJ")) {

                    String prevarasb =
                            currentaraone + currentaratwo + currentarathree + currentarafour + currentarafive;
                    str = new SpannableStringBuilder(prevarasb);

                    int wordlen = str.length();
                    int indexOf;
                    //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
                    indexOf = ayahWord.getWord().get(indexv).getQuranversestr().indexOf(String.valueOf(str));


                    //    verse = new SpannableStringBuilder();
                    if (indexOf != -1) {
                        indexes.put(indexOf, indexOf + wordlen);
                        verse.setSpan(sifaspansDark, indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        //  verse.setSpan(new ForegroundColorSpan(mausofColoragainstBlack), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);

                    }


                }


                // SetMousufSifaSpan(indexes, verse,  ayahWord.getWord().get(indexv).getSurahId(),ayahWord.getWord().get(indexv).getVerseId());


                ayahWord.getWord().get(indexv).getWordsAr();
                ayahWord.getWord().get(indexv).getWordno();
                setSuracounter(ayahWord.getWord().get(indexv).getSurahId());
                //   updateVSPANS(verse);
            }//for


        }
        //   newwritefile("sifa" + getSuracounter(), NEWmousufSifaArrayList);


        return corpusayahWordArrayList;
    }
    private void setIndexesExceptions(CorpusAyahWord ayahWord, int indexv, String araone, SpannableString verse, String translations) {
        SpannableString str;


        str = new SpannableString(araone);

        int wordlen = str.length();
        int indexOf;
        //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
        indexOf = verse.toString().indexOf(String.valueOf(str));

        //   SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);
        //    verse = new SpannableStringBuilder();
        //todo error due to change quranverses from corpusexpand to qurans qurantext
        if (indexOf != -1) {
            //   verse = sifat.get(indexv).getCorpusSpnnableQuranverse();
            //indexes.put(indexOf, indexOf + wordlen);
            try {
                verse.setSpan(sifaspansDark, indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                //   verse.setSpan(new ForegroundColorSpan(BYELLOW), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);


            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

            //   sifat.get(indexv).setCorpusSpnnableQuranverse(verse);
            //   ayahWord.setSpannableverse(verse);


        }

    }


    private void ColoredShart(CorpusAyahWord ayahWord, int indexv, String araone, String prevthirdaraone, SpannableString verse, String translations) {
        SpannableString strss;

        strss = new SpannableString(prevthirdaraone);
        SpannableString currentara = new SpannableString(araone);

        int wordlen = strss.length();
        int indexOf;
        //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
        indexOf = verse.toString().indexOf(String.valueOf(strss));


        int wordlentwo = currentara.length();
        int indexOftwo;
        //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
        indexOf = verse.toString().indexOf(String.valueOf(strss));

        indexOftwo = verse.toString().indexOf(String.valueOf(currentara));

        //   SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);

        //   SetMousufSpan(ayahWord, indexv, verse, translations, wordlentwo, indexOftwo);
        //    verse = new SpannableStringBuilder();
        //todo error due to change quranverses from corpusexpand to qurans qurantext


        if (indexOf != -1) {
            //   verse = sifat.get(indexv).getCorpusSpnnableQuranverse();
            //indexes.put(indexOf, indexOf + wordlen);
            try {

                verse.setSpan(sifaspansDark, indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                //  verse.setSpan(new ForegroundColorSpan(BYELLOW), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);


            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }

        if (indexOftwo != -1) {
            //   verse = sifat.get(indexv).getCorpusSpnnableQuranverse();
            //indexes.put(indexOf, indexOf + wordlen);
            try {
                verse.setSpan(sifaspansDark, indexOftwo, indexOftwo + wordlentwo, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                //    verse.setSpan(new ForegroundColorSpan(BYELLOW), indexOftwo, indexOftwo + wordlentwo, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);


            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void setMainindexes(CorpusAyahWord ayahWord, int indexv, String prevaraone, String prevaratwo, String prevarathree, String
            prevarafour, String prevarafive, String araone, String aratwo, String arathree, String
                                        arafour, String arafive, SpannableString verse, String translations) {
        SpannableStringBuilder str;
        StringBuilder pprevarasb = new StringBuilder();

        pprevarasb.append(prevaraone).append(prevaratwo).append(prevarathree).append(prevarafour).append(prevarafive).append(" ");

        String prevarasb = prevaraone + prevaratwo + prevarathree + prevarafour + prevarafive + " " +
                araone + aratwo + arathree + arafour + arafive;
        str = new SpannableStringBuilder(prevarasb);

        int wordlen = str.length();
        int indexOf;
        //  indexOf = ayahWord.get(index)getQuranverses().indexOf(String.valueOf(str));
        indexOf = verse.toString().indexOf(String.valueOf(str));

        //     SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);
        //    verse = new SpannableStringBuilder();
        //todo error due to change quranverses from corpusexpand to qurans qurantext
        if (indexOf != -1) {
            //   verse = sifat.get(indexv).getCorpusSpnnableQuranverse();
            //indexes.put(indexOf, indexOf + wordlen);
            try {
                verse.setSpan(sifaspansDark, indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                //   verse.setSpan(new ForegroundColorSpan(BYELLOW), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SetMousufSpan(ayahWord, indexv, verse, translations, wordlen, indexOf);


            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

            //   sifat.get(indexv).setCorpusSpnnableQuranverse(verse);
            //   ayahWord.setSpannableverse(verse);


        }
    }
  */




}
