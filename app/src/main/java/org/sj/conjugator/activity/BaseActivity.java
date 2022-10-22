package org.sj.conjugator.activity;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.mushafconsolidated.R;

public abstract class BaseActivity extends AppCompatActivity {

  public static final String LIGHT_THEME ="white";
  public static final String DARK_THEME = "dark";

  public   String currenttheme;
  private static String sCurrentTheme = LIGHT_THEME;

  public static final String  DARK_BLUE = "blue";

  public static final String BROWN_MODE = "brown";



  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    currenttheme= PreferenceManager.getDefaultSharedPreferences(this).getString("theme", "dark");
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
        setTheme(R.style.Theme_White);
        break;
      case DARK_THEME:
        setTheme(R.style.Theme_Black);
        break;
      case DARK_BLUE:
        setTheme(R.style.Theme_DarkBlue);
        break;
        case BROWN_MODE:
        setTheme(R.style.Theme_Brown);
        break;

    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("theme",  currenttheme).apply();
  }
}