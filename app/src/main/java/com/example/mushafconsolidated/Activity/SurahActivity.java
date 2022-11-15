package com.example.mushafconsolidated.Activity;

import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.AYAH_ID;
import static com.example.Constant.CHAPTER;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Adapters.NewSurahDisplayAdapter;
import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.databinding.ActivitySurahBinding;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.mushafconsolidated.intrface.PassdataInterface;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class SurahActivity extends BaseActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivitySurahBinding binding;
    private RecyclerView parentRecyclerView;
    //   private RecyclerView.Adapter ParentAdapter;
    private NewSurahDisplayAdapter ParentAdapter;
    //  SurahDisplayAdapter ParentAdapter;
    private OnItemClickListener mItemClickListener;
    private final boolean isfragmentshowing = true;
    private ImageView drop;
    private TextView devIndicatorView;
    private PassdataInterface passdataInterface;
    private PassdataInterface datapasser;
    private int lastreadchapterno, lastreadverseno;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_surah_juz);
        //    Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //  getSupportActionBar().setTitle(R.string.toolbar_title);
        Utils utils = new Utils(this);
        ArrayList<ChaptersAnaEntity> allAnaChapters = utils.getAllAnaChapters();
        TypedArray imgs = this.getResources().obtainTypedArray(R.array.sura_imgs);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        // parentRecyclerView = view.findViewById(R.id.juzRecyclerView);
        parentRecyclerView = findViewById(R.id.wordByWordRecyclerView);
        MaterialButton lastread = findViewById(R.id.lastread);
        TextView kahaf = findViewById(R.id.kahaf);
        TextView ayakursi = findViewById(R.id.ayatkursi);
        SharedPreferences pref = this.getSharedPreferences("lastread", MODE_PRIVATE);
        lastreadchapterno = pref.getInt(CHAPTER, 1);
        lastreadverseno = pref.getInt(AYAH_ID, 1);
        lastread.setText("Last read" + ":" + "Surah:" + lastreadchapterno + " " + "Ayah:" + lastreadverseno);
        kahaf.setText(R.string.linkkahaf);
        lastread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(QuranGrammarApplication.getContext(), QuranGrammarAct.class);
                //  Intent intent = new Intent(DarkThemeApplication.getContext(), ReadingSurahPartActivity.class);
                intent.putExtra("chapter", lastreadchapterno);
                intent.putExtra("chapterorpart", true);
                intent.putExtra("partname", allAnaChapters.get(lastreadchapterno - 1).getAbjadname());
                intent.putExtra(AYAH_ID, lastreadverseno);
                intent.putExtra(AYAHNUMBER, lastreadverseno);
                startActivity(intent);

            }
        });
        kahaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuranGrammarApplication.getContext(), QuranGrammarAct.class);
                //  Intent intent = new Intent(DarkThemeApplication.getContext(), ReadingSurahPartActivity.class);
                intent.putExtra("chapter", 18);
                intent.putExtra("chapterorpart", true);
                intent.putExtra("partname", allAnaChapters.get(18).getAbjadname());
                intent.putExtra("verseno", 1);
                intent.putExtra(AYAH_ID, 1);
                startActivity(intent);

            }
        });
        ayakursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuranGrammarApplication.getContext(), QuranGrammarAct.class);
                //  Intent intent = new Intent(DarkThemeApplication.getContext(), ReadingSurahPartActivity.class);
                intent.putExtra("chapter", 2);
                intent.putExtra("chapterorpart", true);
                intent.putExtra("partname", allAnaChapters.get(2).getAbjadname());
                intent.putExtra("verseno", 255);
                intent.putExtra(AYAH_ID, 255);
                startActivity(intent);

            }
        });
        parentRecyclerView.setLayoutManager(mLayoutManager);
        parentRecyclerView.setHasFixedSize(true);
        parentRecyclerView.setLayoutManager(mLayoutManager);
        ParentAdapter = new NewSurahDisplayAdapter(this, allAnaChapters);
        ParentAdapter.setUp(allAnaChapters);
        parentRecyclerView.setAdapter(ParentAdapter);
        ParentAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // TranslationEntity entity = loadedTranslation.get(position);
                ChaptersAnaEntity entity = (ChaptersAnaEntity) ParentAdapter.getItem(position);
                // View id1 =       v.findViewById(R.id.translationid);
                // View id2 =       v.findViewById(R.id.authorname);
                // View id3 =      v.findViewById(R.id.languagename);
                Bundle bundle = new Bundle();
                //   Intent intent = new Intent(getActivity(), NounOccuranceAsynKAct.class);
                //   Toast.makeText(SearchActivity.this, "tobe downloaded click", Toast.LENGTH_SHORT).show();
            }
        });

    }

}