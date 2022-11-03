package sj.hisnul.fragments;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.appbar.MaterialToolbar;


import java.util.ArrayList;

import sj.hisnul.adapter.CatAllAdapter;
import sj.hisnul.entity.hduanames;

public class AllDuaFrag extends Fragment implements SearchView.OnQueryTextListener {

    private SearchView searchView = null;

    private SearchView.OnQueryTextListener queryTextListener;
    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String TAG = "PermissionDemo";
    CatAllAdapter ska;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    RecyclerView recyclerView;


    public static  AllDuaFrag newInstance() {
         AllDuaFrag f = new AllDuaFrag();
       // Bundle dataBundle = getArguments();
       // assert dataBundle != null;


        //f.setArguments(dataBundle);
        return f;

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     View view = inflater.inflate(R.layout.activity_dua_group, container, false);

     //   View view = inflater.inflate(R.layout.rwz, container, falser
        recyclerView=view.findViewById(R.id.duaListView);
        Utils utils=new Utils(getContext());
        ArrayList<hduanames> duall = Utils.getAllList();
       ska = new CatAllAdapter(duall, getContext());
        setHasOptionsMenu(true);
        MaterialToolbar toolbar = view.findViewById(R.id.my_action_bar);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ska.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
            //    ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
             //   hduanames hduanames = duall.get(position);
                hduanames hduanames = (sj.hisnul.entity.hduanames) ska.getItem(position);
                String did = hduanames.getID();
                int chap_id = hduanames.getChap_id();


                Bundle bundle1=new Bundle();

                bundle1.putString("name",hduanames.getChapname());

                bundle1.putInt("chap_id",chap_id);
                //  bundle.putString("ref",ref);
                Fragment fragvsi = HDuaNamesfrag.newInstance();
                fragvsi.setArguments(bundle1);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.replace(R.id.frame_container, fragvsi, "items");
                //     transaction.addToBackStack("setting");
                transaction.addToBackStack("items");
                transaction.commit();
            }
        });

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
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
        switch (item.getItemId()) {
            case R.id.search:
                // Not implemented here
                return false;
            default:
                break;
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

