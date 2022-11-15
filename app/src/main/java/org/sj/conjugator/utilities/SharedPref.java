package org.sj.conjugator.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {
    public static SharedPreferences sharedPreferences;
    Context sharedContext;

    public SharedPref(Context sharedContext) {
        //  this.sharedPreferences = sharedPreferences;
        this.sharedContext = sharedContext;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(sharedContext);
    }

    public static Integer arabicFontsize() {
        return Integer.parseInt(sharedPreferences.getString("Arabic_Font_Size", String.valueOf(Context.MODE_PRIVATE)));

    }

    public static String arabicFontSelection() {
        return sharedPreferences.getString("arabic_font_category", String.valueOf(Context.MODE_PRIVATE));

    }

    public static String getLanguage() {
        return sharedPreferences.getString("lang", String.valueOf(Context.MODE_PRIVATE));

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

    public static Boolean showTranslation() {
        return sharedPreferences.getBoolean("showTranslationKey", true);

    }

    public static Boolean AutoComplete() {
        boolean aBoolean = sharedPreferences.getBoolean("autocomplete", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean Nominative() {
        boolean aBoolean = sharedPreferences.getBoolean("Accusative", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean Accusative() {
        boolean aBoolean = sharedPreferences.getBoolean("Nominative", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean Jussive() {
        boolean aBoolean = sharedPreferences.getBoolean("Jussive", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean Comparative() {
        boolean aBoolean = sharedPreferences.getBoolean("All", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
    }

    public static Boolean Empathetic() {
        boolean aBoolean = sharedPreferences.getBoolean("Empathetic", false);
        return aBoolean;
//  boolean isChecked = sharedPreferences.getBoolean("switch", false);
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

    public static boolean showErab() {
        return sharedPreferences.getBoolean("showErabKey", true);

    }

}
