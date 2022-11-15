package com.example.mushafconsolidated.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Entities.lughat;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;

import java.util.ArrayList;

public class WordLughatAdapter extends RecyclerView.Adapter<WordLughatAdapter.ItemViewAdapter> {
    OnItemClickListener mItemClickListener;
    boolean isSarfSagheerMazeed;
    String language;
    private Context context;
    private ArrayList<lughat> worddictorary;
    // private ArrayList<GrammarWordEntity> grammarArayList = new ArrayList<>();
    private ArrayList<ArrayList> sarfsagheer;
    public WordLughatAdapter(ArrayList<lughat> dictionary, Context context, String language) {
        this.worddictorary = dictionary;
        this.context = context;
        this.language = language;
    }

    public boolean isSarfSagheerMazeed() {
        return isSarfSagheerMazeed;
    }

    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lughat_layout, parent, false);
        return new ItemViewAdapter(view);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewAdapter holder, int position) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        String quranFont = sharedPreferences.getString("quranFont", "kitab.ttf");
        Typeface mequran = Typeface.createFromAsset(context.getAssets(), quranFont);
        //    holder.wordDictionary.setText(worddetails.get("word"));
        if (!worddictorary.isEmpty()) {
            String replace1 = "";
            String replace2 = "";
            String replace3 = "";
            String replace4 = "";
            if (language.equals("english")) {
                String en_lughat = worddictorary.get(0).getEn_lughat();
                String meanings = worddictorary.get(0).getMeaning();
                String rootword = worddictorary.get(0).getRootword();
                String arabicword = worddictorary.get(0).getArabicword();
                replace1 = en_lughat.replace("\\n", "<br><p>");
                replace2 = rootword.replace("\\n", "<br><p>");
                replace3 = arabicword.replace("\\n", "<br><p>");
                replace4 = meanings.replace("\\n", "<br><p>");
                holder.wordDictionary.setText(Html.fromHtml(replace1));
                holder.rootwowrd.setText(Html.fromHtml(replace2));
                holder.arabicword.setText(Html.fromHtml(replace3));
                holder.meaning.setText(Html.fromHtml(replace4));
            } else if (language.equals("urdu")) {
                String ur_lughat = worddictorary.get(0).getUr_lughat();
                String urdu = ur_lughat.replace("\\n", "<br><p>").replaceAll("\\n", "<br><p>");
                String meanings = worddictorary.get(0).getMeaning();
                String rootword = worddictorary.get(0).getRootword();
                String arabicword = worddictorary.get(0).getArabicword();
                replace2 = rootword.replace("\\n", "<br><p>");
                replace3 = arabicword.replace("\\n", "<br><p>");
                replace4 = meanings.replace("\\n", "<br><p>");
                holder.wordDictionary.setText(Html.fromHtml(urdu));
                holder.rootwowrd.setText(Html.fromHtml(replace2));
                holder.arabicword.setText(Html.fromHtml(replace3));
                holder.meaning.setText(Html.fromHtml(replace4));

            }
            //.replace("\\n", "<br>");
        }

    }

    @Override
    public long getItemId(int position) {
        return worddictorary.get(position).getSurah();
    }

    @Override
    public int getItemCount() {
        return worddictorary.size();
    }

    public Object getItem(int position) {
        return worddictorary.get(position);
    }

    public void setRootWordsAndMeanings(ArrayList<lughat> dictionary,
                                        Context context) {
        this.worddictorary = dictionary;
        this.context = context;

    }

    public class ItemViewAdapter extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public final TextView wordDictionary, wordDictionaryUrdu, meaning, rootwowrd, arabicword;
        final TextView referenceView;
        ImageView dismissview;
        int i = ContextCompat.getColor(context, R.color.kashmirigreen);

        public ItemViewAdapter(View view) {
            super(view);
            rootwowrd = view.findViewById(R.id.rootward);
            arabicword = view.findViewById(R.id.arabicword);
            wordDictionary = view.findViewById(R.id.wordDictionary);
            wordDictionaryUrdu = view.findViewById(R.id.wordDictionaryUrdu);
            meaning = view.findViewById(R.id.meaning);
            referenceView = view.findViewById(R.id.referenceView);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());

            }
        }
    }
}


