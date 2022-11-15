package com.example.mushafconsolidated.Activity;

import static com.example.Constant.ACCUSATIVE;
import static com.example.Constant.CONDITIONAL;
import static com.example.Constant.DEMONSTRATIVE;
import static com.example.Constant.IMPERATIVE;
import static com.example.Constant.ISPARTICPLE;
import static com.example.Constant.NOUNCASE;
import static com.example.Constant.PREPOSITION;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.QURAN_VOCUBALORY_ROOT;
import static com.example.Constant.RELATIVE;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;
import static Utility.ArabicLiterals.LALIF;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.fragments.Dictionary_frag;
import com.example.utility.SharedPref;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.sj.conjugator.fragments.FragmentIsmZarf;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class LughatWordDetailsAct extends BaseActivity {
    private static final int NUM_PAGES_THULATHI = 8;
    private static final int NUM_PAGES_THULATHI_MAJZOOMMANSUB = 9;
    private static final int NUM_PAGES_MAZEED = 6;
    private static final int NUM_PAGES_MAZEED_MAJZOOMMANSUB = 7;
    private static final int NUM_PAGES_VOCABULARY = 4;
    private static final int NUM_PAGES_ARABICWORD_HARFNASB = 3;
    private static final int NUM_PAGES_ISMMARFU = 5;
    // Arrey of strings FOR TABS TITLES
    private final String[] arabicwordharfnasb = new String[]{"English lughat", "Urdu Lughat", "Harf "};
    private final String[] vocabularytitles = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat"};
    private final String[] thulathientitles = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Verb Conjugaton", "Active/Passive PCPL", "N. Instrument", "N.Place/Time"};
    private final String[] thulathientitlesmansub = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Subjunctive",
            "Verb Conjugaton", "Active/Passive PCPL", "N. Instrument", "N.Place/Time"};
    private final String[] mujarradparticple = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", " ",
            "Verb Conjugaton", "Active/Passive PCPL", "N. Instrument", "N.Place/Time"};
    private final String[] mazeedparticpletitle = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", " ", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] thulathientitlesmajzoom = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat",
            "Jussive", "Verb Conjugaton", "Active/Passive PCPL", "N. Instrument", "N.Place/Time"};
    private final String[] ismmansubtitle = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", ""};
    private final String[] ismmarfutitle = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", ""};
    private final String[] ismgenetivetitle = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Genitive"};
    private final String[] thulathiartitles = new String[]{"قاموس هانز", "لين معجم", "English lughat", "Urdu Lughat", "صرف صغير", "تصريف الأفعال ", "لاسم الفاعل/الاسم المفعول", "الاسم الآلة", "الاسم الظرف"};
    private final String[] mazeedentitles = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] mazeedentitlesmajzoom = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Jussive", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] mazeedimperative = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Imperative", "Jussive", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] mujarradimperative = new String[]{"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Imperative", "Jussive",
            "Verb Conjugaton", "Active/Passive PCPL", "N. Instrument", "N.Place/Time"};
    private final String[] mazeedentitlesmansub = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Subjunctive", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] getMazeedentitles = new String[]
            {"Lane Lexicon", "Hans Weir", "English lughat", "Urdu Lughat", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] mazeedartitles = new String[]{"قاموس هانز", "لين معجم", "English lughat", "Urdu Lughat", "صرف صغير", "تصريف الأفعال ", "لاسم الفاعل/الاسم المفعول"};
    private final String[] languages = new String[10];
    Bundle dataBundle;
    private boolean isUnaugmentedWazan, isAugmentedWazan, isnoconjugation, isonlyarabicword, isVerbMajzoom, isVerbMansub;
    private boolean isnoun;
    private boolean isHarf;
    private String nouncase;
    private boolean isIsmMarfu, isIsmMansub, isIsmMajroor, isimperative;
    private boolean isVerbMarfu;
    private boolean isparticple;
    private boolean ismujarrad;

    public void setLanguage(String language) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtabs);
        //   setContentView(R.layout.activity_tabs);
        FloatingTextButton callButton = findViewById(R.id.action_button);
        callButton.setOnClickListener(view -> {
            // viewPager.adapters=null;
            finish();
            //      Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
        });
        FragmentManager fm = getSupportFragmentManager();
        ViewStateAdapter sa = new ViewStateAdapter(fm, getLifecycle());
        final ViewPager2 viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sa);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        dataBundle = new Bundle();
        Bundle bundle = getIntent().getExtras();
        bundle.getParcelableArray("dictionary");
        String conjugationroot = bundle.getString(QURAN_VERB_ROOT);
        String vocubaluryroot = bundle.getString(QURAN_VERB_ROOT);
        String verbformthulathi = bundle.getString(QURAN_VERB_WAZAN);
        String verbtype = bundle.getString(VERBTYPE);
        final String ss = conjugationroot.replaceAll("[\\[\\]]", "");
        String verbroot = ss.replaceAll("[,;\\s]", "");
        int starts = conjugationroot.indexOf(LALIF);
        String hamza = "ء";
        if (starts != -1) {
            conjugationroot = conjugationroot.replace(LALIF, hamza.trim());
        }
        String verbform;
        String verbmood;
        String arabicword;
        if (bundle.getString("nouncase") != null) {
            nouncase = bundle.getString(NOUNCASE);
            isnoun = true;
            switch (nouncase) {
                case "NOM":
                    isIsmMarfu = true;
                    break;
                case "ACC":
                    isIsmMansub = true;
                    break;
                case "GEN":
                    isIsmMajroor = true;
                    break;
            }
        }
        verbform = bundle.getString(QURAN_VERB_WAZAN);
        verbmood = bundle.getString(VERBMOOD);
        verbtype = bundle.getString(VERBTYPE);
        arabicword = bundle.getString("arabicword");
        isimperative = bundle.getBoolean(IMPERATIVE, false);
        isparticple = bundle.getBoolean(ISPARTICPLE, false);
        boolean isharfnasab = bundle.getBoolean(ACCUSATIVE, false);
        boolean isdem = bundle.getBoolean(DEMONSTRATIVE, false);
        boolean isrelative = bundle.getBoolean(RELATIVE, false);
        boolean isShart = bundle.getBoolean(CONDITIONAL, false);
        boolean isprep = bundle.getBoolean(PREPOSITION, false);
        isHarf = isShart == isrelative == isharfnasab == isprep == isdem;
        try {
            if (verbmood.equals("Jussive")) {
                isVerbMajzoom = true;
            } else if (verbmood.equals("Subjunctive")) {
                isVerbMansub = true;
            } else if (verbmood.equals("Indicative")) {
                isVerbMarfu = true;
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());

        }
        boolean ismazeed;
        if (verbtype.equals("mujarrad")) {
            ismujarrad = true;
        } else if (verbtype.equals("mazeed")) {
            ismazeed = true;

        } else {
            ismujarrad = false;
            ismazeed = false;
        }
        if (arabicword.length() == 0) {
            try {
                dataBundle.putString(QURAN_VERB_ROOT, verbroot);
                dataBundle.putString(QURAN_VERB_WAZAN, verbform);
                dataBundle.putString(VERBMOOD, verbmood);
                dataBundle.putString(VERBTYPE, verbtype);
                if (bundle.getString("nouncase") != null) {
                    dataBundle.putString(NOUNCASE, nouncase);

                }
                if (verbtype.equals("mujarrad")) {
                    isUnaugmentedWazan = true;
                    setLanguage("lanes");
                } else if (verbtype.equals("mazeed")) {
                    isAugmentedWazan = true;
                    setLanguage("lanes");
                } else {
                    isnoconjugation = true;
                    setLanguage("english");
                }
            } catch (Exception e) {
                dataBundle.putString(QURAN_VOCUBALORY_ROOT, vocubaluryroot);
                dataBundle.putString(QURAN_VERB_WAZAN, verbformthulathi);
                dataBundle.putSerializable(QURAN_VERB_ROOT, conjugationroot);
                isUnaugmentedWazan = true;
                setLanguage("lanes");

            }
        } else {
            isonlyarabicword = true;
            dataBundle.putString("arabicword", arabicword);
            dataBundle.putString(QURAN_VERB_WAZAN, "");
            dataBundle.putSerializable(QURAN_VERB_ROOT, "");
            isnoconjugation = false;
            setLanguage("english");
        }
        // Up to here, we have working scrollable pages
        if (isimperative) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "imperative";
            languages[5] = "Jussive";
            if (isAugmentedWazan) {
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedimperative[position])).attach();
            } else if (ismujarrad) {
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mujarradimperative[position])).attach();

            }

        } else if (ismujarrad && isparticple && (isIsmMajroor || isIsmMansub || isIsmMarfu)) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            if (isIsmMajroor) {
                languages[4] = "genetivenoun";
                mujarradparticple[4] = "Genitive.Noun";
            } else if (isIsmMansub) {
                languages[4] = "accusativenoun";
                mujarradparticple[4] = "Accusative.Noun";
            } else if (isIsmMarfu) {
                languages[4] = "nominativenoun";
                mujarradparticple[4] = "Nominative.Noun";
            }
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mujarradparticple[position])).attach();
        } else if (isAugmentedWazan && isparticple && (isIsmMajroor || isIsmMansub || isIsmMarfu)) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "genetivenoun";
            if (isIsmMajroor) {
                languages[4] = "genetivenoun";
                mazeedparticpletitle[4] = "Genitive.Noun";
            } else if (isIsmMansub) {
                languages[4] = "accusativenoun";
                mazeedparticpletitle[4] = "Accusative.Noun";
            } else if (isIsmMarfu) {
                languages[4] = "nominativenoun";
                mazeedparticpletitle[4] = "Nominative.Noun";
            }
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedparticpletitle[position])).attach();

        } else if (isIsmMajroor || isIsmMansub || isIsmMarfu) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "genetivenoun";
            mujarradparticple[4] = "Genitive";
            if (isIsmMajroor) {
                languages[4] = "genetivenoun";
                ismmansubtitle[4] = "Genitive.Noun";
            } else if (isIsmMansub) {
                languages[4] = "accusativenoun";
                ismmansubtitle[4] = "Accusative.Noun";
            } else if (isIsmMarfu) {
                languages[4] = "nominativenoun";
                ismmansubtitle[4] = "Nominative.Noun";
            }
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(ismmansubtitle[position])).attach();

        } else if (isIsmMansub) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "accusativenoun";
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(ismmansubtitle[position])).attach();

        } else if (isIsmMarfu) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "nominativenoun";
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(ismmarfutitle[position])).attach();

        } else if (ismujarrad) {
            if (SharedPref.getLanguage().equals("en") && verbmood.equals("Jussive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Jussive";
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(thulathientitlesmajzoom[position])).attach();

            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Subjunctive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Subjunctive";
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(thulathientitlesmansub[position])).attach();
            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Indicative")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(thulathientitles[position])).attach();

            }

        } else if (isAugmentedWazan) {
            if (SharedPref.getLanguage().equals("en") && verbmood.equals("Jussive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Jussive";
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedentitlesmajzoom[position])).attach();

            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Subjunctive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Subjunctive";
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedentitlesmansub[position])).attach();
            } else {
                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(getMazeedentitles[position])).attach();
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";

            }

        } else if (isonlyarabicword && isrelative) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(arabicwordharfnasb[position])).attach();
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "relative";
        } else if (isonlyarabicword && isdem) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(arabicwordharfnasb[position])).attach();
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "demonstrative";
        } else if (isonlyarabicword && isharfnasab) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(arabicwordharfnasb[position])).attach();
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "accusative";
        } else if (isonlyarabicword && isShart) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(arabicwordharfnasb[position])).attach();
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "conditonal";
        } else if (isonlyarabicword && isprep) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(arabicwordharfnasb[position])).attach();
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "preposition";
        } else if (isnoconjugation) {
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(vocabularytitles[position])).attach();
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";

        } else {
            Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        // Now we have tabs, NOTE: I am hardcoding the order, you'll want to do something smarter
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        // And now we have tabs that, when clicked, navigate to the correct page
    }

    private class ViewStateAdapter extends FragmentStateAdapter {
        public ViewStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Hardcoded in this order, you'll want to use lists and make sure the titles match


          /*
            if (isAugmentedWazan && isparticple && (isIsmMajroor || isIsmMansub || isIsmMarfu)) {


            } else
           */
            if (ismujarrad && isparticple && (isIsmMajroor || isIsmMansub || isIsmMarfu)) {
                return getMujarradParticiple(position);

            } else if (ismujarrad && (isVerbMajzoom || isVerbMansub)) {
                return getMujarradMajzoomOrMansub(position);

            } else if (ismujarrad && isVerbMarfu && !isimperative) {
                return getMujarradMarfuu(position);

            } else if (isAugmentedWazan && (isVerbMajzoom || isimperative)) {
                return getMazeedMajzoomOrMarfuImp(position);

            } else if (ismujarrad && (isVerbMajzoom || isimperative)) {
                return getMujarradImperative(position);

            } else if (isAugmentedWazan && (isVerbMajzoom || isVerbMansub)) {
                return getMazeedMajzoomOrMarfu(position);

            } else if (isAugmentedWazan && isVerbMarfu) {
                return getMazeedMarfu(position);
            } else if (isIsmMajroor || isIsmMansub || isIsmMarfu) {
                return getMujarradMajzoomOrMansub(position);

            } else if (isonlyarabicword && (isHarf))//isShart == isrelative == isharfnasab == isprep == isdem;
            {
                return getHarf(position);
            }
            return getMujarradMajzoomOrMansub(position);

        }

        private Fragment getMazeedParticiple(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 4) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMujarradParticiple(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 4) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            } else if (position == 7) {
                org.sj.conjugator.fragments.FragmentIsmIsmAla fragvsi = new org.sj.conjugator.fragments.FragmentIsmIsmAla();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            } else if (position == 8) {
                FragmentIsmZarf fragvsi = new FragmentIsmZarf();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMujarradMarfuu(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentIsmIsmAla fragvsi = new org.sj.conjugator.fragments.FragmentIsmIsmAla();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            } else if (position == 7) {
                FragmentIsmZarf fragvsi = new FragmentIsmZarf();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMujarradMajzoomOrMansub(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                //jussive/sujunnctive/marfu/mansub/majroor
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            } else if (position == 7) {
                org.sj.conjugator.fragments.FragmentIsmIsmAla fragvsi = new org.sj.conjugator.fragments.FragmentIsmIsmAla();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            } else if (position == 8) {
                FragmentIsmZarf fragvsi = new FragmentIsmZarf();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMazeedMarfu(int position) {
            //    private static final int NUM_PAGES_MAZEED = 6;
            //    private static final int NUM_PAGES_MAZEED_MAJZOOMMANSUB = 7;
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getHarf(int position) {
            //    private static final int NUM_PAGES_MAZEED = 6;
            //    private static final int NUM_PAGES_MAZEED_MAJZOOMMANSUB = 7;
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMujarradImperative(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                //jussive/sujunnctive/marfu/mansub/majroor
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                // org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[5]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 7) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            } else if (position == 8) {
                org.sj.conjugator.fragments.FragmentIsmIsmAla fragvsi = new org.sj.conjugator.fragments.FragmentIsmIsmAla();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            } else if (position == 9) {
                FragmentIsmZarf fragvsi = new FragmentIsmZarf();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMazeedMajzoomOrMarfuImp(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                //jussive/sujunnctive/marfu/mansub/majroor
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                // org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[5]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 7) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        private Fragment getMazeedMajzoomOrMarfu(int position) {
            if (position == 0) {
                //hanes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[0]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 1) {
                //kabes
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[1]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 2) {
                //english
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[2]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else if (position == 3) {
                //urudu
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[3]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 4) {
                //jussive/sujunnctive/marfu/mansub/majroor
                Dictionary_frag fragv = new Dictionary_frag(LughatWordDetailsAct.this, languages[4]);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 5) {
                org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();

            } else if (position == 6) {
                org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools fragvs = new org.sj.conjugator.fragments.FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            }
            org.sj.conjugator.fragments.FragmentVerb fragv = new org.sj.conjugator.fragments.FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }

        @Override
        public int getItemCount() {
            if (isimperative && isAugmentedWazan) {
                return 8;
            } else if (isimperative && ismujarrad) {
                return 10;
            } else if (isAugmentedWazan && isparticple) {
                return 7;
            } else if (ismujarrad && isparticple) {
                return 9;
            } else if (isnoun) {
                return NUM_PAGES_ISMMARFU;
            }
            if (isHarf) {
                return NUM_PAGES_ARABICWORD_HARFNASB;
            } else if (isUnaugmentedWazan && (isVerbMajzoom || isVerbMansub)) {
                return NUM_PAGES_THULATHI_MAJZOOMMANSUB;
            } else if (isUnaugmentedWazan) {
                return NUM_PAGES_THULATHI;
            } else if (isAugmentedWazan && (isVerbMansub || isVerbMajzoom)) {
                return NUM_PAGES_MAZEED_MAJZOOMMANSUB;

            } else if (isAugmentedWazan) {
                return NUM_PAGES_MAZEED;

            } else if (isnoconjugation) {
                return NUM_PAGES_VOCABULARY;
            } else {
                return 0;
            }
        }
    }
}
