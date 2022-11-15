package org.sj.conjugator.utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.preference.PreferenceManager;

import java.util.Locale;

import leakcanary.LeakCanary;

public class VerbConjugaorApp extends Application {
    private static Context appContext;

    public static Context getContext() {
        return appContext;
    }

    public static Context getInstance() {
        //Check application language
        Locale locale;
        //  if (AppPreference.isArabicMood(appContext))
        //       locale = new Locale("ar");
        //   else
        //       locale = new Locale("en");
        //   Locale.setDefault(locale);
        Configuration config = new Configuration();
        //   config.locale = locale;
        appContext.getResources().updateConfiguration(config, appContext.getResources().getDisplayMetrics());
        return appContext;
    }

    public void onCreate() {
        super.onCreate();
        LeakCanary.Config config = LeakCanary.getConfig();
        if (appContext == null) {
            appContext = this;
        }
        appContext = getApplicationContext();
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        //  String theme = sharedPreferences.getString("theme", 1);
        String themePref = sharedPreferences.getString("pref", "white");
        ThemeHelper.applyTheme(themePref);
    }

}
