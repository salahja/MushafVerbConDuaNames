package com.example.utility;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class SharedPref {
    public static SharedPreferences sharedPreferences;
    Context sharedContext;

    public SharedPref(Context sharedContext) {
        //  this.sharedPreferences = sharedPreferences;
        this.sharedContext = sharedContext;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(sharedContext);
    }

    public static Boolean AutoComplete() {
        boolean aBoolean = sharedPreferences.getBoolean("autocomplete", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Integer arabicFontsize() {
        return Integer.parseInt(sharedPreferences.getString("quran_arabic_font", String.valueOf(Context.MODE_PRIVATE)));

    }

    public static int SeekarabicFontsize() {
        // return Integer.(sharedPreferences.getInt("pref_font_seekbar_key", (Context.MODE_PRIVATE)));
        return sharedPreferences.getInt("pref_font_arabic_key", Context.MODE_PRIVATE);

    }

    public static int SeekEnglishFontsize() {
        // return Integer.(sharedPreferences.getInt("pref_font_seekbar_key", (Context.MODE_PRIVATE)));
        return sharedPreferences.getInt("pref_font_english_key", Context.MODE_PRIVATE);

    }

    public static String getLanguage() {
        return sharedPreferences.getString("lang", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String getWbwLanguage() {
        return sharedPreferences.getString("wbw", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String arabicFontSelection() {
        return sharedPreferences.getString("Arabic_Font_Selection", String.valueOf(Context.MODE_PRIVATE));

    }

    public static int FontSizeSelection() {
        //   return    sharedPreferences.getString("pref_font_seekbar_key", String.valueOf(Context.MODE_PRIVATE));
        return sharedPreferences.getInt("pref_font_seekbar_key", Context.MODE_PRIVATE);

    }

    public static Integer urduFontsize() {
        return Integer.parseInt(sharedPreferences.getString("Urdu_Font_Size", String.valueOf(Context.MODE_PRIVATE)));
    }

    public static String urduFontSelection() {
        return sharedPreferences.getString("Arabic_Font_Selection", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String themePreferences() {
        return sharedPreferences.getString("themePref", String.valueOf(Context.MODE_PRIVATE));

    }

    public static Integer engishFontsize() {
        return Integer.parseInt(sharedPreferences.getString("English_Font_Size", String.valueOf(Context.MODE_PRIVATE)));
    }

    public static String englishFontSelection() {
        return sharedPreferences.getString("English_Font_Selection", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String quranText() {
        return sharedPreferences.getString("qurantext", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String quranFont() {
        return sharedPreferences.getString("quranFont", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String getTranslation() {
        return sharedPreferences.getString("selecttranslation", String.valueOf(Context.MODE_PRIVATE));

    }

    public static Boolean showTranslation() {
        return sharedPreferences.getBoolean("showTranslationKey", true);

    }

    public static Boolean showWordByword() {
        return sharedPreferences.getBoolean("wordByWord", false);

    }

    public static boolean showErab() {
        return sharedPreferences.getBoolean("showErabKey", true);

    }

    public static boolean showWordColor() {
        return sharedPreferences.getBoolean("colortag", true);

    }

    public static boolean showTransliteration() {
        return sharedPreferences.getBoolean("showtransliterationKey", true);

    }

    public static boolean showJalalayn() {
        return sharedPreferences.getBoolean("showEnglishJalalayn", true);

    }

    public static Boolean GetSarfKabeerVerb() {
        boolean aBoolean = sharedPreferences.getBoolean("sarfkabeer_format_verb", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean SarfKabeerOthers() {
        boolean aBoolean = sharedPreferences.getBoolean("sarfkabeer_format_participles", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

}
