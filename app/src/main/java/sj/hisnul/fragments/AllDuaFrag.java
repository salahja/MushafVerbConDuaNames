package sj.hisnul.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

import sj.hisnul.adapter.CatAllAdapter;
import sj.hisnul.entity.hduanames;

public class AllDuaFrag extends Fragment implements SearchView.OnQueryTextListener {
    CatAllAdapter ska;
    RecyclerView recyclerView;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    public static AllDuaFrag newInstance() {
        return new AllDuaFrag();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dua_group, container, false);
        //   View view = inflater.inflate(R.layout.rwz, container, falser
        recyclerView = view.findViewById(R.id.duaListView);
        ArrayList<hduanames> duall = Utils.getAllList();
        ska = new CatAllAdapter(duall, getContext());
        setHasOptionsMenu(true);
        MaterialToolbar toolbar = view.findViewById(R.id.my_action_bar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final int color = ContextCompat.getColor(getActivity(), R.color.color_background_overlay);
        final int colorsurface = ContextCompat.getColor(getActivity(), R.color.DarkGoldenrod);
        final int coloronbackground = ContextCompat.getColor(getActivity(), R.color.neutral0);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            toolbar.setBackgroundColor(coloronbackground);
            toolbar.setBackgroundColor(color);
        } else {
            toolbar.setBackgroundColor(colorsurface);
        }
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ska.SetOnItemClickListener((v, position) -> {
            //    ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
            //   hduanames hduanames = duall.get(position);
            hduanames hduanames = (sj.hisnul.entity.hduanames) ska.getItem(position);
            String did = hduanames.getID();
            int chap_id = hduanames.getChap_id();
            Bundle bundle1 = new Bundle();
            bundle1.putString("name", hduanames.getChapname());
            bundle1.putInt("chap_id", chap_id);
            //  bundle.putString("ref",ref);
            Fragment fragvsi = HDuaNamesfrag.newInstance();
            fragvsi.setArguments(bundle1);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.replace(R.id.frame_container, fragvsi, "items");
            //     transaction.addToBackStack("setting");
            transaction.addToBackStack("items");
            transaction.commit();
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    //   Log.i("onQueryTextChange", newText);
                    ska.getFilter().filter(newText);
                    return true;
                }

                @Override
                public boolean onQueryTextSubmit(String query) {
                    //    Log.i("onQueryTextSubmit", query);
                    ska.getFilter().filter(query);
                    return false;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {// Not implemented here
            return false;
        }
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ska.getFilter().filter(query);
        //  Utils.LogDebug("Submitted: "+query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //    Utils.LogDebug("Changed: "+newText);
        return false;
    }
}

