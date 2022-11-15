package sj.hisnul.adapter;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.QuranGrammarApplication;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import sj.hisnul.entity.hcategory;

public class CatTwoAdapter extends RecyclerView.Adapter<CatTwoAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<hcategory> catTwoArrayList;
    OnItemClickListener mItemClickListener;

    public CatTwoAdapter(ArrayList<hcategory> lists, Context context) {
        this.context = context;
        this.catTwoArrayList = lists;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_catwo_drawble, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        TypedArray imgs = this.context.getResources().obtainTypedArray(R.array.cat_img);
        hcategory catOne = catTwoArrayList.get(position);
        Drawable icon = imgs.getDrawable(catOne.getId() - 1);
        imgs.recycle();
        //  CatTwo catOne= catTwoArrayList.get(position);
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        StringBuilder sb = new StringBuilder();
        sb.append(catOne.getId());
        //    holder.rulenumber.setTextSize(arabicFontsize);
        holder.title.setText(catOne.getTitle());
        holder.title.setTextSize(18);
        //  holder.id.setCompoundDrawablesWithIntrinsicBounds( icon, null, null, null);
        holder.id.setImageDrawable(icon);

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
        public final ImageView id;
        public final TextView title;
        public CardView cardview;

        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.imgview);
            title = view.findViewById(R.id.content);
            view.setOnClickListener(this);
            id.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }

}

