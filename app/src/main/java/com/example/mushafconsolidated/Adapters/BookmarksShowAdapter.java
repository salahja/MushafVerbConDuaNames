package com.example.mushafconsolidated.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.BookMarks;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.PreferenceUtil;
import com.example.utility.QuranGrammarApplication;

import java.util.List;

/**
 * RecyclerView.Adapter<BookmarksShowAdapter.ViewHolder>
 * Adapter class for the bookmarks list view
 */
public class BookmarksShowAdapter extends RecyclerView.Adapter<BookmarksShowAdapter.ViewHolder> {
    private static final String TAG = "BookmarksShowAdapter";
    OnItemClickListener mItemClickListener;
    Context BookmarksShowAdapterContext;
    int bookmarkpostion;
    PreferenceUtil pref;
    int holderposition;
    int bookmarid;
    private String SurahName;
    private int bookChapterno;
    private int bookVerseno;
    private List<BookMarks> bookMarkArrayList;
    public BookmarksShowAdapter() {
    }

    public BookmarksShowAdapter(Context context) {
        this.BookmarksShowAdapterContext = context;
    }

    public int getBookmarkpostion() {
        return bookmarkpostion;
    }

    public int getBookmarid() {
        return bookmarid;
    }

    public void setBookmarid(int bookmarid) {
        this.bookmarid = bookmarid;
    }

    public int getHolderposition() {
        return holderposition;
    }

    public void setHolderposition(int holderposition) {
        this.holderposition = holderposition;
    }

    public int getBookChapterno() {
        return bookChapterno;
    }

    public int getBookVerseno() {
        return bookVerseno;
    }

    public String getSurahName() {
        return SurahName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bookmar_two, parent, false);
        //   sendVerseClick=(SendVerseClick) getActivity();
        return new ViewHolder(view);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int d = Log.d(TAG, "onBindViewHolder: called");
        final BookMarks bookMark = bookMarkArrayList.get(position);
        setHolderposition(position);
        setBookmarid(bookMark.getId());
        TypedArray imgs = QuranGrammarApplication.getContext().getResources().obtainTypedArray(R.array.sura_imgs);
        SharedPreferences shared = android.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String isNightmode = shared.getString("theme", "dark");
        String chapterno = bookMark.getChapterno();
        final Drawable drawable = imgs.getDrawable((Integer.parseInt(chapterno) - 1));
        holder.surahicon.setImageDrawable(drawable);
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            holder.surahicon.setColorFilter(Color.CYAN);

        }
        holder.datestamp.setText(bookMark.getDatetime());
        holder.suraName.setText(bookMark.getSurahname());
        holder.chapterno.setText(bookMark.getChapterno());
        holder.verseno.setText(bookMark.getVerseno() + "");
        int arabicFontSize = shared.getInt("pref_font_arabic_key", 18);
        holder.datestamp.setTextSize(arabicFontSize);
        holder.suraName.setTextSize(arabicFontSize);
        holder.verseno.setTextSize(arabicFontSize);
        holder.chapterno.setTextSize(arabicFontSize);
        if (isNightmode.equals("dark")) {
            ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.color_background_overlay);
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.color_background_overlay));

        } else if (isNightmode.equals("blue")) {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.solarizedBase02));

        }

    }

    @Override
    public int getItemCount() {
        return bookMarkArrayList.size();
    }

    public List<BookMarks> getBookMarkArrayList() {
        return bookMarkArrayList;
    }

    public void setBookMarkArrayList(List<BookMarks> bookmarstringarray) {
        this.bookMarkArrayList = bookmarstringarray;
    }

    public void removeItem(int position) {
        bookMarkArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public Object getItem(int position) {
        return bookMarkArrayList.get(position);

    }
    // public void restoreItem(ArrayList<BookMarks> item, int position) {
    //      data.add(position, item);
    //     notifyItemInserted(position);
    //  }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public final TextView datestamp;
        public final TextView suraName;
        public final TextView verseno;
        final ImageView surahicon;
        final CardView cardView;
        public TextView chapterno;

        public ViewHolder(View view) {
            super(view);
            surahicon = view.findViewById(R.id.surahicon);
            cardView = view.findViewById(R.id.cardview);
            datestamp = view.findViewById(R.id.date);
            chapterno = view.findViewById(R.id.chapterno);
            suraName = (TextView) view.findViewById(R.id.surahname);
            verseno = view.findViewById(R.id.verseno);
            chapterno = view.findViewById(R.id.chapterno);
            view.setOnClickListener(this); // current clickListerner

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

}
