package com.example.utility;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
// quran_arabic_font = sharedPreferences.getString("quran_arabic_font", String.valueOf(Context.MODE_PRIVATE));
//        String arabic_font_selection = sharedPreferences.getString("Arabic_font_selection", String.valueOf(Context.MODE_PRIVATE));
//        String urdu_font_size = sharedPreferences.getString("Urdu_Font_Size", String.valueOf(Context.MODE_PRIVATE));
//        urdu_font_selection = sharedPreferences.getString("Urdu_Font_Selection", String.valueOf(Context.MODE_PRIVATE));

/*

public class PreferenceUtil {
  public static String getArabicFont(Context paramContext) {
    return paramContext.getSharedPreferences("properties", 0).getString("arabicTextFont", Settings.ArabicFont.getDefaultFont().toString());
  }
 */

public class PreferenceUtil {
    private static SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    public PreferenceUtil(SharedPreferences share) {
        this.sharedPreferences = share;
    }

    public static Integer getArabicTextFontSize(Context paramContext) {
        return Integer.valueOf(paramContext.getSharedPreferences("properties", 0).getInt("quran_arabic_font", 28));
    }

    public static Integer getUrduTextFontSize(Context paramContext) {
        return Integer.valueOf(paramContext.getSharedPreferences("properties", 0).getInt("Urdu_Font_Size", 22));
    }

    public static String getThemeMode(Context paramContext) {
        return paramContext.getSharedPreferences("properties", 0).getString("themePref", "default");
        //  return paramContext.getSharedPreferences("themePref", MODE_PRIVATE);
    }

    public static void setArabicTextFontSize(Context paramContext, String paramString) {
        editor = paramContext.getSharedPreferences("properties", 0).edit();
        editor.putString("quran_arabic_font", paramString);
        editor.apply();
    }

    public static void setUrduTextFontSize(Context paramContext, Integer paramInteger) {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
        editor.putInt("Urdu_Font_Size", paramInteger.intValue());
        editor.apply();
    }

    public String getArabicTextFonts() {
        return sharedPreferences.getString("Arabic_font_selection", String.valueOf(MODE_PRIVATE));

    }

    public String getTranslation() {
        String selecton = sharedPreferences.getString("selecton", String.valueOf(MODE_PRIVATE));
        return selecton;
    }

    public int getfontsize() {
        int selecton = Integer.parseInt(sharedPreferences.getString("pref_font_seek_bar", String.valueOf(MODE_PRIVATE)));
        return selecton;
    }

    public String getUrduTextFontSize() {
        return sharedPreferences.getString("Urdu_Font_Size", String.valueOf(MODE_PRIVATE));
    }

    public String getUrduTextFonts() {
        return sharedPreferences.getString("Urdu_Font_Selection", String.valueOf(MODE_PRIVATE));
    }

    public void setTranslation(Context paramContext, String paramString) {
        editor = paramContext.getSharedPreferences("properties", 0).edit();
        editor.putString("selection", paramString);
        editor.apply();

    }

}


/* Location:              /home/justme/Desktop/mq/classes-dex2jar.jar!/com/atq/quranemajeedapp/org/mufridat/data/PreferenceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */

/*



  public static String getArabicFont(Context paramContext) {
    return paramContext.getSharedPreferences("properties", 0).getString("arabicTextFont",
            Settings.ArabicFont.getDefaultFont().toString());
  }

  public static String getArabicTextColor(Context paramContext) {
    return paramContext.getSharedPreferences("properties", 0).getString("arabicTextColor",
            Settings.TextColor.DEFAULT.toString());
  }

  public static String getUrduFont(Context paramContext) {
    return paramContext.getSharedPreferences("properties", 0).
            getString("urduTextFontv8",
                     Settings.UrduFont.getDefaultFont().toString());
  }




  public static void setArabicFont(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
    editor.putString("arabicTextFont", paramString);
    editor.apply();



  public static void setUrduFont(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
    editor.putString("urduTextFontv8", paramString);
    editor.apply();
  }
  public static void setWordsStyle(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
    editor.putString("wordsStyle", paramString);
    editor.apply();
  }
  }
 */
