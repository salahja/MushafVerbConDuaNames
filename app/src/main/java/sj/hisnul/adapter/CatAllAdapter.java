package sj.hisnul.adapter;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.QuranGrammarApplication;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import sj.hisnul.entity.hduanames;


public class CatAllAdapter extends RecyclerView.Adapter<CatAllAdapter.ViewHolder> implements Filterable {


    private final Context context;
    OnItemClickListener mItemClickListener;


    private List<hduanames> mList = new ArrayList<>();
    private List<hduanames> duasfiltered = new ArrayList<>();

    public CatAllAdapter(ArrayList<hduanames> mList, Context context) {
        this.context = context;
        this.mList = mList;
        this.duasfiltered = mList;

    }





    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



    //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rwz,parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dua_group_item_card,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {

        SharedPreferences sharedPreferences =getDefaultSharedPreferences(QuranGrammarApplication.getContext());



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String fontCategory = sharedPreferences.getString("arabic_font_category", "cal.otf");
        Typeface prefArabicFontTypeface = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), fontCategory);
        String fonts=      prefs.getString("Arabic_Font_Size", "25");
        int arabicfontSize = sharedPreferences.getInt("pref_font_arabic_key", 18);
        int translationfontsize = sharedPreferences.getInt("pref_font_englsh_key", 18);
        //  String arabic_font_category = prefs.getString("arabic_font_category", "kitab.tff");
        String isNightmode = sharedPreferences.getString("themepref", "dark");

        Typeface mequran= Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), "Taha.ttf");
        final Integer arabicFontsize = Integer.valueOf(fonts);
        if (isNightmode.equals("dark")) {


                    holder.tvReference.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
        }
      ;

        if (isNightmode.equals("dark")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.color_background_overlay));


        } else if (isNightmode.equals("blue")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.solarizedBase02));

        }


        if (isNightmode.equals("dark")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));


        } else if (isNightmode.equals("blue")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

        }
        else if (isNightmode.equals("white")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.md_theme_dark_secondaryContainer));

        }
        hduanames catOne= duasfiltered.get(position);

     //   final Integer arabicFontsize = Integer.valueOf(fonts);
        StringBuilder sb=new StringBuilder();
        sb.append(catOne.getChap_id());
        //    holder.rulenumber.setTextSize(arabicFontsize);
        holder.tvReference.setText(sb.toString());
        holder.tvChapname.setText(catOne.getChapname());
         holder.tvChapname.setTextSize(18);
         holder.tvReference.setTextSize(18);

    }


    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);

        return duasfiltered.size();
    }

    public Object getItem(int position) {

        return duasfiltered.get(position);
    }

    @Override
    public int getItemCount() {
        return duasfiltered.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    duasfiltered = mList;
                    ;
                } else {
                    List<hduanames> filteredList = new ArrayList<>();
                    for (hduanames details : mList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getChapname().toLowerCase().contains(charString.toLowerCase()))   {
                            filteredList.add(details);
                        }
                    }

                    duasfiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = duasfiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                duasfiltered = (ArrayList<hduanames>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {

        public final TextView tvReference, tvChapname;
        public CardView cardview;


        public ViewHolder(View view) {
            super(view);


            //    itemView.setTag(this);
            //     itemView.setOnClickListener(onItemClickListener);
            tvReference = view.findViewById(R.id.txtReference);
            tvChapname = view.findViewById(R.id.txtDuaName);

         cardview=     view.findViewById(R.id.cardview);







            view.setOnClickListener(this);

            tvReference.setOnClickListener(this);
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

