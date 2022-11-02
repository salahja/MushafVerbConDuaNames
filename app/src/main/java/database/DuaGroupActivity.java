package database;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.Activity.newDuaGroupAdapter;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.DuaItemFragment;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;

import database.entity.DuaGroup;

public class DuaGroupActivity extends BaseActivity {
    private newDuaGroupAdapter mAdapter;
    private ListView mListView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_group);
        toolbar = (Toolbar) findViewById(R.id.my_action_bar);
        View mToolbarShadow = findViewById(R.id.view_toolbar_shadow);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Utils db=new Utils(this);
        ArrayList<DuaGroup> duagroup = db.getDuagroup();
        RecyclerView recyclerView = findViewById(R.id.duaListView);
        mAdapter = new newDuaGroupAdapter(this, duagroup);
      //  mListView = (ListView) findViewById(R.id.duaListView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //   recyclerView.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(mAdapter);
     //   mAdapter=new newDuaGroupAdapter(this,duagroup);
       // mListView.setAdapter((ListAdapter) mAdapter);


        mAdapter.SetOnItemClickListener(new OnItemClickListener()  {
            @Override
            public void onItemClick(View v, int position) {
                DuaItemFragment item=new DuaItemFragment();
          DuaGroup dua= (DuaGroup) mAdapter.getItem(position);

                Intent intent;
                intent = new Intent(getBaseContext(),
                        DuaDetailActivity.class);


                int dua_id = dua.get_id();
                String dua_title = dua.getEn_title();

                intent.putExtra("dua_id", dua_id);
                intent.putExtra("dua_title", dua_title);

                startActivity(intent);

                //   dataBundle.putString(VERBTYPE, verbtype);
               // Toast.makeText(DuaGroupActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

        });

        if (Build.VERSION.SDK_INT >= 21) {
            mToolbarShadow.setVisibility(View.GONE);
        }


        // For Beta Testing
     //   Resources resource = getResources();
    //    String beta_version = resource.getString(R.string.beta_version);
   //     Toast.makeText(this, "Beta Version: " + beta_version, Toast.LENGTH_SHORT).show();
        // End of Beta Testing

      //  getSupportLoaderManager().initLoader(0, null, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dua_group, menu);

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
                    mAdapter.getFilter().filter(s);
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
           if (id == R.id.action_bookmarks) {
         //   Intent intent = new Intent(this, BookmarksGroupActivity.class);
          //  this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}