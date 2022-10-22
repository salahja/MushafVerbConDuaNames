package com.example.mushafconsolidated.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.databinding.ActivityGrammarruleDetailBinding;

public class GrammarRuleDetailHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGrammarruleDetailBinding binding = ActivityGrammarruleDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_grammarrule_detail);
        NavController navController = navHostFragment.getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(navController.getGraph())
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }


    @Override
    public void onBackPressed() {
        Intent in=new Intent(this , QuranGrammarAct.class);
        startActivity(in);




    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_grammarrule_detail);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}