package com.example.mushafconsolidated.fragments;

import static com.example.Constant.BYELLOW;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Adapters.SifaAdapter;
import com.example.mushafconsolidated.Entities.SifaPOJO;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;

public class SIfaDisplayFrag extends Fragment {
    private RecyclerView recyclerView;
    //   private RecyclerView.Adapter ParentAdapter;
    private SifaAdapter sifaAdapter;
    //  SurahDisplayAdapter ParentAdapter;
    private OnItemClickListener mItemClickListener;
    private RecyclerView.LayoutManager layoutManager;

    public SIfaDisplayFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SIfaDisplayFrag newInstance() {
        SIfaDisplayFrag fragment = new SIfaDisplayFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reccylerview, container, false);
        Utils utils = new Utils(getContext());
        final ArrayList<SifaPOJO> sifabySurahAll = utils.getMousufSIfa();
        for (SifaPOJO sifa : sifabySurahAll) {
            SpannableStringBuilder str = new SpannableStringBuilder(sifa.getQurantext());
            try {
                str.setSpan(new ForegroundColorSpan(BYELLOW), sifa.getStartindex(), sifa.getEndindex(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                sifa.setSpannedverse(str);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println(sifa.getSurah() + "," + sifa.getAyah() + "," + sifa.getWordno());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setSifaAdapter(new SifaAdapter(getContext(), sifabySurahAll));
        getRecyclerView().setAdapter(getSifaAdapter());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getRecyclerView().setAdapter(getSifaAdapter());
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        Utils utils = new Utils(getContext());
        final ArrayList<SifaPOJO> all = utils.getMousufSIfa();
        for (SifaPOJO sifa : all) {
            SpannableStringBuilder str = new SpannableStringBuilder(sifa.getQurantext());
            try {
                str.setSpan(new ForegroundColorSpan(BYELLOW), sifa.getStartindex(), sifa.getEndindex(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                sifa.setSpannedverse(str);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(sifa.getSurah() + "," + sifa.getAyah() + "," + sifa.getWordno() + "," +
                        sifa.getStartindex() + "," + sifa.getEndindex());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setSifaAdapter(new SifaAdapter(getContext(), all));
        getRecyclerView().setAdapter(getSifaAdapter());
        getRecyclerView().setLayoutManager(getLayoutManager());

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public SifaAdapter getSifaAdapter() {
        return sifaAdapter;
    }

    public void setSifaAdapter(SifaAdapter sifaAdapter) {
        this.sifaAdapter = sifaAdapter;
    }

    public OnItemClickListener getmItemClickListener() {
        return mItemClickListener;
    }

    public void setmItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

}