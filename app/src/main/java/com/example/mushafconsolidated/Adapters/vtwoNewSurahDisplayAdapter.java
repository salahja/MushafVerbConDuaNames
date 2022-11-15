package com.example.mushafconsolidated.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.QuranGrammarApplication;
import com.example.utility.SharedPref;

import java.util.ArrayList;
import java.util.List;

//public class VerseDisplayAdapter extends RecyclerView.Adapter<VerseDisplayAdapter.ItemViewAdapter> {
//public class SurahPartAdap extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
public class vtwoNewSurahDisplayAdapter extends RecyclerView.Adapter<vtwoNewSurahDisplayAdapter.ItemViewAdapter> {
    private static final String TAG = "SurahPartAdap ";
    OnItemClickListener mItemClickListener;
    private List<ChaptersAnaEntity> listonearray = new ArrayList<>();
    private List<ChaptersAnaEntity> listtwoarray = new ArrayList<>();
    private final Context context;
    private String surahname;

    public vtwoNewSurahDisplayAdapter(Context context, ArrayList<ChaptersAnaEntity> allAnaChapters) {
        this.context = context;
        this.listonearray = allAnaChapters;

    }

    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surarowlinear, parent, false);
        // view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orignalsurarowlinear, parent, false);
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_main_surah_row, parent, false);
        return new ItemViewAdapter(view, viewType);

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull vtwoNewSurahDisplayAdapter.ItemViewAdapter holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final ChaptersAnaEntity surah = listonearray.get(position);
        Context context = QuranGrammarApplication.getContext();
        SharedPreferences pref = context.getSharedPreferences("lastread", MODE_PRIVATE);
        int chapterno = pref.getInt("surah", 1);
        int verse_no = pref.getInt("ayah", 1);
        SharedPref sharedPref = new SharedPref(context);
        final String isNightmode = SharedPref.themePreferences();
        TypedArray imgs = this.context.getResources().obtainTypedArray(R.array.sura_imgs);
        TypedArray array = imgs;
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        String theme = sharedPreferences.getString("themepref", "dark");
        StringBuilder sb = new StringBuilder();
        sb.append(surah.getChapterid());
        sb.append(":");
        sb.append(surah.getNameenglish());
        StringBuilder sbs = new StringBuilder();
        sbs.append(surah.getChapterid());
        //    sbs.append(surahright.getChapterid());
        //  sbs.append(":");
        //  sbs.append(surahright.getNameenglish());
        //   int surahrightIsmakki = surahright.getIsmakki();
        int surahIsmakki = surah.getIsmakki();
        int cno = surah.getChapterid();
        holder.tvnumber.setText(sbs);
        holder.tvarabic.setText(surah.getAbjadname());
        holder.tvenglish.setText(surah.getNameenglish());
        final Drawable drawable = imgs.getDrawable(cno - 1);
        holder.ivsurahicon.setImageDrawable(drawable);
        if (surahIsmakki == 1) {
            holder.makkimadaniIcon.setImageResource(R.drawable.ic_makkah_foreground);
        } else {
            holder.makkimadaniIcon.setImageResource(R.drawable.ic_madinah_foreground);
        }

/*
    if (theme.equals("dark")) {
      holder.surahcardview.setCardBackgroundColor(context.getResources().getColor(R.color.color_background_overlay));


    } else if (theme.equals("blue")) {
      holder.surahcardview.setCardBackgroundColor(context.getResources().getColor(R.color.solarizedBase02));

    }
 */
        if (theme.equals("dark") || theme.equals("blue")) {
            holder.makkimadaniIcon.setColorFilter(Color.CYAN);
            holder.ivsurahicon.setColorFilter(Color.CYAN);
        } else {
            holder.makkimadaniIcon.setColorFilter(Color.BLUE);
            holder.ivsurahicon.setColorFilter(Color.BLACK);
        }
        holder.tvarabic.setTextSize(SharedPref.SeekarabicFontsize());

    }

    @Override
    public int getItemViewType(int position) {
        return listonearray.get(position).getPart_no();

    }

    @Override
    public int getItemCount() {
        return listonearray.size();
    }

    public Object getItem(int position) {
        return listonearray.get(position);
    }

    public void setUp(List<ChaptersAnaEntity> listone, List<ChaptersAnaEntity> listtwo) {
        this.listonearray = listone;
        this.listtwoarray = listtwo;

    }

    public void setUp(ArrayList<ChaptersAnaEntity> allAnaChapters) {
        this.listonearray = allAnaChapters;
    }

    public class ItemViewAdapter extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public TextView tvnumber, tvsurahright, tvarabic, tvenglish;
        public TextView overlayTypeChapterView, overlayTypePartView;
        public TextView surah_name_arabic;
        // CardView surahcardview;
        public TextView referenceview;
        public RelativeLayout row_surah;
        //   public ConstraintLayout surah_row_table;///for rnew_surah_row
        public LinearLayout surah_row_table;
        ImageView makkimadaniIcon;
        ImageView ivsurahicon, tvarabicright;

        ItemViewAdapter(View layout, int viewType) {
            super(layout);
            //   surahcardview = itemView.findViewById(R.id.surahcardview);
            tvenglish = itemView.findViewById(R.id.tvenglish);
            tvnumber = itemView.findViewById(R.id.tvNumber);
            tvsurahright = itemView.findViewById(R.id.tvSuraright);
            tvarabic = itemView.findViewById(R.id.tvArabic);
            makkimadaniIcon = itemView.findViewById(R.id.makkimadaniicon);
            //  overlayTypeChapterView = itemView.findViewById(R.id.overlayTypeChapterView);
            ivsurahicon = itemView.findViewById(R.id.surahicon);
            //  overlayTypeChapterView.setOnClickListener(this);
            // overlayTypePartView.setOnClickListener(this);
            layout.setOnClickListener(this); // current clickListerner

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());

            }
        }
    }

}