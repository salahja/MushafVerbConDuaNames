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

package com.example.mushafconsolidated.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;

import com.example.mushafconsolidated.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    public static final String TAG = "SettingsFragmentTag";
    static final String SHARED_PREFERENCE_EDITOR_NAME = "properties";
    static final String SHARED_PREFERENCE_SEEKBAR_VALUE = "pref_font_seekbar_key";
    private Drawable mDivider;

    public static void setArabicTextFontSize(Context paramContext, String paramString) {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("properties", 0).edit();
        editor.putString("quran_arabic_font", paramString);
        editor.apply();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        ListPreference selectionPreference = findPreference("selecttranslation");
        if (selectionPreference != null) {
            selectionPreference.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newValue) {
                            String selectionOption = (String) newValue;
                            SharedPreferences.Editor editor = getContext().getSharedPreferences("properties", 0).edit();
                            editor.putString("selecttranslation", selectionOption);
                            editor.apply();
                            return true;
                        }
                    });
        }
        SeekBarPreference fetchBar = (SeekBarPreference) findPreference("pref_font_seekbar_key");
        if (fetchBar != null) {
            fetchBar.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    if (newValue instanceof Integer) {
                        Integer newValueInt;
                        try {
                            newValueInt = (Integer) newValue;
                        } catch (NumberFormatException nfe) {
                            Log.e(TAG,
                                    "SeekBarPreference is a Integer, but it caused a NumberFormatException");
                            return false;
                        }
                        if (preference.getContext() == null) {
                            return false;
                        }
                        final SharedPreferences.Editor editor =
                                preference.getContext().getSharedPreferences(SHARED_PREFERENCE_EDITOR_NAME, Context.MODE_PRIVATE).edit();
                        editor.putInt(SHARED_PREFERENCE_SEEKBAR_VALUE, newValueInt);
                        editor.apply();
                        //   SharedPreferences.Editor editor = preference.getContext().getSharedPreferences("properties", 0).edit();
                        //   editor.putString("quran_arabic_font", paramString);
                        //   editor.apply();
                        return true;
                    } else {
                        String objType = newValue.getClass().getName();
                        Log.e(TAG, "SeekBarPreference is not a Integer, it is " + objType);
                        return false;
                    }
                }
            });
        }
        ListPreference themePreference = findPreference("themePref");
        if (themePreference != null) {
            themePreference.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newValue) {
                            String themeOption = (String) newValue;
                            //    ThemeHelper.applyTheme(themeOption);
                            return true;
                        }
                    });
        }
/*

        ListPreference listPreferenceCategory = (ListPreference) findPreference("selecttranslation");
        if (listPreferenceCategory != null) {
            Utils util = new Utils(getActivity());
            ArrayList<TranslationEntity> loadedTranslation = util.getLoadedTranslation(1,2);
         //   ArrayList<TranslationEntity> availableTranslation = util.getLoadedTranslation(0);

            CharSequence entries[] = new String[loadedTranslation.size()];
            CharSequence entryValues[] = new String[loadedTranslation.size()];
            int i = 0;

            for (TranslationEntity entity : loadedTranslation) {
                entries[i] = entity.getTranslation_id();
                entryValues[i] = entity.getTranslation_id();
                i++;
            }


            listPreferenceCategory.setEntries(entries);
            listPreferenceCategory.setEntryValues(entryValues);
        }

 */
    }

}
