package com.example.mushafconsolidated.Activity;

import static com.example.Constant.AYAH_ID;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.example.mushafconsolidated.Entities.QuranEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.databinding.ActivityTafsirFullscreenBinding;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TafsirFullscreenActivity extends BaseActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;
    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler(Looper.myLooper());
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar
            if (Build.VERSION.SDK_INT >= 30) {
                mContentView.getWindowInsetsController().hide(
                        WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            } else {
                // Note that some of these constants are new as of API 16 (Jelly Bean)
                // and API 19 (KitKat). It is safe to use them, as they are inlined
                // at compile-time and do nothing on earlier devices.
                mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        }
    };
    private View mControlsView;
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private ActivityTafsirFullscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafsir_fullscreen);
        Bundle bundle = getIntent().getExtras();
        int sura = bundle.getInt(SURAH_ID);
        int ayah = bundle.getInt(AYAH_ID);
        String surahname = bundle.getString(SURAH_ARABIC_NAME);
        Utils utils = new Utils(this);
        MaterialToolbar materialToolbar = findViewById(R.id.toolbarmain);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (materialToolbar != null) {
            setSupportActionBar(materialToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        List<QuranEntity> list = Utils.getsurahayahVerses(sura, ayah);
       // binding = ActivityTafsirFullscreenBinding.inflate(getLayoutInflater());
        ActionBar actionBar = getSupportActionBar();
        //  actionBar.show();
        //  mControlsView = binding.fullscreenContentControls;
        // mContentView = binding.fullscreenContent;
        TextView sourcelable = findViewById(R.id.tvSourceLabel);
        TextView tafsir = findViewById(R.id.tvTafsir);
        TextView translation = findViewById(R.id.tvTranslation);
        TextView tvaryah = findViewById(R.id.tvData);
        Button button = findViewById(R.id.detailsbutton);
        button.setText(sura + ":" + ayah + " " + surahname);
        sourcelable.setText("Arabic Ayah");
        String tafsir_kathir = list.get(0).getTafsir_kathir();
        String tafsir_kathirs = tafsir_kathir.replace("<b>", "");
        String tafsir_kathissr = tafsir_kathirs.replace("</b>", "");
        tafsir.setText(tafsir_kathissr);
        translation.setText(list.get(0).getTranslation());
        tvaryah.setText(list.get(0).getQurantext());
        // Set up the user interaction to manually show or hide the system UI.
        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
    }

}