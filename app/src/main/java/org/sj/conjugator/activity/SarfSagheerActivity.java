package org.sj.conjugator.activity;

import static com.example.Constant.VERBTYPE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.sj.conjugator.fragments.RulesBottomSheet;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class SarfSagheerActivity extends BaseActivity {
    RecyclerView recyclerView;
    private TextView mTextView;
    private LinearLayoutManager layoutManager;
    private BottomNavigationView bottomNavigationView;
    private String verbtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarfsagheer);
        //  bottomNavigationView = findViewById(R.id.bottomNavView);
        String rootText = "ضرب";
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            verbtype = bundle.getString(VERBTYPE);
        }
        FloatingTextButton callButton = findViewById(R.id.sagheeractivtyfloat);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SarfSagheerActivity.super.finish();
                Intent conjugatorintent = new Intent(SarfSagheerActivity.this, ConjugatorAct.class);
                // finish();
                startActivity(conjugatorintent);
                //  Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
        RulesBottomSheet item = new RulesBottomSheet();
        //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
        FragmentManager fragmentManager = getSupportFragmentManager();
        String TAG = "bottom";
        String[] data = {verbtype};
        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
        //   transactions.show(item);
        RulesBottomSheet.newInstance(data).show(getSupportFragmentManager(), RulesBottomSheet.TAG);

    }
}