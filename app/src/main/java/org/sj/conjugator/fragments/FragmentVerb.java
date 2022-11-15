package org.sj.conjugator.fragments;

import static com.example.Constant.MUJARRADVERBTAG;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.adapter.VerbSarfKabeerAdapter;
import org.sj.conjugator.utilities.GatherAll;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentVerb extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final String TAG = "PermissionDemo";
    RecyclerView recyclerView;
    boolean isAugmented, isUnAugmented;
    private String verbweakness;
    private String callingfragment;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;

    public FragmentVerb newInstance() {
        FragmentVerb f = new FragmentVerb();
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

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.sarfkabeerheader, container, false);
        FloatingTextButton callButton = view.findViewById(R.id.action_buttons);
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
        //   callButton.setVisibility(View.VISIBLE);
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
                //     fm.popBackStack();
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
            // initMazeedAdapterNew();
            final ArrayList<ArrayList> indictive = GatherAll.getInstance().getMazeedListing(verbmood, verbroot, augmentedFormula);
            VerbSarfKabeerAdapter sk;
            if (!indictive.isEmpty()) {
                indictive.remove(0);
                sk = new VerbSarfKabeerAdapter(indictive, getContext());
                recyclerView.setAdapter(sk);
                //  recyclerView.setAdapter(ska);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

        }
        recyclerView = view.findViewById(R.id.sarfrecview);
        return skabeer;
    }

    private void ninitThulathiAdapter() {
        //  extracted();
        final ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradListing(verbmood, verbroot, unaugmentedFormula);
        mujarradListing.remove(0);
        VerbSarfKabeerAdapter ska = new VerbSarfKabeerAdapter(mujarradListing, getContext());
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

    }

}
