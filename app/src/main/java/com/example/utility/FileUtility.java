package com.example.utility;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtility {
    static Context context;

    public FileUtility(Context context) {
        FileUtility.context = context;
    }

    public static int writetofile(String filename, ArrayList<String> ammended) {
        //  ArrayList<String> ammended = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //   sb.append(surahId).append("|").append(verseId).append("|").append(wordno).append("|").append(wordsAr).append("|");
        //    ammended.add(sb.toString());
        String state = Environment.getExternalStorageState();
        int status = 0;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            FileWriter myWriter;
            String s;
            if (checkPermission()) {
                File sdcard = Environment.getExternalStorageDirectory();
                File dir = new File(sdcard.getAbsolutePath() + "/text/");
                dir.mkdir();
                File file = new File(dir, filename);
                FileOutputStream os;
                try {
                    os = new FileOutputStream(file, true);
                    //      os.write(harfNasbIndexArrayList.toString().getBytes());
                    for (Object str : ammended) {
                        os.write(str.toString().getBytes());
                        String newline = "\n";
                        os.write(newline.getBytes());
                    }
                    os.close();
                    status = 1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                requestPermission(); // Code for permission
            }
        }
        return status;

    }
    //to be delted

    public static int writetofiletemp(String filename, int surahId, int verseId, int wordno, String wordsAr, int startword) {
        ArrayList<String> ammended = new ArrayList<>();
        ammended.add(surahId + "|" + verseId + "|" + startword + "|" + wordno + "|" + wordsAr + "|");
        String state = Environment.getExternalStorageState();
        int status = 0;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            FileWriter myWriter;
            String s;
            if (checkPermission()) {
                File sdcard = Environment.getExternalStorageDirectory();
                File dir = new File(sdcard.getAbsolutePath() + "/text/");
                dir.mkdir();
                File file = new File(dir, filename);
                FileOutputStream os;
                try {
                    os = new FileOutputStream(file, true);
                    //      os.write(harfNasbIndexArrayList.toString().getBytes());
                    for (Object str : ammended) {
                        os.write(str.toString().getBytes());
                        String newline = "\n";
                        os.write(newline.getBytes());
                    }
                    os.close();
                    status = 1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                requestPermission(); // Code for permission
            }
        }
        return status;

    }

    public static int writetofile(String filename, int surahId, int verseId, int wordno, String wordsAr) {
        ArrayList<String> ammended = new ArrayList<>();
        ammended.add(surahId + "|" + verseId + "|" + wordno + "|" + wordsAr + "|");
        String state = Environment.getExternalStorageState();
        int status = 0;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            FileWriter myWriter;
            String s;
            if (checkPermission()) {
                File sdcard = Environment.getExternalStorageDirectory();
                File dir = new File(sdcard.getAbsolutePath() + "/text/");
                dir.mkdir();
                File file = new File(dir, filename);
                FileOutputStream os;
                try {
                    os = new FileOutputStream(file, true);
                    //      os.write(harfNasbIndexArrayList.toString().getBytes());
                    for (Object str : ammended) {
                        os.write(str.toString().getBytes());
                        String newline = "\n";
                        os.write(newline.getBytes());
                    }
                    os.close();
                    status = 1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                requestPermission(); // Code for permission
            }
        }
        return status;

    }

    private static void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText((Activity) context, "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

    private static boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission((Activity) context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
