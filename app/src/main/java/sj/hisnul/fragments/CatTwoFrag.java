package sj.hisnul.fragments;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import sj.hisnul.activity.NewExpandAct;
import sj.hisnul.adapter.CatTwoAdapter;


import java.util.ArrayList;


import sj.hisnul.entity.hcategory;

public class CatTwoFrag extends Fragment {
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

    public CatTwoFrag newInstance() {
        CatTwoFrag f = new CatTwoFrag();
        Bundle dataBundle = getArguments();
        assert dataBundle != null;


        f.setArguments(dataBundle);
        return f;

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_catwo_drawble, container, false);

        recyclerView=         view.findViewById(R.id.recview);
        Utils utils=new Utils(getContext());
        ArrayList<hcategory> duagrouptwo = Utils.getHcategory();





        CatTwoAdapter adapter = new CatTwoAdapter(duagrouptwo, getContext());
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
     //   GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);

        GridLayoutManager layoutManager;
        layoutManager = new GridLayoutManager(getActivity(), 3);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {
            @Override
            public int getSpanSize(int position)
            {
                return position == 0 ? 2 : 1;
            }
        });

        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                hcategory catTwo = duagrouptwo.get(position);
                Bundle   dataBundle = new Bundle();

                if(!catTwo.getTitle().isEmpty()) {
                    Intent intent;
                    intent = new Intent(getActivity(),        NewExpandAct.class);


                    String dua_title = catTwo.getTitle();
                    int catid = catTwo.getId();


                    intent.putExtra("dua_id", catid);

                    //  intent.putExtra("dua_title", dua_title);

                    startActivity(intent);

                }else {

                    Toast.makeText(getContext(), catTwo.getId(), Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

}
