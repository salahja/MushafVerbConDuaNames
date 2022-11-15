package org.sj.conjugator.fragments;

import static com.example.Constant.MUJARRADVERBTAG;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.SARFKABEERWEAKNESS;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.adapter.AconSarfKabeerAdapter;
import org.sj.conjugator.adapter.IsmZarffKabeerAdapter;
import org.sj.conjugator.adapter.MazeedFihiSagheerListingadapter;
import org.sj.conjugator.utilities.GatherAll;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentIsmZarf extends Fragment {
    private static final String TAG = "PermissionDemo";
    private static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private final ArrayList sarfSagheer = new ArrayList();
    private final ArrayList sarfSagheermahmooz = new ArrayList();
    ArrayList<String> sarfkabeer = new ArrayList<>();
    RecyclerView recyclerView;
    Button llPdf;
    ArrayList<String> getall = new ArrayList<>();
    boolean mahmoozfa, mahmoozayn, mahmoozlam, mithalwawi, mithalyayi, ajwafwawi, ajwafyayi, naqiswawi, naqisyai, lafeefajwafwawi, lafeefajwfyayi;
    boolean regularverb;
    boolean isAugmented, isUnAugmented;
    private FloatingTextButton callButton;
    private NavigationView navigationView;
    private Toolbar materialToolbar;
    private BottomNavigationView bottomNavigationView;
    private LinearLayoutManager layoutManager;
    private MazeedFihiSagheerListingadapter mazeedFiHiSagheerListingadapter;
    private AconSarfKabeerAdapter aconSarfKabeerAdapter;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();
    private ArrayList<ArrayList> getsarfsagheer;
    private int verbformmazeed;
    private String verbformthulathi;
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String madhi;
    private String mudharay;
    private String madhimajhool;
    private String mudharaymajhool;
    private String amrstr;
    private String verbweakness;
    private boolean isSarfKabeer;
    private String verbroot, verbmood;

    public FragmentIsmZarf newInstance() {
        FragmentIsmZarf f = new FragmentIsmZarf();
        Bundle b = new Bundle();
        //  f.setArguments(b);
        Bundle dataBundle = getArguments();
        assert dataBundle != null;
        verbformthulathi = dataBundle.getString(QURAN_VERB_WAZAN);
        verbweakness = dataBundle.getString(SARFKABEERWEAKNESS);
        f.setArguments(dataBundle);
        return f;

    }
    // public static SarfKabeerFragmentOnClickFromListing newInstance() {
    //     SarfKabeerFragmentOnClickFromListing VerbListFragment = new SarfKabeerFragmentOnClickFromListing();
    // return VerbListFragment;
    //  }

    public void setRegularverb(boolean regularverb) {
        this.regularverb = regularverb;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.sarfkabeerheader, container, false);
        callButton = view.findViewById(R.id.action_buttons);
        Bundle dataBundle = getArguments();
        if (dataBundle != null) {
            String callingfragment = dataBundle.getString(MUJARRADVERBTAG);
            if (callingfragment != null) {
                if (callingfragment.equals("tverblist")) {
                    callButton.setVisibility(View.VISIBLE);
                } else {
                    callButton.setVisibility(View.GONE);
                }
            } else {
                callButton.setVisibility(View.GONE);
            }
        }
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //     FragmentManager fragmentManager = null;
                //   fragmentManager.popBackStack("mujarrad", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentManager fm = getActivity()
                        .getSupportFragmentManager();
                //   fm.popBackStack ("mujarrad", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                //    getFragmentManager().popBackStack();
                //   FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
                //    fm.popBackStack();
            }
        });
        assert dataBundle != null;
        if (dataBundle.getString(VERBTYPE).equals("mujarrad")) {
            isUnAugmented = true;
            unaugmentedFormula = dataBundle.getString(QURAN_VERB_WAZAN);
        } else {
            augmentedFormula = dataBundle.getString(QURAN_VERB_WAZAN);
            isAugmented = true;
        }
        verbroot = dataBundle.getString(QURAN_VERB_ROOT);
        verbmood = dataBundle.getString(VERBMOOD);
        recyclerView = view.findViewById(R.id.sarfrecview);
        skabeer = setUparrays(view);
        //  AconSarfKabeerAdapter = new AconSarfKabeerAdapter(sarfkabeermadhi,skabeer, getActivity());
        //   aconSarfKabeerAdapter = new AconSarfKabeerAdapter(skabeer, getActivity());
        //  recyclerView.setAdapter(aconSarfKabeerAdapter);
        return view;
    }

    @NotNull
    private ArrayList<ArrayList> setUparrays(View view) {
        if (isUnAugmented) {
            ninitThulathiAdapter();

        } else {
            //   initMazeedAdapter();
            initMazeedAdapterNew();
        }
        return skabeer;
    }

    private void initMazeedAdapterNew() {
    }

    private void ninitThulathiAdapter() {
        ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradZarf(verbmood, verbroot, unaugmentedFormula);
        if (!mujarradListing.isEmpty()) {
            IsmZarffKabeerAdapter ska = new IsmZarffKabeerAdapter(mujarradListing, getContext());
            //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
            recyclerView.setAdapter(ska);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ImageView ref;
        ref = view.findViewById(R.id.dismissView);
        //dismiss(ref);
    }

    private void dismiss(ImageView ref) {
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "tagone";

            }
        });
    }

}
