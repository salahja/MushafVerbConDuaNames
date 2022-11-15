package org.sj.conjugator.fragments;

import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.adapter.SarfMujarradSarfSagheerListingAdapter;
import org.sj.conjugator.utilities.GatherAll;

import java.util.ArrayList;

public class MazeedTabSagheerFragmentVerb extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final String TAG = "PermissionDemo";
    private final Context context;
    // --Commented out by Inspection (31/1/21 5:51 AM):ArrayList<String> sarfkabeer = new ArrayList<>();
    RecyclerView recyclerView;
    boolean isAugmented, isUnAugmented;
    private String verbweakness;
    private SarfMujarradSarfSagheerListingAdapter sarfsagheerAdapter;
    // ArrayList sarfSagheerThulathiArray = new ArrayList();
    private ArrayList sarfSagheerThulathiArray;
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();

    public MazeedTabSagheerFragmentVerb(Context context) {
        this.context = context;

    }

    public MazeedTabSagheerFragmentVerb newInstance() {
        MazeedTabSagheerFragmentVerb f = new MazeedTabSagheerFragmentVerb(context);
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
        Bundle dataBundle = getArguments();
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
            initMazeedAdapterNew();
        }
        recyclerView = view.findViewById(R.id.sarfrecview);
        return skabeer;
    }

    private void initMazeedAdapterNew() {
        ArrayList sarfSagheerMazeedArray = new ArrayList();
        ArrayList<ArrayList> listing = GatherAll.getInstance().getMazeedListing(verbmood, verbroot, augmentedFormula);
        SarfSagheer ss = new SarfSagheer();
        ss.setWeakness(listing.get(0).get(0).toString());
        ss.setWazanname(listing.get(0).get(1).toString());
        ss.setVerbroot(listing.get(0).get(2).toString());
        ss.setMadhi(listing.get(0).get(3).toString());
        ss.setMadhimajhool(listing.get(0).get(4).toString());
        ss.setMudharay(listing.get(0).get(5).toString());
        ss.setMudharaymajhool(listing.get(0).get(6).toString());
        ss.setAmrone(listing.get(0).get(7).toString());
        ss.setNahiamrone(listing.get(0).get(8).toString());
        ss.setIsmfael(listing.get(0).get(9).toString());
        ss.setIsmmafool(listing.get(0).get(10).toString());
        ss.setIsmalaone(listing.get(0).get(11).toString());
        ss.setIsmalatwo(listing.get(0).get(12).toString());
        ss.setIsmalathree(listing.get(0).get(13).toString());
        ss.setZarfone(listing.get(0).get(14).toString());
        ss.setZarftwo(listing.get(0).get(15).toString());
        ss.setZarfthree(listing.get(0).get(16).toString());
        ss.setVerbtype(listing.get(0).get(17).toString());
        ss.setWazan(listing.get(0).get(18).toString());
        ArrayList<SarfSagheer> ssagheer = new ArrayList<>();
        ssagheer.add(ss);
        sarfsagheerAdapter = new SarfMujarradSarfSagheerListingAdapter(ssagheer, getActivity());
        recyclerView.setAdapter(sarfsagheerAdapter);

    }

    private void ninitThulathiAdapter() {
        int babno = 0;
        //  OldSarfSagheer(babno);
        ArrayList<ArrayList> listing = GatherAll.getInstance().getMujarradListing(verbmood, verbroot, unaugmentedFormula);
        //InsertSarfSagheerThulathi(ANAQISYAYI);
        SarfSagheer ss = new SarfSagheer();
        ss.setWeakness(listing.get(0).get(0).toString());
        ss.setWazanname(listing.get(0).get(1).toString());
        ss.setVerbroot(listing.get(0).get(2).toString());
        ss.setMadhi(listing.get(0).get(3).toString());
        ss.setMadhimajhool(listing.get(0).get(4).toString());
        ss.setMudharay(listing.get(0).get(5).toString());
        ss.setMudharaymajhool(listing.get(0).get(6).toString());
        ss.setAmrone(listing.get(0).get(7).toString());
        ss.setNahiamrone(listing.get(0).get(8).toString());
        ss.setIsmfael(listing.get(0).get(9).toString());
        ss.setIsmmafool(listing.get(0).get(10).toString());
        ss.setIsmalaone(listing.get(0).get(11).toString());
        ss.setIsmalatwo(listing.get(0).get(12).toString());
        ss.setIsmalathree(listing.get(0).get(13).toString());
        ss.setZarfone(listing.get(0).get(14).toString());
        ss.setZarftwo(listing.get(0).get(15).toString());
        ss.setZarfthree(listing.get(0).get(16).toString());
        ss.setVerbtype(listing.get(0).get(17).toString());
        ss.setWazan(listing.get(0).get(18).toString());
        ArrayList<SarfSagheer> ssagheer = new ArrayList<>();
        ssagheer.add(ss);
        sarfsagheerAdapter = new SarfMujarradSarfSagheerListingAdapter(ssagheer, getActivity());
        recyclerView.setAdapter(sarfsagheerAdapter);

    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        /*
        sarfsagheerAdapter.SetOnItemClickListener(new OnItemClickListener() {
            private static final String WORDNUMBER = "wordnumber";

            @Override
            public void onItemClick(View v, int position) {
                Object o = sarfSagheerThulathiArray.get(position);
                //      GrammarWordEntity wordEntity = (GrammarWordEntity) sarfsagheerAdapter.getItem(position);
              /*  int surah_id = wordEntity.getChapter_no();
                int ayah_number = wordEntity.getVerse_no();
                int word_no = wordEntity.getWord_no();
                Bundle dataBundle = new Bundle();
                dataBundle.putInt(SURAH_ID, surah_id);
                dataBundle.putInt(AYAHNUMBER, ayah_number);
                dataBundle.putInt(WORDNUMBER, word_no);
                dataBundle.putString(SURAH_ARABIC_NAME, suraharabicname);
                RootDialog rootDialog = new RootDialog();
                FragmentManager fragmentManager = getFragmentManager();
                rootDialog.setArguments(dataBundle);
                assert fragmentManager != null;
                fragmentManager.beginTransaction().add(R.id.fragmentParentViewGroup, rootDialog).addToBackStack(ROOTDIALOGFRAG).commit();


            }
        });

*/
        //     ImageView ref;
        //   ref = view.findViewById(R.id.dismissView);
//        ref.setOnClickListener(view1 -> {
        //    });
    }

}
