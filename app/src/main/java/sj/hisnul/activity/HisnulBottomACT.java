package sj.hisnul.activity;


import static com.example.Constant.MAKKI_MADANI;
import static com.example.Constant.RUKUCOUNT;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.VERSESCOUNT;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.Adapters.FlowAyahWordAdapter;
import com.example.mushafconsolidated.Adapters.FlowAyahWordAdapterPassage;
import com.example.mushafconsolidated.Entities.BadalErabNotesEnt;
import com.example.mushafconsolidated.Entities.BookMarks;
import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
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
import com.example.mushafconsolidated.intrface.PassdataInterface;
import com.example.mushafconsolidated.model.CorpusAyahWord;
import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import sj.hisnul.fragments.AllDuaFrag;
import sj.hisnul.fragments.CatTwoFrag;
import sj.hisnul.fragments.NewHisnulBookmarkFragment;

//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;

public class HisnulBottomACT extends BaseActivity implements PassdataInterface, OnItemClickListenerOnLong {
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
    TextView tvsurah, tvayah, tvrukus;
    int currentSelectSurah;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    View suralistlayout;
    int versescount = 0;
    boolean chapterorpart;
    // --Commented out by Inspection (14/08/21, 7:26 PM):ChipNavigationBar chipNavigationBar;
    int verse_no = 0;
    //  CoordinatorLayout coordinatorLayout;


    private BottomNavigationView bottomNavigationView;

    // ChipNavigationBar chipNavigationBar;
    private MaterialToolbar materialToolbar;
    private FlowAyahWordAdapter flowAyahWordAdapter;
    private FlowAyahWordAdapterPassage flowAyahWordAdapterpassage;
    // private UpdateMafoolFlowAyahWordAdapter flowAyahWordAdapter;
    private boolean mausoof, mudhaf, harfnasb, shart;
    private ArrayList<ChaptersAnaEntity> soraList;
    private EditText ayahIndex;
    private boolean kana;
    private List<QuranEntity> allofQuran;
    private SharedPreferences shared;
    //  private OnClickListener onClickListener;
    private ArrayList<CorpusAyahWord> corpusayahWordArrayList;
    private LinkedHashMap<Integer, ArrayList<CorpusWbwWord>> passage = new LinkedHashMap<>();
    private ArrayList<MafoolBihi> mafoolbihiwords;
    private ArrayList<HalEnt> Jumlahaliya;
    private ArrayList<TameezEnt> Tammezent;
    private ArrayList<MafoolMutlaqEnt> Mutlaqent;
    private ArrayList<LiajlihiEnt> Liajlihient;
    private ArrayList<BadalErabNotesEnt> BadalErabNotesEnt;
    private Utils utils;
    private int isMakkiMadani;
    private int chapterno;
    private RecyclerView parentRecyclerView;
    private RecyclerView surahRecView;

    public int getRukucount() {
        return rukucount;
    }

    public void setRukucount(int rukucount) {
        this.rukucount = rukucount;
    }

    public void setSurahorpart(int surahorpart) {
        this.surahorpart = surahorpart;
    }

    public int getCurrentSelectSurah() {
        return currentSelectSurah;
    }

    public void setCurrentSelectSurah(int currentSelectSurah) {
        this.currentSelectSurah = currentSelectSurah;
    }

    public String getSurahArabicName() {
        return surahArabicName;
    }

    public void setSurahArabicName(String surahArabicName) {
        this.surahArabicName = surahArabicName;
    }

    public void setSurah_id(int surah_id) {
        this.surah_id = surah_id;
    }

    public int getVersescount() {
        return versescount;
    }

    public void setVersescount(int versescount) {
        this.versescount = versescount;
    }

    public void setVerse_no(int verse_no) {
        this.verse_no = verse_no;
    }

    public void setIsMakkiMadani(int isMakkiMadani) {
        this.isMakkiMadani = isMakkiMadani;
    }

    public void setChapterorpart(boolean chapterorpart) {
        this.chapterorpart = chapterorpart;
    }

    public int getChapterno() {
        return chapterno;
    }

    public void setChapterno(int chapterno) {
        this.chapterno = chapterno;
    }


    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
        if (!(fragment instanceof com.example.mushafconsolidated.fragments.IOnBackPressed) || !((com.example.mushafconsolidated.fragments.IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }

        //  finish();


    }






    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shared =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(HisnulBottomACT.this);

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

        setContentView(R.layout.hisnulbottom);

      //  materialToolbar = findViewById(R.id.toolbarmain);


    //  setSupportActionBar(materialToolbar);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().hide();


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



        Intent bundle = getIntent();

            initView();
            initnavigation();



            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);

        CatTwoFrag newCustomFragment = CatTwoFrag.newInstance();
          transaction.replace(R.id.frame_container, newCustomFragment);
          transaction.addToBackStack(null);
           transaction.commit();


        }




    private void initnavigation() {
        btnBottomSheet = findViewById(R.id.fab);

    //    navigationView = findViewById(R.id.navigationView);

        bottomNavigationView = findViewById(R.id.bottomNavView);
     //   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,  materialToolbar, (R.string.drawer_open), (R.string.drawer_close));


    //    drawerLayout.addDrawerListener(toggle);
      //  toggle.syncState();
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        final int color = ContextCompat.getColor(this, R.color.color_background_overlay);
        final int colorsurface = ContextCompat.getColor(this, R.color.color_surface);
        final int coloronbackground = ContextCompat.getColor(this, R.color.neutral0);
  /*
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            bottomNavigationView.setBackgroundColor(coloronbackground);
            bottomNavigationView.setBackgroundColor(color);
        } else {
            bottomNavigationView.setBackgroundColor(colorsurface);
        }
   */
       /*
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            materialToolbar.setBackgroundColor(coloronbackground);
            materialToolbar.setBackgroundColor(color);
        } else {
            materialToolbar.setBackgroundColor(colorsurface);
        }
        */
        btnBottomSheet.setOnClickListener(v -> {
            toggleBottomSheets();
            //  toggleHideSeek();
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(item ->

        {


            Fragment fragment;
            switch (item.getItemId()) {



                case R.id.category:

                //    materialToolbar.setTitle("Surah");

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);

                 CatTwoFrag newCustomFragment = CatTwoFrag.newInstance();
                   transaction.replace(R.id.frame_container, newCustomFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    break;


                case R.id.alldua:
                    //   drawerLayout.closeDrawers();
                 //   materialToolbar.setTitle("Dua List");

                    FragmentManager fragmentManagers = getSupportFragmentManager();

                    FragmentTransaction transactions= fragmentManagers.beginTransaction();
                    transactions.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);

                  AllDuaFrag ALLFAR = AllDuaFrag.newInstance();
                  transactions.replace(R.id.frame_container, ALLFAR);
                    transactions.addToBackStack(null);
                    transactions.commit();
                    break;


                case R.id.bookmark:
                 //   materialToolbar.setTitle("Hisnul Muslim-Dua;s");
                  //  materialToolbar.setTitle("Topics");
                  //  Intent searchs = new Intent(this, BookmarkAct.class);
                  //  startActivity(searchs);
                    FragmentManager fragmentManagerss = getSupportFragmentManager();

                    FragmentTransaction transactionss= fragmentManagerss.beginTransaction();
                    transactionss.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);
                    NewHisnulBookmarkFragment b = NewHisnulBookmarkFragment.newInstance();
               //     BookmarkFragment b = BookmarkFragment.newInstance();
                    transactionss.replace(R.id.frame_container, b);
                    transactionss.addToBackStack(null);
                    transactionss.commit();

                    break;


                case R.id.exitact:
                    //   materialToolbar.setTitle("Hisnul Muslim-Dua;s");
                    //  materialToolbar.setTitle("Topics");
                    //  Intent searchs = new Intent(this, BookmarkAct.class);
                    //  startActivity(searchs);
                     finish();

                    break;




                default:
                    break;
            }


        });



    }





    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void setUpOnCLicks() {


    }


    private void LoadItemList(Bundle dataBundle, QuranEntity word) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);


        GrammerFragmentsBottomSheet item = new GrammerFragmentsBottomSheet();

        FragmentManager fragmentManager = getSupportFragmentManager();

        item.setArguments(dataBundle);
        String[] data = {String.valueOf(word.getSurah()), String.valueOf(word.getAyah()), word.getTranslation(), String.valueOf((1))};
        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
        transactions.show(item);

        GrammerFragmentsBottomSheet.newInstance(data).show(getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);

    }


    @Override
    public void onItemClick(View view, int position) {
        //   popupMenu(view);
        //   popupWindow(view);



    }




    private void RefreshActivity() {
        Log.e(TAG, "onClick called");
        final Intent intent = getIntent().putExtra("chapter", chapterno).putExtra("chapterorpart", chapterorpart).putExtra(SURAH_ARABIC_NAME, surahArabicName)
                .putExtra(VERSESCOUNT, getVersescount()).putExtra(RUKUCOUNT, rukucount).putExtra(MAKKI_MADANI, isMakkiMadani);
        overridePendingTransition(0, 0);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
    }

    private void bookMarkSelected(int position) {

      //  position = flowAyahWordAdapter.getAdapterposition();
        int chapter_no = corpusayahWordArrayList.get(position).getWord().get(0).getSurahId();
        int verse = corpusayahWordArrayList.get(position).getWord().get(0).getVerseId();


        BookMarks en = new BookMarks();


        en.setChapterno(String.valueOf(chapter_no));
        en.setVerseno(String.valueOf(verse));
        en.setSurahname(getSurahArabicName());
        //     Utils utils = new Utils(ReadingSurahPartActivity.this);
        utils.insertBookMark(en);
        View view = findViewById(R.id.bookmark);
        Snackbar snackbar = Snackbar
                .make(view, "BookMark Created", Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.BLUE);
        snackbar.setTextColor(Color.CYAN);
        snackbar.setBackgroundTint(Color.BLACK);
        snackbar.show();
    }





    private void RefreshActivity(SwitchCompat colorsentence) {
        Log.e(TAG, "onClick called");
        final Intent intent = getIntent().putExtra("chapter", chapterno).putExtra("chapterorpart", chapterorpart).putExtra(SURAH_ARABIC_NAME, surahArabicName)
                .putExtra(VERSESCOUNT, getVersescount()).putExtra(RUKUCOUNT, rukucount).putExtra(MAKKI_MADANI, isMakkiMadani);
        overridePendingTransition(0, 0);

        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        //  colorsentence.setOnCheckedChangeListener (null);
        //  colorsentence.setChecked(true);
    }

    @Override
    public void onItemLongClick(int position, View v) {
        //    Toast.makeText(this, "longclick", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        utils = new Utils(getApplication());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());


        btnBottomSheet = findViewById(R.id.fab);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        //    btnBottomSheet=findViewById(R.id.btn_bottom_sheet);


        tvsurah = findViewById(R.id.tvRukus);
        tvayah = findViewById(R.id.tvVerses);
        tvrukus = findViewById(R.id.tvSura);


      //  coordinatorLayout = findViewById(R.id.coordinatorLayout);


        RecyclerView verlayViewRecyclerView = findViewById(R.id.overlayViewRecyclerView);

        verlayViewRecyclerView.setLayoutManager(linearLayoutManager);


        // bookmarkchip.setOnClickListener(v -> CheckStringLENGTHS());


    }

    public void toggleBottomSheets() {
        if (bottomNavigationView.getVisibility() == View.VISIBLE) {
            bottomNavigationView.setVisibility(View.GONE);
            //    btnBottomSheet.setText("Close sheet");
        } else {
            bottomNavigationView.setVisibility(View.VISIBLE);
            //    btnBottomSheet.setText("Expand sheet");
        }
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            //    btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //    btnBottomSheet.setText("Expand sheet");
        }
    }

    @Override
    public void ondatarecevied(int chapterno, String partname, int totalverses, int rukucount, int makkimadani) {


        Log.e(TAG, "onClick called");
        final Intent intent = getIntent().putExtra("chapter", chapterno).putExtra("chapterorpart", chapterorpart).putExtra(SURAH_ARABIC_NAME, partname)
                .putExtra(VERSESCOUNT, totalverses).putExtra(RUKUCOUNT, rukucount).putExtra(MAKKI_MADANI, makkimadani);


        overridePendingTransition(0, 0);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

    }


}




