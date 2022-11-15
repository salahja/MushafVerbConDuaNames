package org.sj.conjugator.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import org.sj.conjugator.interfaces.OnItemClickListener;
import org.sj.conjugator.utilities.SharedPref;

import java.util.ArrayList;

public class IsmAlaSarfKabeerAdapter extends RecyclerView.Adapter<IsmAlaSarfKabeerAdapter.ViewHolder> {
    private final Context context;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    private ArrayList<String> madhi = new ArrayList<>();
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private int arabic_font_size;
    private Typeface arabicTypeface;
    private int urdu_font_size;
    private String arabic_font_selection;
    private ArrayList<ArrayList> sarfSagheer = new ArrayList<>();
    private boolean isTraditional;

    public IsmAlaSarfKabeerAdapter(ArrayList<ArrayList> lists, Context context) {
        this.context = context;
        this.sarfSagheer = lists;

    }

    public IsmAlaSarfKabeerAdapter(boolean mazeedregular, ArrayList sarfSagheer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = sarfSagheer;
        this.mazeedregular = mazeedregular;

    }

    public IsmAlaSarfKabeerAdapter(ArrayList<String> madhi, ArrayList<ArrayList> skabeer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = skabeer;
        this.madhi = madhi;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        isTraditional = SharedPref.SarfKabeerOthers();
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view;
        if (isTraditional) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismalasktraditional, parent, false);
        } else {
            //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismalacolumkabeer, parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismalacolumkabeer, parent, false);
        }
        //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        int ismalaf = sarfSagheer.get(0).size();
        int ismalas = sarfSagheer.get(1).size();
        //   if (ismalas == 9) {
        //   IsmAlamifalmifalatunNaqis(holder, 1);
        // } else {
        //     IsmAlamifalmifalatun(holder, 0);
        //  }
        IsmAlamifalmifal(holder, 0);
        IsmAlaMifalatun(holder, 1);
        IsmAlaMifaal(holder, 2);
        gcase(holder);
        ismalanumbers(holder);
        FontSIzeSelection(holder);
        SetTypeface(holder);

    }

    private void gcase(ViewHolder holder) {
        SharedPref sf = new SharedPref(context);
        String language = SharedPref.getLanguage();
        String[] array;
        if (language.equals("en")) {
            array = context.getResources().getStringArray(R.array.encase);
        } else {
            array = context.getResources().getStringArray(R.array.arcase);
        }
        if (isTraditional) {
            holder.nom.setText(array[0]);
            holder.acc.setText(array[1]);
            holder.gen.setText(array[2]);
            holder.nom1.setText(array[0]);
            holder.acc1.setText(array[1]);
            holder.gen1.setText(array[2]);
            holder.nom2.setText(array[0]);
            holder.acc2.setText(array[1]);
            holder.gen2.setText(array[2]);

        } else {
            holder.nom.setText(array[0]);
            holder.acc.setText(array[1]);
            holder.gen.setText(array[2]);

        }

    }

    private void ismalanumbers(ViewHolder holder) {
        SharedPref sf = new SharedPref(context);
        String language = SharedPref.getLanguage();
        String[] array;
        if (language.equals("en"))
            array = context.getResources().getStringArray(R.array.ennumbers);
        else {
            array = context.getResources().getStringArray(R.array.arnumbers);
        }
        if (isTraditional) {
            holder.sin1.setText(array[0]);
            holder.dual1.setText(array[1]);
            holder.plu1.setText(array[2]);
            holder.sin2.setText(array[0]);
            holder.dual2.setText(array[1]);
            holder.plu2.setText(array[2]);
            holder.sin3.setText(array[0]);
            holder.dual3.setText(array[1]);
            holder.plu3.setText(array[2]);
        } else {
            holder.sin1.setText(array[0]);
            holder.dual1.setText(array[1]);
            holder.plu1.setText(array[2]);
            holder.sin2.setText(array[0]);
            holder.dual2.setText(array[1]);
            holder.plu2.setText(array[2]);
            holder.sin3.setText(array[0]);
            holder.dual3.setText(array[1]);
            holder.plu3.setText(array[2]);

        }

    }

    private void IsmAlaMifaal(ViewHolder holder, int position) {
        String mifaalone = sarfSagheer.get(position).get(0).toString();//String mifaalone);
        String mifaaltwo = sarfSagheer.get(position).get(1).toString();//String mifaaltwo);
        String mifaalthree = "-";//String mifaalthree);
        String mifaalfour = sarfSagheer.get(position).get(2).toString();//String mifaalfour);
        String mifaalfive = sarfSagheer.get(position).get(3).toString();//String mifaalfive);
        String mifaalsix = "-";//String mifaalsix);
        String mifaalseven = sarfSagheer.get(position).get(4).toString();//String mifaalseven);
        String mifaaleight = sarfSagheer.get(position).get(5).toString();//String mifaaleight);
        String mifaalnine = "-";//mifaalnine);
        //     FontSIzeSelection(holder);
        SetTypeface(holder);
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

    private void IsmAlamifalmifalatunNaqis(ViewHolder holder, int position) {
        String mifalatunone = sarfSagheer.get(position).get(0).toString();//String mifalatunone);
        String mifalatuntwo = sarfSagheer.get(position).get(1).toString();//String mifalatuntwo);
        String mifalatunthree = sarfSagheer.get(position).get(2).toString();//String mifalatunthree);
        String mifalatunfour = sarfSagheer.get(position).get(3).toString();//String mifalatunfour);
        String mifalatunfive = sarfSagheer.get(position).get(4).toString();//String mifalatunfive);
        String mifalatunsix = sarfSagheer.get(position).get(5).toString();//String mifalatunsix);
        String mifalatunseven = sarfSagheer.get(position).get(6).toString();//String mifalatunseven);
        String mifalatuneight = sarfSagheer.get(position).get(7).toString();//String mifalatuneight);
        String mifalatunnine = sarfSagheer.get(position).get(8).toString();//mifalatunnine);
        //      FontSIzeSelection(holder);
        SetTypeface(holder);
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

    private void IsmAlamifalmifal(ViewHolder holder, int position) {
        String mifalone = sarfSagheer.get(position).get(0).toString();//String smifalone);
        String mifaltwo = sarfSagheer.get(position).get(1).toString();//String smifaltwo);
        String mifalthree = "-";//String smifalthree);
        String mifalfour = sarfSagheer.get(position).get(2).toString();//String smifalfour);
        String mifalfive = sarfSagheer.get(position).get(3).toString();//String smifalfive);
        String mifalsix = "-";
        String mifalseven = sarfSagheer.get(position).get(4).toString();//String smifalseven);
        String mifaleight = sarfSagheer.get(position).get(5).toString();//String smifaleight);
        String mifalnine = "-";//mifalnine);
        //    FontSIzeSelection(holder);
        SetTypeface(holder);
        //       FontSIzeSelection(holder);
        SetTypeface(holder);
        holder.mifalone.setText(mifalone);
        holder.mifaltwo.setText(mifaltwo);
        holder.mifalthree.setText(mifalthree);
        holder.mifalfour.setText(mifalfour);
        holder.mifalfive.setText(mifalfive);
        holder.mifalsix.setText(mifalsix);
        holder.mifalseven.setText(mifalseven);
        holder.mifaleight.setText(mifaleight);
        holder.mifalnine.setText(mifalnine);

    }

    private void IsmAlaMifalatun(ViewHolder holder, int position) {
        String mifalatunone = sarfSagheer.get(position).get(0).toString();//String mifalatunone);
        String mifalatuntwo = sarfSagheer.get(position).get(1).toString();//String mifalatuntwo);
        String mifalatunthree = "-";//String mifalatunthree);
        String mifalatunfour = sarfSagheer.get(position).get(2).toString();//String mifalatunfour);
        String mifalatunfive = sarfSagheer.get(position).get(3).toString();//String mifalatunfive);
        String mifalatunsix = "-";//String mifalatunsix);
        String mifalatunseven = sarfSagheer.get(position).get(4).toString();//String mifalatunseven);
        String mifalatuneight = sarfSagheer.get(position).get(5).toString();//String mifalatuneight);
        String mifalatunnine = "-";//mifalatunnine);
        //    FontSIzeSelection(holder);
        SetTypeface(holder);
        //    FontSIzeSelection(holder);
        SetTypeface(holder);
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

    private void FontSIzeSelection(ViewHolder holder) {
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String width = sharedPreferences.getString("width", "compactWidth");
        final Integer arabicFontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        if (width.equals("mediumWidth") || width.equals("expandedWidth")) {
            if (isTraditional) {
                holder.nom.setTextSize(arabicFontsize);//(array[0]);
                holder.acc.setTextSize(arabicFontsize);//(array[1]);
                holder.gen.setTextSize(arabicFontsize);//(array[2]);
                holder.nom1.setTextSize(arabicFontsize);//(array[0]);
                holder.acc1.setTextSize(arabicFontsize);//(array[1]);
                holder.gen1.setTextSize(arabicFontsize);//(array[2]);
                holder.nom2.setTextSize(arabicFontsize);//(array[0]);
                holder.acc2.setTextSize(arabicFontsize);//(array[1]);
                holder.gen2.setTextSize(arabicFontsize);//(array[2]);
                holder.sin1.setTextSize(arabicFontsize);//(array[0]);
                holder.dual1.setTextSize(arabicFontsize);//(array[1]);
                holder.plu1.setTextSize(arabicFontsize);//(array[2]);
                holder.sin2.setTextSize(arabicFontsize);//(array[0]);
                holder.dual2.setTextSize(arabicFontsize);//(array[1]);
                holder.plu2.setTextSize(arabicFontsize);//(array[2]);
                holder.sin3.setTextSize(arabicFontsize);//(array[0]);
                holder.dual3.setTextSize(arabicFontsize);//(array[1]);
                holder.plu3.setTextSize(arabicFontsize);//(array[2]);

            } else {
                holder.nom.setTextSize(arabicFontsize);//(array[0]);
                holder.acc.setTextSize(arabicFontsize);//(array[1]);
                holder.gen.setTextSize(arabicFontsize);//(array[2]);
                holder.sin1.setTextSize(arabicFontsize);//(array[0]);
                holder.dual1.setTextSize(arabicFontsize);//(array[1]);
                holder.plu1.setTextSize(arabicFontsize);//(array[2]);
                holder.sin2.setTextSize(arabicFontsize);//(array[0]);
                holder.dual2.setTextSize(arabicFontsize);//(array[1]);
                holder.plu2.setTextSize(arabicFontsize);//(array[2]);
                holder.sin3.setTextSize(arabicFontsize);//(array[0]);
                holder.dual2.setTextSize(arabicFontsize);//(array[1]);
                holder.dual3.setTextSize(arabicFontsize);//(array[2]);

            }
        }
        /*    holder.nom.setTextSize(arabicFontsize);//(array[0]);
            holder.acc.setTextSize(arabicFontsize);//(array[1]);
            holder.gen.setTextSize(arabicFontsize);//(array[2]);
            holder.sin1.setTextSize(arabicFontsize);//(array[0]);
            holder.dual1.setTextSize(arabicFontsize);//(array[1]);
            holder.plu1.setTextSize(arabicFontsize);//(array[2]);

            holder.sin2.setTextSize(arabicFontsize);//(array[0]);
            holder.dual2.setTextSize(arabicFontsize);//(array[1]);
            holder.plu2.setTextSize(arabicFontsize);//(array[2]);

            holder.sin3.setTextSize(arabicFontsize);//(array[0]);
            holder.dual2.setTextSize(arabicFontsize);//(array[1]);
            holder.dual3.setTextSize(arabicFontsize);//(array[2]);*/
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

    }

    private void SetTypeface(ViewHolder holder) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        //  String theme = sharedPreferences.getString("theme", 1);
        String indictive = sharedPreferences.getString("Arabic_Font_Selection", "kitab.ttf");
        arabicTypeface = Typeface.createFromAsset(context.getAssets(), indictive);
        holder.nom.setTypeface(arabicTypeface);//(array[0]);
        holder.acc.setTypeface(arabicTypeface);//(array[1]);
        holder.gen.setTypeface(arabicTypeface);//(array[2]);
        holder.sin1.setTypeface(arabicTypeface);// (array[0]);
        holder.dual1.setTypeface(arabicTypeface);// (array[1]);
        holder.plu1.setTypeface(arabicTypeface);// (array[2]);
        holder.sin2.setTypeface(arabicTypeface);// (array[0]);
        holder.dual2.setTypeface(arabicTypeface);// (array[1]);
        holder.plu2.setTypeface(arabicTypeface);// (array[2]);
        holder.sin3.setTypeface(arabicTypeface);// (array[0]);
        holder.dual2.setTypeface(arabicTypeface);// (array[1]);
        holder.dual3.setTypeface(arabicTypeface);// (array[2]);
        holder.mifalone.setTypeface(arabicTypeface);//(mifalone);
        holder.mifaltwo.setTypeface(arabicTypeface);//(mifaltwo);
        holder.mifalthree.setTypeface(arabicTypeface);//(mifalthree);
        holder.mifalfour.setTypeface(arabicTypeface);//(mifalfour);
        holder.mifalfive.setTypeface(arabicTypeface);//(mifalfive);
        holder.mifalsix.setTypeface(arabicTypeface);//(mifalsix);
        holder.mifalseven.setTypeface(arabicTypeface);//(mifalseven);
        holder.mifaleight.setTypeface(arabicTypeface);//(mifaleight);
        holder.mifalnine.setTypeface(arabicTypeface);//(mifalnine);
        holder.mifalatunone.setTypeface(arabicTypeface);//(mifalatunone);
        holder.mifalatuntwo.setTypeface(arabicTypeface);//(mifalatuntwo);
        holder.mifalatunthree.setTypeface(arabicTypeface);//(mifalatunthree);
        holder.mifalatunfour.setTypeface(arabicTypeface);//(mifalatunfour);
        holder.mifalatunfive.setTypeface(arabicTypeface);//(mifalatunfive);
        holder.mifalatunsix.setTypeface(arabicTypeface);//(mifalatunsix);
        holder.mifalatunseven.setTypeface(arabicTypeface);//(mifalatunseven);
        holder.mifalatuneight.setTypeface(arabicTypeface);//(mifalatuneight);
        holder.mifalatunnine.setTypeface(arabicTypeface);//(mifalatunnine);
        holder.mifaalone.setTypeface(arabicTypeface);//(mifaalone);
        holder.mifaaltwo.setTypeface(arabicTypeface);//(mifaaltwo);
        holder.mifaalthree.setTypeface(arabicTypeface);//(mifaalthree);
        holder.mifaalfour.setTypeface(arabicTypeface);//(mifaalfour);
        holder.mifaalfive.setTypeface(arabicTypeface);//(mifaalfive);
        holder.mifaalsix.setTypeface(arabicTypeface);//(mifaalsix);
        holder.mifaalseven.setTypeface(arabicTypeface);//(mifaalseven);
        holder.mifaaleight.setTypeface(arabicTypeface);//(mifaaleight);
        holder.mifaalnine.setTypeface(arabicTypeface);//(mifaalnine);

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
        //  return sarfSagheer.size();
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
        public final TextView sin1, dual1, plu1, sin2, dual2, plu2, sin3, dual3, plu3;
        public final TextView nom, acc, gen;
        public final TextView nom1, acc1, gen1;
        public final TextView nom2, acc2, gen2;

        public ViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.indictive);
            acc = view.findViewById(R.id.subjunctive);
            gen = view.findViewById(R.id.genitive);
            nom1 = view.findViewById(R.id.nominative1);
            acc1 = view.findViewById(R.id.accusative1);
            gen1 = view.findViewById(R.id.genitive1);
            nom2 = view.findViewById(R.id.nominative2);
            acc2 = view.findViewById(R.id.accusative2);
            gen2 = view.findViewById(R.id.genitive2);
            sin1 = view.findViewById(R.id.singular1);
            dual1 = view.findViewById(R.id.dual1);
            plu1 = view.findViewById(R.id.plural1);
            sin2 = view.findViewById(R.id.singular2);
            dual2 = view.findViewById(R.id.dual2);
            plu2 = view.findViewById(R.id.plural2);
            sin3 = view.findViewById(R.id.singular3);
            dual3 = view.findViewById(R.id.dual3);
            plu3 = view.findViewById(R.id.plural3);
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






