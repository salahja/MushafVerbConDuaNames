package com.example.mushafconsolidated.Activity;

import static com.example.Constant.ACCUSATIVE;
import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.CONDITIONAL;
import static com.example.Constant.DEMONSTRATIVE;
import static com.example.Constant.NOUNCASE;
import static com.example.Constant.PREPOSITION;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.RELATIVE;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;
import static com.example.Constant.WORDNUMBER;
import static com.example.Constant.html;
import static com.example.Constant.particlespanDark;
import static org.sj.conjugator.utilities.ArabicLiterals.AlifHamzaAbove;
import static org.sj.conjugator.utilities.ArabicLiterals.AlifMaksuraString;
import static org.sj.conjugator.utilities.ArabicLiterals.Hamza;
import static org.sj.conjugator.utilities.ArabicLiterals.LALIF;
import static org.sj.conjugator.utilities.ArabicLiterals.Ya;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.Constant;
import com.example.mushafconsolidated.Adapters.NounVerbOccuranceListAdapter;
import com.example.mushafconsolidated.Entities.CorpusNounWbwOccurance;
import com.example.mushafconsolidated.Entities.CorpusVerbWbwOccurance;
import com.example.mushafconsolidated.Entities.GrammarRules;
import com.example.mushafconsolidated.Entities.NounCorpusBreakup;
import com.example.mushafconsolidated.Entities.VerbCorpusBreakup;
import com.example.mushafconsolidated.Entities.hanslexicon;
import com.example.mushafconsolidated.Entities.lanelexicon;
import com.example.mushafconsolidated.Entities.lughat;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.QuranMorphologyDetails;
import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.example.mushafconsolidated.fragments.WordAnalysisListAdapter;
import com.example.utility.CorpusUtilityorig;
import com.example.utility.QuranGrammarApplication;
import com.example.utility.SharedPref;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class WordDictionaryAct extends BaseActivity {
    private static final int REQUEST_WRITE_STORAGE = 112;
    private static final int REQUEST_WRITE_Settings = 113;
    private final String[] languages = new String[10];
    public ArrayList<CorpusNounWbwOccurance> corpusNounWbwOccurances;
    ExpandableListView expandableListView;
    ViewPager2 viewPager2;
    boolean harf;
    List<String> expandNounTitles;
    List<String> expandVerbTitles;
    int mPageNo = 0;
    LinkedHashMap<String, List<String>> expandableListDetail;
    ImageView imgPg;
    TextView link;
    String root;
    int counter = 0;
    AlertDialog dialog;
    boolean isarabicword, islanes, ishans;
    LinkedHashMap<String, List<SpannableString>> updatechild = new LinkedHashMap<>();
    LinkedHashMap<String, List<SpannableString>> expandNounVerses = new LinkedHashMap<>();
    LinkedHashMap<String, List<SpannableString>> expandVerbVerses = new LinkedHashMap<>();
    Utils utils;
    TextView tv;
    ProgressBar progressBar;
    int firstcolortat, maincolortag, pronouncolortag, fourcolortag;
    private String str2;
    private RelativeLayout LL;
    private Bundle dataBundle;
    private MaterialToolbar materialToolbar;
    private MenuItem jumpto;
    private ProgressBar progressBar1;
    private File childfile;
    private String databasepath;
    private File mainDatabasesZIP;
    private File targetDirectory;
    private FileInputStream is;
    private ZipInputStream zis;
    private ZipEntry ze;
    private String filename;
    private ArrayList<VerbCorpusBreakup> verbCorpusArrayList;
    private ArrayList<CorpusNounWbwOccurance> occurances;
    private ArrayList<NounCorpusBreakup> nounCorpusArrayList;
    private boolean isUnaugmentedWazan, isAugmentedWazan, isnoconjugation, isonlyarabicword, isMajzoom, isMansub;
    private boolean isnoun, isrelative, isdem, isprep, isharfnasab, isShart, isHarf;
    private String nouncase;
    private boolean isIsmMarfu, isIsmMansub, isIsmMajroor;
    private boolean ismujarrad, ismazeed;
    private LinearLayoutManager parentLayoutManager;
    private SharedPreferences shared;
    private RecyclerView recview;
    private ProgressDialog progressBarDD;
    private final int progressBarStatus = 0;
    public WordDictionaryAct() {
    }

    public boolean isHarf() {
        return harf;
    }

    public void setHarf(boolean harf) {
        this.harf = harf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_list);
        //   recview=findViewById(R.id.recyclerView);
        //  parentLayoutManager = new LinearLayoutManager(WordOccuranceAsynKAct.this);
        Bundle bundle = getIntent().getExtras();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        root = bundle.getString(QURAN_VERB_ROOT);
        utils = new Utils(WordDictionaryAct.this);
        //
        dataBundle = new Bundle();
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
        String verbform = null;
        String verbmood = null;
        String arabicword = null;
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
        if (arabicword.isEmpty()) {
            arabicword = bundle.getString("root");
        }
        isharfnasab = bundle.getBoolean(ACCUSATIVE, false);
        isdem = bundle.getBoolean(DEMONSTRATIVE, false);
        isrelative = bundle.getBoolean(RELATIVE, false);
        isShart = bundle.getBoolean(CONDITIONAL, false);
        isprep = bundle.getBoolean(PREPOSITION, false);
        isHarf = isShart == isrelative == isharfnasab == isprep == isdem;
        try {
            if (verbmood.equals("Jussive")) {
                isMajzoom = true;
            } else if (verbmood.equals("Subjunctive")) {
                isMansub = true;
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());

        }
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
                if (verbtype.equals("mujarrad")) {
                    isUnaugmentedWazan = true;
                    //    setLanguage("lanes");
                } else if (verbtype.equals("mazeed")) {
                    isAugmentedWazan = true;
                    //   setLanguage("lanes");
                } else {
                    isnoconjugation = true;
                    //     setLanguage("english");
                }
            } catch (Exception e) {
                // dataBundle.putString(QURAN_VOCUBALORY_ROOT, vocubaluryroot);
                //  dataBundle.putString(QURAN_VERB_WAZAN, verbformthulathi);
                //    dataBundle.putSerializable(QURAN_VERB_ROOT, conjugationroot);
                isUnaugmentedWazan = true;
                //    setLanguage("lanes");
            }
        } else {
            isonlyarabicword = true;
            //   dataBundle.putString("arabicword", arabicword);
            //  dataBundle.putString(QURAN_VERB_WAZAN, "");
            // dataBundle.putSerializable(QURAN_VERB_ROOT, "");
            isnoconjugation = false;
            //    setLanguage("english");
        }
        if (isIsmMarfu) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "genetivenoun";
            expandableListDetail = new LinkedHashMap<>();
            int indexOfHamza = verbroot.indexOf(Hamza);
            if (indexOfHamza != -1) {
                verbroot = verbroot.replaceAll(Hamza, LALIF);
            }
//lanes dictionary
            getLanes(verbroot);
            getHans(verbroot);
            ArrayList<lughat> dictionary = new ArrayList<>();
            dictionary = utils.getRootDictionary(arabicword);
            if (!dictionary.isEmpty()) {
                isarabicword = true;
                String en_lughat = dictionary.get(0).getEn_lughat();
                String ur_lughat = dictionary.get(0).getUr_lughat();
                expandableListDetail.put("english", Collections.singletonList(en_lughat));
                expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
            }
            //nominativenouns/mansubism
            getSelectedIsm();
            displayAdapter();

        } else if (isIsmMansub) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "accusativenoun";
            expandableListDetail = new LinkedHashMap<>();
            int indexOfHamza = verbroot.indexOf(Hamza);
            if (indexOfHamza != -1) {
                verbroot = verbroot.replaceAll(Hamza, LALIF);
            }
//lanes dictionary
            getLanes(verbroot);
            getHans(verbroot);
            ArrayList<lughat> dictionary = new ArrayList<>();
            dictionary = utils.getRootDictionary(arabicword);
            if (!dictionary.isEmpty()) {
                isarabicword = true;
                String en_lughat = dictionary.get(0).getEn_lughat();
                String ur_lughat = dictionary.get(0).getUr_lughat();
                expandableListDetail.put("english", Collections.singletonList(en_lughat));
                expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
            }
            //nominativenouns/mansubism
            getSelectedIsm();
            displayAdapter();

        } else if (isIsmMajroor) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";
            languages[4] = "nominativenoun";
            expandableListDetail = new LinkedHashMap<>();
            int indexOfHamza = verbroot.indexOf(Hamza);
            if (indexOfHamza != -1) {
                verbroot = verbroot.replaceAll(Hamza, LALIF);
            }
//lanes dictionary
            getLanes(verbroot);
            getHans(verbroot);
            ArrayList<lughat> dictionary = new ArrayList<>();
            dictionary = utils.getRootDictionary(arabicword);
            if (!dictionary.isEmpty()) {
                isarabicword = true;
                String en_lughat = dictionary.get(0).getEn_lughat();
                String ur_lughat = dictionary.get(0).getUr_lughat();
                expandableListDetail.put("english", Collections.singletonList(en_lughat));
                expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
            }
            //nominativenouns/mansubism
            getSelectedIsm();
            displayAdapter();

        } else if (ismujarrad) {
            if (SharedPref.getLanguage().equals("en") && verbmood.equals("Jussive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Jussive";
                expandableListDetail = new LinkedHashMap<>();
                int indexOfHamza = verbroot.indexOf(Hamza);
                if (indexOfHamza != -1) {
                    verbroot = verbroot.replaceAll(Hamza, LALIF);
                }
//lanes dictionary
                getLanes(verbroot);
                getHans(verbroot);
                ArrayList<lughat> dictionary = new ArrayList<>();
                dictionary = utils.getRootDictionary(arabicword);
                if (!dictionary.isEmpty()) {
                    isarabicword = true;
                    String en_lughat = dictionary.get(0).getEn_lughat();
                    String ur_lughat = dictionary.get(0).getUr_lughat();
                    expandableListDetail.put("english", Collections.singletonList(en_lughat));
                    expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
                }
                //nominativenouns/mansubism
                ArrayList<GrammarRules> jazam = utils.getGrammarRulesByRules("jazam");
                String jussiveverb = jazam.get(0).getDetailsrules();
                expandableListDetail.put("Majzuum", Collections.singletonList(jussiveverb));
                displayAdapter();

            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Subjunctive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Subjunctive";
                expandableListDetail = new LinkedHashMap<>();
                int indexOfHamza = verbroot.indexOf(Hamza);
                if (indexOfHamza != -1) {
                    verbroot = verbroot.replaceAll(Hamza, LALIF);
                }
//lanes dictionary
                getLanes(verbroot);
                getHans(verbroot);
                ArrayList<lughat> dictionary = new ArrayList<>();
                dictionary = utils.getRootDictionary(arabicword);
                if (!dictionary.isEmpty()) {
                    isarabicword = true;
                    String en_lughat = dictionary.get(0).getEn_lughat();
                    String ur_lughat = dictionary.get(0).getUr_lughat();
                    expandableListDetail.put("english", Collections.singletonList(en_lughat));
                    expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
                }
                //nominativenouns/mansubism
                ArrayList<GrammarRules> nasab = utils.getGrammarRulesByRules("nasab");
                String nasabverb = nasab.get(0).getDetailsrules();
                expandableListDetail.put("MansUB", Collections.singletonList(nasabverb));
                displayAdapter();

            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Indicative")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                expandableListDetail = new LinkedHashMap<>();
                int indexOfHamza = verbroot.indexOf(Hamza);
                if (indexOfHamza != -1) {
                    verbroot = verbroot.replaceAll(Hamza, LALIF);
                }
//lanes dictionary
                getLanes(verbroot);
                getHans(verbroot);
                ArrayList<lughat> dictionary = new ArrayList<>();
                dictionary = utils.getRootDictionary(arabicword);
                if (!dictionary.isEmpty()) {
                    isarabicword = true;
                    String en_lughat = dictionary.get(0).getEn_lughat();
                    String ur_lughat = dictionary.get(0).getUr_lughat();
                    expandableListDetail.put("english", Collections.singletonList(en_lughat));
                    expandableListDetail.put("Urdu", Collections.singletonList(ur_lughat));
                }
                //nominativenouns/mansubism
                displayAdapter();

            }

        } else if (isAugmentedWazan) {
            if (SharedPref.getLanguage().equals("en") && verbmood.equals("Jussive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Jussive";

            } else if (SharedPref.getLanguage().equals("en") && verbmood.equals("Subjunctive")) {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";
                languages[4] = "Subjunctive";

            } else {
                languages[0] = "lanes";
                languages[1] = "hans";
                languages[2] = "english";
                languages[3] = "urdu";

            }

        } else if (isonlyarabicword && isrelative) {
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "relative";
        } else if (isonlyarabicword && isdem) {
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "demonstrative";
        } else if (isonlyarabicword && isharfnasab) {
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "accusative";
        } else if (isonlyarabicword && isShart) {
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "conditonal";
        } else if (isonlyarabicword && isprep) {
            languages[0] = "english";
            languages[1] = "urdu";
            languages[2] = "preposition";
        } else if (isnoconjugation) {
            languages[0] = "lanes";
            languages[1] = "hans";
            languages[2] = "english";
            languages[3] = "urdu";

        }
        // String preferences = SharedPref.themePreferences();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);
        dialog = builder.create();
        shared =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);
        String whichtranslation = shared.getString("selecttranslation", "en_sahih");
        Boolean showtranslation = shared.getBoolean("prefs_show_translation", true);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String preferences = prefs.getString("theme", "dark");
        if (preferences.equals("dark")) {
            firstcolortat = Constant.BCYAN;
            maincolortag = Constant.BYELLOW;
            pronouncolortag = Constant.BBLUE;
            fourcolortag = Constant.BWHITE;

        } else {
            firstcolortat = Constant.WBURNTUMBER;
            maincolortag = ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.prussianblue);
            pronouncolortag = Constant.WMIDNIHTBLUE;
            fourcolortag = Constant.GREENDARK;

        }
        FloatingTextButton callBackbutton = findViewById(R.id.action_button);
        String pref = "dark";
        if (pref.equals("dark")) {
            int color = getResources().getColor(R.color.color_background_overlay);
            callBackbutton.setBackgroundColor(color);
        } else {
            callBackbutton.setBackgroundColor(getResources().getColor(R.color.color_background));

        }
        callBackbutton.setOnClickListener(view -> {
            //  Intent quranintnt = new Intent(VerbOccuranceAsynKAct.this, ReadingSurahPartActivity.class);
            finish();
            //     startActivity(quranintnt);
        });
        if (root.equals("ACC") || root.equals("LOC") || root.equals("T")) {
            occurances = utils.getnounoccuranceHarfNasbZarf(root);
            harf = true;
            ExecuteNounOcurrance();

        } else {
            harf = false;
            //    ExecuteNounOcurrance();
        }

    }

    private void displayAdapter() {
        WordAnalysisListAdapter wordAnalysisListAdapter;
        ArrayList<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        wordAnalysisListAdapter = new WordAnalysisListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(wordAnalysisListAdapter);
        for (int i = 0; i < wordAnalysisListAdapter.getGroupCount(); i++) {
            expandableListView.expandGroup(i);
        }
    }

    private void getSelectedIsm() {
        if (isIsmMarfu) {
            ArrayList<GrammarRules> ismmarfu = utils.getGrammarRulesByRules("nomnouns");
            String ismmarfustr = ismmarfu.get(0).getDetailsrules();
            expandableListDetail.put("IsmMarfu", Collections.singletonList(ismmarfustr));
        } else if (isIsmMansub) {
            ArrayList<GrammarRules> ismmansub = utils.getGrammarRulesByRules("accusativenoun");
            String ismmarfustr = ismmansub.get(0).getDetailsrules();
            expandableListDetail.put("IsmMansub", Collections.singletonList(ismmarfustr));
        } else if (isIsmMajroor) {
            ArrayList<GrammarRules> ismmansub = utils.getGrammarRulesByRules("genetivenoun");
            String ismmarfustr = ismmansub.get(0).getDetailsrules();
            expandableListDetail.put("IsmMajroor", Collections.singletonList(ismmarfustr));
        }

    }

    private void getHans(String verbroot) {
        String probableRoot = verbroot;
        List<String> hanesDefinition = new ArrayList<String>();
        Character C2 = verbroot.charAt(1);
        Character C3 = verbroot.charAt(2);
        char c1 = verbroot.charAt(0);
        if (verbroot.equals("يدي")) {
            verbroot = verbroot.substring(0, 2);
        } else if (verbroot.equals("ايي")) {
            verbroot = "آي";
        } else if (Character.toString(C3).equals(Ya)) {
            verbroot = verbroot.replace(Ya, AlifMaksuraString);
        } else if (Character.toString(C3).equals(LALIF)) {
            verbroot = verbroot.replace(LALIF, Hamza);//change alif to hamza
        } else if (Character.toString(C2).equals(Character.toString(C3))) {
            verbroot = verbroot.substring(0, 2);//contract the double at end
        }
        if (Character.toString(c1).equals(Hamza)) {
            verbroot = verbroot.replace(Hamza, LALIF);
        }
        StringBuilder hanssb = new StringBuilder();
        ArrayList<hanslexicon> hansdictionary = utils.getHansDifinition(verbroot);
        if (hansdictionary.isEmpty()) {
            hansdictionary = utils.getHansDifinition(probableRoot);
        }
        if (!hansdictionary.isEmpty())
            ishans = true;
        hanssb.append(html);
        for (hanslexicon lanes : hansdictionary) {
            //  <p style="margin-left:200px; margin-right:50px;">
            hanssb.append("<p style=\"margin-left:10px; margin-right:10px;\">");
            hanssb.append(lanes.getDefinition()).append("</p>");
            hanssb.append("<hr size=\"1\" width=\"100%\" color=\"red\">  ");
        }
        hanssb.append("</html");
        hanesDefinition.add(hanssb.toString());
        expandableListDetail.put("hans", hanesDefinition);

    }

    @NonNull
    private void getLanes(String verbroot) {
        List<String> lanesDefinition = new ArrayList<String>();
        StringBuilder difinitionbuilder = new StringBuilder();
        Character C2 = verbroot.charAt(1);
        Character C3 = verbroot.charAt(2);
        if (verbroot.equals("يدي")) {
            verbroot = verbroot.substring(0, 2);
        } else if (verbroot.equals("حيي")) {
        } else if (verbroot.equals("ايي")) {
            verbroot = "اى";
        } else if (C3.toString().equals(Ya)) {
            verbroot = verbroot.replace(Ya, AlifMaksuraString);
        } else if (C3.toString().equals(LALIF)) {
            verbroot = verbroot.replace(LALIF, AlifHamzaAbove);
        } else if (C2.toString().equals(C3.toString())) {
            verbroot = verbroot.substring(0, 2);
        }
        ArrayList<lanelexicon> lanesdictionary = utils.getLanesDifinition(verbroot);
        if (!lanesdictionary.isEmpty())
            islanes = true;
        //  <p style="margin-left:200px; margin-right:50px;">
        difinitionbuilder.append(html);
        String replaced;
        for (lanelexicon lanes : lanesdictionary) {
            //  replaced = getLanes(lanes);
            replaced = lanes.getDefinition();
            int indexOf = replaced.indexOf("<orth extent=\"full\" lang=\"ar\">ذ</orth>");
            int indexofForm = replaced.indexOf("<form>");
            int indexofFormclose = replaced.indexOf("</form>");
            int indexofforminfl = replaced.indexOf("<form n=\"infl\">");
            difinitionbuilder.append("<p dir='ltr' style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">");
            if (indexOf != -1) {
                replaced = replaced.replaceAll("<orth extent=\"full\" lang=\"ar\">ذ</orth>", "");
                //     difinitionbuilder.append(replaced);
            }
            if (indexofForm != -1) {
                replaced = replaced.replaceAll("<form>", "");
                //     difinitionbuilder.append(replaced);
            }
            if (indexofFormclose != -1) {
                replaced = replaced.replaceAll("</form>", "");
                //    difinitionbuilder.append(replaced);
            }
            if (indexofforminfl != -1) {
                replaced = replaced.replaceAll("<form n=\"infl\">", "");
                //    difinitionbuilder.append(replaced);
            }
            difinitionbuilder.append(replaced);
            difinitionbuilder.append("</p>");
            difinitionbuilder.append("<hr size=\"1\" width=\"100%\" color=\"red\">  ");

        }
        lanesDefinition.add(difinitionbuilder.toString());
        expandableListDetail.put("lanes", lanesDefinition);
        //  return verbroot;
    }

    void ExecuteNounOcurrance() {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.show();
                    }
                });
                //  occurances = utils.getNounOccuranceBreakVerses(root);
                nounCorpusArrayList = utils.getNounBreakup(root);
                verbCorpusArrayList = utils.getVerbBreakUp(root);
                String Lemma = "";
                int incexofgroup = 0;
                List alist = new ArrayList();
                if (harf) {
                    for (CorpusNounWbwOccurance vers : occurances) {
                        //    alist.add("");
                        StringBuilder sb = new StringBuilder();
                        SpannableString spanDark = new SpannableString(vers.getQurantext());
                        Spannable spannableVerses = CorpusUtilityorig.getSpannableVerses(vers.getAraone() + vers.getAratwo() + vers.getArathree() + vers.getArafour() + vers.getArafive(),
                                vers.getQurantext());
                        sb.append(vers.getSurah()).append(":").append(vers.getAyah()).append(":").append(vers.getWordno()).append("-").append(vers.getEn()).append("-");
                        SpannableString ref = new SpannableString(sb.toString());
                        ref.setSpan(particlespanDark, 0, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        String which = shared.getString("selecttranslation", "en_sahih");
                        SpannableString trans = null;
                        if (which.equals("en_sahih")) {
                            trans = SpannableString.valueOf(vers.getTranslation());
                        } else if (which.equals("ur_jalalayn")) {
                            trans = SpannableString.valueOf(vers.getUr_jalalayn());
                        } else if (which.equals("en_jalalayn")) {
                            trans = SpannableString.valueOf(vers.getEn_jalalayn());
                        }
                        CharSequence charSequence = TextUtils.concat(ref, "\n ", spannableVerses);
                        alist.add(charSequence);
                        alist.add(trans);
                        expandNounVerses.put(sb.toString(), alist);

                    }

                }
                for (NounCorpusBreakup noun : nounCorpusArrayList) {
                    List list = new ArrayList();
                    list.add("");
                    Lemma = noun.getLemma_a();
                    if (noun.getForm().equals("null")) {
                        StringBuilder sb = new StringBuilder();
                        String nounexpand = QuranMorphologyDetails.expandTags(noun.getTag());
                        String times = "";
                        if (noun.getCount() == 1) {
                            times = "Once";
                        } else {
                            int count = noun.getCount();
                            String timess = String.valueOf(count);
                            times = timess.concat("-").concat("times");
                        }
                        sb.append(times).append(" ").append(noun.getLemma_a()).append(" ").append("occurs as the").append(" ").append(nounexpand);
                        expandNounVerses.put(sb.toString(), list);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        String s = QuranMorphologyDetails.expandTags(noun.getPropone() + noun.getProptwo());
                        //  String s1 = QuranMorphologyDetails.expandTags(noun.getProptwo());
                        String s2 = QuranMorphologyDetails.expandTags(noun.getTag());
                        String times = "";
                        if (noun.getCount() == 1) {
                            times = "Once";
                        } else {
                            int count = noun.getCount();
                            String timess = String.valueOf(count);
                            times = timess.concat("-").concat("times");
                        }
                        sb.append(times).append(" ").append(noun.getLemma_a()).append(" ").append("occurs as the").append(" ").append(noun.getForm())
                                .append(" ");
                        if (!s.equals("null")) {
                            sb.append(s).append(" ").append(" ");
                        }
                        sb.append(s2);
                        expandNounVerses.put(sb.toString(), list);

                    }

                }
                for (VerbCorpusBreakup verbCorpusBreakup : verbCorpusArrayList) {
                    List list = new ArrayList();
                    list.add("");
                    Lemma = verbCorpusBreakup.getLemma_a();
                    if (verbCorpusBreakup.getForm().equals("I")) {
                        StringBuilder sb = new StringBuilder();
                        String mujarrad = String.valueOf(QuranMorphologyDetails.getThulathiName(verbCorpusBreakup.getThulathibab()));
                        sb.append(verbCorpusBreakup.getCount()).append("-").append("times").append(" ").append(verbCorpusBreakup.getLemma_a()).append(" ").append("occurs as the").append(" ").append(mujarrad);
                        expandVerbVerses.put(sb.toString(), list);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        String s = QuranMorphologyDetails.expandTags(verbCorpusBreakup.getTense());
                        String s1 = QuranMorphologyDetails.expandTags(verbCorpusBreakup.getVoice());
                        //  String s1 = QuranMorphologyDetails.expandTags(noun.getProptwo());
                        //   String s2 = QuranMorphologyDetails.expandTags(noun.get);
                        String mazeed = String.valueOf(QuranMorphologyDetails.getFormName(verbCorpusBreakup.getForm()));
                        sb.append(verbCorpusBreakup.getCount()).append("-").append("times").append(" ").append(verbCorpusBreakup.getLemma_a()).append(" ").append("occurs as the").append(" ").append(mazeed)
                                .append(" ").append(s).append(" ").append(" ").append(s1);
                        expandVerbVerses.put(sb.toString(), list);

                    }

                }
                expandNounTitles = new ArrayList<String>(expandNounVerses.keySet());
                expandVerbTitles = new ArrayList<String>(expandVerbVerses.keySet());
                expandNounVerses.putAll(expandVerbVerses);
                expandNounTitles.addAll(expandVerbTitles);
                //post
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        // Intent intent = new Intent();
                        // intent.putExtra("result", 1);
                        //  setResult(RESULT_OK, intent);
                        NounVerbOccuranceListAdapter listAdapter;
                        listAdapter = new NounVerbOccuranceListAdapter(WordDictionaryAct.this, expandNounTitles, expandNounVerses, expandVerbVerses, expandVerbTitles);
                        expandableListView.setAdapter(listAdapter);
                        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                            @Override
                            public void onGroupExpand(int groupPosition) {
                                String[] split = expandNounTitles.get(groupPosition).split("\\s");
                                if (!harf) {
                                    if (expandNounTitles.get(groupPosition).contains("Hans")) {
                                        ExecutorService ex = Executors.newSingleThreadExecutor();
                                        ex.execute(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(() -> {
                                                    dialog.show();
                                                });
                                                String verbroot = "";
                                                int indexOfHamza = root.indexOf(Hamza);
                                                int indexofAlifMaksura = root.indexOf(Ya);
                                                if (indexOfHamza != -1) {
                                                    verbroot = root.replaceAll(Hamza, LALIF);
                                                } else {
                                                    verbroot = root;
                                                }
                                                if (indexofAlifMaksura != -1) {
                                                    verbroot = verbroot.replaceAll(Ya, AlifMaksuraString);
                                                }
                                                List list = new ArrayList();
                                                //   ArrayList<CorpusNounWbwOccurance> verses = utils.getNounOccuranceBreakVerses(split[1]);
                                                ArrayList<hanslexicon> lanesDifinition = utils.getHansDifinition(verbroot);
                                                //    ArrayList<SpannableString> lanesdifinition;
                                                //   StringBuilder lanessb = new StringBuilder();
                                                for (hanslexicon hans : lanesDifinition) {
                                                    //  <p style="margin-left:200px; margin-right:50px;">
                                                    //    list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
                                                    //  list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
                                                    list.add(hans.getDefinition());
//
                                                }
                                                list = highLightParadigm(list);
                                                List finalList = list;
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ex.shutdown();
                                                        dialog.dismiss();
                                                        expandNounVerses.put(expandNounTitles.get(groupPosition), finalList);
                                                        listAdapter.notifyDataSetChanged();
                                                    }
                                                });

                                            }

                                            private List highLightParadigm(List list) {
                                                List lists = new ArrayList();
                                                String REGEX = "aor.([\\s\\S]){3}";
                                                Pattern pattern = Pattern.compile(REGEX);
                                                for (Object l : list) {
                                                    String replaceAll = l.toString().replaceAll("<br></br>", "");
                                                    Matcher m = pattern.matcher(replaceAll);
                                                    SpannableString sb = null;
                                                    int indexof = 0;
                                                    if (m.find()) {
                                                        System.out.println("Found value: " + m.group(0));
                                                        System.out.println("Found value: " + m.group(1));
                                                        indexof = l.toString().indexOf(m.group(0));
                                                        sb = new SpannableString(l.toString());
                                                        sb.setSpan(particlespanDark, indexof, m.group(0).length() + indexof, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                        lists.add(sb);
                                                        //   System.out.println("Found value: " + m.group(2) );
                                                    } else {
                                                        lists.add(replaceAll);
                                                    }

                                                }
                                                return lists;
                                            }
                                        });

                                    } else if (expandNounTitles.get(groupPosition).contains("lanes")) {
                                        ExecutorService ex = Executors.newSingleThreadExecutor();
                                        ex.execute(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(() -> {
                                                    dialog.show();
                                                });
                                                List list = new ArrayList();
                                                ArrayList<lanelexicon> lanesDifinition = utils.getLanesDifinition(root);
                                                for (lanelexicon lanes : lanesDifinition) {
                                                    //  <p style="margin-left:200px; margin-right:50px;">
                                                    //    list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
                                                    //  list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
                                                    list.add(lanes.getDefinition());
//
                                                }
                                                list = highLightParadigm(list);
                                                List finalList = list;
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ex.shutdown();
                                                        dialog.dismiss();
                                                        expandNounVerses.put(expandNounTitles.get(groupPosition), finalList);
                                                        listAdapter.notifyDataSetChanged();
                                                    }
                                                });

                                            }

                                            private List highLightParadigm(List list) {
                                                List lists = new ArrayList();
                                                String REGEX = "aor.([\\s\\S]){3}";
                                                Pattern pattern = Pattern.compile(REGEX);
                                                for (Object l : list) {
                                                    String replaceAll = l.toString().replaceAll("<br></br>", "");
                                                    Matcher m = pattern.matcher(replaceAll);
                                                    SpannableString sb = null;
                                                    int indexof = 0;
                                                    if (m.find()) {
                                                        System.out.println("Found value: " + m.group(0));
                                                        System.out.println("Found value: " + m.group(1));
                                                        indexof = l.toString().indexOf(m.group(0));
                                                        sb = new SpannableString(l.toString());
                                                        sb.setSpan(particlespanDark, indexof, m.group(0).length() + indexof, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                        lists.add(sb);
                                                        //   System.out.println("Found value: " + m.group(2) );
                                                    } else {
                                                        lists.add(replaceAll);
                                                    }

                                                }
                                                return lists;
                                            }
                                        });

                                    } else if (expandNounTitles.get(groupPosition).contains("Noun") || expandNounTitles.get(groupPosition).contains("Adverb") || expandNounTitles.get(groupPosition).contains("Adjective")) {
                                        ExecutorService ex = Executors.newSingleThreadExecutor();
                                        AlertDialog.Builder builder = new AlertDialog.Builder(WordDictionaryAct.this);
                                        builder.setCancelable(false); // if you want user to wait for some process to finish,
                                        builder.setView(R.layout.layout_loading_dialog);
                                        AlertDialog dialog = builder.create();
                                        ex.execute(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(() -> {
                                                    dialog.show();
                                                });
                                                List list = new ArrayList();
                                                ArrayList<CorpusNounWbwOccurance> verses = utils.getNounOccuranceBreakVerses(split[1]);
                                                for (CorpusNounWbwOccurance vers : verses) {
                                                    StringBuilder sb = new StringBuilder();
                                                    SpannableString spanDark = new SpannableString(vers.getQurantext());
                                                    Spannable spannableVerses = CorpusUtilityorig.getSpannableVerses(vers.getAraone() + vers.getAratwo() + vers.getArathree() + vers.getArafour() + vers.getArafive(),
                                                            vers.getQurantext());
                                                    sb.append(vers.getSurah()).append(":").append(vers.getAyah()).append(":").append(vers.getWordno()).append("-").append(vers.getEn()).append("-");
                                                    SpannableString ref = new SpannableString(sb.toString());
                                                    ref.setSpan(particlespanDark, 0, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                    String which = shared.getString("selecttranslation", "en_sahih");
                                                    SpannableString trans = null;
                                                    if (which.equals("en_sahih")) {
                                                        trans = SpannableString.valueOf(vers.getTranslation());
                                                    } else if (which.equals("ur_jalalayn")) {
                                                        trans = SpannableString.valueOf(vers.getUr_jalalayn());
                                                    } else if (which.equals("en_jalalayn")) {
                                                        trans = SpannableString.valueOf(vers.getEn_jalalayn());
                                                    }
                                                    CharSequence charSequence = TextUtils.concat(ref, "\n ", spannableVerses);
                                                    list.add(charSequence);
                                                    list.add(trans);

                                                }
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ex.shutdown();
                                                        dialog.dismiss();
                                                        expandNounVerses.put(expandNounTitles.get(groupPosition), list);
                                                        listAdapter.notifyDataSetChanged();
                                                    }
                                                });

                                            }
                                        });

                                    } else {
                                        ExecutorService ex = Executors.newSingleThreadExecutor();
                                        ex.execute(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        dialog.show();

                                                    }
                                                });
                                                List list = new ArrayList();
                                                ArrayList<CorpusVerbWbwOccurance> verses = utils.getVerbOccuranceBreakVerses((split[1]));
                                                for (CorpusVerbWbwOccurance vers : verses) {
                                                    StringBuilder sb = new StringBuilder();
                                                    SpannableString spanDark = new SpannableString(vers.getQurantext());
                                                    Spannable spannableVerses = CorpusUtilityorig.getSpannableVerses(vers.getAraone() + vers.getAratwo() + vers.getArathree() + vers.getArafour() + vers.getArafive(),
                                                            vers.getQurantext());
                                                    //  SpannableString spannableString = CorpusUtilityorig.SetWordSpanNew(vers.getTagone(), vers.getTagtwo(), vers.getTagthree(), vers.getTagfour(), vers.getTagfive(),
                                                    //     vers.getAraone(), vers.getAratwo(), vers.getArathree(), vers.getArafour(), vers.getArafive());
                                                    sb.append(vers.getSurah()).append(":").append(vers.getAyah()).append(":").append(vers.getWordno()).append("-").append(vers.getEn()).append("-");
                                                    //       sb.append(vers.getSurah()).append(":").append(vers.getAyah()).append(":").append(vers.getWordno()).append("-");
                                                    vers.getWordno();
                                                    SpannableString ref = new SpannableString(sb.toString());
                                                    ref.setSpan(maincolortag, 0, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                    String which = shared.getString("selecttranslation", "en_sahih");
                                                    SpannableString trans = null;
                                                    if (which.equals("en_sahih")) {
                                                        trans = SpannableString.valueOf(vers.getTranslation());
                                                    } else if (which.equals("ur_jalalayn")) {
                                                        trans = SpannableString.valueOf(vers.getUr_jalalayn());
                                                    } else if (which.equals("en_jalalayn")) {
                                                        trans = SpannableString.valueOf(vers.getEn_jalalayn());
                                                    }
                                                    CharSequence charSequence = TextUtils.concat(ref, "\n ", spannableVerses);
                                                    list.add(charSequence);
                                                    list.add(trans);

                                                }
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ex.shutdown();
                                                        dialog.dismiss();
                                                        expandNounVerses.put(expandNounTitles.get(groupPosition), list);
                                                        listAdapter.notifyDataSetChanged();
                                                    }
                                                });

                                            }
                                        });

                                    }
                                }

                            }
                        });
                        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                            public boolean onChildClick(ExpandableListView parent, View v,
                                                        int groupPosition, int childPosition, long id) {
                                //   final String selected = String.valueOf((SpannableString) listAdapter.getChild(
                                //      groupPosition, childPosition));
                                CharSequence child = (CharSequence) listAdapter.getChild(groupPosition, childPosition);
                                String[] split = child.toString().split("-");
                                String[] surahaya = split[0].split(":");
                                if (surahaya.length > 1) {
                                    try {
                                        Integer.valueOf(surahaya[2]);
                                    } catch (NumberFormatException e) {
                                        return false;
                                    }
                                    try {
                                        Integer.valueOf(surahaya[1]);
                                    } catch (NumberFormatException e) {
                                        return false;
                                    }
                                    try {
                                        Integer.valueOf(surahaya[0]);
                                    } catch (NumberFormatException e) {
                                        return false;
                                    }
                                    String wordno = surahaya[2];
                                    String ayah = surahaya[1];
                                    String surah = surahaya[0];
                                    Bundle dataBundle = new Bundle();
                                    dataBundle.putInt(SURAH_ID, Integer.parseInt(surah));
                                    dataBundle.putInt(AYAHNUMBER, Integer.parseInt(ayah));
                                    dataBundle.putInt(WORDNUMBER, Integer.parseInt(wordno));
                                    dataBundle.putString(SURAH_ARABIC_NAME, "SurahName");
                                    LoadItemList(dataBundle, surah, ayah, wordno);
                                    return true;
                                } else {
                                    return false;
                                }
                            }

                            private void LoadItemList(Bundle dataBundle, String surah, String ayah, String wordno) {
                                WordAnalysisBottomSheet item = new WordAnalysisBottomSheet();
                                //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                item.setArguments(dataBundle);
                                String[] data = {surah, ayah, "", wordno};
                                FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
                                //     transactions.show(item);
                                WordAnalysisBottomSheet.newInstance(data).show(getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);
                                //   WordAnalysisBottomSheet.newInstance(data).show(WordOccuranceAsynKAct.this).getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);
                            }
                        });
                    }
                });

            }

        });
        //  ExpandableRecAdapter expandableRecAdapter=new ExpandableRecAdapter(WordOccuranceAsynKAct.this,expandNounVerses,expandNounTitles);
        //  recview.setAdapter(expandableRecAdapter);
    }

}












