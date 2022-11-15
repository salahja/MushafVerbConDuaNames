package com.example.mushafconsolidated.Activity;

import static com.example.Constant.QURAN_VERB_ROOT;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.qurandictionary;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;

public class QuranDIctionarySearchActivity extends BaseActivity implements OnItemClickListener {
    private static final int LAUNCH_SECOND_ACTIVITY = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    // url to fetch contacts json
    private static final String URL = "https://api.androidhive.info/json/contacts.json";
    private RecyclerView recyclerView;
    // private QuranTopicSearchAdapter topicSearchAdapter;
    private SearchAdapter topicSearchAdapter;
    private SearchView searchView;
    private View readytodownload, downloadedtranslation, backbutton;
    //  private DownloadSearchAdapter.ContactsAdapterListener contactsAdapterListener;
    private View translationDownloaded;
    private View translationReadytoDownload;
    private View view2, view1, view3;
    private ArrayList<qurandictionary> topicSearchAll;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                if (result != null) {
                    final String[] split = result.split(",");
                    //       File file=new File(split[0]);
                    //    new InsertingTranslationFetch(TranslationActivitySearch.this).execute(split[0], split[1]);
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth = outMetrics.widthPixels / density;
        // toolbar fancy stuff
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        Utils utils = new Utils(this);
        view2 = findViewById(R.id.translationReadytoDownload);
        (view2.getLayoutParams()).width = (int) (dpWidth / 2);
        view1 = findViewById(R.id.translationDownloaded);
        view3 = findViewById(R.id.backButtonView);
        (view1.getLayoutParams()).width = (int) (dpWidth / 2);
        view1.setX(-1.0F);
        //     searchDownloadAdapter = new DownloadSearchAdapter(this,translationEntity -> {});
        topicSearchAll = utils.getQuranDictionary();
        recyclerView = findViewById(R.id.recycler_view);
        topicSearchAdapter = new SearchAdapter(QuranDIctionarySearchActivity.this, topicSearchAll, false);
        topicSearchAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // TranslationEntity entity = loadedTranslation.get(position);
                qurandictionary entity = (qurandictionary) topicSearchAdapter.getItem(position);
                // View id1 =       v.findViewById(R.id.translationid);
                // View id2 =       v.findViewById(R.id.authorname);
                // View id3 =      v.findViewById(R.id.languagename);
                Bundle bundle = new Bundle();
                //   Intent intent = new Intent(getActivity(), NounOccuranceAsynKAct.class);
                Intent intent = new Intent(QuranDIctionarySearchActivity.this, SearchResult.class);
                bundle.putString(QURAN_VERB_ROOT, entity.getRootarabic());
                intent.putExtras(bundle);
                //   intent.putExtra(QURAN_VERB_ROOT,vb.getRoot());
                startActivity(intent);
                //   Toast.makeText(SearchActivity.this, "tobe downloaded click", Toast.LENGTH_SHORT).show();
            }
        });
        // white background notification bar
        whiteNotificationBar(recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //   recyclerView.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(topicSearchAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                topicSearchAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                topicSearchAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.backButtonView) {
            Intent rintent = new Intent(QuranDIctionarySearchActivity.this, QuranGrammarAct.class);
            startActivity(rintent);
            finish();

        }
        Intent rintent = new Intent(QuranDIctionarySearchActivity.this, QuranGrammarAct.class);
        startActivity(rintent);
        finish();
        //return super.onOptionsItemSelected(item);
        return true;

    }

    @Override
    public void onBackPressed() {
        finish();
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(), "Selected: " + translationEntity.getLanguage_name()+ ", " + translationEntity.getLanguage_name(), Toast.LENGTH_LONG).show();
    }
}
