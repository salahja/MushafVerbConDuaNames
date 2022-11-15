package sj.hisnul.adapter;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
    private final List<hduanames> mList;
    OnItemClickListener mItemClickListener;
    private List<hduanames> duasfiltered;

    public CatAllAdapter(ArrayList<hduanames> mList, Context context) {
        this.context = context;
        this.mList = mList;
        this.duasfiltered = mList;

    }

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rwz,parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dua_group_item_card, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        //  String arabic_font_category = prefs.getString("arabic_font_category", "DejaVuSans.tff");
        String isNightmode = sharedPreferences.getString("themepref", "dark");
        if (isNightmode.equals("dark")) {
            holder.tvReference.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
        }

        if (isNightmode.equals("dark")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

        } else if (isNightmode.equals("blue")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.bg_dark_blue));

        } else if (isNightmode.equals("white")) {
            holder.cardview.setCardBackgroundColor(context.getResources().getColor(R.color.md_theme_dark_inversePrimary));

        }



        hduanames catOne = duasfiltered.get(position);
        holder.tvReference.setText(String.valueOf(catOne.getChap_id())
                //    holder.rulenumber.setTextSize(arabicFontsize);
        );
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
                } else {
                    List<hduanames> filteredList = new ArrayList<>();
                    for (hduanames details : mList) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getChapname().toLowerCase().contains(charString.toLowerCase())) {
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
        public final CardView cardview;

        public ViewHolder(View view) {
            super(view);
            tvReference = view.findViewById(R.id.txtReference);
            tvChapname = view.findViewById(R.id.txtDuaName);
            cardview = view.findViewById(R.id.cardview);
            view.setOnClickListener(this);
            tvReference.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }

}

