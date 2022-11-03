package sj.hisnul.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


public class HnewExpandAdapter extends RecyclerView.Adapter<HnewExpandAdapter.ViewHolder> {

    int rootcolor, weaknesscolor, wazancolor;
    private final Context context;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;
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
    HashMap<String, List<String>> catOneArrayList = new LinkedHashMap<>();




    public HnewExpandAdapter(HashMap<String, List<String>> expandableListDetail, Context context) {
        this.catOneArrayList=expandableListDetail;
        this.context=context;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_act,parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        //  final List sarf = sarfSagheer.get(position);
//        final String[] array = (String[]) sarfSagheer.get(position).toArray.get();

        TypedArray imgs = this.context.getResources().obtainTypedArray(R.array.cat_img);


        int cweakness = 0;
        int crootword = 0;
        final int cbabcolor;

        List<String> strings = catOneArrayList.get(position);
        Set<String> keys = catOneArrayList.keySet();
        for (String key : keys) {
            List<String> strings1 = catOneArrayList.get(key);
            holder.title.setText(key);

            for (String s : strings1) {
                holder.content.setText(s);
            }


            System.out.println(key + " -- "
                    + catOneArrayList.get(key));
        }
   //     Drawable icon = imgs.getDrawable(catOne.get-1);





     //   final Integer arabicFontsize = Integer.valueOf(fonts);
        StringBuilder sb=new StringBuilder();
    //    sb.append(catOne.getId());
        //    holder.rulenumber.setTextSize(arabicFontsize);
     //   holder.title.setText(catOne.getTitle_en());
      //  holder.title.setText(catOne.getTitle_en());
       //  holder.title.setTextSize(18);
       //  holder.title.setTextSize(18);
      //  holder.imageView.setCompoundDrawablesWithIntrinsicBounds( icon, null, null, null);
       //  holder.imageView.setImageDrawable(icon);








    }


    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);

        return catOneArrayList.size();
    }

    public Object getItem(int position) {

        return catOneArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return catOneArrayList.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }




    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {

        public final TextView  title;
        TextView content;



        public ViewHolder(View view) {
            super(view);


            //    itemView.setTag(this);
            //     itemView.setOnClickListener(onItemClickListener);
            content = view.findViewById(R.id.expandedListItem);
            title = view.findViewById(R.id.header_text);
            title.setOnClickListener(this);
            content.setOnClickListener(this);

            title.setOnClickListener(view1 -> {


                if (content.getVisibility() == View.GONE) {
                    content.setVisibility(View.VISIBLE);
                    //  AnimationUtility.slide_down(context, erabexpand);
                 //   AnimationUtility.AnimateArrow(90.0f, erabexpand);
                } else {
                    content.setVisibility(View.GONE);
                  //  AnimationUtility.AnimateArrow(0.0f, erabexpand);
                    //   Fader.slide_down(context,expandImageButton);
                }


            });
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });









            view.setOnClickListener(this);

            //imageView.setOnClickListener(this);



        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }


}

