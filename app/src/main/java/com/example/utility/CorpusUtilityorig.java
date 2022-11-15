package com.example.utility;

import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.YELLOW;
import static com.example.Constant.AYAH_ID;
import static com.example.Constant.BCYAN;
import static com.example.Constant.CHAPTER;
import static com.example.Constant.CYANLIGHTEST;
import static com.example.Constant.FORESTGREEN;
import static com.example.Constant.GOLD;
import static com.example.Constant.GREENDARK;
import static com.example.Constant.GREENYELLOW;
import static com.example.Constant.MIDNIGHTBLUE;
import static com.example.Constant.ORANGE400;
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

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
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

    // --Commented out by Inspection START (26/04/22, 1:17 AM):
//    public void setIsmousoofsifa(boolean ismousoofsifa) {
//        this.ismousoofsifa = ismousoofsifa;
//    }
// --Commented out by Inspection STOP (26/04/22, 1:17 AM)

    final ArrayList<MousufSifa> NEWmousufSifaArrayList = new ArrayList<>();
    private final String preferences;
    private final Context context;
 
   

  

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
        } else if (b && bb && bbb && bbbb) {
            tagcounter = 5;
        }
 /*
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
  */
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

             SpannableString strone = new SpannableString(araone.trim() );
            SpannableString strtwo = new SpannableString(aratwo.trim() );

            strtwo.setSpan(spanhash.get(tagtwo), 0,  aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strone.setSpan(spanhash.get(tagone), 0,araone.length() ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            CharSequence charSequence = TextUtils.concat(strtwo,strone);
            str=new SpannableString(charSequence);

        } else if (tagcounter == 3) {
            spanhash.get(tagone);
            SpannableString strone = new SpannableString(araone.trim() );
            SpannableString strtwo = new SpannableString(aratwo.trim() );
            SpannableString strthree = new SpannableString(arathree.trim() );
            strthree.setSpan(spanhash.get(tagthree), 0, arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strtwo.setSpan(spanhash.get(tagtwo), 0,  aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strone.setSpan(spanhash.get(tagone), 0,araone.length() ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            CharSequence charSequence = TextUtils.concat(strthree,strtwo,strone);
            str=new SpannableString(charSequence);
        } else if (tagcounter == 4) {
            //  str = new SpannableString(arafour.trim() + arathree.trim() + aratwo.trim() + araone.trim());
            SpannableString strone = new SpannableString(araone.trim() );
            SpannableString strtwo = new SpannableString(aratwo.trim() );
            SpannableString strthree = new SpannableString(arathree.trim() );
            SpannableString strfour = new SpannableString(arafour.trim() );
           strfour.setSpan(spanhash.get(tagfour), 0, arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strthree.setSpan(spanhash.get(tagthree), 0, arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strtwo.setSpan(spanhash.get(tagtwo), 0,  aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strone.setSpan(spanhash.get(tagone), 0,araone.length() ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            CharSequence charSequence = TextUtils.concat(strfour,strthree,strtwo,strone);
            str=new SpannableString(charSequence);
        } else if (tagcounter == 5) {

            SpannableString strone = new SpannableString(araone.trim() );
            SpannableString strtwo = new SpannableString(aratwo.trim() );
            SpannableString strthree = new SpannableString(arathree.trim() );
            SpannableString strfour = new SpannableString(arafour.trim() );
            SpannableString strfive = new SpannableString(arafive.trim() );
            strfive.setSpan(spanhash.get(tagone), 0, arafive.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strfour.setSpan(spanhash.get(tagtwo), 0, arafour.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strthree.setSpan(spanhash.get(tagthree), 0, arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strtwo.setSpan(spanhash.get(tagfour), 0,  aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strone.setSpan(spanhash.get(tagfive), 0,araone.length() ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
           CharSequence charSequence = TextUtils.concat(strone,strtwo,strthree,strfour,strfive);
            str=new SpannableString(charSequence);
        }
        return str;
    }

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
        } else if (b && bb && bbb && bbbb) {
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
        } else if (tagcounter == 4) {
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

        boolean istagnull = tagone == null || tagtwo == null || tagthree == null || tagfour == null || tagfive == null;
        if (istagnull) {
            return str = new SpannableString(araone);
        }

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
        } else if (b && bb && bbb && bbbb) {
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
        if (isNightmode.equals("dark") || isNightmode.equals("blue") || isNightmode.equals("purple")) {
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

    public static BackgroundColorSpan getSpancolor(String preferences, boolean b) {
        BackgroundColorSpan sifaspansDark = Constant.sifaspansDark;
        BackgroundColorSpan mudhafspansDark = Constant.mudhafspansDark;
        if (b) {
            if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                Constant.mudhafspansDark = new BackgroundColorSpan(MIDNIGHTBLUE);
            } else {
                Constant.mudhafspansDark = new BackgroundColorSpan(GREENYELLOW);
            }
            return mudhafspansDark;

        } else {
            if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                Constant.sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
            } else {
                Constant.sifaspansDark = new BackgroundColorSpan(CYANLIGHTEST);
            }
            return sifaspansDark;
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
            if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                str.setSpan(new ForegroundColorSpan(CYAN), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                str.setSpan(new ForegroundColorSpan(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.midnightblue)), indexOf, indexOf + wordlen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            }

        } else {
            str = new SpannableString(quranverses);
        }
        return str;

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
            SifaSpansSetup(frameshartharf, corpusayahWordArrayList, sifaEntity, indexstart, indexend);

        }
    }

    private void SifaSpansSetup(FrameSpan frameshartharf, ArrayList<CorpusAyahWord> corpusayahWordArrayList, SifaEntity sifaEntity, int indexstart, int indexend) {
        SpannableString spannableverse;
      
        try {
            spannableverse = corpusayahWordArrayList.get(sifaEntity.getAyah() - 1).getSpannableverse();
            //spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(sifaEntity.getAyah() - 1).getSpannableverse());
            try {
                if (indexstart == 0 || indexstart > 0) {
                    //   sifaspansDark = getSpancolor(preferences, false);
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                        sifaspansDark = new BackgroundColorSpan(WBURNTUMBER);
                    } else {
                        sifaspansDark = new BackgroundColorSpan(CYANLIGHTEST);
                    }
                    spannableverse.setSpan(sifaspansDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    //   spannableverse.setSpan(new UnderlineSpan(),indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                }

            } catch (IndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
            }

        } catch (IndexOutOfBoundsException e) {
            //System.out.println(e.getMessage());
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
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
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
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
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
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
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
     
      
//todo 2 188 iza ahudu
        //todo 9;92 UNCERTAIN
        //TODO 9:94 JAWABHARMAHDOOF 9 95 JAWABHSARMAHODFF
        //TO 9;118 IZA IN THE MEANING OF HEENA AND 9 122 IZA AS HEENA
        for (NewMudhafEntity mudhafen : surah) {
            int indexstart = mudhafen.getStartindex();
            int indexend = mudhafen.getEndindex();
            FrameSpan frameshartharf = new FrameSpan(GREEN, 2, RECKT);
     
            MudhafSpansSetup(frameshartharf, corpusayahWordArrayList, mudhafen, indexstart, indexend);

        }

    }

    private void MudhafSpansSetup(FrameSpan frameshartharf, ArrayList<CorpusAyahWord> corpusayahWordArrayList, NewMudhafEntity mudhafen, int indexstart, int indexend) {
        SpannableString spannableverse;
        //  SpannableString spannableString;
        try {
            spannableverse = corpusayahWordArrayList.get(mudhafen.getAyah() - 1).getSpannableverse();
            // spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(mudhafen.getAyah() - 1).getSpannableverse());
            try {
                if (indexstart == 0 || indexstart > 0) {
                    if (true) {
                        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
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
          //      corpusayahWordArrayList.get(shart.getSurah());
                //       boolean iscolored = true;
                try {
                    SpannableString spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(shart.getSurah() + " " + shart.getAyah());
                }
              
                //   spanIt(SpanType.BGCOLOR,spannableString, shart, indexstart, indexend, shartsindex, sharteindex, jawabstartindex, jawabendindex);
                ColoredShart(frameshartharf, frameshart, framejawabshart, corpusayahWordArrayList, shart, indexstart, indexend, shartsindex, sharteindex, jawabstartindex, jawabendindex);

            }

        }
    }

    private void ColoredShart(FrameSpan frameshartharf, FrameSpan frameshart, FrameSpan framejawabshart, ArrayList<CorpusAyahWord> corpusayahWordArrayList, NewShartEntity shart, int indexstart, int indexend, int shartsindex, int sharteindex, int jawabstartindex, int jawabendindex) {
        SpannableString spannableverse;
        try {
            spannableverse = corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse();
            //   spannableString = SpannableString.valueOf(corpusayahWordArrayList.get(shart.getAyah() - 1).getSpannableverse());
            try {
                if (indexstart == 0 || indexstart > 0) {
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                        harfshartspanDark = new ForegroundColorSpan(GOLD);
                    } else {
                        harfshartspanDark = new ForegroundColorSpan(FORESTGREEN);
                    }
                    spannableverse.setSpan(harfshartspanDark, indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableverse.setSpan(new UnderlineSpan(), indexstart, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                if (shartsindex == 0 || shartsindex > 0) {
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                        shartspanDark = new ForegroundColorSpan(ORANGE400);
                    } else {
                        shartspanDark = new ForegroundColorSpan(GREENDARK);
                    }
                    spannableverse.setSpan(shartspanDark, shartsindex, sharteindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableverse.setSpan(new UnderlineSpan(), shartsindex, sharteindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                if (jawabstartindex == 0 || jawabstartindex > 0) {
                    Drawable myDrawable = AppCompatResources.getDrawable(context, R.drawable.oval_circle);
                    assert myDrawable != null;
                    myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
                    if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("purple")) {
                        jawabshartspanDark = new ForegroundColorSpan(CYAN);
                    } else {
                        jawabshartspanDark = new ForegroundColorSpan(WHOTPINK);
                    }
                    spannableverse.setSpan(jawabshartspanDark, jawabstartindex, jawabendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableverse.setSpan(new UnderlineSpan(), jawabstartindex, jawabendindex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

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

                TextBorderSpan tb = new TextBorderSpan();

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

 

    public static SpannableStringBuilder PassageSetWordSpan(String tagone, String tagtwo, String tagthree, String tagfour, String tagfive, String araone, String aratwo, String arathree, String arafour, String arafive) {
        SpannableStringBuilder str;


        boolean istagnull = tagone == null || tagtwo == null || tagthree == null || tagfour == null || tagfive == null;
        if (istagnull) {
            return str = new SpannableStringBuilder(araone);
        }

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
            str = new SpannableStringBuilder(araone.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else if (tagcounter == 2) {
            //   str = new SpannableStringBuilder(araone.trim() + aratwo.trim());
            //   str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //  str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //  str = new SpannableString(araone.trim() + aratwo.trim());
            SpannableStringBuilder stro = new SpannableStringBuilder(araone.trim());
            SpannableStringBuilder strt = new SpannableStringBuilder(aratwo.trim());
            ForegroundColorSpan sp = spanhash.get(tagone);

            stro.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strt.setSpan(spanhash.get(tagtwo), 0, aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            CharSequence concat = TextUtils.concat(stro, strt);
            str = (SpannableStringBuilder) concat;


        } else if (tagcounter == 3) {
            spanhash.get(tagone);
            str = new SpannableStringBuilder(araone.trim() + aratwo.trim() + arathree.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else if (tagcounter == 4) {
            str = new SpannableStringBuilder(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfour), araone.length() + aratwo.length() + arathree.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //    str.setSpan(attachedpronoun, araone.length() + aratwo.length() + arathree.length() + arafour.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length() + arafive.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else if (tagcounter == 5) {
            str = new SpannableStringBuilder(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim() + arafive.trim());
            str.setSpan(spanhash.get(tagone), 0, araone.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagtwo), araone.length(), araone.length() + aratwo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagthree), araone.length() + aratwo.length(), araone.length() + aratwo.length() + arathree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfour), araone.length() + aratwo.length() + arathree.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            str.setSpan(spanhash.get(tagfive), araone.length() + aratwo.length() + arathree.length() + arafour.length(), araone.length() + aratwo.length() + arathree.length() + arafour.trim().length() + arafive.trim().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else {
            str = new SpannableStringBuilder(araone.trim() + aratwo.trim() + arathree.trim() + arafour.trim() + arafive.trim());
        }
        return str;
    }


}
