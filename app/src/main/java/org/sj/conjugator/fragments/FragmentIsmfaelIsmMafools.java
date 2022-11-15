package org.sj.conjugator.fragments;

import static com.example.Constant.MUJARRADVERBTAG;
import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import org.sj.conjugator.adapter.IsmFaelIsmMafoolSarfKabeerAdapter;
import org.sj.conjugator.adapter.MazeedFihiSagheerListingadapter;
import org.sj.conjugator.utilities.GatherAll;
import org.sj.nounConjugation.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.util.KovRulesManager;
import org.sj.verbConjugation.util.SarfDictionary;
import org.sj.verbConjugation.util.TrilateralKovRule;

import java.util.ArrayList;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentIsmfaelIsmMafools extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String TAG = "PermissionDemo";
    private static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private final ArrayList sarfSagheer = new ArrayList();
    private final ArrayList sarfSagheermahmooz = new ArrayList();
    Spinner spinthulathi;
    boolean thulathi, mazeed;
    Button mujarradregular, mujarradweak, mazeedregular, mazeedweak;
    ArrayList<String> sarfkabeer = new ArrayList<>();
    RecyclerView recyclerView;
    Button llPdf;
    ArrayList<String> getall = new ArrayList<>();
    boolean mahmoozfa, mahmoozayn, mahmoozlam, mithalwawi, mithalyayi, ajwafwawi, ajwafyayi, naqiswawi, naqisyai, lafeefajwafwawi, lafeefajwfyayi;
    boolean regularverb;
    boolean isAugmented, isUnAugmented;
    private NavigationView navigationView;
    private Toolbar materialToolbar;
    private BottomNavigationView bottomNavigationView;
    private MazeedFihiSagheerListingadapter mazeedFiHiSagheerListingadapter;
    private Bitmap bitmap;
    private Spinner spinmazeed;
    private AconSarfKabeerAdapter aconSarfKabeerAdapter;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();
    private ArrayList<ArrayList> getsarfsagheer;
    private int augmented;
    private String unaugmented;
    private String madhi;
    private String mudharay;
    private String madhimajhool;
    private String mudharaymajhool;
    private String amrstr;
    private String verbweakness;
    private boolean isSarfKabeer;
    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;

    public FragmentIsmfaelIsmMafools newInstance() {
        FragmentIsmfaelIsmMafools f = new FragmentIsmfaelIsmMafools();
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
    //  public static SarfKabeerFragmentOnClickFromListing newInstance() {
    //     SarfKabeerFragmentOnClickFromListing VerbListFragment = new SarfKabeerFragmentOnClickFromListing();
    //     return VerbListFragment;
    // }

    public void setRegularverb(boolean regularverb) {
        this.regularverb = regularverb;
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
                //   fm.popBackStack();
            }
        });
        //    Bundle dataBundle = this.getArguments();
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
        recyclerView = view.findViewById(R.id.sarfrecview);
        return skabeer;
    }

    private void initMazeedAdapterNew() {
        //   SarfKabeerMazeed skmazeed = new SarfKabeerMazeed(verbroot, augmented);
        // skabeer = skmazeed.SarfKabeerMazeed();
        List ismfael = null;
        List ismmafool = null;
        ArrayList<ArrayList> arrayLists = GatherAll.getInstance().buildAugmenteParticiples(verbroot, augmentedFormula);
        if (!arrayLists.isEmpty()) {
            IsmFaelIsmMafoolSarfKabeerAdapter ska = new IsmFaelIsmMafoolSarfKabeerAdapter(arrayLists, getContext(), false);
            recyclerView.setAdapter(ska);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }

    private void ninitThulathiAdapter() {
        //   OldThulathi();
        ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradParticiple(verbroot, unaugmentedFormula);
        if (!mujarradListing.isEmpty()) {
            boolean newsarf = true;
            IsmFaelIsmMafoolSarfKabeerAdapter ska = new IsmFaelIsmMafoolSarfKabeerAdapter(mujarradListing, getContext(), newsarf);
            //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
            recyclerView.setAdapter(ska);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }

    private void sarfParticpleCOnjugation() {
        char c1 = verbroot.charAt(0);
        char c2 = verbroot.charAt(1);
        char c3 = verbroot.charAt(2);
        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance()
                .getUnaugmentedTrilateralRoots(verbroot, augmentedFormula);
        List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                unaugmentedTrilateralRoot.getConjugation());
        final String formula = "";
        final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
                getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");
        final List finalIsmFael = conjugationResult.getFinalResult();
        List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
                unaugmentedTrilateralRoot.getConjugation());
        final String formulas = "";
        final org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
                PassiveParticipleModifier.
                        getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
        final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();
        skabeer.add((ArrayList) finalIsmFael);
        skabeer.add((ArrayList) ismmafoolresultFinalResult);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ImageView ref;
        ref = view.findViewById(R.id.dismissView);
        //     dismiss(ref);
    }

}
