package com.example.mushafconsolidated.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.qurandictionary;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>
        implements Filterable {
    OnItemClickListener mItemClickListener;
    private ArrayList<qurandictionary> qurandictionaryArrayList;
    private View.OnClickListener olistener;
    private final Context context;
    private List<qurandictionary> qurandictionaryFiltered;
    private ContactsAdapterListener listener;
    private boolean downloadtype;

    public SearchAdapter(Context context, ContactsAdapterListener listener) {
        this.context = context;
        this.listener = listener;

    }

    public SearchAdapter(Context context, ArrayList<qurandictionary> qurandictionaryArrayList, boolean b) {
        this.context = context;
        this.qurandictionaryArrayList = qurandictionaryArrayList;
        this.qurandictionaryFiltered = qurandictionaryArrayList;
    }

    public Object getItem(int position) {
        return qurandictionaryFiltered.get(position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        qurandictionary entity = qurandictionaryFiltered.get(position);
        holder.arabicroot.setText(entity.getRootarabic());
        holder.buckwaterroot.setText(entity.getRootbuckwater());
        //  holder.englishname.setText(entity.getEnglish_name());
        //  holder.translationid.setText(entity.getTranslation_id());
    }

    @Override
    public int getItemCount() {
        return qurandictionaryFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    qurandictionaryFiltered = qurandictionaryArrayList;
                } else {
                    List<qurandictionary> filteredList = new ArrayList<>();
                    for (qurandictionary details : qurandictionaryArrayList) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getRootarabic().toLowerCase().contains(charString.toLowerCase()) ||
                                details.getRootbuckwater().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(details);
                        }
                    }
                    qurandictionaryFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = qurandictionaryFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                qurandictionaryFiltered = (ArrayList<qurandictionary>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ContactsAdapterListener {
        void onselected(qurandictionary translationEntity);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView arabicroot, buckwaterroot, translationid, englishname;
        public ImageView downloadicon, deleteicon;

        public MyViewHolder(View view) {
            super(view);
            arabicroot = view.findViewById(R.id.arabicroot);
            buckwaterroot = view.findViewById(R.id.buckwaterroot);
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
