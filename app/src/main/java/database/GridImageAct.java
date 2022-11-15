package database;

import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.WORDNUMBER;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.Activity.newDuaGroupAdapter;
import com.example.mushafconsolidated.NamesDetail;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.DuaItemFragment;

import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.example.utility.QuranGrammarApplication;

import org.sj.conjugator.adapter.rulesbottomsheetadapter;
import org.sj.conjugator.interfaces.OnItemClickListener;

import java.util.ArrayList;

import database.entity.AllahNames;
import database.entity.DuaGroup;

public class GridImageAct extends BaseActivity {
    private newDuaGroupAdapter mAdapter;
    private ListView mListView;
    private Toolbar toolbar;


    private GridAdapter gadapter;


    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_group);
        //toolbar = (Toolbar) findViewById(R.id.my_action_bar);
       // View mToolbarShadow = findViewById(R.id.view_toolbar_shadow);
      //  setSupportActionBar(toolbar);
        toolbar = (Toolbar) findViewById(R.id.my_action_bar);
        View mToolbarShadow = findViewById(R.id.view_toolbar_shadow);
        setSupportActionBar(toolbar);
        final int color = ContextCompat.getColor(this, R.color.color_background_overlay);
        final int colorsurface = ContextCompat.getColor(this, R.color.DarkGoldenrod);
        final int coloronbackground = ContextCompat.getColor(this, R.color.neutral0);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            toolbar.setBackgroundColor(coloronbackground);
            toolbar.setBackgroundColor(color);
        } else {
            toolbar.setBackgroundColor(colorsurface);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.duaListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
     //  gridView = (GridView) findViewById(R.id.gridView);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
    //  gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
       Utils utils=new Utils(this);
        ArrayList<AllahNames> names = utils.getNames();
        gadapter = new GridAdapter(this,  names,getData());
      //  gridView.setAdapter(gridAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(gadapter);
        gadapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                AllahNames item1 = (AllahNames) gadapter.getItem(position);
                System.out.println(item1.getArabic());
                NamesDetail item=new NamesDetail();

                //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
                //    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                Bundle dataBundle = new Bundle();
                dataBundle.putInt(SURAH_ID, item1.getId());




                item.setArguments(dataBundle);
               int data = (item1.getId());
                //  FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
                //   transactions.show(item);
                NamesDetail.newInstance(data).show(getSupportFragmentManager(), NamesDetail.TAG);

                //   Toast.makeText(GridImageAct.this, item1.getId(), Toast.LENGTH_SHORT).show();
            }
        });


      /*
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                //Create intent
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        }
       */
    }


    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs =getResources().obtainTypedArray(R.array.names_imgs);
    //    TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainsearch, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        if(searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    gadapter.getFilter().filter(s);
                    return true;
                }
            });
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
           if (id == R.id.bookmark) {
         //   Intent intent = new Intent(this, BookmarksGroupActivity.class);
          //  this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}