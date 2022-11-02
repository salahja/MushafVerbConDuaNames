package database;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import com.example.mushafconsolidated.databinding.FragmentItemBinding;

import database.entity.DuaGroup;
import database.placeholder.PlaceholderContent.PlaceholderItem;


import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDuaItemRecyclerViewAdapter extends RecyclerView.Adapter<MyDuaItemRecyclerViewAdapter.ViewHolder>
        implements Filterable  {

    private final List<DuaGroup> mValues;
    private   List<DuaGroup> duasfiltered ;
    public MyDuaItemRecyclerViewAdapter(List<DuaGroup> items) {
        mValues = items;
        this.duasfiltered=items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        int id = mValues.get(position).get_id();
        String s = String.valueOf(id);
        holder.mIdView.setText(s);
        //   holder.mContentView.setText(mValues.get(position).getHarf());
        holder.mContentView.setText(mValues.get(position).getEn_title());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    duasfiltered = mValues;
                    ;
                } else {
                    List<DuaGroup> filteredList = new ArrayList<>();
                    for (DuaGroup details : mValues) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getEn_title().toLowerCase().contains(charString.toLowerCase()))   {
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


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public DuaGroup mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}