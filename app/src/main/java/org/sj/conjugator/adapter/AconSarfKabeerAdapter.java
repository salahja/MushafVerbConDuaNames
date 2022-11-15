package org.sj.conjugator.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import org.sj.conjugator.interfaces.OnItemClickListener;
import org.sj.conjugator.utilities.SharedPref;

import java.util.ArrayList;

public class AconSarfKabeerAdapter extends RecyclerView.Adapter<AconSarfKabeerAdapter.ViewHolder> {
    private final Context context;
    boolean mazeed;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    //   private ArrayList<String> madhi = new ArrayList<>();
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private int arabic_font_size;
    private int urdu_font_size;
    private String arabic_font_selection;
    private ArrayList<ArrayList> sarfKabeer = new ArrayList<>();

    public AconSarfKabeerAdapter(ArrayList<ArrayList> lists, Context context) {
        this.context = context;
        this.sarfKabeer = lists;

    }

    public AconSarfKabeerAdapter(boolean mazeedregular, ArrayList sarfKabeer, FragmentActivity activity) {
        this.context = activity;
        this.sarfKabeer = sarfKabeer;
        this.mazeedregular = mazeedregular;

    }
//    public AconSarfKabeerAdapter(ArrayList<String> madhi, ArrayList<ArrayList> skabeer, FragmentActivity activity) {
    //     this.context = activity;
    //    this.sarfKabeer = skabeer;
    //  this.madhi = madhi;
    // }

    public AconSarfKabeerAdapter(boolean mazeed, ArrayList<ArrayList> skabeer, Context context) {
        this.context = context;
        this.sarfKabeer = skabeer;
        this.mazeed = mazeed;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Boolean aBoolean = SharedPref.GetSarfKabeerVerb();
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view;
        if (aBoolean) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verbsarfkabeertraditional, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsarfkabeercolumn, parent, false);
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
        //  final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray();
        //   ArrayList list = sarfSagheer.get(position);
        //    position++;
        if (mazeed) {
            MadhiMaroof(holder, 0);
            MudhariMaroof(holder, 1);
            MadhiMajhool(holder, 2);
            MudhariMajhool(holder, 3);
            Amar(holder, 4);
            AmarNahi(holder, 5);
        } else {
            MadhiMaroof(holder, 0);
            MudhariMaroof(holder, 1);
            MadhiMajhool(holder, 2);
            MudhariMajhool(holder, 3);
            Amar(holder, 4);
            AmarNahi(holder, 5);
            IsmFael(holder, 6);
            IsmFaelFem(holder, 6);
            IsmMafool(holder, 7);
            IsmMafoolFem(holder, 7);
            IsmAlamifalmifalatun(holder, 8);
            IsmAlaMifaal(holder, 9);
            Zarf(holder, 10);
        }

    }

    private void Zarf(ViewHolder holder, int position) {
        String mafalunone = sarfKabeer.get(position).get(0).toString();//String smafalunone);
        String mafaluntwo = sarfKabeer.get(position).get(1).toString();//String smafaluntwo);
        String mafalunthree = sarfKabeer.get(position).get(2).toString();//String smafalunthree);
        String mafalunfour = sarfKabeer.get(position).get(3).toString();//String smafalunfour);
        String mafalunfive = sarfKabeer.get(position).get(4).toString();//String smafalunfive);
        String mafalunsix = sarfKabeer.get(position).get(5).toString();//String smafalunsix);
        String mafalunseven = sarfKabeer.get(position).get(6).toString();//String smafalunseven);
        String mafaluneight = sarfKabeer.get(position).get(7).toString();//String smafaluneight);
        String mafalunnine = sarfKabeer.get(position).get(8).toString();//mafalunnine);
        String mifalunone = sarfKabeer.get(position).get(9).toString();//String mifalunone);
        String mifaluntwo = sarfKabeer.get(position).get(10).toString();//String mifaluntwo);
        String mifalunthree = sarfKabeer.get(position).get(11).toString();//String mifalunthree);
        String mifalunfour = sarfKabeer.get(position).get(12).toString();//String mifalunfour);
        String mifalunfive = sarfKabeer.get(position).get(13).toString();//String mifalunfive);
        String mifalunsix = sarfKabeer.get(position).get(14).toString();//String mifalunsix);
        String mifalunseven = sarfKabeer.get(position).get(15).toString();//String mifalunseven);
        String mifaluneight = sarfKabeer.get(position).get(16).toString();//String mifaluneight);
        String mifalunnine = sarfKabeer.get(position).get(17).toString();//mifalatunnine);
        holder.mafalunone.setText(mafalunone);
        holder.mafaluntwo.setText(mafaluntwo);
        holder.mafalunthree.setText(mafalunthree);
        holder.mafalunfour.setText(mafalunfour);
        holder.mafalunfive.setText(mafalunfive);
        holder.mafalunsix.setText(mafalunsix);
        holder.mafalunseven.setText(mafalunseven);
        holder.mafaluneight.setText(mafaluneight);
        holder.mafalunnine.setText(mafalunnine);
        holder.mifalunone.setText(mifalunone);
        holder.mifaluntwo.setText(mifaluntwo);
        holder.mifalunthree.setText(mifalunthree);
        holder.mifalunfour.setText(mifalunfour);
        holder.mifalunfive.setText(mifalunfive);
        holder.mifalunsix.setText(mifalunsix);
        holder.mifalunseven.setText(mifalunseven);
        holder.mifaluneight.setText(mifaluneight);
        holder.mifalunnine.setText(mifalunnine);

    }

    private void IsmAlaMifaal(ViewHolder holder, int position) {
        String mifaalone = sarfKabeer.get(position).get(0).toString();//String mifaalone);
        String mifaaltwo = sarfKabeer.get(position).get(1).toString();//String mifaaltwo);
        String mifaalthree = sarfKabeer.get(position).get(2).toString();//String mifaalthree);
        String mifaalfour = sarfKabeer.get(position).get(3).toString();//String mifaalfour);
        String mifaalfive = sarfKabeer.get(position).get(4).toString();//String mifaalfive);
        String mifaalsix = sarfKabeer.get(position).get(5).toString();//String mifaalsix);
        String mifaalseven = sarfKabeer.get(position).get(6).toString();//String mifaalseven);
        String mifaaleight = sarfKabeer.get(position).get(7).toString();//String mifaaleight);
        String mifaalnine = sarfKabeer.get(position).get(8).toString();//mifaalnine);
        holder.mifaalone.setText(mifaalone);
        holder.mifaaltwo.setText(mifaaltwo);
        holder.mifaalthree.setText(mifaalthree);
        holder.mifaalfour.setText(mifaalfour);
        holder.mifaalfive.setText(mifaalfive);
        holder.mifaalsix.setText(mifaalsix);
        holder.mifaalseven.setText(mifaalseven);
        holder.mifaaleight.setText(mifaaleight);
        holder.mifaalnine.setText(mifaalnine);

    }

    private void IsmAlamifalmifalatun(ViewHolder holder, int position) {
        String mifalone = sarfKabeer.get(position).get(0).toString();//String smifalone);
        String mifaltwo = sarfKabeer.get(position).get(1).toString();//String smifaltwo);
        String mifalthree = sarfKabeer.get(position).get(2).toString();//String smifalthree);
        String mifalfour = sarfKabeer.get(position).get(3).toString();//String smifalfour);
        String mifalfive = sarfKabeer.get(position).get(4).toString();//String smifalfive);
        String mifalsix = sarfKabeer.get(position).get(5).toString();//String smifalsix);
        String mifalseven = sarfKabeer.get(position).get(6).toString();//String smifalseven);
        String mifaleight = sarfKabeer.get(position).get(7).toString();//String smifaleight);
        String mifalnine = sarfKabeer.get(position).get(8).toString();//mifalnine);
        String mifalatunone = sarfKabeer.get(position).get(9).toString();//String mifalatunone);
        String mifalatuntwo = sarfKabeer.get(position).get(10).toString();//String mifalatuntwo);
        String mifalatunthree = sarfKabeer.get(position).get(11).toString();//String mifalatunthree);
        String mifalatunfour = sarfKabeer.get(position).get(12).toString();//String mifalatunfour);
        String mifalatunfive = sarfKabeer.get(position).get(13).toString();//String mifalatunfive);
        String mifalatunsix = sarfKabeer.get(position).get(14).toString();//String mifalatunsix);
        String mifalatunseven = sarfKabeer.get(position).get(15).toString();//String mifalatunseven);
        String mifalatuneight = sarfKabeer.get(position).get(16).toString();//String mifalatuneight);
        String mifalatunnine = sarfKabeer.get(position).get(17).toString();//mifalatunnine);
        holder.mifalone.setText(mifalone);
        holder.mifaltwo.setText(mifaltwo);
        holder.mifalthree.setText(mifalthree);
        holder.mifalfour.setText(mifalfour);
        holder.mifalfive.setText(mifalfive);
        holder.mifalsix.setText(mifalsix);
        holder.mifalseven.setText(mifalseven);
        holder.mifaleight.setText(mifaleight);
        holder.mifalnine.setText(mifalnine);
        holder.mifalatunone.setText(mifalatunone);
        holder.mifalatuntwo.setText(mifalatuntwo);
        holder.mifalatunthree.setText(mifalatunthree);
        holder.mifalatunfour.setText(mifalatunfour);
        holder.mifalatunfive.setText(mifalatunfive);
        holder.mifalatunsix.setText(mifalatunsix);
        holder.mifalatunseven.setText(mifalatunseven);
        holder.mifalatuneight.setText(mifalatuneight);
        holder.mifalatunnine.setText(mifalatunnine);

    }

    private void IsmFael(ViewHolder holder, int position) {
        String iisone = sarfKabeer.get(position).get(0).toString();//isone);
        String iistwo = sarfKabeer.get(position).get(2).toString();//istwo);
        String iisthree = sarfKabeer.get(position).get(4).toString();//isthree);
        String iisfour = sarfKabeer.get(position).get(6).toString();//isfour);
        String iisfive = sarfKabeer.get(position).get(8).toString();//isfive);
        String iissix = sarfKabeer.get(position).get(10).toString();//issix);
        String iisseven = sarfKabeer.get(position).get(12).toString();//isseven);
        String iiseight = sarfKabeer.get(position).get(14).toString();//iseight);
        String iisnine = sarfKabeer.get(position).get(16).toString();//isnine);
        holder.isone.setText(iisone);
        holder.istwo.setText(iistwo);
        holder.isthree.setText(iisthree);
        holder.isfour.setText(iisfour);
        holder.isfive.setText(iisfive);
        holder.issix.setText(iissix);
        holder.isseven.setText(iisseven);
        holder.iseight.setText(iiseight);
        holder.isnine.setText(iisnine);

    }

    private void IsmFaelFem(ViewHolder holder, int position) {
        String iisone = sarfKabeer.get(position).get(1).toString();//isone);
        String iistwo = sarfKabeer.get(position).get(3).toString();//istwo);
        String iisthree = sarfKabeer.get(position).get(5).toString();//isthree);
        String iisfour = sarfKabeer.get(position).get(7).toString();//isfour);
        String iisfive = sarfKabeer.get(position).get(9).toString();//isfive);
        String iissix = sarfKabeer.get(position).get(11).toString();//issix);
        String iisseven = sarfKabeer.get(position).get(13).toString();//isseven);
        String iiseight = sarfKabeer.get(position).get(15).toString();//iseight);
        String iisnine = sarfKabeer.get(position).get(17).toString();//isnine);
        holder.ismfemone.setText(iisone);
        holder.ismfemtwo.setText(iistwo);
        holder.ismfemthree.setText(iisthree);
        holder.ismfemfour.setText(iisfour);
        holder.ismfemfive.setText(iisfive);
        holder.ismfemsix.setText(iissix);
        holder.ismfemseven.setText(iisseven);
        holder.ismfemeight.setText(iiseight);
        holder.ismfemnine.setText(iisnine);

    }

    private void IsmMafoolFem(ViewHolder holder, int position) {
        String smafone = sarfKabeer.get(position).get(1).toString();
        String smaftwo = sarfKabeer.get(position).get(3).toString();//imaftwo);
        String smafthree = sarfKabeer.get(position).get(5).toString();//imafthree);
        String smaffour = sarfKabeer.get(position).get(7).toString();//imaffour);
        String smaffive = sarfKabeer.get(position).get(9).toString();//imaffive);
        String smafsix = sarfKabeer.get(position).get(11).toString();//imafseven);
        String smafseven = sarfKabeer.get(position).get(13).toString();//imafseven);
        String smafeight = sarfKabeer.get(position).get(15).toString();//imafeight);
        String smafnine = sarfKabeer.get(position).get(17).toString();//imafnine);
        holder.imafoolfemone.setText(smafone);
        holder.imafoolfemtwo.setText(smaftwo);
        holder.imafoolfemthree.setText(smafthree);
        holder.imafoolfemfour.setText(smaffour);
        holder.imafoolfemfive.setText(smaffive);
        holder.imafoolfemsix.setText(smafsix);
        holder.imafoolfemseven.setText(smafseven);
        holder.imafoolfemeight.setText(smafeight);
        holder.imafoolfemnine.setText(smafnine);
    }

    private void IsmMafool(ViewHolder holder, int position) {
        String smafone = sarfKabeer.get(position).get(0).toString();
        String smaftwo = sarfKabeer.get(position).get(2).toString();//imaftwo);
        String smafthree = sarfKabeer.get(position).get(4).toString();//imafthree);
        String smaffour = sarfKabeer.get(position).get(6).toString();//imaffour);
        String smaffive = sarfKabeer.get(position).get(8).toString();//imaffive);
        String smafsix = sarfKabeer.get(position).get(10).toString();//imafseven);
        String smafseven = sarfKabeer.get(position).get(12).toString();//imafseven);
        String smafeight = sarfKabeer.get(position).get(14).toString();//imafeight);
        String smafnine = sarfKabeer.get(position).get(16).toString();//imafnine);
        holder.imafone.setText(smafone);
        holder.imaftwo.setText(smaftwo);
        holder.imafthree.setText(smafthree);
        holder.imaffour.setText(smaffour);
        holder.imaffive.setText(smaffive);
        holder.imafsix.setText(smafsix);
        holder.imafseven.setText(smafseven);
        holder.imafeight.setText(smafeight);
        holder.imafnine.setText(smafnine);

    }

    private void AmarNahi(ViewHolder holder, int position) {
        String anta = sarfKabeer.get(position).get(0).toString();
        String antuma = sarfKabeer.get(position).get(2).toString();
        String antum = sarfKabeer.get(position).get(3).toString();
        String anti = sarfKabeer.get(position).get(1).toString();
        String antumaf = sarfKabeer.get(position).get(2).toString();
        String antunna = sarfKabeer.get(position).get(4).toString();
        //  final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "me_quran.ttf");
        //     final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "NooreHira.ttf");
        // final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "NooreHuda.ttf");
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        //   final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "Montserrat.ttf");
        holder.nahiamranta.setTypeface(mequran);
        holder.nahiamrantuma.setTypeface(mequran);
        holder.nahiamrantum.setTypeface(mequran);
        holder.nahiamranti.setTypeface(mequran);
        holder.nahiamrantumaf.setTypeface(mequran);
        holder.nahiamrantunna.setTypeface(mequran);
        holder.nahiamranta.setText(anta);
        holder.nahiamrantuma.setText(antuma);
        holder.nahiamrantum.setText(antum);
        holder.nahiamranti.setText(anti);
        holder.nahiamrantumaf.setText(antumaf);
        holder.nahiamrantunna.setText(antunna);

    }

    private void Amar(ViewHolder holder, int position) {
        String anta = sarfKabeer.get(position).get(0).toString();
        String antuma = sarfKabeer.get(position).get(2).toString();
        String antum = sarfKabeer.get(position).get(3).toString();
        String anti = sarfKabeer.get(position).get(1).toString();
        String antumaf = sarfKabeer.get(position).get(2).toString();
        String antunna = sarfKabeer.get(position).get(4).toString();
        //  final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "me_quran.ttf");
        //     final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "NooreHira.ttf");
        // final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "NooreHuda.ttf");
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        //   final Typeface mequran = Typeface.createFromAsset(context.getAssets(), "Montserrat.ttf");
        holder.amranta.setTypeface(mequran);
        holder.amrantuma.setTypeface(mequran);
        holder.amrantum.setTypeface(mequran);
        holder.amranti.setTypeface(mequran);
        holder.amrantumaf.setTypeface(mequran);
        holder.amrantunna.setTypeface(mequran);
        holder.amranta.setText(anta);
        holder.amrantuma.setText(antuma);
        holder.amrantum.setText(antum);
        holder.amranti.setText(anti);
        holder.amrantumaf.setText(antumaf);
        holder.amrantunna.setText(antunna);

    }

    private void MudhariMajhool(ViewHolder holder, int position) {
        String hua = sarfKabeer.get(position).get(0).toString();
        String huma = sarfKabeer.get(position).get(1).toString();
        String hum = sarfKabeer.get(position).get(2).toString();
        String hia = sarfKabeer.get(position).get(3).toString();
        String humaf = sarfKabeer.get(position).get(4).toString();
        String hunna = sarfKabeer.get(position).get(5).toString();
        String anta = sarfKabeer.get(position).get(6).toString();
        String antuma = sarfKabeer.get(position).get(7).toString();
        String antum = sarfKabeer.get(position).get(8).toString();
        String anti = sarfKabeer.get(position).get(9).toString();
        String antumaf = sarfKabeer.get(position).get(4).toString();
        String antunna = sarfKabeer.get(position).get(10).toString();
        String ana = sarfKabeer.get(position).get(11).toString();
        String nahnu = sarfKabeer.get(position).get(12).toString();
//        String fifteen=    sarfSagheer.get(position).get(14).toString();
        //   String fifteen=    sarfSagheer.get(position).get(14).toString();
        final Typeface fontType = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        //     FontSIzeSelection(holder);
//ismfaile
        holder.ismfemone.setTypeface(fontType);
        holder.ismfemtwo.setTypeface(fontType);
        holder.ismfemthree.setTypeface(fontType);
        holder.ismfemfour.setTypeface(fontType);
        holder.ismfemfive.setTypeface(fontType);
        holder.ismfemsix.setTypeface(fontType);
        holder.ismfemseven.setTypeface(fontType);
        holder.ismfemeight.setTypeface(fontType);
        holder.ismfemnine.setTypeface(fontType);
        holder.imafoolfemone.setTypeface(fontType);
        holder.imafoolfemtwo.setTypeface(fontType);
        holder.imafoolfemthree.setTypeface(fontType);
        holder.imafoolfemfour.setTypeface(fontType);
        holder.imafoolfemfive.setTypeface(fontType);
        holder.imafoolfemsix.setTypeface(fontType);
        holder.imafoolfemseven.setTypeface(fontType);
        holder.imafoolfemeight.setTypeface(fontType);
        holder.imafoolfemnine.setTypeface(fontType);
        holder.isone.setTypeface(fontType);
        holder.istwo.setTypeface(fontType);
        holder.isthree.setTypeface(fontType);
        holder.isfour.setTypeface(fontType);
        holder.isfive.setTypeface(fontType);
        holder.issix.setTypeface(fontType);
        holder.isseven.setTypeface(fontType);
        holder.iseight.setTypeface(fontType);
        holder.isnine.setTypeface(fontType);
        holder.imafone.setTypeface(fontType);
        holder.imaftwo.setTypeface(fontType);
        holder.imafthree.setTypeface(fontType);
        holder.imaffour.setTypeface(fontType);
        holder.imaffive.setTypeface(fontType);
        holder.imafsix.setTypeface(fontType);
        holder.imafseven.setTypeface(fontType);
        holder.imafeight.setTypeface(fontType);
        holder.imafnine.setTypeface(fontType);
        //   SharedPref.arabicFontSelection();
        holder.muzmajhua.setTypeface(fontType);
        holder.muzmajhuma.setTypeface(fontType);
        holder.muzmajhum.setTypeface(fontType);
        holder.muzmajhia.setTypeface(fontType);
        holder.muzmajhumaf.setTypeface(fontType);
        holder.muzmajhunna.setTypeface(fontType);
        holder.muzmajanta.setTypeface(fontType);
        holder.muzmajantuma.setTypeface(fontType);
        holder.muzmajantum.setTypeface(fontType);
        holder.muzmajanti.setTypeface(fontType);
        holder.muzmajantumaf.setTypeface(fontType);
        holder.muzmajantunna.setTypeface(fontType);
        holder.muzmajana.setTypeface(fontType);
        holder.muzmajnahnu.setTypeface(fontType);
        //       FontSIzeSelection(holder);
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

    }

    private void FontSIzeSelection(ViewHolder holder) {
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        final Integer arabicFontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        //   Integer arabicFontsize=40;
        holder.mafalunone.setTextSize(arabicFontsize);//(mafalunone);
        holder.mafaluntwo.setTextSize(arabicFontsize);//(mafaluntwo);
        holder.mafalunthree.setTextSize(arabicFontsize);//(mafalunthree);
        holder.mafalunfour.setTextSize(arabicFontsize);//(mafalunfour);
        holder.mafalunfive.setTextSize(arabicFontsize);//(mafalunfive);
        holder.mafalunsix.setTextSize(arabicFontsize);//(mafalunsix);
        holder.mafalunseven.setTextSize(arabicFontsize);//(mafalunseven);
        holder.mafaluneight.setTextSize(arabicFontsize);//(mafaluneight);
        holder.mafalunnine.setTextSize(arabicFontsize);//(mafalunnine);
        holder.mifalunone.setTextSize(arabicFontsize);//(mifalunone);
        holder.mifaluntwo.setTextSize(arabicFontsize);//(mifaluntwo);
        holder.mifalunthree.setTextSize(arabicFontsize);//(mifalunthree);
        holder.mifalunfour.setTextSize(arabicFontsize);//(mifalunfour);
        holder.mifalunfive.setTextSize(arabicFontsize);//(mifalunfive);
        holder.mifalunsix.setTextSize(arabicFontsize);//(mifalunsix);
        holder.mifalunseven.setTextSize(arabicFontsize);//(mifalunseven);
        holder.mifaluneight.setTextSize(arabicFontsize);//(mifaluneight);
        holder.mifalunnine.setTextSize(arabicFontsize);//(mifalunnine);
        holder.mifalone.setTextSize(arabicFontsize);//(mifalone);
        holder.mifaltwo.setTextSize(arabicFontsize);//(mifaltwo);
        holder.mifalthree.setTextSize(arabicFontsize);//(mifalthree);
        holder.mifalfour.setTextSize(arabicFontsize);//(mifalfour);
        holder.mifalfive.setTextSize(arabicFontsize);//(mifalfive);
        holder.mifalsix.setTextSize(arabicFontsize);//(mifalsix);
        holder.mifalseven.setTextSize(arabicFontsize);//(mifalseven);
        holder.mifaleight.setTextSize(arabicFontsize);//(mifaleight);
        holder.mifalnine.setTextSize(arabicFontsize);//(mifalnine);
        holder.mifalatunone.setTextSize(arabicFontsize);//(mifalatunone);
        holder.mifalatuntwo.setTextSize(arabicFontsize);//(mifalatuntwo);
        holder.mifalatunthree.setTextSize(arabicFontsize);//(mifalatunthree);
        holder.mifalatunfour.setTextSize(arabicFontsize);//(mifalatunfour);
        holder.mifalatunfive.setTextSize(arabicFontsize);//(mifalatunfive);
        holder.mifalatunsix.setTextSize(arabicFontsize);//(mifalatunsix);
        holder.mifalatunseven.setTextSize(arabicFontsize);//(mifalatunseven);
        holder.mifalatuneight.setTextSize(arabicFontsize);//(mifalatuneight);
        holder.mifalatunnine.setTextSize(arabicFontsize);//(mifalatunnine);
        holder.mifaalone.setTextSize(arabicFontsize);//(mifaalone);
        holder.mifaaltwo.setTextSize(arabicFontsize);//(mifaaltwo);
        holder.mifaalthree.setTextSize(arabicFontsize);//(mifaalthree);
        holder.mifaalfour.setTextSize(arabicFontsize);//(mifaalfour);
        holder.mifaalfive.setTextSize(arabicFontsize);//(mifaalfive);
        holder.mifaalsix.setTextSize(arabicFontsize);//(mifaalsix);
        holder.mifaalseven.setTextSize(arabicFontsize);//(mifaalseven);
        holder.mifaaleight.setTextSize(arabicFontsize);//(mifaaleight);
        holder.mifaalnine.setTextSize(arabicFontsize);//(mifaalnine);
        holder.imafone.setTextSize(arabicFontsize);//smafone);
        holder.imaftwo.setTextSize(arabicFontsize);//smaftwo);
        holder.imafthree.setTextSize(arabicFontsize);//smafthree);
        holder.imaffour.setTextSize(arabicFontsize);//smaffour);
        holder.imaffive.setTextSize(arabicFontsize);//smaffive);
        holder.imafsix.setTextSize(arabicFontsize);//smafsix);
        holder.imafseven.setTextSize(arabicFontsize);//smafseven);
        holder.imafeight.setTextSize(arabicFontsize);//smafeight);
        holder.imafnine.setTextSize(arabicFontsize);//smafnine);
        //
        holder.imafoolfemone.setTextSize(arabicFontsize);//smafone);
        holder.imafoolfemtwo.setTextSize(arabicFontsize);//smaftwo);
        holder.imafoolfemthree.setTextSize(arabicFontsize);//smafthree);
        holder.imafoolfemfour.setTextSize(arabicFontsize);//smaffour);
        holder.imafoolfemfive.setTextSize(arabicFontsize);//smaffive);
        holder.imafoolfemsix.setTextSize(arabicFontsize);//smafsix);
        holder.imafoolfemseven.setTextSize(arabicFontsize);//smafseven);
        holder.imafoolfemeight.setTextSize(arabicFontsize);//smafeight);
        holder.imafoolfemnine.setTextSize(arabicFontsize);//smafnine);
        //
        holder.ismfemone.setTextSize(arabicFontsize);//iismfemone);
        holder.ismfemtwo.setTextSize(arabicFontsize);//iismfemtwo);
        holder.ismfemthree.setTextSize(arabicFontsize);//iismfemthree);
        holder.ismfemfour.setTextSize(arabicFontsize);//iismfemfour);
        holder.ismfemfive.setTextSize(arabicFontsize);//iismfemfive);
        holder.ismfemsix.setTextSize(arabicFontsize);//iismfemsix);
        holder.ismfemseven.setTextSize(arabicFontsize);//iismfemseven);
        holder.ismfemeight.setTextSize(arabicFontsize);//iismfemeight);
        holder.ismfemnine.setTextSize(arabicFontsize);//iismfemnine);
        holder.isone.setTextSize(arabicFontsize);//iisone);
        holder.istwo.setTextSize(arabicFontsize);//iistwo);
        holder.isthree.setTextSize(arabicFontsize);//iisthree);
        holder.isfour.setTextSize(arabicFontsize);//iisfour);
        holder.isfive.setTextSize(arabicFontsize);//iisfive);
        holder.issix.setTextSize(arabicFontsize);//iissix);
        holder.isseven.setTextSize(arabicFontsize);//iisseven);
        holder.iseight.setTextSize(arabicFontsize);//iiseight);
        holder.isnine.setTextSize(arabicFontsize);//iisnine);
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

    }

    private void MadhiMajhool(ViewHolder holder, int position) {
        String hua = sarfKabeer.get(position).get(0).toString();
        String huma = sarfKabeer.get(position).get(1).toString();
        String hum = sarfKabeer.get(position).get(2).toString();
        String hia = sarfKabeer.get(position).get(3).toString();
        String humaf = sarfKabeer.get(position).get(4).toString();
        String hunna = sarfKabeer.get(position).get(5).toString();
        String anta = sarfKabeer.get(position).get(6).toString();
        String antuma = sarfKabeer.get(position).get(7).toString();
        String antum = sarfKabeer.get(position).get(8).toString();
        String anti = sarfKabeer.get(position).get(9).toString();
        String antumaf = sarfKabeer.get(position).get(4).toString();
        String antunna = sarfKabeer.get(position).get(10).toString();
        String ana = sarfKabeer.get(position).get(11).toString();
        String nahnu = sarfKabeer.get(position).get(12).toString();
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        holder.mafalunone.setTypeface(mequran);//(mafalunone);
        holder.mafaluntwo.setTypeface(mequran);//(mafaluntwo);
        holder.mafalunthree.setTypeface(mequran);//(mafalunthree);
        holder.mafalunfour.setTypeface(mequran);//(mafalunfour);
        holder.mafalunfive.setTypeface(mequran);//(mafalunfive);
        holder.mafalunsix.setTypeface(mequran);//(mafalunsix);
        holder.mafalunseven.setTypeface(mequran);//(mafalunseven);
        holder.mafaluneight.setTypeface(mequran);//(mafaluneight);
        holder.mafalunnine.setTypeface(mequran);//(mafalunnine);
        holder.mifalunone.setTypeface(mequran);//(mifalunone);
        holder.mifaluntwo.setTypeface(mequran);//(mifaluntwo);
        holder.mifalunthree.setTypeface(mequran);//(mifalunthree);
        holder.mifalunfour.setTypeface(mequran);//(mifalunfour);
        holder.mifalunfive.setTypeface(mequran);//(mifalunfive);
        holder.mifalunsix.setTypeface(mequran);//(mifalunsix);
        holder.mifalunseven.setTypeface(mequran);//(mifalunseven);
        holder.mifaluneight.setTypeface(mequran);//(mifaluneight);
        holder.mifalunnine.setTypeface(mequran);//(mifalunnine);
        holder.mifalone.setTypeface(mequran);//(mifalone);
        holder.mifaltwo.setTypeface(mequran);//(mifaltwo);
        holder.mifalthree.setTypeface(mequran);//(mifalthree);
        holder.mifalfour.setTypeface(mequran);//(mifalfour);
        holder.mifalfive.setTypeface(mequran);//(mifalfive);
        holder.mifalsix.setTypeface(mequran);//(mifalsix);
        holder.mifalseven.setTypeface(mequran);//(mifalseven);
        holder.mifaleight.setTypeface(mequran);//(mifaleight);
        holder.mifalnine.setTypeface(mequran);//(mifalnine);
        holder.mifalatunone.setTypeface(mequran);//(mifalatunone);
        holder.mifalatuntwo.setTypeface(mequran);//(mifalatuntwo);
        holder.mifalatunthree.setTypeface(mequran);//(mifalatunthree);
        holder.mifalatunfour.setTypeface(mequran);//(mifalatunfour);
        holder.mifalatunfive.setTypeface(mequran);//(mifalatunfive);
        holder.mifalatunsix.setTypeface(mequran);//(mifalatunsix);
        holder.mifalatunseven.setTypeface(mequran);//(mifalatunseven);
        holder.mifalatuneight.setTypeface(mequran);//(mifalatuneight);
        holder.mifalatunnine.setTypeface(mequran);//(mifalatunnine);
        holder.mifaalone.setTypeface(mequran);//(mifaalone);
        holder.mifaaltwo.setTypeface(mequran);//(mifaaltwo);
        holder.mifaalthree.setTypeface(mequran);//(mifaalthree);
        holder.mifaalfour.setTypeface(mequran);//(mifaalfour);
        holder.mifaalfive.setTypeface(mequran);//(mifaalfive);
        holder.mifaalsix.setTypeface(mequran);//(mifaalsix);
        holder.mifaalseven.setTypeface(mequran);//(mifaalseven);
        holder.mifaaleight.setTypeface(mequran);//(mifaaleight);
        holder.mifaalnine.setTypeface(mequran);//(mifaalnine);
        holder.madimajhua.setTypeface(mequran);
        holder.madimajhuma.setTypeface(mequran);
        holder.madimajhum.setTypeface(mequran);
        holder.madimajhia.setTypeface(mequran);
        holder.madimajhumaf.setTypeface(mequran);
        holder.madimajhunna.setTypeface(mequran);
        holder.madimajanta.setTypeface(mequran);
        holder.madimajantuma.setTypeface(mequran);
        holder.madimajantum.setTypeface(mequran);
        holder.madimajanti.setTypeface(mequran);
        holder.madimajantumaf.setTypeface(mequran);
        holder.madimajantunna.setTypeface(mequran);
        holder.madimajana.setTypeface(mequran);
        holder.madimajnahnu.setTypeface(mequran);
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
        String hua = sarfKabeer.get(position).get(0).toString();
        String huma = sarfKabeer.get(position).get(1).toString();
        String hum = sarfKabeer.get(position).get(2).toString();
        String hia = sarfKabeer.get(position).get(3).toString();
        String humaf = sarfKabeer.get(position).get(4).toString();
        String hunna = sarfKabeer.get(position).get(5).toString();
        String anta = sarfKabeer.get(position).get(6).toString();
        String antuma = sarfKabeer.get(position).get(7).toString();
        String antum = sarfKabeer.get(position).get(8).toString();
        String anti = sarfKabeer.get(position).get(9).toString();
        String antumaf = sarfKabeer.get(position).get(4).toString();
        String antunna = sarfKabeer.get(position).get(10).toString();
        String ana = sarfKabeer.get(position).get(11).toString();
        String nahnu = sarfKabeer.get(position).get(12).toString();
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        holder.muzhua.setTypeface(mequran);
        holder.muzhuma.setTypeface(mequran);
        holder.muzhum.setTypeface(mequran);
        holder.muzhia.setTypeface(mequran);
        holder.muzhumaf.setTypeface(mequran);
        holder.muzhunna.setTypeface(mequran);
        holder.muzanta.setTypeface(mequran);
        holder.muzantuma.setTypeface(mequran);
        holder.muzantum.setTypeface(mequran);
        holder.muzanti.setTypeface(mequran);
        holder.muzantumaf.setTypeface(mequran);
        holder.muzantunna.setTypeface(mequran);
        holder.muzana.setTypeface(mequran);
        holder.muznahnu.setTypeface(mequran);
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
        String hua = sarfKabeer.get(position).get(0).toString();
        String huma = sarfKabeer.get(position).get(1).toString();
        String hum = sarfKabeer.get(position).get(2).toString();
        String hia = sarfKabeer.get(position).get(3).toString();
        String humaf = sarfKabeer.get(position).get(4).toString();
        String hunna = sarfKabeer.get(position).get(5).toString();
        String anta = sarfKabeer.get(position).get(6).toString();
        String antuma = sarfKabeer.get(position).get(7).toString();
        String antum = sarfKabeer.get(position).get(8).toString();
        String anti = sarfKabeer.get(position).get(9).toString();
        String antumaf = sarfKabeer.get(position).get(4).toString();
        String antunna = sarfKabeer.get(position).get(10).toString();
        String ana = sarfKabeer.get(position).get(11).toString();
        String nahnu = sarfKabeer.get(position).get(12).toString();
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());
        holder.madhihua.setTypeface(mequran);
        holder.madhihuma.setTypeface(mequran);
        holder.madhihum.setTypeface(mequran);
        holder.madhihia.setTypeface(mequran);
        holder.madhihumaf.setTypeface(mequran);
        holder.madhihunna.setTypeface(mequran);
        holder.madhianta.setTypeface(mequran);
        holder.madhiantuma.setTypeface(mequran);
        holder.madhiantum.setTypeface(mequran);
        holder.madhianti.setTypeface(mequran);
        holder.madhiantunna.setTypeface(mequran);
        holder.madhiantumaf.setTypeface(mequran);
        holder.madhiana.setTypeface(mequran);
        holder.madhinahnu.setTypeface(mequran);
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
        holder.madhiantunna.setText(antumaf);
        holder.madhiantumaf.setText(antunna);
        holder.madhiana.setText(ana);
        holder.madhinahnu.setText(nahnu);
    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return sarfKabeer.size();
    }

    public Object getItem(int position) {
        return sarfKabeer.get(position);
    }

    @Override
    public int getItemCount() {
        return sarfKabeer.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setVerbArrayList(ArrayList<ArrayList> sarfsagheer) {
        this.sarfKabeer = sarfsagheer;
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
        // imafmnine
        public final TextView isone, istwo, isthree, isfour, isfive, issix, isseven, iseight, isnine;
        public final TextView ismfemone, ismfemtwo, ismfemthree, ismfemfour, ismfemfive, ismfemsix, ismfemseven, ismfemeight, ismfemnine;
        public final TextView imafone, imaftwo, imafthree, imaffour, imaffive, imafsix, imafseven,
                imafeight, imafnine;
        public final TextView imafoolfemone, imafoolfemtwo, imafoolfemthree, imafoolfemfour, imafoolfemfive, imafoolfemsix, imafoolfemseven,
                imafoolfemeight, imafoolfemnine;
        public final TextView mifalone, mifaltwo, mifalthree, mifalfour, mifalfive, mifalsix, mifalseven, mifaleight, mifalnine;
        public final TextView mifalatunone, mifalatuntwo, mifalatunthree, mifalatunfour, mifalatunfive, mifalatunsix, mifalatunseven, mifalatuneight, mifalatunnine;
        public final TextView mifaalone, mifaaltwo, mifaalthree, mifaalfour, mifaalfive, mifaalsix, mifaalseven,
                mifaaleight, mifaalnine;
        public final TextView mafalunone, mafaluntwo, mafalunthree, mafalunfour, mafalunfive, mafalunsix, mafalunseven,
                mafaluneight, mafalunnine;
        public final TextView mifalunone, mifaluntwo, mifalunthree, mifalunfour, mifalunfive, mifalunsix, mifalunseven,
                mifaluneight, mifalunnine;

        public ViewHolder(View view) {
            super(view);
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
            madhiantunna = view.findViewById(R.id.madhiantumaf);
            madhiantumaf = view.findViewById(R.id.madhiantunna);
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
//ismfael masculine
            ismfemone = view.findViewById(R.id.ismfemone);
            ismfemtwo = view.findViewById(R.id.ismfemtwo);
            ismfemthree = view.findViewById(R.id.ismfemthree);
            ismfemfour = view.findViewById(R.id.ismfemfour);
            ismfemfive = view.findViewById(R.id.ismfemfive);
            ismfemsix = view.findViewById(R.id.ismfemsix);
            ismfemseven = view.findViewById(R.id.ismfemseven);
            ismfemeight = view.findViewById(R.id.ismfemeight);
            ismfemnine = view.findViewById(R.id.ismfemnine);
            //
            isone = view.findViewById(R.id.isone);
            istwo = view.findViewById(R.id.istwo);
            isthree = view.findViewById(R.id.isthree);
            isfour = view.findViewById(R.id.isfour);
            isfive = view.findViewById(R.id.isfive);
            issix = view.findViewById(R.id.issix);
            isseven = view.findViewById(R.id.isseven);
            iseight = view.findViewById(R.id.iseight);
            isnine = view.findViewById(R.id.isnine);
//ismmafoolmasculine
            imafone = view.findViewById(R.id.imafone);
            imaftwo = view.findViewById(R.id.imaftwo);
            imafthree = view.findViewById(R.id.imafthree);
            imaffour = view.findViewById(R.id.imaffour);
            imaffive = view.findViewById(R.id.imaffive);
            imafsix = view.findViewById(R.id.imafsix);
            imafseven = view.findViewById(R.id.imafseven);
            imafeight = view.findViewById(R.id.imafeight);
            imafnine = view.findViewById(R.id.imafnine);
            //ismmafoolfeb
            imafoolfemone = view.findViewById(R.id.imafoolfemone);
            imafoolfemtwo = view.findViewById(R.id.imafoolfemtwo);
            imafoolfemthree = view.findViewById(R.id.imafoolfemthree);
            imafoolfemfour = view.findViewById(R.id.imafoolfemfour);
            imafoolfemfive = view.findViewById(R.id.imafoolfemfive);
            imafoolfemsix = view.findViewById(R.id.imafoolfemsix);
            imafoolfemseven = view.findViewById(R.id.imafoolfemseven);
            imafoolfemeight = view.findViewById(R.id.imafoolfemeight);
            imafoolfemnine = view.findViewById(R.id.imafoolfemnine);
            mifalone = view.findViewById(R.id.mifalone);
            mifaltwo = view.findViewById(R.id.mifaltwo);
            mifalthree = view.findViewById(R.id.mifalthree);
            mifalfour = view.findViewById(R.id.mifalfour);
            mifalfive = view.findViewById(R.id.mifalfive);
            mifalsix = view.findViewById(R.id.mifalsix);
            mifalseven = view.findViewById(R.id.mifalseven);
            mifaleight = view.findViewById(R.id.mifaleight);
            mifalnine = view.findViewById(R.id.mifalnine);
            mifalatunone = view.findViewById(R.id.mifalatunone);
            mifalatuntwo = view.findViewById(R.id.mifalatuntwo);
            mifalatunthree = view.findViewById(R.id.mifalatunthree);
            mifalatunfour = view.findViewById(R.id.mifalatunfour);
            mifalatunfive = view.findViewById(R.id.mifalatunfive);
            mifalatunsix = view.findViewById(R.id.mifalatunsix);
            mifalatunseven = view.findViewById(R.id.mifalatunseven);
            mifalatuneight = view.findViewById(R.id.mifalatuneight);
            mifalatunnine = view.findViewById(R.id.mifalatunnine);
            mifaalone = view.findViewById(R.id.mifaalone);
            mifaaltwo = view.findViewById(R.id.mifaaltwo);
            mifaalthree = view.findViewById(R.id.mifaalthree);
            mifaalfour = view.findViewById(R.id.mifaalfour);
            mifaalfive = view.findViewById(R.id.mifaalfive);
            mifaalsix = view.findViewById(R.id.mifaalsix);
            mifaalseven = view.findViewById(R.id.mifaalseven);
            mifaaleight = view.findViewById(R.id.mifaaleight);
            mifaalnine = view.findViewById(R.id.mifaalnine);
            mafalunone = view.findViewById(R.id.mafalunone);
            mafaluntwo = view.findViewById(R.id.mafaluntwo);
            mafalunthree = view.findViewById(R.id.mafalunthree);
            mafalunfour = view.findViewById(R.id.mafalunfour);
            mafalunfive = view.findViewById(R.id.mafalunfive);
            mafalunsix = view.findViewById(R.id.mafalunsix);
            mafalunseven = view.findViewById(R.id.mafalunseven);
            mafaluneight = view.findViewById(R.id.mafaluneight);
            mafalunnine = view.findViewById(R.id.mafalunnine);
            mifalunone = view.findViewById(R.id.mifalunone);
            mifaluntwo = view.findViewById(R.id.mifaluntwo);
            mifalunthree = view.findViewById(R.id.mifalunthree);
            mifalunfour = view.findViewById(R.id.mifalunfour);
            mifalunfive = view.findViewById(R.id.mifalunfive);
            mifalunsix = view.findViewById(R.id.mifalunsix);
            mifalunseven = view.findViewById(R.id.mifalunseven);
            mifaluneight = view.findViewById(R.id.mifaluneight);
            mifalunnine = view.findViewById(R.id.mifalunnine);
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






