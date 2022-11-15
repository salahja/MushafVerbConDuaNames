package org.sj.conjugator.fragments;


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

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import org.sj.conjugator.utilities.ThemeHelper;

public class SettingsFragmentVerb extends PreferenceFragmentCompat {
    public static final String TAG = "SettingsFragmentTag";
    private Drawable mDivider;

    public static void setArabicTextFontSize(Context paramContext, String paramString) {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
        editor.putString("Arabic_Font_Size", paramString);
        editor.apply();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.verbpreferences, rootKey);
        ListPreference themePreference = findPreference("themePref");
        if (themePreference != null) {
            themePreference.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newValue) {
                            String themeOption = (String) newValue;
                            ThemeHelper.applyTheme(themeOption);
                            return true;
                        }
                    });
        }
        Preference selectionPreference = findPreference("Accusative");
        if (selectionPreference != null) {
            selectionPreference.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newValue) {
                            boolean selectionOption = (boolean) newValue;
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext()).edit();
                            //   SharedPreferences.Editor editor =  getContext().getSharedPreferences("properties", 0).edit();
                            editor.putBoolean("Accusative", selectionOption);
                            editor.putBoolean("Nominative", false);
                            editor.apply();
                            return true;
                        }
                    });
        }

    }

}
