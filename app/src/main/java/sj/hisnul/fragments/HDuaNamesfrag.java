package sj.hisnul.fragments;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.google.android.material.appbar.MaterialToolbar;


import java.util.ArrayList;
import java.util.LinkedList;

import sj.hisnul.adapter.HRecyclerViewAdapter;
import sj.hisnul.entity.hduadetails;
import sj.hisnul.entity.hduanames;

public class HDuaNamesfrag extends Fragment {

    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String TAG = "PermissionDemo";

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    RecyclerView recyclerView;

    private HRecyclerViewAdapter adapter;
    private String lists;
    private String refid;
    private ArrayList<hduadetails> duaItems = new ArrayList<>();


    LinkedList link = new LinkedList<>();

    public static HDuaNamesfrag newInstance(String id, String list) {


        HDuaNamesfrag fragment = new HDuaNamesfrag();
        Bundle bundle = new Bundle();
        bundle.putString("list", list);
        bundle.putString("id", id);
        fragment.setArguments(bundle);


        return fragment;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            lists = getArguments().getString("list");
            refid = getArguments().getString("id");

        }


        Utils utils = new Utils(getActivity());

        duaItems = utils.gethDuadetailsitems(refid);


        System.out.println("check");


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.dunamefragview, container, false);
        setHasOptionsMenu(true);
        MaterialToolbar toolbar = view.findViewById(R.id.toolbarmain);

        //  ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        recyclerView = view.findViewById(R.id.dunamerec);
        Utils utils = new Utils(getContext());

        toolbar.setTitle("someTitle");
        toolbar.inflateMenu(R.menu.menu_bookmark);

        // and finally set click listener
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.action_bookmark:
                        Toast.makeText(getContext(), "First book item", Toast.LENGTH_SHORT).show();
                       // ArrayList<hduanames> det = utils.getDuanamesDetails(refid);
                     //   ArrayList<hduadetails> dd = utils.gethDuadetailsitems(refid);
                        ArrayList<hduanames> duanamesDetails = utils.getIsmarked(refid);




                        if(duanamesDetails.get(0).getFav()==0)

                        {
                            int up = utils.updateFav(1, refid);

                        }else{
                            int upd = utils.updateFav(0, refid);
                        }


                        return true;


                    case R.id.action_share:
                        Toast.makeText(getContext(), "First share item", Toast.LENGTH_SHORT).show();
                        //       setuptoolbar();
                        return true;
                    case R.id.action_search:
                        Toast.makeText(getContext(), "First sear item", Toast.LENGTH_SHORT).show();
                        //       setuptoolbar();
                        return true;


                }
                Toast.makeText(getActivity(), "tool", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //  int si = duacoll.size();

        adapter = new HRecyclerViewAdapter(duaItems, getContext());

        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.SetOnItemClickListener(new HRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });


        return view;
    }


    public boolean allowBackPressed() {

        return true;
    }


}
