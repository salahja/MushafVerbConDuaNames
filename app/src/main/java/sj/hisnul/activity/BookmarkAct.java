package sj.hisnul.activity;


        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ExpandableListAdapter;
        import android.widget.ExpandableListView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;


        import com.example.mushafconsolidated.Activity.BaseActivity;
        import com.example.mushafconsolidated.R;
        import com.example.mushafconsolidated.Utils;
        import com.google.android.material.appbar.MaterialToolbar;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

        import sj.hisnul.fragments.HDuaNamesfrag;

        import sj.hisnul.entity.hduanames;

public class BookmarkAct
        extends BaseActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_act);
        //     setContentView(R.layout.activity_dua_group);
        toolbar = findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().hide();
        // getActionBar().hide();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //   String list=   bundle.getString("list");
        String dua_id = bundle.getString("dua_id");
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        //  expandableListDetail = ExpandableListDataPump.getData();
        ArrayList<hduanames> hduadetailsArrayList;
        Utils utils = new Utils(this);
        Bundle bundle1 = new Bundle();
        bundle1.putString("id", dua_id);
        bundle1.putString("list", "list");
        //  bundle.putString("ref",ref);
        Fragment fragvsi = HDuaNamesfrag.newInstance(dua_id, "list");
        fragvsi.setArguments(bundle1);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.frame_container, fragvsi, "items");
        //     transaction.addToBackStack("setting");
        transaction.addToBackStack("items");
        transaction.commit();
    }
}
