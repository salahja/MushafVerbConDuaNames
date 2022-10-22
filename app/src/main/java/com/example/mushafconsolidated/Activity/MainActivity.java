package com.example.mushafconsolidated.Activity;


import static com.example.mushafconsolidated.settings.Constants.DATABASENAME;
import static com.example.mushafconsolidated.settings.Constants.DATABASEZIP;
import static com.example.mushafconsolidated.settings.Constants.FILEPATH;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.fragments.BookmarkFragment;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.sj.conjugator.activity.ConjugatorAct;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import database.DuaGroupActivity;
import database.GridImageAct;


public class MainActivity extends BaseActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MaterialToolbar materialToolbar;

    private static final int REQUEST_WRITE_STORAGE = 112;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private File newquran;
    private BottomNavigationView bottomNavigationView;


    public enum WindowSizeClass {COMPACT, MEDIUM, EXPANDED}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switchTheme("brown");
        super.onCreate(savedInstanceState);
        boolean hasPermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
     */
        computeWindowSizeClasses();

        //  setContentView(R.layout.fragment_reading);

        setContentView(R.layout.drawer_activity);
        materialToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);


        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int SPL = 1;
        if (sp.getInt("spl", 0) != SPL) {
            PreferenceManager.setDefaultValues(this, R.xml.preferences, true);
            //  PreferenceManager.setDefaultValues(this, R.xml.prefs2, true);
            sp.edit().putInt("spl", SPL).apply();
        }


        newquran = new File(FILEPATH + "/" + DATABASENAME);


        if (!hasPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE);
        } else {

            try {
                validateFilesAndDownload();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //  PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        boolean hasPermissions = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);


    }

    private void computeWindowSizeClasses() {
        WindowMetrics metrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
        float widthDp = metrics.getBounds().width() / getResources().getDisplayMetrics().density;
        // WindowSizeClass widthWindowSizeClass;

        //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();

        if (widthDp < 600f) {
            //widthWindowSizeClass = WindowSizeClass.COMPACT;

            //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();
            editor.putString("width", "compactWidth");
            editor.apply();


        } else if (widthDp < 840f) {
            //widthWindowSizeClass = WindowSizeClass.MEDIUM;

            //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();
            editor.putString("width", "mediumWidth");

            editor.apply();
        } else {
            // widthWindowSizeClass = WindowSizeClass.EXPANDED;

            editor.putString("width", "expandedWidth");

            editor.apply();

        }

        float heightDp = metrics.getBounds().height() / getResources().getDisplayMetrics().density;
        WindowSizeClass heightWindowSizeClass;

        if (heightDp < 480f) {
            heightWindowSizeClass = WindowSizeClass.COMPACT;


        } else if (heightDp < 900f) {
            heightWindowSizeClass = WindowSizeClass.MEDIUM;
        } else {
            heightWindowSizeClass = WindowSizeClass.EXPANDED;
        }

        // Use widthWindowSizeClass and heightWindowSizeClass
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //check if permission had taken or not
        if (requestCode == REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //valid to download or not
                try {
                    validateFilesAndDownload();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, getString(R.string.permission), Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
            }
        }
    }

    private void validateFilesAndDownload() throws IOException {
        boolean isexternalstorageMounted = getDefaultSaveRootPath();


        if (!newquran.exists()) {
            // first install copy newquran.db.zip and unzip
            //   new CopyDatabase().execute();
            CopyDatbases();


        } else {
            Intent homeactivity = new Intent(MainActivity.this, QuranGrammarAct.class);
            //   Intent homeactivity = new Intent(MainActivity.this, ReadingSurahPartActivity.class);
            startActivity(homeactivity);
            MainActivity.this.finish();
         //   initnavigation();


        }


    }

    private void initnavigation() {
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        materialToolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, materialToolbar, (R.string.drawer_open), (R.string.drawer_close));


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        final int color = ContextCompat.getColor(this, R.color.color_background_overlay);
        final int colorsurface = ContextCompat.getColor(this, R.color.color_surface);
        final int coloronbackground = ContextCompat.getColor(this, R.color.neutral0);
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            bottomNavigationView.setBackgroundColor(coloronbackground);
            bottomNavigationView.setBackgroundColor(color);
        } else {
            bottomNavigationView.setBackgroundColor(colorsurface);
        }
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            materialToolbar.setBackgroundColor(coloronbackground);
            materialToolbar.setBackgroundColor(color);
        } else {
            materialToolbar.setBackgroundColor(colorsurface);
        }


        bottomNavigationView.setOnNavigationItemReselectedListener(item ->

        {


            Fragment fragment;
            switch (item.getItemId()) {

                case R.id.surahnav:


                    Intent searchintents = new Intent(this, QuranGrammarAct.class);

                    startActivity(searchintents);
                    navigationView.setCheckedItem(R.id.surahnav);
                    break;


                case R.id.conjugationnav:
                    //   drawerLayout.closeDrawers();
                    materialToolbar.setTitle("Setting");
                    //  Intent conjugatorintent = new Intent(newreadactivity.this, VerbConjugationAct.class);
                    Intent conjugatorintent = new Intent(this, ConjugatorAct.class);
                    //   Intent conjugatorintent = new Intent(newreadactivity.this, VerbConjugationAct.class);


                    //    finish();
                    startActivity(conjugatorintent);
                    break;
                default:
                    break;
            }


        });


        navigationView.setNavigationItemSelectedListener(item ->

        {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.dua:
                    drawerLayout.closeDrawers();
                    Intent searchintent = new Intent(this, DuaGroupActivity.class);



                    startActivity(searchintent);
                    navigationView.setCheckedItem(R.id.duanav);
                    break;


                case R.id.Names:
                    drawerLayout.closeDrawers();
                    Intent searchintents = new Intent(this, GridImageAct.class);

                    startActivity(searchintents);
                    navigationView.setCheckedItem(R.id.Names);
                    break;



                case R.id.bookmark:
                    drawerLayout.closeDrawers();


                    //  Intent intents = new Intent(MainActivity.this, MufradatPagerActivity.class);
                    //  startActivity(intents);

                    break;
                case R.id.setting:

                    drawerLayout.closeDrawers();

                    Intent intents = new Intent(this, ActivitySettings.class);
                    startActivity(intents);
                    break;
                default:
                    break;
            }
            return false;
        });
    }

    private void CopyDatbases() {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);
        AlertDialog dialog = builder.create();
        ex.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(dialog::show);
                boolean canWrie = canWriteInSDCard();
                if (canWrie) {
                    try {

                        File databaseDirectory = new File(FILEPATH);


                        if (!databaseDirectory.exists()) {
                            boolean cr = databaseDirectory.mkdirs();
                            System.out.println(cr);
                        }

                        File databaseFile = new File(databaseDirectory, DATABASEZIP);

                        databaseFile.getParentFile();

                        if (!databaseFile.exists()) {
                            databaseFile.createNewFile();
                        }
                        //    InputStream inputStream = getApplicationContext().getAssets().open("newquran.db");
                        InputStream inputStream = getApplicationContext().getAssets().open(DATABASEZIP);
                        FileOutputStream outputStream = new FileOutputStream(databaseFile);
                        int fileSize = inputStream.available();
                        //   publishProgress(0, fileSize);
                        int copylength = 0;
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int read = inputStream.read(buffer);
                            if (read == -1) break;
                            copylength += read;
                            //   publishProgress(copylength, fileSize);
                            outputStream.write(buffer, 0, read);
                        }
                        outputStream.flush();
                        outputStream.close();
                        inputStream.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();

                    }
                }

                runOnUiThread(() -> {


                    File zipfile = new File(getExternalFilesDir(null).getAbsolutePath() + getString(R.string.app_folder_path) + File.separator + DATABASEZIP);

                    File targetDirectory = new File(FILEPATH);
                    File mainDatabasesZIP = new File(String.valueOf(zipfile));


                    ZipInputStream zis = null;
                    int progress = 1;
                    try {
                        zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(mainDatabasesZIP)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        AlertDialog.Builder dialog1 = new AlertDialog.Builder(MainActivity.this);
                        dialog1.setMessage(e.getCause().toString());
                        AlertDialog alertDialog = dialog1.create();
                        alertDialog.show();

                    }
                    try {
                        ZipEntry ze;
                        int count;
                        byte[] buffer = new byte[8192];
                        while ((ze = zis.getNextEntry()) != null) {
                            File file = new File(targetDirectory, ze.getName());
                            File dir = ze.isDirectory() ? file : file.getParentFile();
                            if (!dir.isDirectory() && !dir.mkdirs())
                                throw new FileNotFoundException("Failed to ensure directory: " + dir.getAbsolutePath());
                            if (ze.isDirectory()) continue;
                            try (FileOutputStream fout = new FileOutputStream(file)) {
                                progress += 1;

                                while ((count = zis.read(buffer)) != -1) {
                                    fout.write(buffer, 0, count);
                                    progress += 1;
                                    //   progressBarDD.setProgress(progress);
                                }
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            zis.close();
                            mainDatabasesZIP.delete();
                            //     progressBarDD.dismiss();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    ex.shutdown();
                    dialog.dismiss();

                    Intent zipintent = new Intent(MainActivity.this, QuranGrammarAct.class);

                    startActivity(zipintent);
                    MainActivity.this.finish();

                });


            }

            private boolean canWriteInSDCard() {
                String state = Environment.getExternalStorageState();
                return Environment.MEDIA_MOUNTED.equals(state);
            }
        });

    }


    public boolean getDefaultSaveRootPath() {


        boolean useExternalStorage = false;
        File externalCacheDir = getExternalCacheDir();
        boolean mounted = Environment.getExternalStorageState().equals("mounted");
        final long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();


        if (mounted) {
            if (freeSpace > 0) {
                useExternalStorage = true;

            }
        }

        return useExternalStorage;
    }


}


