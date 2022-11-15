package com.example.mushafconsolidated.fragments;

import static com.example.Constant.BYELLOW;
import static com.example.Constant.GOLD;
import static com.example.Constant.GREENDARK;

import android.content.Intent;
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
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Activity.QuranGrammarAct;
import com.example.mushafconsolidated.Adapters.KanaAdapter;
import com.example.mushafconsolidated.Entities.KanaPOJO;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;

public class KanaDisplayFrag extends DialogFragment implements IOnBackPressed {
    ArrayList<SpannableStringBuilder> sharts = new ArrayList<>();
    private RecyclerView recyclerView;
    //   private RecyclerView.Adapter ParentAdapter;
    private KanaAdapter kanaAdapter;
    //  SurahDisplayAdapter ParentAdapter;
    private OnItemClickListener mItemClickListener;
    private RecyclerView.LayoutManager layoutManager;

    public KanaDisplayFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KanaDisplayFrag newInstance() {
        KanaDisplayFrag fragment = new KanaDisplayFrag();
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
        final ArrayList<KanaPOJO> sifabySurahAll = utils.getKanaPojo();
        for (KanaPOJO shart : sifabySurahAll) {
            SpannableStringBuilder spannableverse = new SpannableStringBuilder(shart.getQurantext());
            int shartAyah = shart.getAyah();
            try {
                spannableverse.setSpan(new ForegroundColorSpan(GOLD), shart.getIndexstart(), shart.getIndexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(BYELLOW), shart.getKhabarstart(), shart.getKhabarend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(GREENDARK), shart.getIsmkanastart(), shart.getIsmkanaend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setKanaAdapter(new KanaAdapter(getContext(), sifabySurahAll));
        getRecyclerView().setAdapter(getKanaAdapter());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getRecyclerView().setAdapter(getKanaAdapter());
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        Utils utils = new Utils(getContext());
        final ArrayList<KanaPOJO> all = utils.getKanaPojo();
        for (KanaPOJO shart : all) {
            SpannableStringBuilder spannableverse = new SpannableStringBuilder(shart.getQurantext());
            try {
                spannableverse.setSpan(new ForegroundColorSpan(GOLD), shart.getIndexstart(), shart.getIndexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(BYELLOW), shart.getKhabarstart(), shart.getKhabarend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(GREENDARK), shart.getIsmkanastart(), shart.getIsmkanaend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setKanaAdapter(new KanaAdapter(getContext(), all));
        getRecyclerView().setAdapter(getKanaAdapter());
        getRecyclerView().setLayoutManager(getLayoutManager());
        getKanaAdapter().SetOnItemClickListener((v, position) -> {
            //   Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
        });

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public KanaAdapter getKanaAdapter() {
        return kanaAdapter;
    }

    public void setKanaAdapter(KanaAdapter kanaAdapter) {
        this.kanaAdapter = kanaAdapter;
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

    @Override
    public boolean onBackPressed() {
        Intent in = new Intent(getActivity(), QuranGrammarAct.class);
        startActivity(in);
        return true;

    }
}