package org.sj.conjugator.utilities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mushafconsolidated.R;

import org.sj.conjugator.MainActivity;

public class Splash extends AppCompatActivity {
    public final int SPLASH_DISPLAY_LENGTH = 3000;

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK) !=
                PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) !=
                        PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE)
                        != PackageManager.PERMISSION_GRANTED) {//Can add more as per requirement
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WAKE_LOCK,
                            Manifest.permission.INTERNET,
                            Manifest.permission.ACCESS_NETWORK_STATE},
                    123);
        }
    }

    @Override
    protected void onCreate(Bundle sis) {
        super.onCreate(sis);
//set the content view. The XML file can contain nothing but an image, such as a logo or the       app icon
        setContentView(R.layout.splash_layout);
//we want to display the splash screen for a few seconds before it automatically
        //disappears and loads the game. So we create a thread:
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//request permissions. NOTE: Copying this and the manifest will cause the app to           crash as the permissions requested aren't defined in the manifest.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    checkPermission();
                }
                //    String lang =["ss"];
                //  Locale locale = new Locale(lang);
                //  Locale.setDefault(locale);
                Configuration config = new Configuration
                        ();
                //  config.locale = locale;
                Splash.this.getResources().updateConfiguration(config,
                        Splash.this.getResources().getDisplayMetrics())
                ;
//after three seconds, it will execute all of this code.
//as such, we then want to redirect to the master-activity
                startActivity(new Intent(Splash.this, MainActivity.class));
                // Intent intent = new Intent(Splash.this.getActivity(), MainActivity.class);
                // Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                //  startActivity(mainIntent);
//then we finish this class. Dispose of it as it is longer needed
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}