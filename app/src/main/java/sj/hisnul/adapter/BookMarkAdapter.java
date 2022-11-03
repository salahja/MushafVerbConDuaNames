package sj.hisnul.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import sj.hisnul.entity.hcategory;
import sj.hisnul.entity.hduanames;


public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.ViewHolder> {


    private final Context context;
    int bookmarkpostion;
    OnItemClickListener mItemClickListener;

    private ArrayList<hduanames> catTwoArrayList = new ArrayList<>();


    public BookMarkAdapter(ArrayList<hduanames> lists, Context context) {
        this.context = context;
        this.catTwoArrayList = lists;


    }





    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark,parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {





        hduanames catOne = catTwoArrayList.get(position);





        //   final Integer arabicFontsize = Integer.valueOf(fonts);
        StringBuilder sb=new StringBuilder();
        sb.append(catOne.getID());
        //    holder.rulenumber.setTextSize(arabicFontsize);
        holder.id.setText(sb);
        holder.chapter.setText(catOne.getChapname());
          holder.duaname.setText(catOne.getDuaname());
        //  holder.title.setTextSize(18);
        holder.duaname.setTextSize(18);
        holder.chapter.setTextSize(18);





    }


    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);

        return catTwoArrayList.size();
    }

    public Object getItem(int position) {

        return catTwoArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return catTwoArrayList.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {

        public final TextView id,chapter,duaname;
        public ImageView ivdelete;


        public ViewHolder(View view) {
            super(view);
            view.setTag(this);
            view.setOnClickListener(this);

            //    itemView.setTag(this);
            //     itemView.setOnClickListener(onItemClickListener);
            id = view.findViewById(R.id.id);
            chapter = view.findViewById(R.id.chapter);

            duaname = view.findViewById(R.id.duaname);
            ivdelete=view.findViewById(R.id.ivdelete);








            chapter.setOnClickListener(this);
            id.setOnClickListener(this);
            ivdelete.setOnClickListener(this);
            id.setTag("id");
            ivdelete.setTag("delete");
            chapter.setTag("id");


        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }


}

