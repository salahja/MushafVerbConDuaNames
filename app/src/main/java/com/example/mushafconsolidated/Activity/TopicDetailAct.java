package com.example.mushafconsolidated.Activity;


import static android.text.TextUtils.concat;
import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.AYAH_ID;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Adapters.FlowAyahWordAdapterPassage;
import com.example.mushafconsolidated.Adapters.TopicFlowAyahWordAdapter;
import com.example.mushafconsolidated.Entities.BadalErabNotesEnt;
import com.example.mushafconsolidated.Entities.BookMarks;
import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.Entities.CorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.HalEnt;
import com.example.mushafconsolidated.Entities.LiajlihiEnt;
import com.example.mushafconsolidated.Entities.MafoolBihi;
import com.example.mushafconsolidated.Entities.MafoolMutlaqEnt;
import com.example.mushafconsolidated.Entities.QuranEntity;
import com.example.mushafconsolidated.Entities.TameezEnt;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.GrammerFragmentsBottomSheet;
import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.example.mushafconsolidated.intrface.OnItemClickListenerOnLong;
import com.example.mushafconsolidated.model.CorpusAyahWord;
import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;

public class TopicDetailAct extends BaseActivity implements  OnItemClickListenerOnLong   {
    private static final String TAG = "fragment";
    private final ArrayList<String> det = new ArrayList<>();
    FloatingActionButton btnBottomSheet;
    String surahArabicName;
    boolean jumptostatus = false;
    int surah_id = 0;
    int verseNumber, suraNumber;
    int rukucount;
    String surahname;
    int mudhafColoragainstBlack, mausofColoragainstBlack, sifatColoragainstBlack, brokenPlurarColoragainstBlack, shartagainstback;
    int surahorpart = 0;

    int currentSelectSurah;

    int versescount = 0;
    boolean chapterorpart;
    // --Commented out by Inspection (14/08/21, 7:26 PM):ChipNavigationBar chipNavigationBar;
    int verse_no = 0;

    private NavigationView navigationView;

    private MaterialToolbar materialToolbar;
    private TopicFlowAyahWordAdapter flowAyahWordAdapter;
    private FlowAyahWordAdapterPassage flowAyahWordAdapterpassage;

    private boolean mausoof, mudhaf, harfnasb, shart;
    private ArrayList<ChaptersAnaEntity> soraList;
    private boolean kana;
    private SharedPreferences shared;

    private ArrayList<CorpusAyahWord> corpusayahWordArrayList;
    private LinkedHashMap<Integer, ArrayList<CorpusWbwWord>> passage = new LinkedHashMap<>();



    private int chapterno;



    public void setSurah_id(int surah_id) {
        this.surah_id = surah_id;
    }

    public int getVersescount() {
        return versescount;
    }

    public void setVersescount(int versescount) {
        this.versescount = versescount;
    }


    public int getChapterno() {
        return chapterno;
    }

    public void setChapterno(int chapterno) {
        this.chapterno = chapterno;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dua_group, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        MenuItem jumpitem = menu.findItem(R.id.jumpto);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_bookmarks) {
            //   Intent intent = new Intent(this, BookmarksGroupActivity.class);
            //  this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shared =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(TopicDetailAct.this);

        String preferences = shared.getString("themePref", "dark");
        switch (preferences) {
            case "white":
                switchTheme("white");
                break;
            case "dark":
                switchTheme("dark");

                break;
            case "blue":
                switchTheme("blue");


                break;
            case "green":
                switchTheme("green");


                break;
            case "brwon":
                switchTheme("brown");


                break;
        }
        super.onCreate(savedInstanceState);



        setContentView(R.layout.topic_search_main);

       Toolbar toolbar = findViewById(R.id.toolbar);
       View mToolbarShadow = findViewById(R.id.view_toolbar_shadow);
       setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        if (preferences.equals("dark") || preferences.equals("blue") || preferences.equals("white")) {
            shartagainstback = prefs.getInt("shartback", Color.GREEN);
            mausofColoragainstBlack = prefs.getInt("mausoofblack", Color.RED);
            mudhafColoragainstBlack = prefs.getInt("mudhafblack", Color.CYAN);
            sifatColoragainstBlack = prefs.getInt("sifatblack", Color.YELLOW);
            brokenPlurarColoragainstBlack = prefs.getInt("brokenblack", Color.GREEN);


        } else {
            shartagainstback = prefs.getInt("shartback", Color.DKGRAY);
            mudhafColoragainstBlack = prefs.getInt("mausoofwhite", 0xFF000000);
            mausofColoragainstBlack = prefs.getInt("mudhafwhite", 0xFF000000);
            sifatColoragainstBlack = prefs.getInt("sifatwhite", 0xFF000000);
            brokenPlurarColoragainstBlack = prefs.getInt("brokenwhite", 0xFF000000);


        }




        Resources.Theme theme = getTheme();
        try {
            int themeResource = getPackageManager().getActivityInfo(getComponentName(), 0).getThemeResource();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);


        mausoof = shared.getBoolean("mausoof", true);
        mudhaf = shared.getBoolean("mudhaf", true);
        harfnasb = shared.getBoolean("harfnasb", true);
        shart = shared.getBoolean("shart", true);
        kana = shared.getBoolean("kana", true);


       Intent bundle = getIntent();
       Bundle bundlesextra = getIntent().getExtras();

        if (!(bundle.getExtras() == null)) {
            Bundle bundles = getIntent().getExtras();

            HashMap<String, String> map = (HashMap<String, String>) bundle.getSerializableExtra("map");

            bundles.getSerializable("map");
          //  LinkedHashMap map = (LinkedHashMap) bundles.get("map");
            Set<String> keys = map.keySet();
            corpusayahWordArrayList = new ArrayList<>();
            for (String key : keys) {
                String splits = map.get(key);
                assert splits != null;
                String[] split=      splits.split(",");
                for (String s : split) {
                    getwbwy(s,key);

                }


            }





            //  getwbwy(aref);
            String lastread = bundles.getString(QURAN_VERB_ROOT);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            OnItemClickListenerOnLong listener=this;
            TopicFlowAyahWordAdapter flowAyahWordAdapter = new TopicFlowAyahWordAdapter(corpusayahWordArrayList,listener);
            RecyclerView parentRecyclerView = findViewById(R.id.recycler_view);
            parentRecyclerView.setLayoutManager(linearLayoutManager);
            flowAyahWordAdapter.addContext(TopicDetailAct.this);


            parentRecyclerView.setHasFixedSize(true);

            parentRecyclerView.setAdapter(flowAyahWordAdapter);
            flowAyahWordAdapter.notifyDataSetChanged();





        }


    }



    private void getwbwy(String str, String header) {
        String[] ss = str.split(":");
        int suraid = Integer.parseInt(ss[0].trim());
        int ayah = Integer.parseInt(ss[1].trim());
        Utils utils = new Utils(this);


        //  CorpusWbwWord word = new CorpusWbwWord();
        CorpusAyahWord ayahWord = new CorpusAyahWord();
        int verseglobal = ayah;

        ArrayList<CorpusWbwWord> wordArrayList = new ArrayList<>();
        ArrayList<CorpusExpandWbwPOJO> wbw = utils.getCorpusWbwBySurahAyahtopic(suraid, ayah);
        int verseno = 0;


        //    final Object o6 = wbwa.get(verseglobal).get(0);
        StringBuilder sb = new StringBuilder();
        for (CorpusExpandWbwPOJO pojo : wbw) {
            CorpusWbwWord word = new CorpusWbwWord();
            word.setSurahId(pojo.getSurah());


            sb.append(pojo.getAraone()).append(pojo.getAratwo());
            CharSequence sequence = concat(pojo.getAraone() + pojo.getAratwo() +
                    pojo.getArathree() + pojo.getArafour());
            //   Object o4 = pojo.getWord();
            Object en = pojo.getEn();
            Object bn = pojo.getBn();
            Object ind = pojo.getIn();
            String ur = pojo.getUr();

            word.setRootword(pojo.getRoot_a());
            word.setSurahId(pojo.getSurah());
            word.setVerseId(pojo.getAyah());
            word.setWordno(pojo.getWordno());
            word.setWordcount(pojo.getWordcount());



            word.setWordsAr(sequence.toString());
            //  word.setWordindex(getIndex(pojo.getQuranverses()));
            word.setTranslateEn(en.toString());
            word.setTranslateBn(bn.toString());
            word.setTranslateIndo(ind.toString());
            word.setTranslationUrdu(ur);

            word.setAraone(pojo.getAraone());
            word.setAratwo(pojo.getAratwo());
            word.setArathree(pojo.getArathree());
            word.setArafour(pojo.getArafour());
            word.setArafive(pojo.getArafive());

            word.setTagone(pojo.getTagone());
            word.setTagtwo(pojo.getTagtwo());
            word.setTagthree(pojo.getTagthree());
            word.setTagfour(pojo.getTagfour());
            word.setTagfive(pojo.getTagfive());
            word.setPassage_no(pojo.getPassage_no());
            word.setDetailsone(pojo.getDetailsone());
            word.setDetailstwo(pojo.getDetailstwo());
            word.setDetailsthree(pojo.getDetailsthree());
            word.setDetailsfour(pojo.getDetailsfour());
            word.setDetailsfive(pojo.getDetailsfive());

            word.setCorpusSpnnableQuranverse(SpannableStringBuilder.valueOf(pojo.getQurantext()));
            //    word.setQuranversestr(pojo.getQuranverses());
            word.setQuranversestr(pojo.getQurantext());
            word.setTranslations(pojo.getTranslation());
            word.setSurahId((pojo.getSurah()));
            word.setVerseId((pojo.getAyah()));
            word.setWordno(pojo.getWordno());
            word.setWordcount((pojo.getWordcount()));


            verseno = pojo.getAyah();

            ayahWord.setAr_irab_two((pojo.getAr_irab_two()));
            ayahWord.setTafsir_kathir((pojo.getTafsir_kathir()));
            //  ayahWord.setSpannableverse(SpannableStringBuilder.valueOf(pojo.getQuranverses()));
            ayahWord.setSpannableverse(SpannableString.valueOf(pojo.getQurantext()));
            ayahWord.setPassage_no(pojo.getPassage_no());

            ayahWord.setEn_transliteration((pojo.getEn_transliteration()));
            ayahWord.setEn_jalalayn((pojo.getEn_jalalayn()));
            //  ayahWord.setSpannableverse(SpannableStringBuilder.valueOf(pojo.getQuranverses()));

            ayahWord.setEn_arberry(pojo.getEn_arberry());
            ayahWord.setUr_jalalayn((pojo.getUr_jalalayn()));
            //  ayahWord.setSpannableverse(SpannableStringBuilder.valueOf(pojo.getQuranverses()));

            ayahWord.setUr_junagarhi(pojo.getUr_junagarhi());
           ayahWord.setTopictitle(header);

            wordArrayList.add(word);
            ayahWord.setWord(wordArrayList);
            // wordArrayListpassage.add(word);
        }
        corpusayahWordArrayList.add(ayahWord);
        System.out.println("check");
    }













    private void LoadItemList(Bundle dataBundle, CorpusAyahWord word) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);


        GrammerFragmentsBottomSheet item = new GrammerFragmentsBottomSheet();

        FragmentManager fragmentManager = getSupportFragmentManager();

        item.setArguments(dataBundle);
        String[] data = {String.valueOf(word.getWord().get(0).getSurahId()), String.valueOf(word.getWord().get(0).getVerseId()), word.getQuranTranslate(), String.valueOf((1))};
        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
        transactions.show(item);

        GrammerFragmentsBottomSheet.newInstance(data).show(getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);

    }


    @Override
    public void onItemClick(View view, int position) {
        //   popupMenu(view);
        //   popupWindow(view);
        qurangrammarmenu(view, position);


    }

    void qurangrammarmenu(View view, int position) {
        Object tag = view.getTag();
        QuranEntity quranEntity;
        View bookmarkview = null;
        View overflow = view.findViewById(R.id.ivActionOverflow);









         if (tag.equals("bookmark")) {
            bookMarkSelected(position, bookmarkview);


            //  SurahAyahPicker();

        } else if (tag.equals("overflow_img")) {



            AlertDialog.Builder builder = new AlertDialog.Builder(TopicDetailAct.this);
            LayoutInflater factory = LayoutInflater.from(TopicDetailAct.this);
            view = factory.inflate(R.layout.topic_popup_layout, null);
            View tafsirtag = view.findViewById(R.id.tafsir);

              bookmarkview = view.findViewById(R.id.bookmark);


            builder.setView(view);

            int[] location = new int[2];
           overflow.getLocationOnScreen(location);

            AlertDialog dialog = builder.create();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
            wmlp.gravity = Gravity.TOP | Gravity.LEFT;
            wmlp.x = location[0];   //x position
            wmlp.y = location[1];  //y position

            dialog.getWindow().getAttributes().windowAnimations = R.style.WindowAnimationTransition; //style id

            dialog.show();

            tafsirtag.setOnClickListener(view12 -> {
                Intent readingintent = new Intent(TopicDetailAct.this, TafsirFullscreenActivity.class);

             //  flowAyahWordAdapter.getItem(position);
                int chapter_no = corpusayahWordArrayList.get(position).getWord().get(0).getSurahId();
                int verse = corpusayahWordArrayList.get(position).getWord().get(0).getVerseId();
                final String[] surahArrays = getResources().getStringArray(R.array.suraharabic);
                String surahname = surahArrays[chapter_no-1];



                readingintent.putExtra(SURAH_ID, chapter_no);
                readingintent.putExtra(AYAH_ID, verse);
                readingintent.putExtra(SURAH_ARABIC_NAME, surahname);


                startActivity(readingintent);
                dialog.dismiss();


            });


             View finalBookmarkview = bookmarkview;
             bookmarkview.setOnClickListener(view1 -> {
                bookMarkSelected(position, finalBookmarkview);
                dialog.dismiss();
            });



            System.out.println("check");
        }


        else if (tag.equals("qurantext")) {
            CorpusAyahWord word;
            if (position != 0) {
                word = corpusayahWordArrayList.get(position - 1);
            } else {
                word = corpusayahWordArrayList.get(position);

            }

            Bundle dataBundle = new Bundle();
            dataBundle.putInt(SURAH_ID, word.getWord().get(0).getSurahId());
            dataBundle.putInt(AYAHNUMBER, Math.toIntExact(word.getWord().get(0).getVerseId()));

            LoadItemList(dataBundle, word);
        }
    }




    private void bookMarkSelected(int position, View bookmarkview) {


        int chapter_no = corpusayahWordArrayList.get(position).getWord().get(0).getSurahId();
        int verse = corpusayahWordArrayList.get(position).getWord().get(0).getVerseId();
        final String[] surahArrays = getResources().getStringArray(R.array.suraharabic);
        String surahname = surahArrays[chapter_no-1];

        BookMarks en = new BookMarks();


        en.setChapterno(String.valueOf(chapter_no));
        en.setVerseno(String.valueOf(verse));
        en.setSurahname(surahname);
        //     Utils utils = new Utils(ReadingSurahPartActivity.this);
        Utils utils = new Utils(this);
        utils.insertBookMark(en);
        View view = findViewById(R.id.bookmark);
        Snackbar snackbar = Snackbar
                .make(bookmarkview, "BookMark Created", Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.BLUE);
        snackbar.setTextColor(Color.CYAN);
        snackbar.setBackgroundTint(Color.BLACK);
        snackbar.show();
    }







    @Override
    public void onItemLongClick(int position, View v) {
        //    Toast.makeText(this, "longclick", Toast.LENGTH_SHORT).show();

    }








}



