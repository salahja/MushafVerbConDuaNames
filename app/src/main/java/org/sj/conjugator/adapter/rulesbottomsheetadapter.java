package org.sj.conjugator.adapter;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import org.jetbrains.annotations.NotNull;
import org.sj.conjugator.interfaces.OnItemClickListener;

import java.util.ArrayList;

import database.entity.kov;

public class rulesbottomsheetadapter extends RecyclerView.Adapter<rulesbottomsheetadapter.ViewHolder> {
    private final Context context;
    private final ArrayList<String> madhi = new ArrayList<>();
    int rootcolor, weaknesscolor, wazancolor;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    String ismzaftitle = "(الْظَرْف:)";
    String ismalatitle = "( الآلَة:)";
    String alaheader = "اِسْم الآلَة";
    String zarfheader = "اِسْم الْظَرفْ";
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private int quran_arabic_font;
    private int urdu_font_size;
    private String arabic_font_selection;
    private ArrayList<kov> kovArrayList = new ArrayList<>();

    public rulesbottomsheetadapter(ArrayList<kov> lists, Context context) {
        this.context = context;
        this.kovArrayList = lists;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rules, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        //  final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray.get();
        SharedPreferences shared = getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String preferences = shared.getString("theme", "dark");
        int cweakness = 0;
        int crootword = 0;
        final int cbabcolor;
        kov toArray = kovArrayList.get(position);
        //  final Object[] toArray.get = sarfSagheer.get(position).toArray.get();
        //  final ArrayList arrayList = (ArrayList) sarfSagheer.get(position).get(position);
        // final Typeface mequran = Typeface.createFromAsset(context.getAssets(), shared.getString("arabic_font_category","me_quran.tff"));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String fonts = prefs.getString("Arabic_Font_Size", "25");
        //  String arabic_font_category = prefs.getString("arabic_font_category", "kitab.tff");
        Typeface mequran = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), "Taha.ttf");
        final Integer arabicFontsize = Integer.valueOf(fonts);
        //    holder.rulenumber.setTextSize(arabicFontsize);
        holder.rulenumber.setText(toArray.getRulename() + "(" + toArray.getExample() + ")"
                //    holder.rulenumber.setTextSize(arabicFontsize);
        );
        holder.rulenumber.setTextSize(arabicFontsize);
        holder.rulenumber.setTypeface(mequran);

    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return kovArrayList.size();
    }

    public Object getItem(int position) {
        return kovArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return kovArrayList.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setVerbArrayList(ArrayList<kov> sarfsagheer) {
        this.kovArrayList = sarfsagheer;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public final TextView rulenumber, rulename;

        public ViewHolder(View view) {
            super(view);
            //    itemView.setTag(this);
            //     itemView.setOnClickListener(onItemClickListener);
            rulenumber = view.findViewById(R.id.tvKovNumber);
            rulename = view.findViewById(R.id.tvKovName);
            view.setOnClickListener(this);
            rulename.setOnClickListener(this);
            //  mumaroof.setOnClickListener(this);//R.id.mumaroof);
            //  mamaroof.setOnClickListener(this);//R.id.mamaroof);
            //   ismmafool.setOnClickListener(this);//R.id.ismmafool);
            //   mumajhool.setOnClickListener(this);//R.id.mumajhool);
            //   mamajhool.setOnClickListener(this);//R.id.mamajhool);
            //   amr.setOnClickListener(this);//R.id.amr);
            //   nahiamr.setOnClickListener(this);//R.id.nahiamr);
            //    ismala.setOnClickListener(this);//R.id.ismaalatable);
            //    ismzarf.setOnClickListener(this);//R.id.zarftable);
            //      rootword.setOnClickListener(this);//R.id.weaknesstype);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }

}

