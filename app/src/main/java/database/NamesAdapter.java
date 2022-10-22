package database;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.mushafconsolidated.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import database.entity.AllahNames;

public class NamesAdapter extends BaseAdapter implements Filterable {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<AllahNames> mList;
    private CharSequence mSearchText = "";
    private   List<AllahNames> duasfiltered ;
    public NamesAdapter(Context context, List<AllahNames> list) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mList = list;
        duasfiltered=list;
        notifyDataSetChanged();
    }

    public void setData(List<AllahNames> list) {
        mList = list;
        duasfiltered=list;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        // return a filter that filters data based on a constraint
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    duasfiltered = mList;
                    ;
                } else {
                    List<AllahNames> filteredList = new ArrayList<>();
                    for (AllahNames details : mList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (details.getMeaning().toLowerCase().contains(charString.toLowerCase())) {
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
                duasfiltered = (ArrayList<AllahNames>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public int getItemCount() {
        return duasfiltered.size();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public AllahNames getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder mHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.nameimages, parent, false);
            mHolder = new ViewHolder();
            mHolder.tvNames = (TextView) convertView.findViewById(R.id.Names);
            mHolder.tvMeanings = (TextView) convertView.findViewById(R.id.meaning);
        //    mHolder.shape = (GradientDrawable) mHolder.tvNames.getBackground();
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }

        AllahNames p = getItem(position);
        if (p != null) {
            mHolder.tvNames.setText("" + p.getArabic());
            mHolder.tvMeanings.setText(p.getMeaning());

            String filter = mSearchText.toString();
            String itemValue = mHolder.tvMeanings.getText().toString();

            int startPos = itemValue.toLowerCase(Locale.US).indexOf(filter.toLowerCase(Locale.US));
            int endPos = startPos + filter.length();

            if (startPos != -1) { // This should always be true, just a sanity check
                Spannable spannable = new SpannableString(itemValue);
                mHolder.tvMeanings.setText(spannable);
            } else {
                mHolder.tvMeanings.setText(itemValue);
            }
        }
        return convertView;
    }

    public static class ViewHolder {
        TextView tvMeanings;
        TextView tvNames;
        GradientDrawable shape;
    }
}


