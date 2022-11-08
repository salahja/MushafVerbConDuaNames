package sj.hisnul.fragments;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;


import sj.hisnul.adapter.BookMarkAdapter;
import sj.hisnul.entity.hduanames;


public class BookmarkFragment extends Fragment{
    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String TAG = "PermissionDemo";

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };



    RecyclerView recyclerView;

    @Override
    public void onResume() {
        super.onResume();
    }

    private BookMarkAdapter adapter;
    private CoordinatorLayout coordinatorLayout;

    public BookmarkFragment newInstance() {
        BookmarkFragment f = new BookmarkFragment();
        Bundle dataBundle = getArguments();
        assert dataBundle != null;


        f.setArguments(dataBundle);
        return f;

    }


    private ArrayList<hduanames> catOneArrayList = new ArrayList<>();

    //   public static SarfKabeerFragmentOnClickFromListing newInstance() {
    //      SarfKabeerFragmentOnClickFromListing VerbListFragment = new SarfKabeerFragmentOnClickFromListing();
    //     return VerbListFragment;
    //  }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.catfragoneview, container, false);

        recyclerView=         view.findViewById(R.id.catonerecview);
        coordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        Utils utils=new Utils(getContext());
        ArrayList<hduanames> hduanames = utils.getBookmarked(1);


         adapter = new BookMarkAdapter
                 (hduanames, getContext());

        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.setHasFixedSize(true);
 ;
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Object tag = view.getTag();



                boolean id = tag.equals("id");
                boolean delete =tag.equals("delete");
                hduanames bookid = hduanames.get(position);
                if(id) {

                    Bundle dataBundle = new Bundle();
                    String catid = bookid.getID();

            /*
                    Intent intent;
                    intent = new Intent(getActivity(),        BookmarkAct.class);






                    intent.putExtra("dua_id", catid);

                    //  intent.putExtra("dua_title", dua_title);

                    startActivity(intent);

             */
                    Utils utils = new Utils(getActivity());
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("id", catid);
                    // bundle1.putString("list", "list");
                    //  bundle.putString("ref",ref);
                    Fragment fragvsi = HDuaNamesfrag.newInstance(catid, "list");
                    fragvsi.setArguments(bundle1);

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    transaction.replace(R.id.frame_container, fragvsi, "items");
                    //     transaction.addToBackStack("setting");
                    transaction.addToBackStack("items");
                    transaction.commit();
                }else if(delete){
                    String catid = bookid.getID();
                    utils.updateFav(0, bookid.getID());
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.CYAN);
                    snackbar.show();

                }






            }
        });

        return view;
    }




}


/*
   dataBundle.putString("list", catOne.getList());
                 Fragment fragvsi = DuaNamesfrag.newInstance(catOne.getList());
                 fragvsi.setArguments(dataBundle);

                 FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction()
                         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                 transaction.add(R.id.frame_container, fragvsi, "items");
                 //     transaction.addToBackStack("setting");
                 transaction.addToBackStack(null);
                 transaction.commit();
                 getActivity().getSupportFragmentManager().executePendingTransactions();
 */