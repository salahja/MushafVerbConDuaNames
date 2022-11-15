package sj.hisnul.activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListenerOnLong;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import sj.hisnul.fragments.AllDuaFrag;
import sj.hisnul.fragments.CatTwoFrag;
import sj.hisnul.fragments.NewHisnulBookmarkFragment;
//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;

public class HisnulBottomACT extends BaseActivity implements OnItemClickListenerOnLong {
    FloatingActionButton btnBottomSheet;
    TextView tvsurah, tvayah, tvrukus;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    private BottomNavigationView bottomNavigationView;
    private ArrayList<ChaptersAnaEntity> soraList;

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
        SharedPreferences shared = androidx.preference.PreferenceManager.getDefaultSharedPreferences(HisnulBottomACT.this);
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
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
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
        bottomNavigationView = findViewById(R.id.bottomNavView);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
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
                    FragmentManager fragmentManagers = getSupportFragmentManager();
                    FragmentTransaction transactions = fragmentManagers.beginTransaction();
                    transactions.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);
                    AllDuaFrag ALLFAR = AllDuaFrag.newInstance();
                    transactions.replace(R.id.frame_container, ALLFAR);
                    transactions.addToBackStack(null);
                    transactions.commit();
                    break;
                case R.id.bookmark:
                    FragmentManager fragmentManagerss = getSupportFragmentManager();
                    FragmentTransaction transactionss = fragmentManagerss.beginTransaction();
                    transactionss.setCustomAnimations(R.anim.slide_down, R.anim.slide_up);
                    NewHisnulBookmarkFragment b = NewHisnulBookmarkFragment.newInstance();
                    //     BookmarkFragment b = BookmarkFragment.newInstance();
                    transactionss.replace(R.id.frame_container, b);
                    transactionss.addToBackStack(null);
                    transactionss.commit();
                    break;
                case R.id.exitact:
                    finish();
                    break;
                default:
                    break;
            }

        });

    }

    @Override
    public void onItemClick(View v, int position) {
    }

    @Override
    public void onItemLongClick(int position, View v) {
        //    Toast.makeText(this, "longclick", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        Utils utils = new Utils(getApplication());
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

}




