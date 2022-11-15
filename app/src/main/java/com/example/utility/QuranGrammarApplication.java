/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.utility;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.preference.PreferenceManager;

import java.util.Locale;

import leakcanary.LeakCanary;

public class QuranGrammarApplication extends Application {
    private static Context appContext;

    public static Context getContext() {
        return appContext;
    }

    public static Context getInstance() {
        //Check application language
        Locale locale;
        Configuration config = new Configuration();
        appContext.getResources().updateConfiguration(config, appContext.getResources().getDisplayMetrics());
        return appContext;
    }

    public void onCreate() {
        super.onCreate();
        LeakCanary.Config config = LeakCanary.getConfig();
        if (appContext == null) {
            appContext = this;
        }
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        //  String theme = sharedPreferences.getString("theme", 1);
        String themePref = sharedPreferences.getString("themepref", "white");
        ThemeHelper.applyTheme(themePref);
    }

}
