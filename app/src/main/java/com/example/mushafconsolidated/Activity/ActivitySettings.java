package com.example.mushafconsolidated.Activity;

import static com.example.Constant.AYAH_ID;
import static com.example.Constant.CHAPTER;
import static com.example.Constant.CHAPTERORPART;
import static com.example.Constant.MUFRADATFRAGTAG;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.WBW;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;

import com.example.mushafconsolidated.FontQuranListDialogFragment;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivitySettings extends BaseActivity implements
        PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    private static final String TAG = ActivitySettings.class.getSimpleName();
    private static final String TITLE_TAG = "settingsActivityTitle";
    static final String SHARED_PREFERENCE_EDITOR_NAME = "shared_pref_name";
    static final String SHARED_PREFERENCE_SEEKBAR_VALUE = "seek_value";
    ImageView backa;
    MaterialToolbar materialToolbar;
    FloatingActionButton btnBottomSheet;
    private ActivitySettings activity;
    // RelativeLayout layoutBottomSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        activity = this;

        initView();

        //    backa=findViewById(R.id.back);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new HeaderFragment())
                    .commit();
        } else {
            setTitle(savedInstanceState.getCharSequence(TITLE_TAG));
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    private void initView() {
        //  setSupportActionBar(materialToolbar);


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save current activity title so we can set it again after a configuration change
        outState.putCharSequence(TITLE_TAG, getTitle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Intent intent = getIntent();
        //   startActivity(intent);
        //   finish();
        //  Intent intents = new Intent(this, QuranGrammarAct.class);
        //  Intent intents = new Intent(this, ReadingSurahPartActivity.class);
        Intent readingintent = getIntent();


        finish();
        startActivity(readingintent);


    }

    @NonNull
    public Intent getIntent() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("lastread", MODE_PRIVATE);
        String surahname = pref.getString(SURAH_ARABIC_NAME, "");


        Intent readingintent = new Intent(this, QuranGrammarAct.class);
        readingintent.putExtra(MUFRADATFRAGTAG, false);
        readingintent.putExtra(CHAPTER, pref.getInt(CHAPTER, 1));
        readingintent.putExtra(AYAH_ID, pref.getInt(AYAH_ID, 1));
        readingintent.putExtra(SURAH_ARABIC_NAME, surahname);
        return readingintent;
    }


    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().popBackStackImmediate()) {
            return true;
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        if (pref.getKey().equals("quranFont")) {

            // Instantiate the new Fragment

            FontQuranListDialogFragment item = new FontQuranListDialogFragment();
            //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
            FragmentManager fragmentManager = ActivitySettings.this.getSupportFragmentManager();
            String sample = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ";

            String data[] = {sample, sample, sample};
            FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
            transactions.show(item);
            FontQuranListDialogFragment.newInstance(data).show(ActivitySettings.this.getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);
            setTitle(pref.getTitle());


        } else if (pref.getKey().equals("Exit")) {
            Intent readingintent = getIntent();

            //   Intent intent = getIntent();
            //   Intent intents = new Intent(this, ReadingSurahPartActivity.class);
            finish();
            startActivity(readingintent);
        }

        return true;
    }

    public static class HeaderFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            Preference button = (Preference) getPreferenceManager().findPreference("exitlink");
            if (button != null) {
                button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {


                    @Override
                    public boolean onPreferenceClick(Preference arg0) {
                        Intent intents = new Intent(getActivity(), QuranGrammarAct.class);
                        //  finish();
                        startActivity(intents);

                        return true;
                    }
                });
            }
            SeekBarPreference fetchBar = (SeekBarPreference) findPreference("pref_seekbar_key");
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

                            return true;
                        } else {
                            String objType = newValue.getClass().getName();
                            Log.e(TAG, "SeekBarPreference is not a Integer, it is " + objType);
                            return false;
                        }
                    }
                });
            }
      /*

            ListPreference selectionPreference = findPreference("selecttranslation");
            if (selectionPreference != null) {
                selectionPreference.setOnPreferenceChangeListener(
                        new Preference.OnPreferenceChangeListener() {
                            @Override
                            public boolean onPreferenceChange(Preference preference, Object newValue) {
                                String selectionOption = (String) newValue;
                                SharedPreferences.Editor editor =  getContext().getSharedPreferences("properties", 0).edit();
                                editor.putString("selecttranslation", selectionOption);
                                editor.apply();



                                return true;
                            }
                        });
            }



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
            ListPreference themePreference = findPreference("theme");
            if (themePreference != null) {
                themePreference.setOnPreferenceChangeListener(
                        new Preference.OnPreferenceChangeListener() {
                            @Override
                            public boolean onPreferenceChange(Preference preference, Object newValue) {
                                String themeOption = (String) newValue;


                                //  ThemeHelper.applyTheme(themeOption);
                                return true;
                            }


                        });
            }


        }
    }

    public class SelectQuranFronts extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.website_preferences, rootKey);
            FontQuranListDialogFragment item = new FontQuranListDialogFragment();
            //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
            FragmentManager fragmentManager = ActivitySettings.this.getSupportFragmentManager();


            String data[] = {String.valueOf("surah_id")};
            FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
            transactions.show(item);
            //     WordAnalysisBottomSheet.newInstance(data).show(ActivitySettings.this.getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);
        }
    }


}
