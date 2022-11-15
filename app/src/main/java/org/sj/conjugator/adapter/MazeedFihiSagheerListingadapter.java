package org.sj.conjugator.adapter;

import static android.view.View.GONE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.chip.Chip;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.interfaces.OnItemClickListener;
import org.sj.conjugator.utilities.SharedPref;

import java.util.ArrayList;

public class MazeedFihiSagheerListingadapter extends RecyclerView.Adapter<MazeedFihiSagheerListingadapter.MufradatViewHolder> {
    private final Context context;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private int arabic_font_size;
    private int urdu_font_size;
    private String arabic_font_selection;
    private ArrayList<ArrayList> sarfSagheer = new ArrayList<>();
    private String ScreensizeName;

    public MazeedFihiSagheerListingadapter(ArrayList<ArrayList> lists, Context context) {
        this.context = context;
        this.sarfSagheer = lists;

    }

    public MazeedFihiSagheerListingadapter(boolean mazeedregular, ArrayList sarfSagheer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = sarfSagheer;
        this.mazeedregular = mazeedregular;

    }

    public MufradatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //   View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mufradat_ayah_list_row, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mazeedsarfsagheer, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathitable, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        MufradatViewHolder viewHolder = new MufradatViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NotNull MufradatViewHolder holder, int position) {
        //  final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray();
        //    final Object[] toArray = sarfSagheer.get(position).toArray();
        final ArrayList toArray = sarfSagheer.get(position);
        final int length = toArray.size();
        Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        Integer fontsize = SharedPref.arabicFontsize();
        //   final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "me_quran.ttf");
        // final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "NooreHuda.ttf");
        //    final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        //  final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "Monteserrat.ttf");
        holder.conjugate.setText("Conjugate All");
        holder.conjugate.setTextSize(fontsize);
        holder.conjugate.setTypeface(mequran);
        holder.ismalaheader.setVisibility(GONE);
        holder.ismala.setVisibility(GONE);
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String width = sharedPreferences.getString("width", "compactWidth");
        final Integer arabicFontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        if (length == 11) {
            int ind = 0;
            String s;
            holder.rootword.setText((CharSequence) toArray.get(2));
            holder.weaknessname.setText((CharSequence) toArray.get(0));
            holder.babno.setText((CharSequence) toArray.get(1));
            holder.mamaroof.setText((CharSequence) toArray.get(2));
            holder.mamajhool.setText((CharSequence) toArray.get(3));
            holder.mumaroof.setText((CharSequence) toArray.get(3));
            holder.mumajhool.setText((CharSequence) toArray.get(4));
            holder.amr.setText((CharSequence) toArray.get(6));
            holder.nahiamr.setText((CharSequence) toArray.get(7));
            holder.ismfail.setText((CharSequence) toArray.get(8));
            holder.ismmafool.setText((CharSequence) toArray.get(9));
            //  holder.ismala.setText((CharSequence) toArray.get(10));
            //  holder.ismzarf.setText((CharSequence) toArray.get(11));
//        final CharSequence  cs9 = (CharSequence) toArray.get(9);
            //    final CharSequence  cs10 = (CharSequence) toArray.get(10);
            //    FontSizeSelection(holder);
            //  final String fontSelection = SharedPref.arabicFontSelection();
            holder.mamaroof.setTextSize(fontsize);
            holder.mumaroof.setTextSize(fontsize);
            holder.masdaro.setTextSize(fontsize);
            holder.masdart.setTextSize(fontsize);
            holder.ismfail.setTextSize(fontsize);
            holder.mamajhool.setTextSize(fontsize);
            holder.mumajhool.setTextSize(fontsize);
            holder.ismmafool.setTextSize(fontsize);
            holder.amr.setTextSize(fontsize);
            holder.nahiamr.setTextSize(fontsize);
            holder.babno.setTextSize(fontsize);
            holder.babno.setTextColor(Color.YELLOW);
            holder.rootword.setTextSize(fontsize);
            holder.rootword.setTextColor(Color.BLUE);
            holder.weaknessname.setTextSize(fontsize);
            holder.weaknessname.setTextColor(Color.GREEN);
            holder.mamaroof.setTypeface(mequran);
            holder.mumaroof.setTypeface(mequran);
            holder.masdaro.setTypeface(mequran);
            holder.masdart.setTypeface(mequran);
            holder.ismfail.setTypeface(mequran);
            holder.mamajhool.setTypeface(mequran);
            holder.mumajhool.setTypeface(mequran);
            holder.ismmafool.setTypeface(mequran);
            holder.amr.setTypeface(mequran);
            holder.nahiamr.setTypeface(mequran);
            holder.babno.setTypeface(mequran);
            holder.babno.setTextColor(Color.YELLOW);
            holder.rootword.setTypeface(mequran);
            holder.rootword.setTextColor(Color.BLUE);
            holder.weaknessname.setTypeface(mequran);
            holder.weaknessname.setTextColor(Color.GREEN);
            holder.mamaroof.setText((CharSequence) toArray.get(0));
            holder.mumaroof.setText((CharSequence) toArray.get(1));
            holder.masdaro.setText((CharSequence) toArray.get(8));
            holder.masdart.setText((CharSequence) toArray.get(8));
            holder.ismfail.setText((CharSequence) toArray.get(2));
            holder.mamajhool.setText((CharSequence) toArray.get(3));
            holder.mumajhool.setText((CharSequence) toArray.get(4));
            holder.ismmafool.setText((CharSequence) toArray.get(5));
            holder.ismzarf.setText((CharSequence) toArray.get(5));
            FontSizeSelection(holder);

        }

    }

    private void FontSizeSelection(@NotNull MufradatViewHolder holder) {
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String width = sharedPreferences.getString("width", "compactWidth");
        final Integer fontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        if (width.equals("mediumWidth") || width.equals("expandedWidth")) {
            holder.mamaroof.setTextSize(fontsize);
            holder.mumaroof.setTextSize(fontsize);
            holder.masdaro.setTextSize(fontsize);
            holder.masdart.setTextSize(fontsize);
            holder.ismfail.setTextSize(fontsize);
            holder.mamajhool.setTextSize(fontsize);
            holder.mumajhool.setTextSize(fontsize);
            holder.ismmafool.setTextSize(fontsize);
            holder.amr.setTextSize(fontsize);
            holder.nahiamr.setTextSize(fontsize);
            holder.babno.setTextSize(fontsize);
            holder.babno.setTextColor(Color.YELLOW);
            holder.rootword.setTextSize(fontsize);
            holder.rootword.setTextColor(Color.BLUE);
            holder.weaknessname.setTextSize(fontsize);
            holder.weaknessname.setTextColor(Color.GREEN);
        }
    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return sarfSagheer.get(position).size();
    }

    public Object getItem(int position) {
        return sarfSagheer.get(position);
    }

    @Override
    public int getItemCount() {
        return sarfSagheer.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setVerbArrayList(ArrayList<ArrayList> sarfsagheer) {
        this.sarfSagheer = sarfsagheer;
    }

    public class MufradatViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        //  public final TextView ayah_number;
        public final Chip amr, nahiamr, ismfail, masdaro, mumaroof, mamaroof, ismalaheader, ismala,
                ismmafool, masdart, mumajhool, mamajhool, ismzarf, babno, conjugate, rootword, weaknessname;

        public MufradatViewHolder(View view) {
            super(view);
            ismalaheader = view.findViewById(R.id.ismalaheader);
            ismala = view.findViewById(R.id.ismaalatable);
            ismfail = view.findViewById(R.id.ismfail);
            masdaro = view.findViewById(R.id.masdar);
            mumaroof = view.findViewById(R.id.mumaroof);
            mamaroof = view.findViewById(R.id.mamaroof);
            ismmafool = view.findViewById(R.id.ismmafool);
            masdart = view.findViewById(R.id.masdar2);
            mumajhool = view.findViewById(R.id.mumajhool);
            mamajhool = view.findViewById(R.id.mamajhool);
            amr = view.findViewById(R.id.amr);
            nahiamr = view.findViewById(R.id.nahiamr);
            conjugate = view.findViewById(R.id.conjugateall);
            ismzarf = view.findViewById(R.id.zarftable);
            babno = view.findViewById(R.id.babno);
            rootword = view.findViewById(R.id.rootword);
            weaknessname = view.findViewById(R.id.weknessname);
            mumajhool.setTooltipText("Click for Verb Conjugation");
            view.setOnClickListener(this);
            //    ismfail.setOnClickListener(this);//R.id.ismfail);
//
            //   mumaroof.setOnClickListener(this);//R.id.mumaroof);
            //  mamaroof.setOnClickListener(this);//R.id.mamaroof);
            //  ismmafool.setOnClickListener(this);//R.id.ismmafool);
            //  mumajhool.setOnClickListener(this);//R.id.mumajhool);
            // // mamajhool.setOnClickListener(this);//R.id.mamajhool);
            //   amr.setOnClickListener(this);//R.id.amr);
            //  nahiamr.setOnClickListener(this);//R.id.nahiamr);
            // ismzarf.setOnClickListener(this);//R.id.zarftable);
            conjugate.setOnClickListener(this);//R.id.zarftable);
            //view.setOnClickListener(this); // current clickListerner
            view.setOnClickListener(this); // current clickListerner
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }
}





