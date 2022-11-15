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

public class IsmFaelIsmMafoolSarfKabeerAdapter extends RecyclerView.Adapter<IsmFaelIsmMafoolSarfKabeerAdapter.ViewHolder> {
    private final Context context;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
    //    private final Integer arabicTextColor;
    Context mycontext;
    private SharedPref sharedPref;
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
    private Typeface arabicTypeface;
    private boolean isTraditional, newsarf;

    public IsmFaelIsmMafoolSarfKabeerAdapter(ArrayList<ArrayList> lists, Context context, boolean newsarf) {
        this.context = context;
        this.sarfSagheer = lists;
        this.newsarf = newsarf;
        sharedPref = new SharedPref(context);

    }

    public IsmFaelIsmMafoolSarfKabeerAdapter(boolean mazeedregular, ArrayList sarfSagheer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = sarfSagheer;
        this.mazeedregular = mazeedregular;
        sharedPref = new SharedPref(context);
    }

    public IsmFaelIsmMafoolSarfKabeerAdapter(ArrayList<String> madhi, ArrayList<ArrayList> skabeer, FragmentActivity activity) {
        this.context = activity;
        this.sarfSagheer = skabeer;
        this.madhi = madhi;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        isTraditional = SharedPref.SarfKabeerOthers();
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view;
        if (isTraditional) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismfaelmafoolsktraditional, parent, false);
        } else {
            //   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismfaelmafoolcolumkabeer, parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ismfaelmafoolcolumkabeer, parent, false);
        }
        //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        //  final List sarf = sarfSagheer.get(position);
        boolean newsarf = true;
        if (newsarf) {
            SetTypeFace(holder);
            IsmFael(holder, 0);
            IsmFaelFem(holder, 0);
            IsmMafool(holder, 1);
            IsmMafoolFem(holder, 1);

        } else {
            SetTypeFace(holder);
            IsmFael(holder, 6);
            IsmFaelFem(holder, 6);
            IsmMafool(holder, 7);
            IsmMafoolFem(holder, 7);

        }
        gcase(holder);
        ismfaelmafoolnumbers(holder);
        //      FontSIzeSelection(holder);
        String[] array;
        SharedPref sf = new SharedPref(context);
        String language = SharedPref.getLanguage();
        if (language.equals("en")) {
            array = context.getResources().getStringArray(R.array.enismfaelmafoolheadings);

        } else {
            array = context.getResources().getStringArray(R.array.arismfaelmafoolheadings);
        }
        holder.apmas.setText(array[0]);
        holder.apfem.setText(array[1]);
        holder.ppmas.setText(array[2]);
        holder.ppfem.setText(array[3]);
        //    IsmAlamifalmifalatun(holder,8);
        //  IsmAlaMifaal(holder,9);
        // Zarf(holder,10);
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
            holder.nom3.setText(array[0]);
            holder.acc3.setText(array[1]);
            holder.gen3.setText(array[2]);
        } else {
            holder.nom.setText(array[0]);
            holder.acc.setText(array[1]);
            holder.gen.setText(array[2]);

        }
    }

    private void ismfaelmafoolnumbers(ViewHolder holder) {
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
            holder.sin4.setText(array[0]);
            holder.dual4.setText(array[1]);
            holder.plu4.setText(array[2]);

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

    private void IsmFael(ViewHolder holder, int position) {
        String iisone = sarfSagheer.get(position).get(0).toString();//isone);
        String iistwo = sarfSagheer.get(position).get(2).toString();//istwo);
        String iisthree = sarfSagheer.get(position).get(4).toString();//isthree);
        String iisfour = sarfSagheer.get(position).get(6).toString();//isfour);
        String iisfive = sarfSagheer.get(position).get(8).toString();//isfive);
        String iissix = sarfSagheer.get(position).get(10).toString();//issix);
        String iisseven = sarfSagheer.get(position).get(12).toString();//isseven);
        String iiseight = sarfSagheer.get(position).get(14).toString();//iseight);
        String iisnine = sarfSagheer.get(position).get(16).toString();//isnine);
        //    FontSIzeSelection(holder);
        SetTypeFace(holder);
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
        String iisone = sarfSagheer.get(position).get(1).toString();//isone);
        String iistwo = sarfSagheer.get(position).get(3).toString();//istwo);
        String iisthree = sarfSagheer.get(position).get(5).toString();//isthree);
        String iisfour = sarfSagheer.get(position).get(7).toString();//isfour);
        String iisfive = sarfSagheer.get(position).get(9).toString();//isfive);
        String iissix = sarfSagheer.get(position).get(11).toString();//issix);
        String iisseven = sarfSagheer.get(position).get(13).toString();//isseven);
        String iiseight = sarfSagheer.get(position).get(15).toString();//iseight);
        String iisnine = sarfSagheer.get(position).get(17).toString();//isnine);
        //     FontSIzeSelection(holder);
        SetTypeFace(holder);
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
        String smafone = sarfSagheer.get(position).get(1).toString();
        String smaftwo = sarfSagheer.get(position).get(3).toString();//imaftwo);
        String smafthree = sarfSagheer.get(position).get(5).toString();//imafthree);
        String smaffour = sarfSagheer.get(position).get(7).toString();//imaffour);
        String smaffive = sarfSagheer.get(position).get(9).toString();//imaffive);
        String smafsix = sarfSagheer.get(position).get(11).toString();//imafseven);
        String smafseven = sarfSagheer.get(position).get(13).toString();//imafseven);
        String smafeight = sarfSagheer.get(position).get(15).toString();//imafeight);
        String smafnine = sarfSagheer.get(position).get(17).toString();//imafnine);
        //     FontSIzeSelection(holder);
        SetTypeFace(holder);
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
        String smafone = sarfSagheer.get(position).get(0).toString();
        String smaftwo = sarfSagheer.get(position).get(2).toString();//imaftwo);
        String smafthree = sarfSagheer.get(position).get(4).toString();//imafthree);
        String smaffour = sarfSagheer.get(position).get(6).toString();//imaffour);
        String smaffive = sarfSagheer.get(position).get(8).toString();//imaffive);
        String smafsix = sarfSagheer.get(position).get(10).toString();//imafseven);
        String smafseven = sarfSagheer.get(position).get(12).toString();//imafseven);
        String smafeight = sarfSagheer.get(position).get(14).toString();//imafeight);
        String smafnine = sarfSagheer.get(position).get(16).toString();//imafnine);
        //     FontSIzeSelection(holder);
        SetTypeFace(holder);
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

    private void SetTypeFace(ViewHolder holder) {
        //    final Typeface arabicTypeface = Typeface.createFromAsset(context.getAssets(), "Pdms.ttf");
        //    arabicTypeface = Typeface.createFromAsset(context.getAssets(), sharedPref.arabicFontSelection());
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        //  String theme = sharedPreferences.getString("theme", 1);
        String indictive = sharedPreferences.getString("Arabic_Font_Selection", "kitab.ttf");
        arabicTypeface = Typeface.createFromAsset(context.getAssets(), indictive);
        //   String s = SharedPref.arabicFontSelection();
        if (isTraditional) {
            holder.nom.setTypeface(arabicTypeface);// (array[0]);
            holder.acc.setTypeface(arabicTypeface);// (array[1]);
            holder.gen.setTypeface(arabicTypeface);// (array[2]);
            holder.nom1.setTypeface(arabicTypeface);// (array[0]);
            holder.acc1.setTypeface(arabicTypeface);// (array[1]);
            holder.gen1.setTypeface(arabicTypeface);// (array[2]);
            holder.nom2.setTypeface(arabicTypeface);// (array[0]);
            holder.acc2.setTypeface(arabicTypeface);// (array[1]);
            holder.gen2.setTypeface(arabicTypeface);// (array[2]);
            holder.nom3.setTypeface(arabicTypeface);// (array[0]);
            holder.acc3.setTypeface(arabicTypeface);// (array[1]);
            holder.gen3.setTypeface(arabicTypeface);// (array[2]);
            holder.sin1.setTypeface(arabicTypeface);//(array[0]);
            holder.dual1.setTypeface(arabicTypeface);//(array[1]);
            holder.plu1.setTypeface(arabicTypeface);//(array[2]);
            holder.sin2.setTypeface(arabicTypeface);//(array[0]);
            holder.dual2.setTypeface(arabicTypeface);//(array[1]);
            holder.plu2.setTypeface(arabicTypeface);//(array[2]);
            holder.sin3.setTypeface(arabicTypeface);//(array[0]);
            holder.dual3.setTypeface(arabicTypeface);//(array[1]);
            holder.plu3.setTypeface(arabicTypeface);//(array[2]);
            holder.sin4.setTypeface(arabicTypeface);//(array[0]);
            holder.dual4.setTypeface(arabicTypeface);//(array[1]);
            holder.plu4.setTypeface(arabicTypeface);//(array[2]);
            FontSIzeSelection(holder);
        } else {
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
            FontSIzeSelection(holder);
        }
        holder.imafone.setTypeface(arabicTypeface);//;//smafone);
        holder.imaftwo.setTypeface(arabicTypeface);//;//smaftwo);
        holder.imafthree.setTypeface(arabicTypeface);//;//smafthree);
        holder.imaffour.setTypeface(arabicTypeface);//;//smaffour);
        holder.imaffive.setTypeface(arabicTypeface);//;//smaffive);
        holder.imafsix.setTypeface(arabicTypeface);//;//smafsix);
        holder.imafseven.setTypeface(arabicTypeface);//;//smafseven);
        holder.imafeight.setTypeface(arabicTypeface);//;//smafeight);
        holder.imafnine.setTypeface(arabicTypeface);//;//smafnine);
        //
        holder.imafoolfemone.setTypeface(arabicTypeface);//;//smafone);
        holder.imafoolfemtwo.setTypeface(arabicTypeface);//;//smaftwo);
        holder.imafoolfemthree.setTypeface(arabicTypeface);//;//smafthree);
        holder.imafoolfemfour.setTypeface(arabicTypeface);//;//smaffour);
        holder.imafoolfemfive.setTypeface(arabicTypeface);//;//smaffive);
        holder.imafoolfemsix.setTypeface(arabicTypeface);//;//smafsix);
        holder.imafoolfemseven.setTypeface(arabicTypeface);//;//smafseven);
        holder.imafoolfemeight.setTypeface(arabicTypeface);//;//smafeight);
        holder.imafoolfemnine.setTypeface(arabicTypeface);//;//smafnine);
        //
        holder.ismfemone.setTypeface(arabicTypeface);//;//iismfemone);
        holder.ismfemtwo.setTypeface(arabicTypeface);//;//iismfemtwo);
        holder.ismfemthree.setTypeface(arabicTypeface);//;//iismfemthree);
        holder.ismfemfour.setTypeface(arabicTypeface);//;//iismfemfour);
        holder.ismfemfive.setTypeface(arabicTypeface);//;//iismfemfive);
        holder.ismfemsix.setTypeface(arabicTypeface);//;//iismfemsix);
        holder.ismfemseven.setTypeface(arabicTypeface);//;//iismfemseven);
        holder.ismfemeight.setTypeface(arabicTypeface);//;//iismfemeight);
        holder.ismfemnine.setTypeface(arabicTypeface);//;//iismfemnine);
        holder.isone.setTypeface(arabicTypeface);//;//iisone);
        holder.istwo.setTypeface(arabicTypeface);//;//iistwo);
        holder.isthree.setTypeface(arabicTypeface);//;//iisthree);
        holder.isfour.setTypeface(arabicTypeface);//;//iisfour);
        holder.isfive.setTypeface(arabicTypeface);//;//iisfive);
        holder.issix.setTypeface(arabicTypeface);//;//iissix);
        holder.isseven.setTypeface(arabicTypeface);//;//iisseven);
        holder.iseight.setTypeface(arabicTypeface);//;//iiseight);
        holder.isnine.setTypeface(arabicTypeface);//;//iisnine);
        FontSIzeSelection(holder);

    }

    private void FontSIzeSelection(ViewHolder holder) {
        SharedPreferences sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        final Integer arabicFontsize = sharedPreferences.getInt("pref_font_arabic_key", 20);
        String width = sharedPreferences.getString("width", "compactWidth");
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
                holder.nom3.setTextSize(arabicFontsize);//(array[0]);
                holder.acc3.setTextSize(arabicFontsize);//(array[1]);
                holder.gen3.setTextSize(arabicFontsize);//(array[2]);
                holder.sin1.setTextSize(arabicFontsize);//(array[0]);
                holder.dual1.setTextSize(arabicFontsize);//(array[1]);
                holder.plu1.setTextSize(arabicFontsize);//(array[2]);
                holder.sin2.setTextSize(arabicFontsize);//(array[0]);
                holder.dual2.setTextSize(arabicFontsize);//(array[1]);
                holder.plu2.setTextSize(arabicFontsize);//(array[2]);
                holder.sin3.setTextSize(arabicFontsize);//(array[0]);
                holder.dual3.setTextSize(arabicFontsize);//(array[1]);
                holder.plu3.setTextSize(arabicFontsize);//(array[2]);
                holder.sin4.setTextSize(arabicFontsize);//(array[0]);
                holder.dual4.setTextSize(arabicFontsize);//(array[1]);
                holder.plu4.setTextSize(arabicFontsize);//(array[2]);
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

        }
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
        //   return sarfSagheer.size();
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
        public final TextView sin4, dual4, plu4;
        public final TextView nom, acc, gen;
        public final TextView nom1, acc1, gen1;
        public final TextView nom2, acc2, gen2;
        public final TextView nom3, acc3, gen3;
        TextView apmas, apfem, ppmas, ppfem;

        public ViewHolder(View view) {
            super(view);
            //   if(isTraditional){
            sin4 = view.findViewById(R.id.singular4);
            dual4 = view.findViewById(R.id.dual4);
            plu4 = view.findViewById(R.id.plural4);
            //    }
            nom = view.findViewById(R.id.indictive);
            acc = view.findViewById(R.id.subjunctive);
            gen = view.findViewById(R.id.genitive);
            nom1 = view.findViewById(R.id.nominative1);
            acc1 = view.findViewById(R.id.accusative1);
            gen1 = view.findViewById(R.id.genitive1);
            nom2 = view.findViewById(R.id.nominative2);
            acc2 = view.findViewById(R.id.accusative2);
            gen2 = view.findViewById(R.id.genitive2);
            nom3 = view.findViewById(R.id.nominative3);
            acc3 = view.findViewById(R.id.accusative3);
            gen3 = view.findViewById(R.id.genitive3);
            sin1 = view.findViewById(R.id.singular1);
            dual1 = view.findViewById(R.id.dual1);
            plu1 = view.findViewById(R.id.plural1);
            sin2 = view.findViewById(R.id.singular2);
            dual2 = view.findViewById(R.id.dual2);
            plu2 = view.findViewById(R.id.plural2);
            sin3 = view.findViewById(R.id.singular3);
            dual3 = view.findViewById(R.id.dual3);
            plu3 = view.findViewById(R.id.plural3);
            apmas = view.findViewById(R.id.apmas);
            apfem = view.findViewById(R.id.apfem);
            ppmas = view.findViewById(R.id.ppmas);
            ppfem = view.findViewById(R.id.ppfem);
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
            //  tv.setText(R.string.faelmazi); // 2
            ismfemone.setText(R.string.faelmazi);
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






