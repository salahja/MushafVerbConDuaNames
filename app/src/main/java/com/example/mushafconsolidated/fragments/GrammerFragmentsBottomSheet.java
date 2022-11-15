package com.example.mushafconsolidated.fragments;

import static com.example.Constant.MIDNIGHTBLUE;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;

import com.example.mushafconsolidated.Adapters.RootWordDisplayAdapter;
import com.example.mushafconsolidated.Adapters.SentenceRootWordDisplayAdapter;
import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.VerbWazan;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.model.SarfSagheerPOJO;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class GrammerFragmentsBottomSheet extends BottomSheetDialogFragment {
    public static final String TAG = "bottom";
    // TODO: Customize parameter argument names
    private static final String ARG_OPTIONS_DATA = "options_data";
    int chapterid = 0;
    int ayanumber = 0;
    boolean isMazeedSarfSagheer;
    boolean isThulathiSarfSagheer;
    boolean isverbconjugaton;
    boolean participles;
    boolean noun;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    LinkedHashMap<String, List<SpannableStringBuilder>> expandableListDetail;
    List<SpannableStringBuilder> kanaExpandableListDetail;
    HashMap<Integer, HashMap<String, SpannableStringBuilder>> wordetailsall = new HashMap<>();
    HashMap<Integer, HashMap<String, String>> verbdetailsall = new HashMap<>();
    HashMap<String, String> vbdetail = new HashMap<>();
    HashMap<String, SpannableStringBuilder> wordbdetail;
    BackgroundColorSpan mudhafspans = new BackgroundColorSpan(MIDNIGHTBLUE);
    boolean showGrammarFragments = false;
    ArrayList<ArrayList> ThulathiMazeedConjugatonList;
    SarfSagheerPOJO sarf;
    private SpannableStringBuilder spannableHarf;
    private SpannableStringBuilder spannable;
    private String HarfNasbAndZarf;
    private SpannableStringBuilder spannableShart;
    private SpannableStringBuilder spannablemousufmudhaf;
    private ArrayList<NewCorpusExpandWbwPOJO> SencorpusSurahWord;
    private ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord;
    private AlertDialog dialog;
    private ArrayList<ArrayList> ismfaelmafool;
    private VerbWazan vb;
    private RootWordDisplayAdapter rwAdapter;
    private SentenceRootWordDisplayAdapter sentenceRootWordDisplayAdapter;

    // TODO: Customize parameters
    @NonNull
    public static GrammerFragmentsBottomSheet newInstance(String[] data) {
        final GrammerFragmentsBottomSheet fragment = new GrammerFragmentsBottomSheet();
        final Bundle args = new Bundle();
        args.putStringArray(ARG_OPTIONS_DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    public boolean isNoun() {
        return noun;
    }

    public void setNoun(boolean noun) {
        this.noun = noun;
    }

    public boolean isParticiples() {
        return participles;
    }

    public void setParticiples(boolean participles) {
        this.participles = participles;
    }

    public boolean isIsverbconjugaton() {
        return isverbconjugaton;
    }

    public void setIsverbconjugaton(boolean isverbconjugaton) {
        this.isverbconjugaton = isverbconjugaton;
    }

    public boolean isMazeedSarfSagheer() {
        return isMazeedSarfSagheer;
    }

    public void setMazeedSarfSagheer(boolean mazeedSarfSagheer) {
        isMazeedSarfSagheer = mazeedSarfSagheer;
    }

    public String getHarfNasbAndZarf() {
        return HarfNasbAndZarf;
    }

    public void setHarfNasbAndZarf(String harfNasbAndZarf) {
        HarfNasbAndZarf = harfNasbAndZarf;
    }

    public boolean isThulathiSarfSagheer() {
        return isThulathiSarfSagheer;
    }

    public void setThulathiSarfSagheer(boolean thulathiSarfSagheer) {
        isThulathiSarfSagheer = thulathiSarfSagheer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expand_list, container, false);
        // RecyclerView recyclerView = view.findViewById(R.id.wordByWordRecyclerView);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);
        dialog = builder.create();
        Bundle bundle = this.getArguments();
        String[] stringArray = bundle.getStringArray(ARG_OPTIONS_DATA);
        chapterid = Integer.parseInt(stringArray[0]);
        SharedPreferences shared =
                PreferenceManager.getDefaultSharedPreferences(getContext());
        showGrammarFragments = shared.getBoolean("fragments", false);
        ayanumber = Integer.parseInt(stringArray[1]);
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Utils utils = new Utils(getActivity());
        ex.execute(new Runnable() {
            final ProgressDialog mProgressBar = new ProgressDialog(getActivity());

            @Override
            public void run() {
                getActivity().runOnUiThread(() -> {
                    dialog.show();
                });
                ArrayList<NewCorpusExpandWbwPOJO> corpusSurahWord;
                corpusSurahWord = utils.getCorpusWbwBySurahAyahWordid(chapterid, ayanumber, 1);
                ArrayList<NounCorpus> corpusNounWord = utils.getQuranNouns(chapterid, ayanumber, 1);
                ExpandableListData expandableListData = new ExpandableListData(chapterid, ayanumber, corpusSurahWord, utils);
                expandableListDetail = expandableListData.getData();
                kanaExpandableListDetail = expandableListData.getKana();
                expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                ThulathiMazeedConjugatonList = new ArrayList<>();
                setIsverbconjugaton(false);
                setParticiples(false);
                corpusNounWord.size();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ex.shutdown();
                        dialog.dismiss();
                        GrammarFragmentsListAdapter grammarFragmentsListAdapter;
                        grammarFragmentsListAdapter = new GrammarFragmentsListAdapter(getContext(), expandableListTitle, expandableListDetail);
                        expandableListView.setAdapter(grammarFragmentsListAdapter);
                        for (int i = 0; i < grammarFragmentsListAdapter.getGroupCount(); i++) {
                            expandableListView.expandGroup(i);
                        }

                    }
                });

            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }




/*

    @Override
    public void onItemClick(View v, int position) {
         v.findViewById(R.id.dismissView);
         if(v.findViewById(R.id.dismissView)!=null){
             getActivity().finish();

         }
    }
*/

}