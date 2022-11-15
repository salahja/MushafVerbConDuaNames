package sj.hisnul.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;

import java.util.ArrayList;

import sj.hisnul.entity.hduadetails;

public class SelectedDuaViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    final ArrayList<ArrayList<hduadetails>> duadetailsitems;
    OnItemClickListener mItemClickListener;
    int weaknesscolor;
    int wazancolor;
    ArrayList<String> subheaders;

    public SelectedDuaViewAdapter(ArrayList<ArrayList<hduadetails>> duaItems, Context context, String name, ArrayList<String> subheaders) {
        this.duadetailsitems = duaItems;
        this.subheaders = subheaders;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //Inflating recycle view item layout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hfrag_duaitems, parent, false);
            return new ViewHolder(view);
        } else if (viewType == TYPE_HEADER) {
            //Inflating header view
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            //Inflating footer view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.duareferncefooter, parent, false);
            return new FooterViewHolder(itemView);
        } else return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (holder instanceof HeaderViewHolder) {
            ArrayList<hduadetails> items = duadetailsitems.get(position);
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.headerTitle.setText("Header View");
            if (!items.get(0).getTop().isEmpty()) {
                headerHolder.headerTitle.setText(items.get(0).getBottom());
                headerHolder.headerTitle.setVisibility(View.VISIBLE);
            } else {
                headerHolder.headerTitle.setVisibility(View.GONE);
            }
            headerHolder.headerTitle.setOnClickListener(view -> {
                //      Toast.makeText(activity, "You clicked at Header View!", Toast.LENGTH_SHORT).show();
            });
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
            footerHolder.footerText.setText("footer");
            footerHolder.footerText.setOnClickListener(view -> {
                //     Toast.makeText(activity, "You clicked at Footer View", Toast.LENGTH_SHORT).show();
            });
        } else if (holder instanceof ViewHolder) {
            //   try {
            ArrayList<hduadetails> items = duadetailsitems.get(position - 1);
            String str = subheaders.get(position - 1);
            ViewHolder itemViewHolder = (ViewHolder) holder;
            //   final Integer arabicFontsize = Integer.valueOf(fonts);
            StringBuilder sb = new StringBuilder();
            sb.append(items.get(0).getID());
            itemViewHolder.duaheader.setText(str);
            //    holder.rulenumbe.r.setTextSize(arabicFontsize);
            itemViewHolder.tvDuaNumber.setText(sb);
            //  holder.title.setText(catOne.getTitle_en());
            //  holder.title.setTextSize(18);
            itemViewHolder.tvDuaNumber.setTextSize(18);
            itemViewHolder.duaheader.setTextSize(24);
            if (!items.get(0).getTop().isEmpty()) {
                itemViewHolder.top.setText(items.get(0).getTop());
                itemViewHolder.top.setTextSize(24);
                itemViewHolder.top.setVisibility(View.VISIBLE);

            } else {
                itemViewHolder.top.setVisibility(View.GONE);

            }
            if (!items.get(0).getArabic().isEmpty()) {
                itemViewHolder.tvDuaArabic.setText(items.get(0).getArabic());
                itemViewHolder.tvDuaArabic.setTextSize(24);
                itemViewHolder.tvDuaArabic.setVisibility(View.VISIBLE);
            } else {
                itemViewHolder.tvDuaArabic.setVisibility(View.GONE);
            }
            if (!items.get(0).getArabic().isEmpty()) {
                itemViewHolder.tvDuaTranslation.setText(items.get(0).getTranslations());
                itemViewHolder.tvDuaTranslation.setTextSize(24);
                itemViewHolder.tvDuaTranslation.setVisibility(View.VISIBLE);
            } else {
                itemViewHolder.tvDuaTranslation.setVisibility(View.GONE);
            }
            if (!items.get(0).getTransliteration().isEmpty()) {
                itemViewHolder.tvliteration.setText(Html.fromHtml(items.get(0).getTransliteration()));
                itemViewHolder.tvliteration.setTextSize(24);
                itemViewHolder.tvliteration.setVisibility(View.VISIBLE);
            } else {
                itemViewHolder.tvliteration.setVisibility(View.GONE);
            }
            if (!items.get(0).getBottom().isEmpty()) {
                itemViewHolder.tvbottom.setText(items.get(0).getBottom());
                itemViewHolder.tvbottom.setVisibility(View.VISIBLE);
                itemViewHolder.tvbottom.setTextSize(24);
            } else {
                itemViewHolder.tvbottom.setVisibility(View.GONE);
            }
            itemViewHolder.tvDuaReference.setText(items.get(0).getReference());
            itemViewHolder.sharebtn.setOnClickListener(convertView -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,
                        itemViewHolder.duaheader.getText() + "\n\n" +
                                itemViewHolder.tvDuaArabic.getText() + "\n\n" +
                                itemViewHolder.tvDuaTranslation.getText() + "\n\n" +
                                itemViewHolder.tvDuaReference.getText() + "\n\n" +
                                convertView.getResources().getString(R.string.action_share_credit)
                );
                intent.setType("text/plain");
                convertView.getContext().startActivity(
                        Intent.createChooser(
                                intent,
                                convertView.getResources().getString(R.string.action_share_title)
                        )
                );
            });

        }

    }

    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);
        return duadetailsitems.size();
    }

    public Object getItem(int position) {
        return duadetailsitems.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == duadetailsitems.size() + 1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return duadetailsitems.size() + 2;
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);

    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        final TextView headerTitle;

        public HeaderViewHolder(View view) {
            super(view);
            headerTitle = (TextView) view.findViewById(R.id.header_text);
        }
    }

    private static class FooterViewHolder extends RecyclerView.ViewHolder {
        final TextView footerText;

        public FooterViewHolder(View view) {
            super(view);
            footerText = view.findViewById(R.id.txtDuaReference);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            // current clickListerner
    {
        final TextView tvDuaNumber;
        final TextView tvDuaArabic;
        final TextView tvDuaReference;
        final TextView tvDuaTranslation;
        final TextView tvliteration;
        final TextView tvbottom;
        final TextView duaheader;
        final TextView sharebtn;
        final TextView top;

        public ViewHolder(View view) {
            super(view);
            view.setTag(this);
            top = view.findViewById(R.id.top);
            sharebtn = view.findViewById(R.id.sharebtn);
            duaheader = view.findViewById(R.id.duaheader);
            tvDuaNumber = view.findViewById(R.id.txtDuaNumber);
            tvDuaArabic = (TextView) view.findViewById(R.id.txtDuaArabic);
            tvDuaTranslation = (TextView) view.findViewById(R.id.txtDuaTranslation);
            tvDuaReference = (TextView) view.findViewById(R.id.txtDuaReference);
            tvliteration = view.findViewById(R.id.transliteration);
            tvbottom = view.findViewById(R.id.txtbottom);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

}
