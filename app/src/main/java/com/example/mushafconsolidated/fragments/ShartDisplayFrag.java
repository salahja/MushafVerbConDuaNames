package com.example.mushafconsolidated.fragments;

import static com.example.Constant.BYELLOW;
import static com.example.Constant.GOLD;
import static com.example.Constant.GREENDARK;

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

import com.example.mushafconsolidated.Adapters.ShartAdapter;
import com.example.mushafconsolidated.Entities.ShartPOJO;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ShartDisplayFrag extends Fragment {
    List<SpannableStringBuilder> kanaExpandableListDetail;
    private RecyclerView recyclerView;
    //   private RecyclerView.Adapter ParentAdapter;
    private ShartAdapter shartAdapter;
    //  SurahDisplayAdapter ParentAdapter;
    private OnItemClickListener mItemClickListener;
    private RecyclerView.LayoutManager layoutManager;

    public ShartDisplayFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShartDisplayFrag newInstance() {
        ShartDisplayFrag fragment = new ShartDisplayFrag();
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
        //   ExpandableListData expandableListData=new ExpandableListData(chapterid,ayanumber,corpusSurahWord,utils);
        //   kanaExpandableListDetail=   expandableListData .getKana();
        final ArrayList<ShartPOJO> sifabySurahAll = utils.getSharts();
        for (ShartPOJO shart : sifabySurahAll) {
            SpannableStringBuilder spannableverse = new SpannableStringBuilder(shart.getQurantext());
            try {
                spannableverse.setSpan(new ForegroundColorSpan(GOLD), shart.getIndexstart(), shart.getIndexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(BYELLOW), shart.getShartindexstart(), shart.getShartindexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(GREENDARK), shart.getJawabshartindexstart(), shart.getJawabshartindexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setShartAdapter(new ShartAdapter(getContext(), sifabySurahAll));
        getRecyclerView().setAdapter(getShartAdapter());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getRecyclerView().setAdapter(getShartAdapter());
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        Utils utils = new Utils(getContext());
        final ArrayList<ShartPOJO> all = utils.getSharts();
        for (ShartPOJO shart : all) {
            SpannableStringBuilder spannableverse = new SpannableStringBuilder(shart.getQurantext());
            try {
                spannableverse.setSpan(new ForegroundColorSpan(GOLD), shart.getIndexstart(), shart.getIndexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(BYELLOW), shart.getShartindexstart(), shart.getShartindexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);
                spannableverse.setSpan(new ForegroundColorSpan(GREENDARK), shart.getJawabshartindexstart(), shart.getJawabshartindexend(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                shart.setSpannedverse(spannableverse);

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
        setRecyclerView(view.findViewById(R.id.RecyclerView));
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().setLayoutManager(getLayoutManager());
        setShartAdapter(new ShartAdapter(getContext(), all));
        getRecyclerView().setAdapter(getShartAdapter());
        getRecyclerView().setLayoutManager(getLayoutManager());
        getShartAdapter().SetOnItemClickListener((v, position) -> {
            //   Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
        });

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public ShartAdapter getShartAdapter() {
        return shartAdapter;
    }

    public void setShartAdapter(ShartAdapter shartAdapter) {
        this.shartAdapter = shartAdapter;
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