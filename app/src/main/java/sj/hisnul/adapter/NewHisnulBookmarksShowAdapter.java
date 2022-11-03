package sj.hisnul.adapter;


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

import java.util.ArrayList;
import java.util.List;

import sj.hisnul.entity.hduanames;

/**
 * RecyclerView.Adapter<BookmarksShowAdapter.ViewHolder>
 * Adapter class for the bookmarks list view
 */
public class NewHisnulBookmarksShowAdapter extends RecyclerView.Adapter<NewHisnulBookmarksShowAdapter.ViewHolder> {


  private static final String TAG = "BookmarksShowAdapter";
  OnItemClickListener mItemClickListener;


  Context BookmarksShowAdapterContext;
  private String SurahName;
  private int bookChapterno;
  private int bookVerseno;




  int bookmarkpostion;

  ArrayList<hduanames>  bookMarkArrayList;


  public int getBookmarkpostion() {
    return bookmarkpostion;
  }

  PreferenceUtil pref;


  int holderposition;
  int bookmarid;

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

  public NewHisnulBookmarksShowAdapter() {
  }

  public NewHisnulBookmarksShowAdapter(Context context) {
    this.BookmarksShowAdapterContext = context;
  }


  public String getSurahName() {
    return SurahName;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark, parent, false);


    //   sendVerseClick=(SendVerseClick) getActivity();
    return new ViewHolder(view);
  }


  public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.mItemClickListener = mItemClickListener;

  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    final int d = Log.d(TAG, "onBindViewHolder: called");

    final hduanames catOne = bookMarkArrayList.get(position);
    setHolderposition(position);
   // setBookmarid(bookMark.getChap_id());
    TypedArray imgs = QuranGrammarApplication.getContext().getResources().obtainTypedArray(R.array.sura_imgs);
    SharedPreferences shared = android.preference.PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
    String isNightmode = shared.getString("theme", "dark");







    //   final Integer arabicFontsize = Integer.valueOf(fonts);

    boolean empty = catOne.getChapname().isEmpty();

    if(!empty) {
      StringBuilder sb=new StringBuilder();
      sb.append(catOne.getID());
      holder.id.setText(sb);
      holder.duaname.setText(catOne.getChapname());
    //  holder.duaname.setText(catOne.getDuaname());
      //  holder.title.setTextSize(18);
   //   holder.duaname.setTextSize(18);
      holder.duaname.setTextSize(18);

    }else{
      holder.duaname.setVisibility(View.GONE);
      holder.id.setVisibility(View.GONE);
      holder.ivdelete.setVisibility(View.GONE);
    }






  }


  @Override
  public int getItemCount() {
    return bookMarkArrayList.size();
  }


  public List<hduanames> getBookMarkArrayList() {
    return bookMarkArrayList;
  }


  public void removeItem(int position) {
    bookMarkArrayList.remove(position);
    notifyItemRemoved(position);
  }

  public void setBookMarkArrayList( ArrayList<hduanames> bookmarstringarray) {

    this.bookMarkArrayList = bookmarstringarray;
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
      duaname.setTag("id");


    }


    @Override
    public void onClick(View v) {
      if (mItemClickListener != null) {
        mItemClickListener.onItemClick(v, getLayoutPosition());
      }
    }
  }


}
