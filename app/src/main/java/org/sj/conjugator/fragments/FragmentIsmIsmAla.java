package org.sj.conjugator.fragments;

import static com.example.Constant.MUJARRADVERBTAG;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

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
import org.sj.conjugator.adapter.IsmAlaSarfKabeerAdapter;
import org.sj.conjugator.adapter.MazeedFihiSagheerListingadapter;
import org.sj.conjugator.utilities.GatherAll;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentIsmIsmAla extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String TAG = "PermissionDemo";
    private static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private final ArrayList sarfSagheer = new ArrayList();
    private final ArrayList sarfSagheermahmooz = new ArrayList();
    boolean isAugmented, isUnAugmented;
    Spinner spinthulathi;
    boolean thulathi, mazeed;
    Button mujarradregular, mujarradweak, mazeedregular, mazeedweak;
    ArrayList<String> sarfkabeer = new ArrayList<>();
    RecyclerView recyclerView;
    Button llPdf;
    ArrayList<String> getall = new ArrayList<>();
    boolean mahmoozfa, mahmoozayn, mahmoozlam, mithalwawi, mithalyayi, ajwafwawi, ajwafyayi, naqiswawi, naqisyai, lafeefajwafwawi, lafeefajwfyayi;
    boolean regularverb;
    private FloatingTextButton callButton;
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;
    private NavigationView navigationView;
    private Toolbar materialToolbar;
    private BottomNavigationView bottomNavigationView;
    private LinearLayoutManager layoutManager;
    private MazeedFihiSagheerListingadapter mazeedFiHiSagheerListingadapter;
    private Bitmap bitmap;
    private Spinner spinmazeed;
    private AconSarfKabeerAdapter aconSarfKabeerAdapter;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();
    private ArrayList<ArrayList> getsarfsagheer;
    private int verbformmazeed;
    private String verbformthulathi;
    private String madhi;
    private String mudharay;
    private String madhimajhool;
    private String mudharaymajhool;
    private String amrstr;
    private String verbweakness;
    private boolean isSarfKabeer;

    public FragmentIsmIsmAla newInstance() {
        FragmentIsmIsmAla f = new FragmentIsmIsmAla();
        Bundle dataBundle = getArguments();
        assert dataBundle != null;
        if (null != dataBundle) {
            dataBundle.getString(QURAN_VERB_ROOT);
            dataBundle.getString(QURAN_VERB_WAZAN);//verb formula depnding upon the verbtype mujjarad or mazeed
            dataBundle.getString(VERBMOOD);
            dataBundle.getString(VERBTYPE);

        }
        f.setArguments(dataBundle);
        return f;

    }
    //   public static SarfKabeerFragmentOnClickFromListing newInstance() {
    //      SarfKabeerFragmentOnClickFromListing VerbListFragment = new SarfKabeerFragmentOnClickFromListing();
    //     return VerbListFragment;
    //  }

    public void setRegularverb(boolean regularverb) {
        this.regularverb = regularverb;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.d(TAG, "ONCREATE OPTION MENU verse ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        // callButton = view.findViewById(R.id.action_buttons);
        //   callButton.setVisibility(View.VISIBLE);
        //   Bundle dataBundle = this.getArguments();
        assert dataBundle != null;
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
                //      ffm.popBackStack();
                fm.popBackStack();

            }
        });
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
        recyclerView = view.findViewById(R.id.sarfrecview);
        //    SarfSagheerThulathiWeak sw = new SarfSagheerThulathiWeak(getActivity());
        //    SarfSagheerMazeedRegular mw = new SarfSagheerMazeedRegular(getActivity());
        //    sarf = new SarfSagheerThulathiRegular(getActivity());
        //     getsarfsagheer = sf.getThulathiRegularQuery("نصر",NASARA);
        // getsarfsagheer = sw.getThulathiWeakQuery("وجد",ZARABA);
        //  getsarfsagheer = mw.setUpSarfSagheerMazidQuery("نصر", 2);
        return skabeer;
    }

    private void initMazeedAdapterNew() {
    }

    private void ninitThulathiAdapter() {
        //   OldThulathi();
        ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradIsmAla(verbmood, verbroot, unaugmentedFormula);
        if (!mujarradListing.isEmpty()) {
            IsmAlaSarfKabeerAdapter ska = new IsmAlaSarfKabeerAdapter(mujarradListing, getContext());
            //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
            recyclerView.setAdapter(ska);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }

}
