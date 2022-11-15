package com.example.mushafconsolidated.Activity;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.QuranGrammarApplication;

import java.util.ArrayList;
import java.util.List;

import database.entity.DuaGroup;

public class newDuaGroupAdapter extends RecyclerView.Adapter<newDuaGroupAdapter.MyViewHolder>
        implements Filterable {
    OnItemClickListener mItemClickListener;
    private View.OnClickListener olistener;
    private final Context context;
    private boolean downloadtype;
    private Context mContext;
    private LayoutInflater mInflater;
    private final List<DuaGroup> mList;
    private final CharSequence mSearchText = "";
    private List<DuaGroup> duasfiltered;

    public newDuaGroupAdapter(Context context, ArrayList<DuaGroup> mList) {
        this.context = context;
        this.mList = mList;
        this.duasfiltered = mList;
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dua_group_item_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        DuaGroup entity = duasfiltered.get(position);
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String fontCategory = sharedPreferences.getString("arabic_font_category", "cal.otf");
        Typeface prefArabicFontTypeface = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), fontCategory);
        String fonts = prefs.getString("Arabic_Font_Size", "25");
        int arabicfontSize = sharedPreferences.getInt("pref_font_arabic_key", 18);
        int translationfontsize = sharedPreferences.getInt("pref_font_englsh_key", 18);
        //  String arabic_font_category = prefs.getString("arabic_font_category", "kitab.tff");
        String isNightmode = sharedPreferences.getString("themepref", "dark");
        Typeface mequran = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), "Taha.ttf");
        final Integer arabicFontsize = Integer.valueOf(fonts);
        holder.tvReference.setText(String.valueOf(entity.get_id())
                //  String arabic_font_category = prefs.getString("arabic_font_category", "kitab.tff");
        );
        holder.tvDuaName.setText(entity.getEn_title());
        if (isNightmode.equals("dark")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.color_background_overlay));

        } else if (isNightmode.equals("blue")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.solarizedBase02));

        }
        if (isNightmode.equals("dark")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

        } else if (isNightmode.equals("blue")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

        } else if (isNightmode.equals("white")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.md_theme_dark_secondaryContainer));

        }
        //  holder.englishname.setText(entity.getEnglish_name());
        //  holder.translationid.setText(entity.getTranslation_id());
    }

    @Override
    public int getItemCount() {
        return duasfiltered.size();
    }

    public Object getItem(int position) {
        return duasfiltered.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    duasfiltered = mList;
                } else {
                    List<DuaGroup> filteredList = new ArrayList<>();
                    for (DuaGroup details : mList) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getEn_title().toLowerCase().contains(charString.toLowerCase())) {
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
                duasfiltered = (ArrayList<DuaGroup>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView arabicroot, buckwaterroot, translationid, englishname, tvReference, tvDuaName;
        public ImageView downloadicon, deleteicon, shape;
        public CardView cardview;

        public MyViewHolder(View view) {
            super(view);
            tvReference = (TextView) view.findViewById(R.id.txtReference);
            tvDuaName = (TextView) view.findViewById(R.id.txtDuaName);
            cardview = view.findViewById(R.id.cardview);
            // shape = (GradientDrawable) view.tvReference.getBackground();
            //   mHolder = new RecyclerView.ViewHolder();
            //   view.findViewById(R.id.txtReference);
            //   view.findViewById(R.id.txtDuaName);
            view.setOnClickListener(this);


            /*
               view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onselected(translationEntitiesFiltered.get(getAdapterPosition()));
                }
            });
             */
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

}
