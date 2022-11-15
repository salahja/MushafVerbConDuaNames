package org.sj.conjugator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.sj.conjugator.activity.BaseActivity;
import org.sj.conjugator.activity.ConjugatorAct;
import org.sj.conjugator.fragments.SettingsFragmentVerb;
import org.sj.conjugator.utilities.SharedPref;

public class MainActivity extends BaseActivity {
    public static final String TAG = "bottom";
    private static final int PERMISSION_REQUEST_CODE = 100;
    static String lang;
    int mazeedform;
    Button mujarradListingbtn, mazeedlistingbtn, conjugatorbtn,
            settingbtn, qurangrammarbtn;
    FloatingActionButton btnBottomSheet;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    SharedPreferences sharedPreferences;

    public int getMazeedform() {
        return mazeedform;
    }

    public void setMazeedform(int mazeedform) {
        this.mazeedform = mazeedform;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences shared =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);
        String preferences = shared.getString("theme", "dark");
        if (preferences.equals("light")) {
            switchTheme("light");
        } else if (preferences.equals("dark")) {
            switchTheme("dark");

        } else if (preferences.equals("blue")) {
            switchTheme("blue");

        } else if (preferences.equals("brown")) {
            switchTheme("brown");

        }
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_verb_conjugation);
        //  setContentView(R.layout.main_activity);
        if (isFirstTime()) {
            SettingsFragmentVerb fragment = new SettingsFragmentVerb();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.add(R.id.frame_container, fragment);
            transaction.commit();

        }
        initView();
        SetupBOttomMenu();
        //  DatabaseUtils utils = new DatabaseUtils(this);
        //  ArrayList<Mazeed> mazeedAll = utils.getMazeedAll();
        //   createFile();
/*
        MujarradVerbList fragments = new MujarradVerbList(MainActivity.this);
        FragmentTransaction transactions = getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transactions.add(R.id.frame_container, fragments).addToBackStack("mujarrad");
        transactions.commit();
*/
        Intent conjugatorintent = new Intent(MainActivity.this, ConjugatorAct.class);
        // finish();
        startActivity(conjugatorintent);

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(QuranGrammarApplication.getContext(), "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    private void SetupBOttomMenu() {
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragmentVerb fragments = new SettingsFragmentVerb();
                FragmentTransaction transactions = getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transactions.replace(R.id.frame_container, fragments).addToBackStack("mujarrad");
                transactions.commit();

            }
        });
        conjugatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conjugatorintent = new Intent(MainActivity.this, ConjugatorAct.class);
                // finish();
                startActivity(conjugatorintent);
            }
        });

    }

    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.apply();
        }
        return !ranBefore;
    }

    private void initView() {
        btnBottomSheet = findViewById(R.id.fab);
        mazeedlistingbtn = findViewById(R.id.mazeedlist);
        mujarradListingbtn = findViewById(R.id.conjugationnav);
        settingbtn = findViewById(R.id.conjugatorsetting);
        conjugatorbtn = findViewById(R.id.conjugator);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        //   navigationView = findViewById(R.id.navigationView);
        MaterialToolbar materialToolbar = findViewById(R.id.toolbar);
        //  BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        //    recyclerView = findViewById(R.id.sarfrecview);
        //   materialToolbar = findViewById(R.id.toolbar);
        if (materialToolbar != null) {
            setSupportActionBar(materialToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //  materialToolbar.setNavigationIcon(R.mipmap.ic_ac_foreground);
        //  CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        //   setSupportActionBar(materialToolbar);
        //   getSupportActionBar().setTitle("");
        SharedPref pref = new SharedPref(this);
        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
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
        });
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //       btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //      btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

    }

}