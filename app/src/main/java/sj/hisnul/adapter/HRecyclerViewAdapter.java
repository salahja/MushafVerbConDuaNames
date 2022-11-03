package sj.hisnul.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


;

import com.example.mushafconsolidated.R;

import java.util.ArrayList;

import sj.hisnul.entity.hduadetails;


public class HRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<hduadetails> duadetailsitems;
    private int VIEW_ITEM = 0;
    private int VIEW_PROG = 1;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    OnItemClickListener mItemClickListener;
    private static final int TYPE_ITEM = 2;

    int rootcolor, weaknesscolor, wazancolor;
    private Context context;
    int bookmarkpostion;

    //    private final Integer arabicTextColor;
    Context mycontext;
    private ArrayList<String> madhi = new ArrayList<>();
    private boolean mazeedregular;
    private int bookChapterno;
    private int bookVerseno;
    private Integer ayahNumber;
    private String urdu_font_selection;
    private int quran_arabic_font;

    String ismzaftitle = "(الْظَرْف:)";
    String ismalatitle = "( الآلَة:)";
    String alaheader = "اِسْم الآلَة";
    String zarfheader = "اِسْم الْظَرفْ";
    private int urdu_font_size;
    private String arabic_font_selection;


    public HRecyclerViewAdapter(ArrayList<sj.hisnul.entity.hduadetails> duaItems, Context context) {
        this.duadetailsitems = duaItems;
        this.context = context;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

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

    public interface OnItemClickListener {
        void onItemClick(View v, int position);


    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
     ;
        if (holder instanceof HeaderViewHolder) {
            hduadetails items = duadetailsitems.get(position);
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            headerHolder.headerTitle.setText("Header View");
            if (!items.getTop().isEmpty()){
                headerHolder.headerTitle.setText(items.getBottom());
                headerHolder.headerTitle.setVisibility(View.VISIBLE);
            }else{
                headerHolder.headerTitle.setVisibility(View.GONE);
            }
            headerHolder.headerTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //      Toast.makeText(activity, "You clicked at Header View!", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;

            footerHolder.footerText.setText("footer");
            footerHolder.footerText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //     Toast.makeText(activity, "You clicked at Footer View", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof ViewHolder) {
            //   try {
            hduadetails items = duadetailsitems.get(position - 1);
            ViewHolder itemViewHolder = (ViewHolder) holder;


            //   final Integer arabicFontsize = Integer.valueOf(fonts);
            StringBuilder sb = new StringBuilder();
            sb.append(items.getID());
            //    holder.rulenumbe.r.setTextSize(arabicFontsize);
            itemViewHolder.tvDuaNumber.setText(sb);
            //  holder.title.setText(catOne.getTitle_en());
            //  holder.title.setTextSize(18);
            itemViewHolder.tvDuaNumber.setTextSize(24);
            itemViewHolder.tvDuaArabic.setText(items.getArabic());
            itemViewHolder.tvDuaArabic.setTextSize(24);
            itemViewHolder.tvDuaTranslation.setText(items.getTranslations());
            if (!items.getTransliteration().isEmpty()){

                itemViewHolder.tvliteration.setText(Html.fromHtml(items.getTransliteration()));
                itemViewHolder.tvliteration.setTextSize(24);
            itemViewHolder.tvliteration.setVisibility(View.VISIBLE);
        }
            if (!items.getBottom().isEmpty()){
                itemViewHolder.tvbottom.setText(items.getBottom());
                itemViewHolder.tvbottom.setVisibility(View.VISIBLE);
                itemViewHolder.tvbottom.setTextSize(24);
            }
            itemViewHolder.tvDuaReference.setText(items.getReference());
            //    itemViewHolder.tvDuaReference.setText(items.get(0).getRef_en());


            //   }catch (IndexOutOfBoundsException e){

            //  }


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


    private boolean isPositionItem(int position) {
//    return position != getItemCount()-1; // last position
        return position == duadetailsitems.size() + 1;
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            // current clickListerner
    {


        public CardView cardview;
        TextView tvDuaNumber;
        TextView tvDuaArabic;
        TextView tvDuaReference;
        TextView tvDuaTranslation;
        TextView tvliteration;
        TextView tvbottom;




        public ViewHolder(View view) {
            super(view);
            view.setTag(this);


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

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(View view) {
            super(view);
            headerTitle = (TextView) view.findViewById(R.id.header_text);
        }
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView footerText;

        public FooterViewHolder(View view) {
            super(view);
            footerText = view.findViewById(R.id.txtDuaReference);

        }
    }


}
