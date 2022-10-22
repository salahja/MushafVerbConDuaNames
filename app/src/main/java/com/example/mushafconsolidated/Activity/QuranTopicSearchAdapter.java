package com.example.mushafconsolidated.Activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.qurandictionary;
import com.example.mushafconsolidated.Entities.quranexplorer;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class QuranTopicSearchAdapter extends RecyclerView.Adapter<QuranTopicSearchAdapter.MyViewHolder>
        implements Filterable {
    private ArrayList<quranexplorer> qurandictionaryArrayList;
    private View.OnClickListener olistener;
    private Context context;

    private List<quranexplorer> qurandictionaryFiltered;
    private ContactsAdapterListener listener;
    OnItemClickListener mItemClickListener;
    private boolean downloadtype;
    private boolean[] mcheckedStatus;


    public QuranTopicSearchAdapter(Context context, ContactsAdapterListener listener) {
        this.context = context;
        this.listener = listener;

    }


    public QuranTopicSearchAdapter(Context context, ArrayList<quranexplorer> qurandictionaryArrayList, boolean b) {
        this.context = context;
        this.qurandictionaryArrayList = qurandictionaryArrayList;
        this.qurandictionaryFiltered = qurandictionaryArrayList;
        mcheckedStatus=new boolean[this.qurandictionaryFiltered.size()];
    }


    public Object getItem(int position) {
        return qurandictionaryFiltered.get(position);
    }

    public List<quranexplorer> getList() {
        return qurandictionaryFiltered;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView arabicroot, buckwaterroot, translationid, englishname;
        public ImageView downloadicon, deleteicon;
        public CheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
            arabicroot = view.findViewById(R.id.title);
            buckwaterroot = view.findViewById(R.id.count);
            checkBox=view.findViewById(R.id.selection);



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


    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_row_item , parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        quranexplorer entity = qurandictionaryFiltered.get(position);
        String ayahref = entity.getAyahref();
        if(ayahref!=null) {
            String[] split = ayahref.split(",");
            int length = split.length;
            holder.buckwaterroot.    setText(Integer.toString(length));
        }
/*
        holder.arabicroot.setText(entity.getTitle());
        holder.checkBox.setTag(qurandictionaryFiltered.get(position));
        holder.itemView.setSelected(entity.isSelected() ? true : false);
        holder.checkBox.setChecked(false);
 */

        final int pos = position;

        holder.arabicroot.setText(qurandictionaryFiltered.get(position).getTitle());

        holder.checkBox.setChecked(qurandictionaryFiltered.get(position).isSelected());
        holder.checkBox.setTag(qurandictionaryFiltered.get(position));


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                quranexplorer contact = (quranexplorer) cb.getTag();

                contact.setSelected(cb.isChecked());
                qurandictionaryFiltered.get(pos).setSelected(cb.isChecked());


            }
        });




        holder.arabicroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entity.setSelected(!entity.isSelected());
                holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(holder.checkBox.isChecked()){
                            holder.checkBox.setChecked(false);
                        }else{
                            holder.checkBox.setChecked(true);
                        }
                    }
                });
                //   holder.itemView.setBackgroundColor(entity.isSelected() ? Color.CYAN : Color.BLUE);
                //   holder.itemView.setSelected(entity.isSelected()) ? true.
            }
        });





        //  holder.englishname.setText(entity.getEnglish_name());
        //  holder.translationid.setText(entity.getTranslation_id());


    }

/*
    @Override
    public int getItemCount() {
        return qurandictionaryFiltered.size();
    }

 */
@Override
public int getItemCount() {
    return qurandictionaryFiltered == null ? 0 : qurandictionaryFiltered.size();
}
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    qurandictionaryFiltered = qurandictionaryArrayList;
                    ;
                } else {
                    List<quranexplorer> filteredList = new ArrayList<>();
                    for (quranexplorer details : qurandictionaryArrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getTitle().toLowerCase().contains(charString.toLowerCase())  )
                                {
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
                qurandictionaryFiltered = (ArrayList<quranexplorer>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ContactsAdapterListener {
        void onselected(qurandictionary translationEntity);
    }


}
