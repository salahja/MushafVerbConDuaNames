package sj.hisnul.fragments;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;


import java.util.ArrayList;

import sj.hisnul.adapter.CatAllAdapter;
import sj.hisnul.entity.hduanames;

public class AllDuaFrag extends Fragment {

    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String TAG = "PermissionDemo";

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;
    boolean isAugmented, isUnAugmented;
    Spinner spinthulathi;
    boolean thulathi, mazeed;

    Button mujarradregular, mujarradweak, mazeedregular, mazeedweak;
    ArrayList<String> sarfkabeer = new ArrayList<>();
    RecyclerView recyclerView;
    Button llPdf;

    public AllDuaFrag newInstance() {
        AllDuaFrag f = new AllDuaFrag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recylerview, container, false);

        recyclerView=         view.findViewById(R.id.recview);
        Utils utils=new Utils(getContext());
        ArrayList<hduanames> duall = Utils.getAllList();
        CatAllAdapter ska = new CatAllAdapter(duall, getContext());
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ska.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                hduanames hduanames = duall.get(position);
                String did = hduanames.getID();


                Bundle bundle1=new Bundle();
                bundle1.putString("id",  did);
                bundle1.putString("list","list");
                //  bundle.putString("ref",ref);
                Fragment fragvsi = HDuaNamesfrag.newInstance(did,"list");
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

}
