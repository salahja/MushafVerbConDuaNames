package com.example.mushafconsolidated.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.mushafconsolidated.R;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity {

  public static final String LIGHT_THEME ="white";
  public static final String DARK_THEME = "dark";

  public   String currenttheme;
  private static final String sCurrentTheme = LIGHT_THEME;

  public static final String  DARK_BLUE = "blue";
  public static final String GREEN_MODE =  "green";
  public static final String BROWN_MODE = "brown";
  public static final String SHRINE_MODE = "shrine";



  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
     currenttheme= PreferenceManager.getDefaultSharedPreferences(this).getString("themepref", "dark");
    super.onCreate(savedInstanceState);

    switchTheme(currenttheme);
  }



//  protected  void setTheme(){

  //  switchTheme(currenttheme);
 // }
  protected void switchTheme(String currenttheme) {
    switch (currenttheme) {
      default:
      case LIGHT_THEME:
        setTheme(R.style.Theme_Purple);
        break;
      case DARK_THEME:
        setTheme(R.style.Theme_Black);
        break;
      case DARK_BLUE:
        setTheme(R.style.Theme_DarkBlue);
        break;
      case GREEN_MODE:
        setTheme(R.style.Theme_Green);
        break;
      case BROWN_MODE:
        setTheme(R.style.Theme_Brown);
        break;

    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("theme",  currenttheme).apply();
  }
}