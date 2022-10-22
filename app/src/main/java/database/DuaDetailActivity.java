package database;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.mushafconsolidated.Activity.BaseActivity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;

import java.util.ArrayList;
import java.util.List;

import database.entity.DuaDetails;

public class DuaDetailActivity extends BaseActivity
     {
    private int duaIdFromDuaListActivity;
    private String duaTitleFromDuaListActivity;
    private DuaDetailAdapter adapter;
    private ListView listView;

    private Toolbar toolbar;
    private TextView my_toolbar_duaGroup_number;
    private TextView my_autofit_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_detail);

        toolbar = (Toolbar) findViewById(R.id.my_detail_action_bar);
        my_toolbar_duaGroup_number = (TextView) findViewById(R.id.txtReference_duaDetail);
        my_autofit_toolbar_title = (TextView) findViewById(R.id.dua_detail_autofit_actionbar_title);
        View mToolbarShadow = findViewById(R.id.view_toolbar_shadow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.listView = (ListView) findViewById(R.id.duaDetailListView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        duaIdFromDuaListActivity = bundle.getInt("dua_id");
        duaTitleFromDuaListActivity = bundle.getString("dua_title");
        Utils utils=new Utils(this);
        ArrayList<DuaDetails> duagroup = utils.getDuagroup(duaIdFromDuaListActivity);

        my_toolbar_duaGroup_number.setText(Integer.toString(duaIdFromDuaListActivity));
        my_autofit_toolbar_title.setText(duaTitleFromDuaListActivity);
        setTitle("");

        if (Build.VERSION.SDK_INT >= 21) {
            mToolbarShadow.setVisibility(View.GONE);
        }
        if (adapter == null) {
            adapter = new DuaDetailAdapter(this, duagroup, duaTitleFromDuaListActivity);
            listView.setAdapter(adapter);
        } else {
            adapter.setData(duagroup);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dua_detail, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, PreferencesActivity.class);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }




}