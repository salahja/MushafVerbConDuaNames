package org.sj.conjugator.fragments;

import static com.example.Constant.QURAN_VERB_ROOT;
import static com.example.Constant.QURAN_VERB_WAZAN;
import static com.example.Constant.VERBMOOD;
import static com.example.Constant.VERBTYPE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.chip.Chip;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.MainActivity;
import org.sj.conjugator.activity.ConjugatorTabsActivity;
import org.sj.conjugator.adapter.MujarradSarfSagheerListingAdapter;
import org.sj.conjugator.adapter.SarfMujarradSarfSagheerListingAdapter;
import org.sj.conjugator.utilities.GatherAll;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import database.DatabaseUtils;
import database.entity.MujarradVerbs;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class RulesMujarradVerbList extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "PermissionDemo";
    private final ArrayList sarfSagheerMazeedArray = new ArrayList();
    PopupWindow popupWindowLists;
    Chip buttonShowDropDown;
    String verbmood, verbtype;
    Context context;
    ArrayList<SarfSagheer> ssagheer = new ArrayList<>();
    RecyclerView recyclerView;
    //   private ArrayList sarfSagheerThulathiArray = new ArrayList();
    ArrayList<ArrayList> sarfSagheerThulathiArray = new ArrayList<>();
    private Spinner mujarradspinner;
    // --Commented out by Inspection (13/6/21 6:52 PM):private NavigationView navigationView;
    // --Commented out by Inspection (13/6/21 6:51 PM):private BottomNavigationView bottomNavigationView;
    ///  private MazeedFihiAdapter mazeedFiHiAdapter;
    private MujarradSarfSagheerListingAdapter sarfsagheer;
    private SarfMujarradSarfSagheerListingAdapter sarfsagheerAdapter;

    public RulesMujarradVerbList(Context context) {
        this.context = context;
    }

    public RulesMujarradVerbList() {
    }

    public RulesMujarradVerbList(MainActivity context) {
        this.context = context;
    }
    // --Commented out by Inspection (13/6/21 6:51 PM):Button llPdf;

    public String getVerbtype() {
        return verbtype;
    }

    public void setVerbtype(String verbtype) {
        this.verbtype = verbtype;
    }

    public String getVerbmood() {
        return verbmood;
    }

    public void setVerbmood(String verbmood) {
        this.verbmood = verbmood;
    }
    // --Commented out by Inspection (13/6/21 6:51 PM):private Bitmap bitmap;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.thulathilistingnotoolbar, container, false);
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        //  String theme = sharedPreferences.getString("theme", 1);
        String indictive = sharedPreferences.getString(VERBMOOD, "Indicative");
        setVerbmood(indictive);
        FloatingTextButton callButton = view.findViewById(R.id.action_buttons);
        recyclerView = view.findViewById(R.id.sarfrecview);
        if (getArguments() != null) {
            String rule = getArguments().getString(QURAN_VERB_WAZAN);
            MujarradListing(ssagheer, rule);
        } else {
            MujarradListing(ssagheer, String.valueOf(24));

        }
        return view;
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //  recyclerView.setAdapter(sarfsagheerAdapter);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void MujarradListing(ArrayList<SarfSagheer> ssagheer, String kov) {
        setVerbtype("mujarrad");
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_verblist);
        dialog = builder.create();
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.execute(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.show();
                    }
                });
                DatabaseUtils utils = new DatabaseUtils(QuranGrammarApplication.getContext());
                ArrayList<MujarradVerbs> mujarradBYWeakness = utils.getMujarradBYWeakness(kov);
                listingMujarradWeakness(ssagheer, mujarradBYWeakness);
                setVerbtype("mujarrad");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ex.shutdown();
                        sarfsagheerAdapter = new SarfMujarradSarfSagheerListingAdapter(ssagheer, getActivity());
                        recyclerView.setAdapter(sarfsagheerAdapter);
                        setupOnItemClickThulathiAdapter();
                        dialog.dismiss();

                    }
                });

            }
        });
        //   setupOnItemClickThulathiAdapter();
    }

    private void listingMujarradWeakness(ArrayList<SarfSagheer> ssagheer, ArrayList<MujarradVerbs> mujarradBYWeakness) {
        for (MujarradVerbs s : mujarradBYWeakness) {
            ArrayList<ArrayList> listing = GatherAll.getInstance().getMujarradListing(getVerbmood(), s.getRoot());
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
            ss.setZarfone(listing.get(0).get(13).toString());
            ss.setZarftwo(listing.get(0).get(15).toString());
            ss.setZarfthree(listing.get(0).get(16).toString());
            ss.setVerbtype(listing.get(0).get(17).toString());
            ss.setWazan(listing.get(0).get(18).toString());
      /*
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

      ss.setZarfone(listing.get(0).get(13).toString());
      ss.setZarftwo(listing.get(0).get(15).toString());
      ss.setZarfthree(listing.get(0).get(16).toString());
      ss.setVerbtype(listing.get(0).get(17).toString());
      ss.setWazan(listing.get(0).get(18).toString());
      */
            ssagheer.add(ss);
        }
    }

    private void setupOnItemClickThulathiAdapter() {
        sarfsagheerAdapter.SetOnItemClickListener((v, position) -> {
            SarfSagheer arrayList = ssagheer.get(position);
            ArrayList<String> rootParadigm = new ArrayList<>();
            Bundle dataBundle = new Bundle();
            if (v.findViewById(R.id.conjugateall) != null) {
                //  rootParadigm = Harakah.getMujarradRootParadigm(arrayList);
                // dataBundle.putString(QURAN_VERB_WAZAN, arrayList.get(2));
                dataBundle.putString(QURAN_VERB_WAZAN, arrayList.getWazan());
                dataBundle.putString(QURAN_VERB_ROOT, arrayList.getVerbroot());
                dataBundle.putString(VERBTYPE, arrayList.getVerbtype());
                dataBundle.putString(VERBMOOD, getVerbmood());
                Intent intent = new Intent(getActivity(), ConjugatorTabsActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);

            }

        });
    }

}