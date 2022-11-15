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

public class IsmZarffKabeerAdapter extends RecyclerView.Adapter<IsmZarffKabeerAdapter.ViewHolder> {
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
    private int urdu_font_size;
    private String arabic_font_selection;
    private ArrayList<ArrayList> sarfSagheer = new ArrayList<>();
    private boolean isTraditional;

    public IsmZarffKabeerAdapter(ArrayList<ArrayList> lists, Context context) {
        this.context = context;
        this.sarfSagheer = lists;

    }

    public IsmZarffKabeerAdapter(boolean mazeedregular, ArrayList sarfSagheer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = sarfSagheer;
        this.mazeedregular = mazeedregular;

    }

    public IsmZarffKabeerAdapter(ArrayList<String> madhi, ArrayList<ArrayList> skabeer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = skabeer;
        this.madhi = madhi;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        isTraditional = SharedPref.SarfKabeerOthers();
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view;
        if (isTraditional) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismzarfkbtraditional, parent, false);
        } else {
            //  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zarfcolumnkabeer , parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismzarfcolumnkabeer, parent, false);
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
        int size = sarfSagheer.get(0).size();
        if (size > 1) {
            Zarfmafal(holder, 0, size);
            Zarfmafil(holder, 1, size);
            Zarfmafalatun(holder, 2, size);
            ismzarfnumbers(holder);
            gcase(holder);
            FontSIzeSelection(holder);
            SetTypeface(holder);

        }

    }

    private void gcase(ViewHolder holder) {
        SharedPref sf = new SharedPref(context);
        String language = SharedPref.getLanguage();
        String[] array;
        if (language.equals("en"))
            array = context.getResources().getStringArray(R.array.encase);
        else {
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

    private void ismzarfnumbers(ViewHolder holder) {
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

    private void Zarfmafal(ViewHolder holder, int position, int size) {
        String mafalunone = sarfSagheer.get(position).get(0).toString();//String smafalunone);
        String mafaluntwo = sarfSagheer.get(position).get(1).toString();//String smafaluntwo);
        String mafalunthree = "";//String smafalunthree);
        String mafalunfour = sarfSagheer.get(position).get(2).toString();//String smafalunfour);
        String mafalunfive = sarfSagheer.get(position).get(3).toString();//String smafalunfive);
        String mafalunsix = "";//String smafalunsix);
        String mafalunseven = sarfSagheer.get(position).get(4).toString();//String smafalunseven);
        String mafaluneight = sarfSagheer.get(position).get(5).toString();//String smafaluneight);
        String mafalunnine = "";//mafalunnine);
        holder.mafalunone.setText(mafalunone);
        holder.mafaluntwo.setText(mafaluntwo);
        holder.mafalunthree.setText(mafalunthree);
        holder.mafalunfour.setText(mafalunfour);
        holder.mafalunfive.setText(mafalunfive);
        holder.mafalunsix.setText(mafalunsix);
        holder.mafalunseven.setText(mafalunseven);
        holder.mafaluneight.setText(mafaluneight);
        holder.mafalunnine.setText(mafalunnine);

    }

    private void Zarfmafil(ViewHolder holder, int position, int size) {
        String zarfmafalunone = sarfSagheer.get(position).get(0).toString();//String zarfmafalunone);
        String zarfmafaluntwo = sarfSagheer.get(position).get(1).toString();//String zarfmafaluntwo);
        String zarfmafalunthree = "-";//String zarfmafalunthree);
        String zarfmafalunfour = sarfSagheer.get(position).get(2).toString();//String zarfmafalunfour);
        String zarfmafalunfive = sarfSagheer.get(position).get(3).toString();//String zarfmafalunfive);
        String zarfmafalunsix = "-";//String zarfmafalunsix);
        String zarfmafalunseven = sarfSagheer.get(position).get(4).toString();//String zarfmafalunseven);
        String zarfmafaluneight = sarfSagheer.get(position).get(5).toString();//String zarfmafaluneight);
        String zarfmafalunnine = "-";//mifalatunnine);
        holder.zarfmafalunone.setText(zarfmafalunone);
        holder.zarfmafaluntwo.setText(zarfmafaluntwo);
        holder.zarfmafalunthree.setText(zarfmafalunthree);
        holder.zarfmafalunfour.setText(zarfmafalunfour);
        holder.zarfmafalunfive.setText(zarfmafalunfive);
        holder.zarfmafalunsix.setText(zarfmafalunsix);
        holder.zarfmafalunseven.setText(zarfmafalunseven);
        holder.zarfmafaluneight.setText(zarfmafaluneight);
        holder.zarfmafalunnine.setText(zarfmafalunnine);

    }

    private void Zarfmafalatun(ViewHolder holder, int position, int size) {
        String zarffemone = sarfSagheer.get(position).get(0).toString();//String zarffemone);
        String zarffemtwo = sarfSagheer.get(position).get(1).toString();//String zarffemtwo);
        String zarffemthree = "-";//String zarffemthree);
        String zarffemfour = sarfSagheer.get(position).get(2).toString();//String zarffemfour);
        String zarffemfive = sarfSagheer.get(position).get(3).toString();//String zarffemfive);
        String zarffemsix = "-";//String zarffemsix);
        String zarffemseven = sarfSagheer.get(position).get(4).toString();//String zarffemseven);
        String zarffemeight = sarfSagheer.get(position).get(5).toString();//String zarffemeight);
        String zarffemnine = "-";//mifalatunnine);
        holder.zarffemone.setText(zarffemone);
        holder.zarffemtwo.setText(zarffemtwo);
        holder.zarffemthree.setText(zarffemthree);
        holder.zarffemfour.setText(zarffemfour);
        holder.zarffemfive.setText(zarffemfive);
        holder.zarffemsix.setText(zarffemsix);
        holder.zarffemseven.setText(zarffemseven);
        holder.zarffemeight.setText(zarffemeight);
        holder.zarffemnine.setText(zarffemnine);

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
            holder.mafalunone.setTextSize(arabicFontsize);//;//(mafalunone);
            holder.mafaluntwo.setTextSize(arabicFontsize);//;//(mafaluntwo);
            holder.mafalunthree.setTextSize(arabicFontsize);//;//(mafalunthree);
            holder.mafalunfour.setTextSize(arabicFontsize);//;//(mafalunfour);
            holder.mafalunfive.setTextSize(arabicFontsize);//;//(mafalunfive);
            holder.mafalunsix.setTextSize(arabicFontsize);//;//(mafalunsix);
            holder.mafalunseven.setTextSize(arabicFontsize);//;//(mafalunseven);
            holder.mafaluneight.setTextSize(arabicFontsize);//;//(mafaluneight);
            holder.mafalunnine.setTextSize(arabicFontsize);//;//(mafalunnine);
            holder.zarfmafalunone.setTextSize(arabicFontsize);//;//(zarfmafalunone);
            holder.zarfmafaluntwo.setTextSize(arabicFontsize);//;//(zarfmafaluntwo);
            holder.zarfmafalunthree.setTextSize(arabicFontsize);//;//(zarfmafalunthree);
            holder.zarfmafalunfour.setTextSize(arabicFontsize);//;//(zarfmafalunfour);
            holder.zarfmafalunfive.setTextSize(arabicFontsize);//;//(zarfmafalunfive);
            holder.zarfmafalunsix.setTextSize(arabicFontsize);//;//(zarfmafalunsix);
            holder.zarfmafalunseven.setTextSize(arabicFontsize);//;//(zarfmafalunseven);
            holder.zarfmafaluneight.setTextSize(arabicFontsize);//;//(zarfmafaluneight);
            holder.zarfmafalunnine.setTextSize(arabicFontsize);//;//(zarfmafalunnine);
            holder.zarffemone.setTextSize(arabicFontsize);//;//(zarffemone);
            holder.zarffemtwo.setTextSize(arabicFontsize);//;//(zarffemtwo);
            holder.zarffemthree.setTextSize(arabicFontsize);//;//(zarffemthree);
            holder.zarffemfour.setTextSize(arabicFontsize);//;//(zarffemfour);
            holder.zarffemfive.setTextSize(arabicFontsize);//;//(zarffemfive);
            holder.zarffemsix.setTextSize(arabicFontsize);//;//(zarffemsix);
            holder.zarffemseven.setTextSize(arabicFontsize);//;//(zarffemseven);
            holder.zarffemeight.setTextSize(arabicFontsize);//;//(zarffemeight);
            holder.zarffemnine.setTextSize(arabicFontsize);//;//(zarfmafalunnine);
        }

    }

    private void SetTypeface(ViewHolder holder) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        //  String theme = sharedPreferences.getString("theme", 1);
        String indictive = sharedPreferences.getString("Arabic_Font_Selection", "kitab.ttf");
        Typeface arabicTypeface = Typeface.createFromAsset(context.getAssets(), indictive);
        holder.nom.setTypeface(arabicTypeface, Typeface.BOLD);//(array[0]);
        holder.nom.setTypeface(arabicTypeface, Typeface.BOLD);
        //(array[1]);
        holder.nom.setTypeface(arabicTypeface, Typeface.BOLD);
        //(array[2]);
        holder.sin1.setTypeface(arabicTypeface, Typeface.BOLD);// (array[0]);
        holder.dual1.setTypeface(arabicTypeface, Typeface.BOLD);// (array[1]);
        holder.plu1.setTypeface(arabicTypeface, Typeface.BOLD);// (array[2]);
        holder.sin2.setTypeface(arabicTypeface, Typeface.BOLD);// (array[0]);
        holder.dual2.setTypeface(arabicTypeface, Typeface.BOLD);// (array[1]);
        holder.plu2.setTypeface(arabicTypeface, Typeface.BOLD);// (array[2]);
        holder.sin3.setTypeface(arabicTypeface, Typeface.BOLD);// (array[0]);
        holder.dual2.setTypeface(arabicTypeface, Typeface.BOLD);// (array[1]);
        holder.dual3.setTypeface(arabicTypeface, Typeface.BOLD);// (array[2]);
        holder.mafalunone.setTypeface(arabicTypeface);//(mafalunone);
        holder.mafaluntwo.setTypeface(arabicTypeface);//(mafaluntwo);
        holder.mafalunthree.setTypeface(arabicTypeface);//(mafalunthree);
        holder.mafalunfour.setTypeface(arabicTypeface);//(mafalunfour);
        holder.mafalunfive.setTypeface(arabicTypeface);//(mafalunfive);
        holder.mafalunsix.setTypeface(arabicTypeface);//(mafalunsix);
        holder.mafalunseven.setTypeface(arabicTypeface);//(mafalunseven);
        holder.mafaluneight.setTypeface(arabicTypeface);//(mafaluneight);
        holder.mafalunnine.setTypeface(arabicTypeface);//(mafalunnine);
        holder.zarfmafalunone.setTypeface(arabicTypeface);//(zarfmafalunone);
        holder.zarfmafaluntwo.setTypeface(arabicTypeface);//(zarfmafaluntwo);
        holder.zarfmafalunthree.setTypeface(arabicTypeface);//(zarfmafalunthree);
        holder.zarfmafalunfour.setTypeface(arabicTypeface);//(zarfmafalunfour);
        holder.zarfmafalunfive.setTypeface(arabicTypeface);//(zarfmafalunfive);
        holder.zarfmafalunsix.setTypeface(arabicTypeface);//(zarfmafalunsix);
        holder.zarfmafalunseven.setTypeface(arabicTypeface);//(zarfmafalunseven);
        holder.zarfmafaluneight.setTypeface(arabicTypeface);//(zarfmafaluneight);
        holder.zarfmafalunnine.setTypeface(arabicTypeface);//(zarfmafalunnine);
        holder.zarffemone.setTypeface(arabicTypeface);//(zarffemone);
        holder.zarffemtwo.setTypeface(arabicTypeface);//(zarffemtwo);
        holder.zarffemthree.setTypeface(arabicTypeface);//(zarffemthree);
        holder.zarffemfour.setTypeface(arabicTypeface);//(zarffemfour);
        holder.zarffemfive.setTypeface(arabicTypeface);//(zarffemfive);
        holder.zarffemsix.setTypeface(arabicTypeface);//(zarffemsix);
        holder.zarffemseven.setTypeface(arabicTypeface);//(zarffemseven);
        holder.zarffemeight.setTypeface(arabicTypeface);//(zarffemeight);
        holder.zarffemnine.setTypeface(arabicTypeface);//(zarfmafalunnine);

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
        public final TextView mafalunone, mafaluntwo, mafalunthree, mafalunfour, mafalunfive, mafalunsix, mafalunseven,
                mafaluneight, mafalunnine;
        public final TextView zarfmafalunone, zarfmafaluntwo, zarfmafalunthree, zarfmafalunfour, zarfmafalunfive, zarfmafalunsix, zarfmafalunseven,
                zarfmafaluneight, zarfmafalunnine;
        public final TextView zarffemone, zarffemtwo, zarffemthree, zarffemfour, zarffemfive, zarffemsix, zarffemseven,
                zarffemeight, zarffemnine;
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
            mafalunone = view.findViewById(R.id.mafalunone);
            mafaluntwo = view.findViewById(R.id.mafaluntwo);
            mafalunthree = view.findViewById(R.id.mafalunthree);
            mafalunfour = view.findViewById(R.id.mafalunfour);
            mafalunfive = view.findViewById(R.id.mafalunfive);
            mafalunsix = view.findViewById(R.id.mafalunsix);
            mafalunseven = view.findViewById(R.id.mafalunseven);
            mafaluneight = view.findViewById(R.id.mafaluneight);
            mafalunnine = view.findViewById(R.id.mafalunnine);
            zarffemone = view.findViewById(R.id.zarffemone);
            zarffemtwo = view.findViewById(R.id.zarffemtwo);
            zarffemthree = view.findViewById(R.id.zarffemthree);
            zarffemfour = view.findViewById(R.id.zarffemfour);
            zarffemfive = view.findViewById(R.id.zarffemfive);
            zarffemsix = view.findViewById(R.id.zarffemsix);
            zarffemseven = view.findViewById(R.id.zarffemseven);
            zarffemeight = view.findViewById(R.id.zarffemeight);
            zarffemnine = view.findViewById(R.id.zarffemnine);
            zarfmafalunone = view.findViewById(R.id.zarfmafalunone);
            zarfmafaluntwo = view.findViewById(R.id.zarfmafaluntwo);
            zarfmafalunthree = view.findViewById(R.id.zarfmafalunthree);
            zarfmafalunfour = view.findViewById(R.id.zarfmafalunfour);
            zarfmafalunfive = view.findViewById(R.id.zarfmafalunfive);
            zarfmafalunsix = view.findViewById(R.id.zarfmafalunsix);
            zarfmafalunseven = view.findViewById(R.id.zarfmafalunseven);
            zarfmafaluneight = view.findViewById(R.id.zarfmafaluneight);
            zarfmafalunnine = view.findViewById(R.id.zarfmafalunnine);
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






