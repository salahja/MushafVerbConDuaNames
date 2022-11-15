package sj.hisnul.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.LinkedList;

import sj.hisnul.adapter.SelectedDuaViewAdapter;
import sj.hisnul.entity.hduadetails;
import sj.hisnul.entity.hduanames;

public class DisplayFromBookMark extends Fragment {
    private static final String TAG = "PermissionDemo";
    final ArrayList<String> subheaders = new ArrayList<>();
    final ArrayList<ArrayList<hduadetails>> duacoll = new ArrayList<>();
    SelectedDuaViewAdapter sadapter;
    //called by allduarag and  catwofrag retrival by the chaptername in hdunames
    RecyclerView recyclerView;
    LinkedList link = new LinkedList<>();
    private String lists, name, subheader;
    private boolean fromcatwo = false;
    private int chap_id;
    private String refid;

    public static DisplayFromBookMark newInstance() {
        return new DisplayFromBookMark();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            chap_id = getArguments().getInt("chap_id");
            fromcatwo = getArguments().getBoolean("cattwp");
        }
        Utils utils = new Utils(getActivity());
        if (chap_id != -1) {
            ArrayList<hduanames> dd = Utils.getdualistbychapter(chap_id);
            for (hduanames hduanames : dd) {
                ArrayList<hduadetails> duaItems = utils.gethDuadetailsitems(hduanames.getID());
                duacoll.add(duaItems);
                subheaders.add(hduanames.getDuaname());

            }

        } else {
            Toast.makeText(getActivity(), "Chapter Id not Found", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.dunamefragview, container, false);
        setHasOptionsMenu(true);
        MaterialToolbar toolbar = view.findViewById(R.id.toolbarmain);
        android.app.ActionBar actionBa = ((AppCompatActivity) getActivity()).getActionBar();
        //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        if (actionBa != null) {
            actionBa.setDisplayHomeAsUpEnabled(true);
        }
        recyclerView = view.findViewById(R.id.dunamerec);
        Utils utils = new Utils(getContext());
        toolbar.setTitle(name);
        toolbar.inflateMenu(R.menu.menu_bookmark);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.bookmark:
                    //     Toast.makeText(getContext(), "First book item", Toast.LENGTH_SHORT).show();
                    //     ArrayList<hduanames> duanamesDetails = utils.getIsmarked(chap_id);
                    ArrayList<hduanames> dunamesbyid = Utils.getdualistbychapter(chap_id);
//sadapter.duadetailsitems
                    int gookstat = dunamesbyid.get(0).getFav();
                    if (gookstat == 0) {
                        int up = utils.updateFav(1, chap_id);
                        //  RefreshActivity();
                    } else {
                        int upd = utils.updateFav(0, chap_id);
                        //     RefreshActivity();
                    }
                    return true;
                case R.id.backup:
                    int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                    if (count == 0) {
                        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
                        //additional code
                    } else {
                        getActivity().getSupportFragmentManager().popBackStack();
                    }
                    return true;
                case R.id.action_share:
                    Toast.makeText(getContext(), "First share item", Toast.LENGTH_SHORT).show();
                    //       setuptoolbar();
                    return true;

            }
            Toast.makeText(getActivity(), "tool", Toast.LENGTH_SHORT).show();
            return false;
        });
        if (chap_id != -1) {
            sadapter = new SelectedDuaViewAdapter(duacoll, getContext(), name, subheaders);
            recyclerView.setAdapter(sadapter);
        }
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void RefreshActivity() {
        Log.e(TAG, "onClick called");
        final Intent intent = getActivity().getIntent();
        String parentActivityRef = intent.getStringExtra("PARENT_ACTIVITY_REF");
        intent.putExtra("tabposition", 1);
        getActivity().overridePendingTransition(0, 0);
        startActivity(intent);
        getActivity().finish();
        getActivity().overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        if (fromcatwo) {
            //  HisnulMainAct.viewPager.setCurrentItem(0);
        } else {
            //    HisnulMainAct.viewPager.setCurrentItem(1);
        }
        //  colorsentence.setOnCheckedChangeListener (null);
        //  colorsentence.setChecked(true);
    }

    public boolean allowBackPressed() {
        return true;
    }

}
