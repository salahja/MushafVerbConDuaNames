package sj.hisnul.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;

import sj.hisnul.adapter.SelectedDuaViewAdapter;
import sj.hisnul.entity.hduadetails;
import sj.hisnul.entity.hduanames;

public class HDuaNamesfrag extends Fragment {
    private static final String TAG = "PermissionDemo";
    final ArrayList<String> subheaders = new ArrayList<>();
    final ArrayList<ArrayList<hduadetails>> duacoll = new ArrayList<>();
    SelectedDuaViewAdapter sadapter;
    //called by allduarag and  catwofrag retrival by the chaptername in hdunames
    RecyclerView recyclerView;
    private String name;
    private boolean fromcatwo = false;
    private int chap_id;
    private CoordinatorLayout coordinatorLayout;

    public static HDuaNamesfrag newInstance() {
        HDuaNamesfrag fragment = new HDuaNamesfrag();
        return fragment;

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
        final View[] view = {inflater.inflate(R.layout.dunamefragview, container, false)};
        setHasOptionsMenu(true);
        MaterialToolbar toolbar = view[0].findViewById(R.id.toolbarmain);
        android.app.ActionBar actionBa = ((AppCompatActivity) requireActivity()).getActionBar();
        final int color = ContextCompat.getColor(getActivity(), R.color.color_background_overlay);
        final int colorsurface = ContextCompat.getColor(getActivity(), R.color.DarkGoldenrod);
        final int coloronbackground = ContextCompat.getColor(getActivity(), R.color.neutral0);
        coordinatorLayout = (CoordinatorLayout) view[0].findViewById(R.id.coordinatorLayout);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            toolbar.setBackgroundColor(coloronbackground);
            toolbar.setBackgroundColor(color);
        } else {
            toolbar.setBackgroundColor(colorsurface);
        }
        //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        if (actionBa != null) {
            actionBa.setDisplayHomeAsUpEnabled(true);
        }
        recyclerView = view[0].findViewById(R.id.dunamerec);
        Utils utils = new Utils(getContext());
        toolbar.setTitle(name);
        toolbar.inflateMenu(R.menu.menu_bookmark);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.bookmark:
                       Toast.makeText(getContext(), "First book item", Toast.LENGTH_SHORT).show();

                    ArrayList<hduanames> dunamesbyid = Utils.getdualistbychapter(chap_id);
//sadapter.duadetailsitems
                    int gookstat = dunamesbyid.get(0).getFav();
                    if (gookstat == 0) {
                        utils.updateFav(1, chap_id);

                    } else {
                        utils.updateFav(0, chap_id);

                    }


                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "BookMarked", Snackbar.LENGTH_LONG);
                      view[0] = snackbar.getView();
                    CoordinatorLayout.LayoutParams params =(CoordinatorLayout.LayoutParams) view[0].getLayoutParams();
                    params.gravity = Gravity.TOP;
                    view[0].setLayoutParams(params);
                    snackbar.show();
                    return true;
                case R.id.backup:
                    int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                    ((AppCompatActivity) getActivity()).getSupportActionBar().show();
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
        return view[0];
    }

    private void RefreshActivity() {
        Log.e(TAG, "onClick called");
        final Intent intent = requireActivity().getIntent();
        String parentActivityRef = intent.getStringExtra("PARENT_ACTIVITY_REF");
        intent.putExtra("tabposition", 1);
        getActivity().overridePendingTransition(0, 0);
        startActivity(intent);
        getActivity().finish();
        getActivity().overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        //  HisnulMainAct.viewPager.setCurrentItem(0);
        //    HisnulMainAct.viewPager.setCurrentItem(1);
        //  colorsentence.setOnCheckedChangeListener (null);
        //  colorsentence.setChecked(true);
    }

    public boolean allowBackPressed() {
        return true;
    }

}
