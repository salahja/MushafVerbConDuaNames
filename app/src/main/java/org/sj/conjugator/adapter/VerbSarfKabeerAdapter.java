package org.sj.conjugator.adapter;

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

import org.sj.conjugator.interfaces.OnItemClickListener;
import org.sj.conjugator.utilities.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class VerbSarfKabeerAdapter extends RecyclerView.Adapter<VerbSarfKabeerAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<String> madhi = new ArrayList<>();
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private ArrayList<ArrayList> sarfSagheer;
    private Typeface arabicTypeface;

    public VerbSarfKabeerAdapter(ArrayList<ArrayList> lists, Context context) {
        this.context = context;
        this.sarfSagheer = lists;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        Boolean aBoolean = prefs.getBoolean("sarfkabeer_format_verb", true);
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view;
        if (aBoolean) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verbsarfkabeertraditional, parent, false);
        } else {
            //  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test ,parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verbscolumnkabeer, parent, false);

        }
        //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

/*
    public void onBindViewHolder(ViewHolder holder, int position) {
        //  final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray();
        //   ArrayList list = sarfSagheer.get(position);
        //    position++;
        MadhiMaroof(holder, 0);
        MudhariMaroof(holder, 1);
        MadhiMajhool(holder, 2);
        MudhariMajhool(holder, 3);
        Amar(holder, 4);

    }
*/

    public void onBindViewHolder(ViewHolder holder, int position) {
        final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray();
        //   ArrayList list = sarfSagheer.get(position);
        //    position++;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String font_category = prefs.getString("Arabic_Font_Selection", "kitab.tff");
        // String quranverses = corpusSurahWord.get(0).getQurantext();
        String jumlashart = "جملة شرطية";
        StringBuilder sb = new StringBuilder();
        StringBuilder sbjawab = new StringBuilder();
        //   String verse = jumlashart.concat(":" + quranverses);
        //  this.spannable = new SpannableStringBuilder(quranverses);
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String indictive = sharedPreferences.getString("Arabic_Font_Selection", "kitab.ttf");
        arabicTypeface = Typeface.createFromAsset(context.getAssets(), indictive);
        //  SharedPref sharedPref=new SharedPref(DarkThemeApplication.getContext());
        //   arabicTypeface = Typeface.createFromAsset(context.getAssets(), sharedPref.arabicFontSelection());
        //   MadhiMaroof(holder, 8);
        //    MudhariMaroof(holder, 9);
        ///   MadhiMajhool(holder, 10);
        //    MudhariMajhool(holder, 11);
        //  Amar(holder, 4);
        //     AmarNahi(holder, 5);
        //    pronouns(holder);
        //   MadhiMaroof(holder, 0);
        //  MudhariMaroof(holder, 2);
        //  MadhiMajhool(holder, 1);
        //  MudhariMajhool(holder, 3);
        //  Amar(holder, 4);
        //  AmarNahi(holder, 5);
        //  pronouns(holder);
        MadhiMaroof(holder, 0);
        MudhariMaroof(holder, 2);
        MadhiMajhool(holder, 1);
        MudhariMajhool(holder, 3);
        Amar(holder, 4);
        AmarNahi(holder, 5);
        pronouns(holder);

    }

    private void pronouns(ViewHolder holder) {
        String[] array = context.getResources().getStringArray(R.array.arabicpronouns);
        holder.huaid.setText(array[0]);
        holder.humamid.setText(array[1]);
        holder.humid.setText(array[2]);
        holder.hiaid.setText(array[3]);
        holder.humafid.setText(array[4]);
        holder.hunnaid.setText(array[5]);
        holder.antaid.setText(array[6]);
        holder.antumamid.setText(array[7]);
        holder.antumid.setText(array[8]);
        holder.antiid.setText(array[9]);
        holder.antumafid.setText(array[10]);
        holder.antunnaid.setText(array[11]);
        holder.anaid.setText(array[12]);
        holder.nahnuid.setText(array[13]);
        holder.huaid.setTypeface(arabicTypeface);//(array[0]);
        holder.humamid.setTypeface(arabicTypeface);//(array[1]);
        holder.humid.setTypeface(arabicTypeface);//(array[2]);
        holder.hiaid.setTypeface(arabicTypeface);//(array[3]);
        holder.humafid.setTypeface(arabicTypeface);//(array[4]);
        holder.hunnaid.setTypeface(arabicTypeface);//(array[5]);
        holder.antaid.setTypeface(arabicTypeface);//(array[6]);
        holder.antumamid.setTypeface(arabicTypeface);//(array[7]);
        holder.antumid.setTypeface(arabicTypeface);//(array[8]);
        holder.antiid.setTypeface(arabicTypeface);//(array[9]);
        holder.antumafid.setTypeface(arabicTypeface);//(array[10]);
        holder.antunnaid.setTypeface(arabicTypeface);//(array[11]);
        holder.anaid.setTypeface(arabicTypeface);//(array[12]);
        holder.nahnuid.setTypeface(arabicTypeface);//(array[13]);

    }

    private void AmarNahi(ViewHolder holder, int position) {
        String anta, antuma, antum, anti, antumaf, antunna;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[10]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            antunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");

        } else {
            anta = sarfSagheer.get(position).get(0).toString();
            antuma = sarfSagheer.get(position).get(2).toString();
            antum = sarfSagheer.get(position).get(3).toString();
            anti = sarfSagheer.get(position).get(1).toString();
            antumaf = sarfSagheer.get(position).get(2).toString();
            antunna = sarfSagheer.get(position).get(4).toString();

        }
        holder.nahiamranta.setTypeface(arabicTypeface);
        holder.nahiamrantuma.setTypeface(arabicTypeface);
        holder.nahiamrantum.setTypeface(arabicTypeface);
        holder.nahiamranti.setTypeface(arabicTypeface);
        holder.nahiamrantumaf.setTypeface(arabicTypeface);
        holder.nahiamrantunna.setTypeface(arabicTypeface);
        holder.nahiamranta.setText(anta);
        holder.nahiamrantuma.setText(antuma);
        holder.nahiamrantum.setText(antum);
        holder.nahiamranti.setText(anti);
        holder.nahiamrantumaf.setText(antumaf);
        holder.nahiamrantunna.setText(antunna);

    }

    private void Amar(ViewHolder holder, int position) {
        String anta, antuma, antum, anti, antumaf, antunna;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            antunna = sb.toString();

        } else {
            anta = sarfSagheer.get(position).get(0).toString();
            antuma = sarfSagheer.get(position).get(2).toString();
            antum = sarfSagheer.get(position).get(3).toString();
            anti = sarfSagheer.get(position).get(1).toString();
            antumaf = sarfSagheer.get(position).get(2).toString();
            antunna = sarfSagheer.get(position).get(4).toString();

        }
        holder.amranta.setTypeface(arabicTypeface);
        holder.amrantuma.setTypeface(arabicTypeface);
        holder.amrantum.setTypeface(arabicTypeface);
        holder.amranti.setTypeface(arabicTypeface);
        holder.amrantumaf.setTypeface(arabicTypeface);
        holder.amrantunna.setTypeface(arabicTypeface);
        holder.amranta.setText(anta);
        holder.amrantuma.setText(antuma);
        holder.amrantum.setText(antum);
        holder.amranti.setText(anti);
        holder.amrantumaf.setText(antumaf);
        holder.amrantunna.setText(antunna);

    }

    private void MudhariMajhool(ViewHolder holder, int position) {
        String hua, huma, hum, hia, humaf, hunna, anta, antuma, antum, anti, antumaf, antunna, ana, nahnu;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[0]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            hua = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[1]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            huma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[2]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            hum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[3]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            hia = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[4]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            humaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[5]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(5).toString());
            hunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(6).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(8).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(9).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(10).toString());
            antunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[12]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(11).toString());
            ana = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[13]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(12).toString());
            nahnu = sb.toString();

        } else {
            hua = sarfSagheer.get(position).get(0).toString();
            huma = sarfSagheer.get(position).get(1).toString();
            hum = sarfSagheer.get(position).get(2).toString();
            hia = sarfSagheer.get(position).get(3).toString();
            humaf = sarfSagheer.get(position).get(4).toString();
            hunna = sarfSagheer.get(position).get(5).toString();
            anta = sarfSagheer.get(position).get(6).toString();
            antuma = sarfSagheer.get(position).get(7).toString();
            antum = sarfSagheer.get(position).get(8).toString();
            anti = sarfSagheer.get(position).get(9).toString();
            antumaf = sarfSagheer.get(position).get(4).toString();
            antunna = sarfSagheer.get(position).get(10).toString();
            ana = sarfSagheer.get(position).get(11).toString();
            nahnu = sarfSagheer.get(position).get(12).toString();
        }
        //     FontSIzeSelection(holder);
//ismfaile
        //   SharedPref.arabicFontSelection();
        holder.muzmajhua.setTypeface(arabicTypeface);
        holder.muzmajhuma.setTypeface(arabicTypeface);
        holder.muzmajhum.setTypeface(arabicTypeface);
        holder.muzmajhia.setTypeface(arabicTypeface);
        holder.muzmajhumaf.setTypeface(arabicTypeface);
        holder.muzmajhunna.setTypeface(arabicTypeface);
        holder.muzmajanta.setTypeface(arabicTypeface);
        holder.muzmajantuma.setTypeface(arabicTypeface);
        holder.muzmajantum.setTypeface(arabicTypeface);
        holder.muzmajanti.setTypeface(arabicTypeface);
        holder.muzmajantumaf.setTypeface(arabicTypeface);
        holder.muzmajantunna.setTypeface(arabicTypeface);
        holder.muzmajana.setTypeface(arabicTypeface);
        holder.muzmajnahnu.setTypeface(arabicTypeface);
        holder.muzmajhua.setText(hua);
        holder.muzmajhuma.setText(huma);
        holder.muzmajhum.setText(hum);
        holder.muzmajhia.setText(hia);
        holder.muzmajhumaf.setText(humaf);
        holder.muzmajhunna.setText(hunna);
        holder.muzmajanta.setText(anta);
        holder.muzmajantuma.setText(antuma);
        holder.muzmajantum.setText(antum);
        holder.muzmajanti.setText(anti);
        holder.muzmajantumaf.setText(antumaf);
        holder.muzmajantunna.setText(antunna);
        holder.muzmajana.setText(ana);
//
        holder.muzmajnahnu.setText(nahnu);
        FontSIzeSelection(holder);
    }

    private void FontSIzeSelection(ViewHolder holder) {
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String width = sharedPreferences.getString("width", "compactWidth");
        final Integer arabicFontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        if (width.equals("mediumWidth") || width.equals("expandedWidth")) {
            //   final Integer arabicFontsize = SharedPref.arabicFontsize();
            holder.muzhua.setTextSize(arabicFontsize);
            holder.muzhuma.setTextSize(arabicFontsize);
            holder.muzhum.setTextSize(arabicFontsize);
            holder.muzhia.setTextSize(arabicFontsize);
            holder.muzhumaf.setTextSize(arabicFontsize);
            holder.muzhunna.setTextSize(arabicFontsize);
            holder.muzanta.setTextSize(arabicFontsize);
            holder.muzantuma.setTextSize(arabicFontsize);
            holder.muzantum.setTextSize(arabicFontsize);
            holder.muzanti.setTextSize(arabicFontsize);
            holder.muzantumaf.setTextSize(arabicFontsize);
            holder.muzantunna.setTextSize(arabicFontsize);
            holder.muzana.setTextSize(arabicFontsize);
            holder.muznahnu.setTextSize(arabicFontsize);
            holder.muzmajhua.setTextSize(arabicFontsize);
            holder.muzmajhuma.setTextSize(arabicFontsize);
            holder.muzmajhum.setTextSize(arabicFontsize);
            holder.muzmajhia.setTextSize(arabicFontsize);
            holder.muzmajhumaf.setTextSize(arabicFontsize);
            holder.muzmajhunna.setTextSize(arabicFontsize);
            holder.muzmajanta.setTextSize(arabicFontsize);
            holder.muzmajantuma.setTextSize(arabicFontsize);
            holder.muzmajantum.setTextSize(arabicFontsize);
            holder.muzmajanti.setTextSize(arabicFontsize);
            holder.muzmajantumaf.setTextSize(arabicFontsize);
            holder.muzmajantunna.setTextSize(arabicFontsize);
            holder.muzmajana.setTextSize(arabicFontsize);
            holder.muzmajnahnu.setTextSize(arabicFontsize);
            holder.madhihua.setTextSize(arabicFontsize);
            holder.madhihuma.setTextSize(arabicFontsize);
            holder.madhihum.setTextSize(arabicFontsize);
            holder.madhihia.setTextSize(arabicFontsize);
            holder.madhihumaf.setTextSize(arabicFontsize);
            holder.madhihunna.setTextSize(arabicFontsize);
            holder.madhianta.setTextSize(arabicFontsize);
            holder.madhiantuma.setTextSize(arabicFontsize);
            holder.madhiantum.setTextSize(arabicFontsize);
            holder.madhianti.setTextSize(arabicFontsize);
            holder.madhiantunna.setTextSize(arabicFontsize);
            holder.madhiantumaf.setTextSize(arabicFontsize);
            holder.madhiana.setTextSize(arabicFontsize);
            holder.madhinahnu.setTextSize(arabicFontsize);
            holder.madimajhua.setTextSize(arabicFontsize);
            holder.madimajhuma.setTextSize(arabicFontsize);
            holder.madimajhum.setTextSize(arabicFontsize);
            holder.madimajhia.setTextSize(arabicFontsize);
            holder.madimajhumaf.setTextSize(arabicFontsize);
            holder.madimajhunna.setTextSize(arabicFontsize);
            holder.madimajanta.setTextSize(arabicFontsize);
            holder.madimajantuma.setTextSize(arabicFontsize);
            holder.madimajantum.setTextSize(arabicFontsize);
            holder.madimajanti.setTextSize(arabicFontsize);
            holder.madimajantumaf.setTextSize(arabicFontsize);
            holder.madimajantunna.setTextSize(arabicFontsize);
            holder.madimajana.setTextSize(arabicFontsize);
            holder.madimajnahnu.setTextSize(arabicFontsize);
            holder.amranta.setTextSize(arabicFontsize);
            holder.amrantuma.setTextSize(arabicFontsize);
            holder.amrantum.setTextSize(arabicFontsize);
            holder.amranti.setTextSize(arabicFontsize);
            holder.amrantumaf.setTextSize(arabicFontsize);
            holder.amrantunna.setTextSize(arabicFontsize);
            holder.nahiamranta.setTextSize(arabicFontsize);
            holder.nahiamrantuma.setTextSize(arabicFontsize);
            holder.nahiamrantum.setTextSize(arabicFontsize);
            holder.nahiamranti.setTextSize(arabicFontsize);
            holder.nahiamrantumaf.setTextSize(arabicFontsize);
            holder.nahiamrantunna.setTextSize(arabicFontsize);
            holder.huaid.setTextSize(arabicFontsize);//(array[0]);
            holder.humamid.setTextSize(arabicFontsize);//(array[1]);
            holder.humid.setTextSize(arabicFontsize);//(array[2]);
            holder.hiaid.setTextSize(arabicFontsize);//(array[3]);
            holder.humafid.setTextSize(arabicFontsize);//(array[4]);
            holder.hunnaid.setTextSize(arabicFontsize);//(array[5]);
            holder.antaid.setTextSize(arabicFontsize);//(array[6]);
            holder.antumamid.setTextSize(arabicFontsize);//(array[7]);
            holder.antumid.setTextSize(arabicFontsize);//(array[8]);
            holder.antiid.setTextSize(arabicFontsize);//(array[9]);
            holder.antumafid.setTextSize(arabicFontsize);//(array[10]);
            holder.antunnaid.setTextSize(arabicFontsize);//(array[11]);
            holder.anaid.setTextSize(arabicFontsize);//(array[12]);
            holder.nahnuid.setTextSize(arabicFontsize);//(array[13]);

        }
    }

    private void MadhiMajhool(ViewHolder holder, int position) {
        String hua, huma, hum, hia, humaf, hunna, anta, antuma, antum, anti, antumaf, antunna, ana, nahnu;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[0]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            hua = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[1]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            huma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[2]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            hum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[3]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            hia = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[4]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            humaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[5]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(5).toString());
            hunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(6).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(8).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(9).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(10).toString());
            antunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[12]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(11).toString());
            ana = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[13]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(12).toString());
            nahnu = sb.toString();

        } else {
            hua = sarfSagheer.get(position).get(0).toString();
            huma = sarfSagheer.get(position).get(1).toString();
            hum = sarfSagheer.get(position).get(2).toString();
            hia = sarfSagheer.get(position).get(3).toString();
            humaf = sarfSagheer.get(position).get(4).toString();
            hunna = sarfSagheer.get(position).get(5).toString();
            anta = sarfSagheer.get(position).get(6).toString();
            antuma = sarfSagheer.get(position).get(7).toString();
            antum = sarfSagheer.get(position).get(8).toString();
            anti = sarfSagheer.get(position).get(9).toString();
            antumaf = sarfSagheer.get(position).get(4).toString();
            antunna = sarfSagheer.get(position).get(10).toString();
            ana = sarfSagheer.get(position).get(11).toString();
            nahnu = sarfSagheer.get(position).get(12).toString();
        }
        holder.madimajhua.setTypeface(arabicTypeface);
        holder.madimajhuma.setTypeface(arabicTypeface);
        holder.madimajhum.setTypeface(arabicTypeface);
        holder.madimajhia.setTypeface(arabicTypeface);
        holder.madimajhumaf.setTypeface(arabicTypeface);
        holder.madimajhunna.setTypeface(arabicTypeface);
        holder.madimajanta.setTypeface(arabicTypeface);
        holder.madimajantuma.setTypeface(arabicTypeface);
        holder.madimajantum.setTypeface(arabicTypeface);
        holder.madimajanti.setTypeface(arabicTypeface);
        holder.madimajantumaf.setTypeface(arabicTypeface);
        holder.madimajantunna.setTypeface(arabicTypeface);
        holder.madimajana.setTypeface(arabicTypeface);
        holder.madimajnahnu.setTypeface(arabicTypeface);
        holder.madimajhua.setText(hua);
        holder.madimajhuma.setText(huma);
        holder.madimajhum.setText(hum);
        holder.madimajhia.setText(hia);
        holder.madimajhumaf.setText(humaf);
        holder.madimajhunna.setText(hunna);
        holder.madimajanta.setText(anta);
        holder.madimajantuma.setText(antuma);
        holder.madimajantum.setText(antum);
        holder.madimajanti.setText(anti);
        holder.madimajantumaf.setText(antumaf);
        holder.madimajantunna.setText(antunna);
        holder.madimajana.setText(ana);
        holder.madimajnahnu.setText(nahnu);
    }

    private void MudhariMaroof(ViewHolder holder, int position) {
        String hua, huma, hum, hia, humaf, hunna, anta, antuma, antum, anti, antumaf, antunna, ana, nahnu;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[0]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            hua = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[1]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            huma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[2]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            hum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[3]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            hia = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[4]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            humaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[5]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(5).toString());
            hunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(6).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(8).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(9).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(10).toString());
            antunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[12]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(11).toString());
            ana = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[13]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(12).toString());
            nahnu = sb.toString();

        } else {
            hua = sarfSagheer.get(position).get(0).toString();
            huma = sarfSagheer.get(position).get(1).toString();
            hum = sarfSagheer.get(position).get(2).toString();
            hia = sarfSagheer.get(position).get(3).toString();
            humaf = sarfSagheer.get(position).get(4).toString();
            hunna = sarfSagheer.get(position).get(5).toString();
            anta = sarfSagheer.get(position).get(6).toString();
            antuma = sarfSagheer.get(position).get(7).toString();
            antum = sarfSagheer.get(position).get(8).toString();
            anti = sarfSagheer.get(position).get(9).toString();
            antumaf = sarfSagheer.get(position).get(4).toString();
            antunna = sarfSagheer.get(position).get(10).toString();
            ana = sarfSagheer.get(position).get(11).toString();
            nahnu = sarfSagheer.get(position).get(12).toString();

        }
        holder.muzhua.setTypeface(arabicTypeface);
        holder.muzhuma.setTypeface(arabicTypeface);
        holder.muzhum.setTypeface(arabicTypeface);
        holder.muzhia.setTypeface(arabicTypeface);
        holder.muzhumaf.setTypeface(arabicTypeface);
        holder.muzhunna.setTypeface(arabicTypeface);
        holder.muzanta.setTypeface(arabicTypeface);
        holder.muzantuma.setTypeface(arabicTypeface);
        holder.muzantum.setTypeface(arabicTypeface);
        holder.muzanti.setTypeface(arabicTypeface);
        holder.muzantumaf.setTypeface(arabicTypeface);
        holder.muzantunna.setTypeface(arabicTypeface);
        holder.muzana.setTypeface(arabicTypeface);
        holder.muznahnu.setTypeface(arabicTypeface);
        holder.muzhua.setText(hua);
        holder.muzhuma.setText(huma);
        holder.muzhum.setText(hum);
        holder.muzhia.setText(hia);
        holder.muzhumaf.setText(humaf);
        holder.muzhunna.setText(hunna);
        holder.muzanta.setText(anta);
        holder.muzantuma.setText(antuma);
        holder.muzantum.setText(antum);
        holder.muzanti.setText(anti);
        holder.muzantumaf.setText(antumaf);
        holder.muzantunna.setText(antunna);
        holder.muzana.setText(ana);
        holder.muznahnu.setText(nahnu);
    }

    private void MadhiMaroof(ViewHolder holder, int position) {
        String hua, huma, hum, hia, humaf, hunna, anta, antuma, antum, anti, antumaf, antunna, ana, nahnu;
        SharedPref sf = new SharedPref(context);
        Boolean isTraditional = SharedPref.GetSarfKabeerVerb();
        String[] arraypronouns = context.getResources().getStringArray(R.array.arabicpronouns);
        StringBuilder sb;
        if (isTraditional) {
            sb = new StringBuilder();
            sb.append(arraypronouns[0]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(0).toString());
            hua = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[1]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(1).toString());
            huma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[2]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(2).toString());
            hum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[3]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(3).toString());
            hia = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[4]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(4).toString());
            humaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[5]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(5).toString());
            hunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[6]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(6).toString());
            anta = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antuma = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[8]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(8).toString());
            antum = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[9]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(9).toString());
            anti = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[7]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(7).toString());
            antumaf = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[11]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(10).toString());
            antunna = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[12]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(11).toString());
            ana = sb.toString();
            sb = new StringBuilder();
            sb.append(arraypronouns[13]);
            sb.append("-");
            sb.append(sarfSagheer.get(position).get(12).toString());
            nahnu = sb.toString();

        } else {
            hua = sarfSagheer.get(position).get(0).toString();
            huma = sarfSagheer.get(position).get(1).toString();
            hum = sarfSagheer.get(position).get(2).toString();
            hia = sarfSagheer.get(position).get(3).toString();
            humaf = sarfSagheer.get(position).get(4).toString();
            hunna = sarfSagheer.get(position).get(5).toString();
            anta = sarfSagheer.get(position).get(6).toString();
            antuma = sarfSagheer.get(position).get(7).toString();
            antum = sarfSagheer.get(position).get(8).toString();
            anti = sarfSagheer.get(position).get(9).toString();
            antumaf = sarfSagheer.get(position).get(7).toString();
            antunna = sarfSagheer.get(position).get(10).toString();
            ana = sarfSagheer.get(position).get(11).toString();
            nahnu = sarfSagheer.get(position).get(12).toString();
        }
        String language = SharedPref.getLanguage();
        String[] arrayheadings;
        if (language.equals("en"))
            arrayheadings = context.getResources().getStringArray(R.array.enverbheadings);
        else {
            arrayheadings = context.getResources().getStringArray(R.array.arverbheadings);
        }
        //    holder.pronouns.setText(array[0]);
        holder.pastactive.setText(arrayheadings[1]);
        holder.presentactive.setText(arrayheadings[2]);
        holder.pastpassive.setText(arrayheadings[3]);
        holder.presentpassive.setText(arrayheadings[4]);
        holder.command.setText(arrayheadings[5]);
        holder.negcommand.setText(arrayheadings[6]);
        holder.madhihua.setTypeface(arabicTypeface);
//        holder.madhihuma.setTypeface(arabicTypeface);
        holder.madhihum.setTypeface(arabicTypeface);
        holder.madhihia.setTypeface(arabicTypeface);
        holder.madhihumaf.setTypeface(arabicTypeface);
        holder.madhihunna.setTypeface(arabicTypeface);
        holder.madhianta.setTypeface(arabicTypeface);
        holder.madhiantuma.setTypeface(arabicTypeface);
        holder.madhiantum.setTypeface(arabicTypeface);
        holder.madhianti.setTypeface(arabicTypeface);
        holder.madhiantunna.setTypeface(arabicTypeface);
        holder.madhiantumaf.setTypeface(arabicTypeface);
        holder.madhiana.setTypeface(arabicTypeface);
        holder.madhinahnu.setTypeface(arabicTypeface);
        holder.madhihua.setText(hua);
        holder.madhihua.setText(hua);
        holder.madhihuma.setText(huma);
        holder.madhihum.setText(hum);
        holder.madhihia.setText(hia);
        holder.madhihumaf.setText(humaf);
        holder.madhihunna.setText(hunna);
        holder.madhianta.setText(anta);
        holder.madhiantuma.setText(antuma);
        holder.madhiantum.setText(antum);
        holder.madhianti.setText(anti);
        holder.madhiantumaf.setText(antumaf);
        holder.madhiantunna.setText(antunna);
        holder.madhiana.setText(ana);
        holder.madhinahnu.setText(nahnu);
    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return sarfSagheer.size();
    }

    public Object getItem(int position) {
        return sarfSagheer.get(position);
    }

    @Override
    public int getItemCount() {
        //    return sarfSagheer.size();
        return 1;

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setVerbArrayList(ArrayList<ArrayList> sarfsagheer) {
        this.sarfSagheer = sarfsagheer;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        //  public final TextView ayah_number;
        public final TextView madhihua, madhihuma, madhihum, madhihia, madhihumaf,
                madhihunna, madhianta, madhiantuma, madhiantum, madhianti, madhiantumaf,
                madhiantunna, madhiana, madhinahnu;
        public final TextView muzhua, muzhuma, muzhum, muzhia, muzhumaf, muzhunna, muzanta, muzantuma, muzantum,
                muzanti, muzantumaf, muzantunna, muzana, muznahnu;
        public final TextView madimajhua, madimajhuma, madimajhum, madimajhia, madimajhumaf, madimajhunna, madimajanta, madimajantuma, madimajantum,
                madimajanti, madimajantumaf, madimajantunna, madimajana, madimajnahnu;
        public final TextView muzmajhua, muzmajhuma, muzmajhum, muzmajhia, muzmajhumaf, muzmajhunna, muzmajanta, muzmajantuma, muzmajantum,
                muzmajanti, muzmajantumaf, muzmajantunna, muzmajana, muzmajnahnu;
        public final TextView amranta, amrantuma, amrantum,
                amranti, amrantumaf, amrantunna;
        public final TextView nahiamranta, nahiamrantuma, nahiamrantum,
                nahiamranti, nahiamrantumaf, nahiamrantunna;
        public final TextView huaid, humamid, humid, hiaid, humafid, hunnaid, antaid, antumamid,
                antumid, antiid, antumafid, antunnaid, anaid, nahnuid;
        public final TextView pronouns, pastactive, presentactive, pastpassive, presentpassive, command, negcommand;

        public ViewHolder(View view) {
            super(view);
            pronouns = view.findViewById(R.id.pronouns);
            pastactive = view.findViewById(R.id.pastactive);
            presentactive = view.findViewById(R.id.presentactive);
            pastpassive = view.findViewById(R.id.pastpassive);
            presentpassive = view.findViewById(R.id.presentpassive);
            command = view.findViewById(R.id.command);
            negcommand = view.findViewById(R.id.negcommand);
            huaid = view.findViewById(R.id.huaid);
            humamid = view.findViewById(R.id.humamid);
            humid = view.findViewById(R.id.humid);
            hiaid = view.findViewById(R.id.hiaid);
            humafid = view.findViewById(R.id.humafid);
            hunnaid = view.findViewById(R.id.hunnaid);
            antaid = view.findViewById(R.id.antaid);
            antumamid = view.findViewById(R.id.antumamid);
            antumid = view.findViewById(R.id.antumid);
            antiid = view.findViewById(R.id.antiid);
            antumafid = view.findViewById(R.id.antumafid);
            antunnaid = view.findViewById(R.id.antunnaid);
            anaid = view.findViewById(R.id.anaid);
            nahnuid = view.findViewById(R.id.nahnuid);
            madhihua = view.findViewById(R.id.madhihua);
            madhihuma = view.findViewById(R.id.madhihuma);
            madhihum = view.findViewById(R.id.madihum);
            madhihia = view.findViewById(R.id.madhihia);
            madhihumaf = view.findViewById(R.id.madhihumaf);
            madhihunna = view.findViewById(R.id.madihunna);
            madhianta = view.findViewById(R.id.madhianta);
            madhiantuma = view.findViewById(R.id.madhiantuma);
            madhiantum = view.findViewById(R.id.madhiantum);
            madhianti = view.findViewById(R.id.madhianti);
            madhiantumaf = view.findViewById(R.id.madhiantumaf);
            madhiantunna = view.findViewById(R.id.madhiantunna);
            madhiana = view.findViewById(R.id.madhiana);
            madhinahnu = view.findViewById(R.id.madhinahnu);
            muzhua = view.findViewById(R.id.muzhua);
            muzhuma = view.findViewById(R.id.muzhuma);
            muzhum = view.findViewById(R.id.muzhum);
            muzhia = view.findViewById(R.id.muzhia);
            muzhumaf = view.findViewById(R.id.muzhumaf);
            muzhunna = view.findViewById(R.id.muzhunna);
            muzanta = view.findViewById(R.id.muzanta);
            muzantuma = view.findViewById(R.id.muzantuma);
            muzantum = view.findViewById(R.id.muzantum);
            muzanti = view.findViewById(R.id.muzanti);
            muzantumaf = view.findViewById(R.id.muzantumaf);
            muzantunna = view.findViewById(R.id.muzantunna);
            muzana = view.findViewById(R.id.muzana);
            muznahnu = view.findViewById(R.id.muznahnu);
//
            madimajhua = view.findViewById(R.id.madimajhua);
            madimajhuma = view.findViewById(R.id.madimajhuma);
            madimajhum = view.findViewById(R.id.madimajhum);
            madimajhia = view.findViewById(R.id.madimajhia);
            madimajhumaf = view.findViewById(R.id.madimajhumaf);
            madimajhunna = view.findViewById(R.id.madimajhunna);
            madimajanta = view.findViewById(R.id.madimajanta);
            madimajantuma = view.findViewById(R.id.madimajantuma);
            madimajantum = view.findViewById(R.id.madimajantum);
            madimajanti = view.findViewById(R.id.madimajanti);
            madimajantumaf = view.findViewById(R.id.madimajantumaf);
            madimajantunna = view.findViewById(R.id.madimajantunna);
            madimajana = view.findViewById(R.id.madimajana);
            madimajnahnu = view.findViewById(R.id.madimajnahnu);
///muzmajhool
            muzmajhua = view.findViewById(R.id.muzmajhua);
            muzmajhuma = view.findViewById(R.id.muzmajhuma);
            muzmajhum = view.findViewById(R.id.muzmajhum);
            muzmajhia = view.findViewById(R.id.muzmajhia);
            muzmajhumaf = view.findViewById(R.id.muzmajhumaf);
            muzmajhunna = view.findViewById(R.id.muzmajhunna);
            muzmajanta = view.findViewById(R.id.muzmajanta);
            muzmajantuma = view.findViewById(R.id.muzmajantuma);
            muzmajantum = view.findViewById(R.id.muzmajantum);
            muzmajanti = view.findViewById(R.id.muzmajanti);
            muzmajantumaf = view.findViewById(R.id.muzmajantumaf);
            muzmajantunna = view.findViewById(R.id.muzmajantunna);
            muzmajana = view.findViewById(R.id.muzmajana);
            muzmajnahnu = view.findViewById(R.id.muzmajnahnu);
//
            amranta = view.findViewById(R.id.amranta);
            amrantuma = view.findViewById(R.id.amrantuma);
            amrantum = view.findViewById(R.id.amrantum);
            amranti = view.findViewById(R.id.amranti);
            amrantumaf = view.findViewById(R.id.amrantumaf);
            amrantunna = view.findViewById(R.id.amrantunna);
            nahiamranta = view.findViewById(R.id.nahiamranta);
            nahiamrantuma = view.findViewById(R.id.nahiamrantuma);
            nahiamrantum = view.findViewById(R.id.nahiamrantum);
            nahiamranti = view.findViewById(R.id.nahiamranti);
            nahiamrantumaf = view.findViewById(R.id.nahiamrantumaf);
            nahiamrantunna = view.findViewById(R.id.nahiamrantunna);
            view.setOnClickListener(this); // current clickListerner
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






