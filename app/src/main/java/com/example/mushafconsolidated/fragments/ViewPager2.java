package com.example.mushafconsolidated.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPager2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPager2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    androidx.viewpager2.widget.ViewPager2 viewPagertwo;
    Utils util;
    Context context;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewPager2(Context context) {
        this.context = context;
    }

    public ViewPager2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ViewPager2 newInstance(String param1, String param2) {
        ViewPager2 fragment = new ViewPager2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_view_pager2, container, false);
        viewPagertwo = view.findViewById(R.id.view_pagers);
//
        util = new Utils(context);
        ArrayList<ChaptersAnaEntity> surahArrayList = util.getAllAnaChapters();
// viewPager2.setAdapter(new OrignalPager(this, list, viewPager2));
//  viewPager2.setAdapter(new ViewPagerAdapter(this, list, viewPager2));
        //   viewPagertwo.setAdapter(new ViewPagerAdapter((MainActivity) context, surahArrayList, viewPagertwo));
        return view;
    }
}