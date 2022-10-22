package com.example.mushafconsolidated.Adapters;


import static android.content.Context.MODE_PRIVATE;
import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.AYAH_ID;
import static com.example.Constant.CHAPTER;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;
import static com.example.Constant.WORDNUMBER;
import static com.example.utility.QuranGrammarApplication.getContext;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.Config;
import com.example.mushafconsolidated.Entities.LiajlihiEnt;
import com.example.mushafconsolidated.Entities.MafoolBihi;
import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.QuranEntity;
import com.example.mushafconsolidated.Entities.VerbCorpus;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.QuranMorphologyDetails;
import com.example.mushafconsolidated.fragments.SentenceAnalysisBottomSheet;
import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.example.mushafconsolidated.fragments.WordMorphologyDetails;
import com.example.mushafconsolidated.intrface.OnItemClickListenerOnLong;
import com.example.mushafconsolidated.model.CorpusAyahWord;
import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.utility.AnimationUtility;
import com.example.utility.CorpusUtilityorig;
import com.example.utility.FileUtility;
import com.example.utility.FlowLayout;
import com.example.utility.PreferenceUtil;
import com.example.utility.QuranGrammarApplication;
import com.tooltip.Tooltip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;
//public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnItemClickListenerOnLong {
public class UpdateMafoolFlowAyahWordAdapter extends RecyclerView.Adapter<UpdateMafoolFlowAyahWordAdapter.ItemViewAdapter> implements OnItemClickListenerOnLong {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    public static Object ItemViewAdapter;
    static boolean showTranslation;
    static boolean wordByWord;
    int arabicfontSize,translationfontsize;
    private final boolean issentence;

    private final SharedPreferences sharedPreferences;

    OnItemClickListenerOnLong mItemClickListener;

    static int fontSizeArabic;
    static int fontSizeTranslation;

    static Typeface corpusTypeface;

    public Context context;
    final long surah_id;
    private ArrayList<CorpusAyahWord> ayahWordArrayList;
    private final List<QuranEntity> allofQuran;

    public int adapterposition;
    private OnItemClickListenerOnLong onclicklistner;
    private ArrayList<String> header;
    private String isNightmode;

    public int getAdapterposition() {
        return adapterposition;
    }

    public void setAdapterposition(int adapterposition) {
        this.adapterposition = adapterposition;
    }

    PreferenceUtil pref;
    private String SurahName;
    private int isMakkiMadani;
    public TextView arabic,rootword,wordno;


    public void setItemClickListener(View.OnClickListener clickListener) {
        //   private final List<QuranEntity> translations;
        //  privviewate final List<QuranEntity> erab;
    }

    public UpdateMafoolFlowAyahWordAdapter(ArrayList<String> header, List<QuranEntity> allofQuran,


                                           ArrayList<CorpusAyahWord> ayahWordArrayList, Context context, long surah_id, String surahName, int ismakki, OnItemClickListenerOnLong listener) {
        this.header = header;
        this.allofQuran = allofQuran;

        this.ayahWordArrayList = ayahWordArrayList;
        this.context = context;
        this.surah_id = surah_id;
        this.SurahName = surahName;
        this.isMakkiMadani = ismakki;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        //   showTranslation =
        //        sharedPreferences.getBoolean(Config.SHOW_TRANSLATION, Config.defaultShowTranslation);
        sharedPreferences.getBoolean(Config.SHOW_Erab, Config.defaultShowErab);

        issentence = sharedPreferences.getBoolean("grammarsentence", false);

        arabicfontSize = sharedPreferences.getInt("pref_font_arabic_key", 18);
        translationfontsize=sharedPreferences.getInt("pref_font_englsh_key", 18);

        mItemClickListener = listener;

    }


    public void addContext(Context context) {
        this.context = context;

    }


    public void SetOnItemClickListener(final OnItemClickListenerOnLong mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return ayahWordArrayList.size()+1;
        //     return  quran.size();
    }

    @Override
    public long getItemId(int position) {

        CorpusAyahWord ayahWord = ayahWordArrayList.get(position);
      long itemId = 0;

        for (CorpusWbwWord word : ayahWord.getWord()) {
            itemId = word.getVerseId();
        }
        return itemId;
    }


    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surah_header, parent, false);
            return new ItemViewAdapter(view, viewType);
        } else {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ayah_word, parent, false);
            //   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewer_aya_cardview, parent, false);
            return new ItemViewAdapter(view, viewType);
        }


    }


    public class ItemViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener, OnLongClickListener {
        TextView tvSura, tvRukus, tvVerses;
        ImageView ivSurahIcon, ivLocationmakki, ivLocationmadani,ivhelp,ivoverflow,arrowforward,arrowback;
  SwitchCompat colorize;
        public TextView verse_idTextView;
        public TextView quran_jalalayn,kathir_translation, kathir_note;
        public TextView quran_transliteration;
        //  public   com.nex3z.flowlayout.FlowLayout  flow_word_by_word;
        FlowLayout flow_word_by_word;

        public TextView translate_textView;

        public TextView erab_textView;
        public TextView surah_info;
        public TextView bismilla;
        public TextView quran_textView;
        public TextView quran_transliterationnote;
        public TextView quran_jalalaynnote;
        public TextView erab_textViewnote;
        public TextView translate_textViewnote;
        public ImageView bookmark, jumpto, makkimadaniicon;
        public ImageView expandImageButton, ivBismillah,erabexpand;

        // public MaterialCardView cardview;
        public FlowLayout cardview;


        ItemViewAdapter(View view, int viewType) {
            super(view);
            view.setTag(this);
            itemView.setOnClickListener(this);
            if (viewType == 0) {
                ivLocationmakki = view.findViewById(R.id.ivLocationmakki);
                ivLocationmadani = view.findViewById(R.id.ivLocationmadani);
                ivSurahIcon = view.findViewById(R.id.ivSurahIcon);
                tvVerses = (TextView) view.findViewById(R.id.tvVerses);
                tvRukus = (TextView) view.findViewById(R.id.tvRukus);
                tvSura = (TextView) view.findViewById(R.id.tvSura);
                ivBismillah = view.findViewById(R.id.ivBismillah);


            } else {
              //  kathir_note =view.findViewById(R.id.kathir_note);
                kathir_translation=view.findViewById(R.id.katheer_textview);
                arrowforward=view.findViewById(R.id.arrowforward);
                arrowback=view.findViewById(R.id.arrowback);
                colorize=view.findViewById(R.id.colorized);
                bookmark=view.findViewById(R.id.bookmark);
              jumpto=view.findViewById(R.id.jumpto);
                ivhelp=view.findViewById(R.id.ivHelp);
                ivoverflow=view.findViewById(R.id.ivActionOverflow);
                ivhelp.setOnClickListener(this);
                ivoverflow.setOnClickListener(this);

                jumpto.setOnClickListener(this);
                bookmark.setOnClickListener(this);
                ivhelp.setTag("help_img");
                ivoverflow.setTag("overflow_img");
                bookmark.setTag("bookmark");
            //    colorize.setChecked(true);
                colorize.setOnClickListener(this);
                colorize.setTag("colorize");
                jumpto.setTag("jumpto");
                arrowforward.setOnClickListener(this);
                arrowback.setOnClickListener(this);
                arrowback.setTag("arrowback");
                arrowforward.setTag("arrowforward");
                makkimadaniicon = view.findViewById(R.id.makkimadaniicon);

            //    jumpto = view.findViewById(R.id.jumpto);
                bismilla = view.findViewById(R.id.bismillah);
                quran_transliterationnote = view.findViewById(R.id.quran_transliterationnote);
                quran_jalalaynnote = view.findViewById(R.id.quran_jalalaynnote);
                translate_textViewnote = view.findViewById(R.id.translate_textViewnote);
                erab_textViewnote = view.findViewById(R.id.erab_textViewnote);
                quran_transliteration = view.findViewById(R.id.quran_transliteration);
                quran_jalalayn = view.findViewById(R.id.quran_jalalayn);
                surah_info = view.findViewById(R.id.chaptername);
                //    verse_idTextView = view.findViewById(R.id.verse_id_textView);

                flow_word_by_word = view.findViewById(R.id.flow_word_by_word);
                translate_textView = view.findViewById(R.id.translate_textView);
                erab_textView = view.findViewById(R.id.erab_textView);
                quran_textView = view.findViewById(R.id.quran_textView);
           //     bookmark = view.findViewById(R.id.bookmarkView);
                erabexpand= view.findViewById(R.id.erabexpand);
                expandImageButton = view.findViewById(R.id.expandImageButton);
                quran_textView.setOnClickListener(this);
                quran_textView.setTag("qurantext");
            //    bookmark.setOnClickListener(this);
             //   jumpto.setOnClickListener(this);

                view.setOnClickListener(this);
                view.setOnLongClickListener(this);
                SharedPreferences shared = androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext());
                boolean colortag = shared.getBoolean("colortag", true);
                if(colortag){
                    colorize.setChecked(true);
                }else {
                    colorize.setChecked(false);

                }

                erabexpand.setOnClickListener(view1 -> {

                    final int visibility = erab_textView.getVisibility();


                    if (erab_textView.getVisibility() == View.GONE) {
                        erab_textView.setVisibility(View.VISIBLE);
                      //  AnimationUtility.slide_down(context, erabexpand);
                        AnimationUtility.AnimateArrow(90.0f, erabexpand);
                    }  else {
                        erab_textView.setVisibility(View.GONE);
                      AnimationUtility.AnimateArrow(0.0f, erabexpand);
                        //   Fader.slide_down(context,expandImageButton);
                    }


                });

                expandImageButton.setOnClickListener(view1 -> {

                    final int visibility = kathir_translation.getVisibility();


                    if (kathir_translation.getVisibility() == View.GONE) {
                        kathir_translation.setVisibility(View.VISIBLE);
                        AnimationUtility.AnimateArrow(90.0f, expandImageButton);
                    }     else {
                        kathir_translation.setVisibility(View.GONE);
                        AnimationUtility.AnimateArrow(-0.0f, expandImageButton);
                        //    Fader.slide_down(context,expandImageButton);
                    }


                });

                flow_word_by_word.setOnClickListener(view1 -> {

                    if (translate_textView.getVisibility() == View.GONE)
                        translate_textView.setVisibility(View.VISIBLE);
                    else
                        translate_textView.setVisibility(View.VISIBLE);


                });

                translate_textView.setOnClickListener(view1 -> {

                    if (translate_textView.getVisibility() == View.VISIBLE)
                        translate_textView.setVisibility(View.GONE);
                    else
                        translate_textView.setVisibility(View.VISIBLE);


                });

                erab_textView.setOnClickListener(view1 -> {

                    if (erab_textView.getVisibility() == View.VISIBLE)
                        erab_textView.setVisibility(View.GONE);
                    else
                        erab_textView.setVisibility(View.VISIBLE);


                });
            }

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }


        @Override
        public boolean onLongClick(View v) {
            mItemClickListener.onItemLongClick(getAdapterPosition(), v);
            return true;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(ItemViewAdapter holder, int position) {
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        isNightmode = sharedPreferences.getString("themepref", "dark");
        String arabic_font_selection = sharedPreferences.getString("Arabic_Font_Selection", String.valueOf(MODE_PRIVATE));


        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),
                arabic_font_selection);
        boolean  showrootkey   = sharedPreferences.getBoolean("showrootkey", true);
        boolean showErab = sharedPreferences.getBoolean("showErabKey", true);
        boolean showWordColor = sharedPreferences.getBoolean("colortag", true);

        boolean showTransliteration = sharedPreferences.getBoolean("showtransliterationKey", true);
        boolean showJalalayn = sharedPreferences.getBoolean("showEnglishJalalayn", true);
        boolean showTranslation = sharedPreferences.getBoolean("showTranslationKey", true);
        boolean showWordByword = sharedPreferences.getBoolean("wordByWord", false);
        boolean showKathir = sharedPreferences.getBoolean("showKathir", false);



        String whichtranslation = sharedPreferences.getString("selecttranslation", "en_sahih");
        if (getItemViewType(position) == 0) {

            TypedArray imgs = this.context.getResources().obtainTypedArray(R.array.sura_imgs);
            // You have to set your header items values with the help of model class and you can modify as per your needs
            holder.tvRukus.setText("Ruku's :" + header.get(0));
            holder.tvVerses.setText("Aya's :" + header.get(1));
            holder.tvSura.setText(header.get(3));
            String chapterno = header.get(2);
            int tauba = Integer.parseInt(chapterno);
            if (tauba == 9) {
                holder.ivBismillah.setVisibility(View.GONE);
            }


            if (isMakkiMadani == 1) {
                holder.ivLocationmakki.setVisibility(View.VISIBLE);
                holder.ivLocationmadani.setVisibility(View.GONE);
            } else {
                holder.ivLocationmadani.setVisibility(View.VISIBLE);
                holder.ivLocationmakki.setVisibility(View.GONE);
            }
            final Drawable drawable = imgs.getDrawable(Integer.parseInt(chapterno) - 1);

            holder.ivSurahIcon.setImageDrawable(drawable);


            if (isNightmode.equals("dark") || isNightmode.equals("blue")) {

                holder.ivLocationmakki.setColorFilter(Color.CYAN);
                holder.ivSurahIcon.setColorFilter(Color.CYAN);

                holder.ivLocationmadani.setColorFilter(Color.CYAN);


            } else {
                holder.ivLocationmakki.setColorFilter(Color.BLACK);
                holder.ivSurahIcon.setColorFilter(Color.BLACK);
                holder.ivLocationmadani.setColorFilter(Color.BLACK);
            }



        } else {


          displayAyats(showrootkey,holder, position-1, sharedPreferences, custom_font, showErab, showWordColor, showTransliteration, showJalalayn, showTranslation, showWordByword, whichtranslation,showKathir);

        }

    }

  private void displayAyats(boolean showrootkey, UpdateMafoolFlowAyahWordAdapter.ItemViewAdapter holder, int position, SharedPreferences sharedPreferences, Typeface custom_font, boolean showErab, boolean showWordColor, boolean showTransliteration, boolean showJalalayn, boolean showTranslation, boolean showWordByword, String whichtranslation, boolean showKathir) {
    //   holder.flowwbw.setBackgroundColor(R.style.Theme_DarkBlue);


    QuranEntity entity = null;
    QuranEntity erabentity = null;
    String wbw = sharedPreferences.getString("wbw", String.valueOf(Context.MODE_PRIVATE));
    int actualposition = position;
    try {
        entity = allofQuran.get(actualposition);
    } catch (IndexOutOfBoundsException e) {
        System.out.println("check");
    }


    final CorpusAyahWord ayahWord = ayahWordArrayList.get(actualposition);
    if (null != entity) {
        storepreferences(entity);
    }
    SpannableString quranverses = ayahWordArrayList.get(actualposition).getSpannableverse();

    holder.quran_textView.setText(quranverses);
    holder.quran_textView.setTextSize(arabicfontSize);
    holder.quran_textView.setTypeface(custom_font);

    setChapterInfo(holder, ayahWord);

    setAdapterposition(actualposition);


    wordBywordWithTranslation( showrootkey,holder, custom_font, showWordColor, wbw, ayahWord, showWordByword);


      if(showKathir){
          holder.kathir_translation.setText(Html.fromHtml(entity.getTafsir_kathir(), Html.FROM_HTML_MODE_LEGACY));

          holder.kathir_translation.setTextSize(translationfontsize);
          holder.kathir_translation.setTextSize(translationfontsize);
       //   holder.kathir_translation.setVisibility(View.VISIBLE);
          holder.kathir_note.setVisibility(View.VISIBLE);

      }
    if (showTransliteration) {
        holder.quran_transliteration.setText(Html.fromHtml(entity.getTranslation(), Html.FROM_HTML_MODE_LEGACY));
        holder.quran_transliteration.setTextSize(translationfontsize);
        holder.quran_transliteration.setTextSize(translationfontsize);
        holder.quran_transliteration.setVisibility(View.VISIBLE);


    }
    if (showJalalayn) {
        //   holder.quran_jalalaynnote.setText(enjalalayn.getAuthor_name());
        holder.quran_jalalayn.setText(entity.getEn_jalalayn());
        holder.quran_jalalayn.setTextSize(translationfontsize);
        holder.quran_jalalayn.setTextSize(translationfontsize);
        holder.quran_jalalayn.setVisibility(View.VISIBLE);
        holder.quran_jalalaynnote.setVisibility(View.VISIBLE);
    }
    if (showTranslation) {

        if (whichtranslation.equals("en_arberry")) {

            holder.translate_textView.setText(entity.getEn_arberry());
            holder.translate_textViewnote.setText(R.string.arberry);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setVisibility(View.VISIBLE);
            holder.translate_textViewnote.setVisibility(View.VISIBLE);
        }
        if (whichtranslation.equals("en_sahih")) {


            holder.translate_textView.setText(entity.getTranslation());
            holder.translate_textViewnote.setText(R.string.ensahih);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setVisibility(View.VISIBLE);
            holder.translate_textViewnote.setVisibility(View.VISIBLE);
        }
        if (whichtranslation.equals("en_jalalayn")) {
            holder.translate_textView.setText(entity.getEn_jalalayn());
            holder.translate_textViewnote.setText(R.string.enjalalayn);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setVisibility(View.VISIBLE);
            holder.translate_textViewnote.setVisibility(View.VISIBLE);
        }
        if (whichtranslation.equals("ur_jalalayn")) {
            holder.translate_textView.setText(entity.getUr_jalalayn());
            holder.translate_textViewnote.setText(R.string.enjalalayn);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setVisibility(View.VISIBLE);
            holder.translate_textViewnote.setVisibility(View.VISIBLE);
        }
        if (whichtranslation.equals("ur_junagarhi")) {
            holder.translate_textView.setText(entity.getUr_junagarhi());
            holder.translate_textViewnote.setText(R.string.urjunagadi);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setTextSize(translationfontsize);
            holder.translate_textView.setVisibility(View.VISIBLE);
            holder.translate_textViewnote.setVisibility(View.VISIBLE);
        }


        holder.translate_textView.setTextSize(translationfontsize);
        holder.translate_textView.setTextSize(translationfontsize);
        holder.translate_textView.setVisibility(View.VISIBLE);
        holder.translate_textViewnote.setVisibility(View.VISIBLE);

    }


    if (showErab) {

        holder.erab_textView.setText(entity.getErabspnabble());
        //   holder.erab_textView.setText(entity.getAr_irab_two());
        //     holder.erab_textView.setText(erabentity.getErabspnabble());
        holder.erab_textView.setTextSize(translationfontsize);
        holder.erab_textView.setTypeface(custom_font);
   //     holder.erab_textView.setVisibility(View.VISIBLE);
        holder.erab_textViewnote.setVisibility(View.VISIBLE);


/*
if (SharedPref.themePreferences().equals("dark")) {
  holder.erab_textView.setTextColor(QuranGrammarApplication.getContext().getResources().getColor(R.color.white));

} else {
  holder.erab_textView.setTextColor(QuranGrammarApplication.getContext().getResources().getColor(R.color.burntamber));

}
*/

    }
  }

  private void wordBywordWithTranslation(boolean showrootkey,ItemViewAdapter holder, Typeface custom_font, boolean showWordColor, String wbw, CorpusAyahWord ayahWord, boolean showWbwTranslation) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder.flow_word_by_word.removeAllViews();
        for (final CorpusWbwWord word : ayahWord.getWord()) {
            final View view = inflater.inflate(R.layout.word_by_word, null);
            //      arabic.setOnLongClickListener((OnLongClickListener) this);

            //   final TextView arabic = view.findViewById(R.id.word_arabic_textView);
            arabic = view.findViewById(R.id.word_arabic_textView);
            rootword=view.findViewById(R.id.root_word);
            wordno=view.findViewById(R.id.wordno);
            final TextView translation = view.findViewById(R.id.word_trans_textView);
            SpannableString spannedroot = null;
           StringBuilder sb=new StringBuilder();
           sb.append(word.getWordno());
            wordno.setText(sb.toString());
            wordno.setTextSize(arabicfontSize);
            wordno.setVisibility(View.VISIBLE);
            if(showrootkey) {
                if (!word.getRootword().isEmpty()) {
                    spannedroot = getSpannedRoots(word);
                    rootword.setText(spannedroot);
                    rootword.setTextSize(arabicfontSize);
                    rootword.setVisibility(View.VISIBLE);
                } else {
                    spannedroot = SpannableString.valueOf(word.getRootword());
                    rootword.setText(spannedroot);
                    rootword.setTextSize(arabicfontSize);
                    rootword.setVisibility(View.VISIBLE);
                }
            }
            if (showWordColor) {

                SpannableString spannedword = null;

               word.getRootword();
                spannedword = getSpannedWords(word);
                //   arabic.setText(fixArabic(String.valueOf(spannedword)));
                spannedword.toString().replaceAll(" ", "");


                arabic.setText(spannedword);
            } else {


                arabic.setText(word.getWordsAr());
            }

            rootword.setText(spannedroot);
            rootword.setTextSize(arabicfontSize);
            //  arabic.setTextSize(18);
            arabic.setTextSize(arabicfontSize);
            arabic.setTypeface(custom_font);
            if (showWbwTranslation) {
                if (wbw.equals("en")) {
                    translation.setText(word.getTranslateEn());
                    translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                } else if (wbw.equals("bn")) {
                    translation.setText(word.getTranslateBn());
                    translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                } else if (wbw.equals("in")) {

                    translation.setText(word.getTranslateIndo());
                    translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                } else if (wbw.equals("ur")) {
                    translation.setText(word.getTranslationUrdu());
                    translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                }
                //  translation.setTextColor(context.getResources().getColor(R.color.neutral2));
            }
            //    translation.setTextSize(forntSize + 4);
            translation.setTextSize(arabicfontSize);
            holder.flow_word_by_word.addView(view);
             StringBuilder fael=new StringBuilder();
            view.setLongClickable(true);
            view.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                Utils utils = new Utils(getContext());






                    return true;
                }





            });
            view.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    Utils utils = new Utils(getContext());
                    String filename="mafool.csv";
                  //  writetofile(filename,word.getSurahId(), word.getVerseId(), word.getWordno(),word.getWordsAr());
                    FileUtility fl=new FileUtility(context);
                    FileUtility. writetofile(filename,word.getSurahId(), word.getVerseId(), word.getWordno(),word.getWordsAr());
                    Toast.makeText(QuranGrammarApplication.getContext(), "inserted", Toast.LENGTH_SHORT).show();


                }


                private void writetofile(String filename, int surahId, int verseId, int wordno, String wordsAr) {

                    ArrayList<String> ammended = new ArrayList<>();
                    StringBuilder sb=new StringBuilder();
                    sb.append(surahId).append("|").append(verseId).append("|").append(wordno).append("|").append(wordsAr).append("|");
                    ammended.add(sb.toString());
                    String state = Environment.getExternalStorageState();



                    if (Environment.MEDIA_MOUNTED.equals(state)) {
                        FileWriter myWriter;
                        String s;
                        if (checkPermission()) {
                            File sdcard = Environment.getExternalStorageDirectory();
                            File dir = new File(sdcard.getAbsolutePath() + "/text/");
                            dir.mkdir();
                            File file = new File(dir, filename);
                            FileOutputStream os;
                            try {
                                os = new FileOutputStream(file,true);
                                //      os.write(harfNasbIndexArrayList.toString().getBytes());

                                for (Object str : ammended) {
                                    os.write(str.toString().getBytes());
                                    String newline = "\n";
                                    os.write(newline.getBytes());
                                }

                                os.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            requestPermission(); // Code for permission
                        }
                    }




                }

                private void requestPermission() {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Toast.makeText((Activity) QuranGrammarApplication.getContext(), "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
                    } else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                    }
                }
                private boolean checkPermission() {
                    int result = ContextCompat.checkSelfPermission((Activity) context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    return result == PackageManager.PERMISSION_GRANTED;
                }
                private void LoadItemList(Bundle dataBundle) {


                    if (issentence) {
                        SentenceAnalysisBottomSheet item = new SentenceAnalysisBottomSheet();
                        //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                        item.setArguments(dataBundle);
                        String[] data = {String.valueOf(word.getSurahId()), String.valueOf(word.getVerseId()), word.getTranslateEn(), String.valueOf((word.getWordno()))};
                        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
                        //   transactions.show(item);
                        SentenceAnalysisBottomSheet.newInstance(data).show(((AppCompatActivity) context).getSupportFragmentManager(), SentenceAnalysisBottomSheet.TAG);

                    } else {
                        WordAnalysisBottomSheet item = new WordAnalysisBottomSheet();
                        //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                        item.setArguments(dataBundle);
                        String[] data = {String.valueOf(word.getSurahId()), String.valueOf(word.getVerseId()), word.getTranslateEn(), String.valueOf((word.getWordno())), SurahName};
                        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
                        //   transactions.show(item);
                        WordAnalysisBottomSheet.newInstance(data).show(((AppCompatActivity) context).getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);

                    }

                }


            });

        }

        holder.flow_word_by_word.setVisibility(View.VISIBLE);

    }


    private SpannableString getSpannedRoots(CorpusWbwWord corpus) {

        boolean b = corpus.getVerseId() == 20 && (corpus.getWordno() == 2 || corpus.getWordno() == 9);
        if (b) {
            System.out.println("check");
        }
        SpannableString spannableStringBuilder = CorpusUtilityorig.ColorizeRootword(corpus.getTagone(), corpus.getTagtwo(), corpus.getTagthree(), corpus.getTagfour(), corpus.getTagfive(),
                corpus.getRootword());


        return spannableStringBuilder;
    }


    private SpannableString getSpannedWords(CorpusWbwWord corpus) {

        boolean b = corpus.getVerseId() == 20 && (corpus.getWordno() == 2 || corpus.getWordno() == 9);
        if (b) {
            System.out.println("check");
        }
        SpannableString spannableStringBuilder = CorpusUtilityorig.NewSetWordSpan(corpus.getTagone(), corpus.getTagtwo(), corpus.getTagthree(), corpus.getTagfour(), corpus.getTagfive(),
                corpus.getAraone(), corpus.getAratwo(), corpus.getArathree(), corpus.getArafour(), corpus.getArafive());


        return spannableStringBuilder;
    }


    private void storepreferences(QuranEntity entity) {


        SharedPreferences pref = context.getSharedPreferences("lastread", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(CHAPTER, entity.getSurah());
        editor.putInt(AYAH_ID, entity.getAyah());
        editor.putString(SURAH_ARABIC_NAME, SurahName);


        editor.apply();
        editor.commit();

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setChapterInfo(ItemViewAdapter holder, CorpusAyahWord verse) {


        StringBuilder surahInfo = new StringBuilder();
//        surahInfo.append(surahName+".");
        surahInfo.append(verse.getWord().get(0).getSurahId()).append(".");
        surahInfo.append(verse.getWord().get(0).getVerseId()).append("-");

        surahInfo.append(SurahName);
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        String isNightmode = sharedPreferences.getString("themepref", "dark");
        if (isMakkiMadani == 1) {
            holder.surah_info.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_makkah_48, 0, 0, 0);
            if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
//TextViewCompat.setCompoundDrawableTintList()

                holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
            } else {
                holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLACK));
            }


        } else {
            holder.surah_info.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_madinah_48, 0, 0, 0);

            if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
                holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
            } else {
                holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLACK));
            }
        }

        holder.surah_info.setText(surahInfo);
        holder.surah_info.setTextSize(arabicfontSize);
        //  holder.surah_info.setTextColor(context.getResources().getColor(R.color.colorOnPrimary));


    }


    private String fixArabic(String s) {
        // Add sukun on mem | nun
        s = s.replaceAll("\u0000", "");
        s = s.replaceAll("([\u0645\u0646])([ \u0627-\u064A]|$)", "$1\u0652$2");
        // Tatweel + Hamza Above (joining chairless hamza) => Yeh With Hamza Above
        s = s.replaceAll("\u0640\u0654", "\u0626");
        return s;
    }

    private int getStringInt(SharedPreferences sp, String key, int defValue) {
        return Integer.parseInt(sp.getString(key, Integer.toString(defValue)));
    }


    public void setListener(OnItemClickListenerOnLong listener) {

        mItemClickListener = listener;
    }

    public void getItem(int position) {
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void onItemLongClick(int position, View v) {

    }
//View.OnClickListener, View.OnLongClickListener


}























