package com.example.mushafconsolidated.Adapters;

import static android.content.Context.MODE_PRIVATE;
import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;
import static com.example.Constant.AYAHNUMBER;
import static com.example.Constant.SURAH_ARABIC_NAME;
import static com.example.Constant.SURAH_ID;
import static com.example.Constant.WORDNUMBER;
import static com.example.utility.QuranGrammarApplication.getContext;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.mushafconsolidated.Config;
import com.example.mushafconsolidated.Entities.NounCorpus;
import com.example.mushafconsolidated.Entities.VerbCorpus;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.Utils;
import com.example.mushafconsolidated.fragments.SentenceAnalysisBottomSheet;
import com.example.mushafconsolidated.fragments.WordAnalysisBottomSheet;
import com.example.mushafconsolidated.fragments.WordMorphologyDetails;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.mushafconsolidated.intrface.OnItemClickListenerOnLong;
import com.example.mushafconsolidated.model.CorpusAyahWord;
import com.example.mushafconsolidated.model.CorpusWbwWord;
import com.example.utility.AnimationUtility;
import com.example.utility.CorpusUtilityorig;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.card.MaterialCardView;
import com.tooltip.Tooltip;

import java.util.ArrayList;

//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;
//public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnItemClickListenerOnLong {
public class TopicFlowAyahWordAdapter extends RecyclerView.Adapter<TopicFlowAyahWordAdapter.ItemViewAdapter> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    final int arabicfontSize;
    final int translationfontsize;
    final OnItemClickListenerOnLong mItemClickListener;
    private final boolean issentence;
    private final ArrayList<CorpusAyahWord> ayahWordArrayList;
    public Context context;
    public TextView arabic, rootword;
    private OnItemClickListener listener;
    private String isNightmode;
    private String SurahName;
    private int isMakkiMadani;
    public TopicFlowAyahWordAdapter(ArrayList<CorpusAyahWord> corpusayahWordArrayList, OnItemClickListenerOnLong listener) {
        this.ayahWordArrayList = corpusayahWordArrayList;
        this.mItemClickListener = listener;
        //  mItemClickListener = listener;
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        sharedPreferences.getBoolean(Config.SHOW_Erab, Config.defaultShowErab);
        issentence = sharedPreferences.getBoolean("grammarsentence", false);
        arabicfontSize = sharedPreferences.getInt("pref_font_arabic_key", 18);
        translationfontsize = sharedPreferences.getInt("pref_font_englsh_key", 18);
    }

    public void addContext(Context context) {
        this.context = context;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return ayahWordArrayList.size();
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
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_row_ayah_word, parent, false);
        //   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewer_aya_cardview, parent, false);
        return new ItemViewAdapter(view, viewType);

    }

    public Object getItem(int position) {
        return ayahWordArrayList.get(0).getWord().get(position);
        //    return allofQuran.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewAdapter holder, int position) {
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        isNightmode = sharedPreferences.getString("themepref", "dark");
        String arabic_font_selection = sharedPreferences.getString("Arabic_Font_Selection", String.valueOf(MODE_PRIVATE));
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),
                arabic_font_selection);
        boolean showrootkey = sharedPreferences.getBoolean("showrootkey", true);
        boolean showErab = sharedPreferences.getBoolean("showErabKey", true);
        boolean showWordColor = sharedPreferences.getBoolean("colortag", true);
        boolean showTransliteration = sharedPreferences.getBoolean("showtransliterationKey", true);
        boolean showJalalayn = sharedPreferences.getBoolean("showEnglishJalalayn", true);
        boolean showTranslation = sharedPreferences.getBoolean("showTranslationKey", true);
        boolean showWordByword = sharedPreferences.getBoolean("wordByWord", false);
        boolean showKathir = sharedPreferences.getBoolean("showKathir", false);
        String whichtranslation = sharedPreferences.getString("selecttranslation", "en_sahih");
        displayAyats(showrootkey, holder, position, sharedPreferences, custom_font, showErab, showWordColor, showTransliteration, showJalalayn, showTranslation, showWordByword, whichtranslation, showKathir);

    }

    private void displayAyats(boolean showrootkey, TopicFlowAyahWordAdapter.ItemViewAdapter holder, int position, SharedPreferences sharedPreferences, Typeface custom_font, boolean showErab, boolean showWordColor, boolean showTransliteration, boolean showJalalayn, boolean showTranslation, boolean showWordByword, String whichtranslation, boolean showKathir) {
        //   holder.flowwbw.setBackgroundColor(R.style.Theme_DarkBlue);
        CorpusAyahWord ayahWord = null;
        SpannableString quranverses = null;
        String wbw = sharedPreferences.getString("wbw", String.valueOf(Context.MODE_PRIVATE));
        try {
            ayahWord = ayahWordArrayList.get(position);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            quranverses = ayahWordArrayList.get(position).getSpannableverse();
        } catch (IndexOutOfBoundsException e) {
        }
        assert ayahWord != null;
        holder.header.setText(ayahWord.getTopictitle());
        holder.quran_textView.setText(quranverses);
        holder.quran_textView.setTextSize(16);
        holder.quran_textView.setTypeface(custom_font);
        holder.base_cardview.setVisibility(View.GONE);
        holder.mafoolbihi.setVisibility(View.GONE);
        holder.base_cardview.setVisibility(View.GONE);
        
        setChapterInfo(holder, ayahWord);
        //  setAdapterposition(position);
        wordBywordWithTranslation(showrootkey, holder, custom_font, showWordColor, wbw, ayahWord, showWordByword);
        if (showKathir) {
            String first = ayahWord.getTafsir_kathir().replaceAll("<b>", "");
            String second = first.replaceAll("</b>", "");
            holder.kathir_translation.setText(second);
            holder.kathir_translation.setTextSize(translationfontsize);
            holder.kathir_translation.setTextSize(translationfontsize);

        } else {
            holder.kahteercardview.setVisibility(View.GONE);
        }
        if (showTransliteration) {
            holder.quran_transliteration.setText(Html.fromHtml(ayahWord.getEn_transliteration(), Html.FROM_HTML_MODE_LEGACY));
            holder.quran_transliteration.setTextSize(translationfontsize);
            holder.quran_transliteration.setTextSize(translationfontsize);
            holder.quran_transliteration.setVisibility(View.VISIBLE);

        }
        if (showTranslation) {
            if (whichtranslation.equals("en_arberry")) {
                holder.translate_textView.setText(ayahWord.getEn_arberry());
                holder.translate_textViewnote.setText(R.string.arberry);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setVisibility(View.VISIBLE);
                holder.translate_textViewnote.setVisibility(View.VISIBLE);
            }
            if (whichtranslation.equals("en_sahih")) {
                holder.translate_textView.setText(ayahWord.getQuranTranslate());
                holder.translate_textViewnote.setText(R.string.ensahih);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setVisibility(View.VISIBLE);
                holder.translate_textViewnote.setVisibility(View.VISIBLE);
            }
            if (whichtranslation.equals("en_jalalayn")) {
                holder.translate_textView.setText(ayahWord.getEn_jalalayn());
                holder.translate_textViewnote.setText(R.string.enjalalayn);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setVisibility(View.VISIBLE);
                holder.translate_textViewnote.setVisibility(View.VISIBLE);
            }
            if (whichtranslation.equals("ur_jalalayn")) {
                holder.translate_textView.setText(ayahWord.getUr_jalalayn());
                holder.translate_textViewnote.setText(R.string.enjalalayn);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setTextSize(translationfontsize);
                holder.translate_textView.setVisibility(View.VISIBLE);
                holder.translate_textViewnote.setVisibility(View.VISIBLE);
            }
            if (whichtranslation.equals("ur_junagarhi")) {
                holder.translate_textView.setText(ayahWord.getUr_junagarhi());
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
            holder.erabexpand.setVisibility(View.VISIBLE);
            holder.erab_textView.setText(ayahWord.getAr_irab_two());
            holder.erab_textView.setTextSize(translationfontsize);
            holder.erab_textView.setTypeface(custom_font);
            //     holder.erab_textView.setVisibility(View.VISIBLE);
            holder.erab_textViewnote.setVisibility(View.VISIBLE);

        } else {
            holder.erabexpand.setVisibility(View.GONE);
        }
    }

    private void wordBywordWithTranslation(boolean showrootkey, ItemViewAdapter holder, Typeface custom_font, boolean showWordColor, String wbw, CorpusAyahWord ayahWord, boolean showWbwTranslation) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder.flow_word_by_word.removeAllViews();
        for (final CorpusWbwWord word : ayahWord.getWord()) {
            final View view = inflater.inflate(R.layout.word_by_word, null);
            arabic = view.findViewById(R.id.word_arabic_textView);
            rootword = view.findViewById(R.id.root_word);
            //   wordno = view.findViewById(R.id.wordno);
            final TextView translation = view.findViewById(R.id.word_trans_textView);
            SpannableString spannedroot = null;
            StringBuilder sb = new StringBuilder();
            sb.append(word.getWordno());
            if (showrootkey) {
                if (!word.getRootword().isEmpty()) {
                    spannedroot = getSpannedRoots(word);
                } else {
                    spannedroot = SpannableString.valueOf(word.getRootword());
                }
                rootword.setText(spannedroot);
                rootword.setTextSize(arabicfontSize);
                rootword.setVisibility(View.VISIBLE);
            }
            if (showWordColor) {
                SpannableString spannedword;
                // word.getRootword();
                spannedword = getSpannedWords(word);
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
                switch (wbw) {
                    case "en":
                        translation.setText(word.getTranslateEn());
                        translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                        break;
                    case "bn":
                        translation.setText(word.getTranslateBn());
                        translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                        break;
                    case "in":
                        translation.setText(word.getTranslateIndo());
                        translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                        break;
                    case "ur":
                        translation.setText(word.getTranslationUrdu());
                        translation.setPaintFlags(translation.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                        break;
                }
                //  translation.setTextColor(context.getResources().getColor(R.color.neutral2));
            }
            //    translation.setTextSize(forntSize + 4);
            translation.setTextSize(translationfontsize);
            holder.flow_word_by_word.addView(view);
            view.setLongClickable(true);
            view.setOnLongClickListener(v -> {
                Utils utils = new Utils(getContext());
                ArrayList<VerbCorpus> verbCorpusRootWords = utils.getQuranRoot(word.getSurahId(), word.getVerseId(), word.getWordno());
                if (verbCorpusRootWords.size() > 0 && verbCorpusRootWords.get(0).getTag().equals("V")) {
                    //    vbdetail = ams.getVerbDetails();
                    System.out.print("check");
                }
                ArrayList<NounCorpus> corpusNounWord = utils.getQuranNouns(word.getSurahId(), word.getVerseId(), word.getWordno());
                ArrayList<VerbCorpus> verbCorpusRootWord = utils.getQuranRoot(word.getSurahId(), word.getVerseId(), word.getWordno());
                WordMorphologyDetails qm = new WordMorphologyDetails(word, corpusNounWord, verbCorpusRootWord);
                SpannableString workBreakDown = qm.getWorkBreakDown();
                int color = context.getResources().getColor(R.color.background_color_light_brown);
                switch (isNightmode) {
                    case "dark":
                    case "blue":
                        color = context.getResources().getColor(R.color.background_color);
                        break;
                    case "brown":
                        color = context.getResources().getColor(R.color.neutral0);
                        break;
                    case "white":
                        color = context.getResources().getColor(R.color.background_color_light_brown);
                        break;
                }
                Tooltip.Builder builder = new Tooltip.Builder(v, R.style.ayah_translation)
                        .setCancelable(true)
                        .setDismissOnClick(false)
                        .setCornerRadius(20f)
                        .setGravity(Gravity.TOP)
                        .setArrowEnabled(true)
                        .setBackgroundColor(color)
                        .setText(workBreakDown);
                builder.show();
                return true;
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setTitle(word.getWordsAr());
                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt(SURAH_ID, word.getSurahId());
                    dataBundle.putInt(AYAHNUMBER, Math.toIntExact(word.getVerseId()));
                    dataBundle.putInt(WORDNUMBER, Math.toIntExact(word.getWordno()));
                    dataBundle.putString(SURAH_ARABIC_NAME, SurahName);
                    LoadItemList(dataBundle);

                }

                private void LoadItemList(Bundle dataBundle) {
                    if (issentence) {
                        SentenceAnalysisBottomSheet item = new SentenceAnalysisBottomSheet();
                        item.setArguments(dataBundle);
                        String[] data = {String.valueOf(word.getSurahId()), String.valueOf(word.getVerseId()), word.getTranslateEn(), String.valueOf((word.getWordno()))};
                        SentenceAnalysisBottomSheet.newInstance(data).show(((AppCompatActivity) context).getSupportFragmentManager(), SentenceAnalysisBottomSheet.TAG);

                    } else {
                        WordAnalysisBottomSheet item = new WordAnalysisBottomSheet();
                        item.setArguments(dataBundle);
                        String[] data = {String.valueOf(word.getSurahId()), String.valueOf(word.getVerseId()), word.getTranslateEn(), String.valueOf((word.getWordno())), SurahName};
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
        return CorpusUtilityorig.ColorizeRootword(corpus.getTagone(), corpus.getTagtwo(), corpus.getTagthree(), corpus.getTagfour(), corpus.getTagfive(),
                corpus.getRootword());
    }

    private SpannableString getSpannedWords(CorpusWbwWord corpus) {
        boolean b = corpus.getVerseId() == 20 && (corpus.getWordno() == 2 || corpus.getWordno() == 9);
        if (b) {
            System.out.println("check");
        }
        return CorpusUtilityorig.NewSetWordSpan(corpus.getTagone(), corpus.getTagtwo(), corpus.getTagthree(), corpus.getTagfour(), corpus.getTagfive(),
                corpus.getAraone(), corpus.getAratwo(), corpus.getArathree(), corpus.getArafour(), corpus.getArafive());
    }

    private void setChapterInfo(ItemViewAdapter holder, CorpusAyahWord verse) {
        StringBuilder surahInfo = new StringBuilder();
//        surahInfo.append(surahName+".");
        surahInfo.append(verse.getWord().get(0).getSurahId()).append(".");
        surahInfo.append(verse.getWord().get(0).getVerseId()).append("-");
        //  surahInfo.append(SurahName);
        SharedPreferences sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        String isNightmode = sharedPreferences.getString("themepref", "dark");
        TypedArray imgs = QuranGrammarApplication.getContext().getResources().obtainTypedArray(R.array.sura_imgs);
        final Drawable drawable = imgs.getDrawable((Integer.parseInt(String.valueOf(verse.getWord().get(0).getSurahId())) - 1));
        imgs.recycle();
        holder.surahicon.setImageDrawable(drawable);
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
            holder.surahicon.setColorFilter(Color.CYAN);

        }
        if (isMakkiMadani == 1) {
            holder.surah_info.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_makkah_48, 0, 0, 0);

        } else {
            holder.surah_info.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_madinah_48, 0, 0, 0);
        }
        if (isNightmode.equals("dark") || isNightmode.equals("blue")) {
//TextViewCompat.setCompoundDrawableTintList()
            holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));

        } else {
            holder.surah_info.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLACK));
        }
        holder.surah_info.setText(surahInfo);
        holder.surah_info.setTextSize(arabicfontSize);
        //  holder.surah_info.setTextColor(context.getResources().getColor(R.color.colorOnPrimary));
    }

    public class ItemViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener, OnLongClickListener {
        public final TextView quran_jalalayn;
        public final TextView kathir_translation;
        public final TextView quran_transliteration;
        public final TextView translate_textView;
        public final TextView erab_textView;
        public final TextView surah_info;
        public final TextView mafoolbihi;
        public final TextView bismilla;
        public final TextView quran_textView;
        public final TextView erab_notes;
        public final TextView quran_transliterationnote;
        public final TextView quran_jalalaynnote;
        public final TextView erab_textViewnote, header;
        public final TextView translate_textViewnote;
        public final ImageView makkimadaniicon;
        public final ImageView expandImageButton;
        public final ImageView erabexpand;
        public final ImageView erab_notes_expand;
        final SwitchCompat colorize;
        final com.example.utility.FlowLayout flow_word_by_word;
        //   RelativeLayout colllayout;
        final CardView erabnotescardView;
        final CardView kahteercardview;
        final ImageView mafoolatarow;
        final ImageView showkatheer;
        final ImageView surahicon, ivoverflow;
        final Group hiddenGroup;
        final Group card_group;
        final MaterialCardView base_cardview;
        public ImageView bookmark;
        public ImageView ivBismillah;

        ItemViewAdapter(View view, int viewType) {
            super(view);
            view.setTag(this);
            header = view.findViewById(R.id.headers);
            itemView.setOnClickListener(this);
            surahicon = view.findViewById(R.id.surahicon);
            kathir_translation = view.findViewById(R.id.katheer_textview);
            colorize = view.findViewById(R.id.colorized);
            ivoverflow = view.findViewById(R.id.ivActionOverflow);
            ivoverflow.setOnClickListener(this);
            ivoverflow.setTag("overflow_img");
            //  ivhelp.setOnClickListener(this);
            makkimadaniicon = view.findViewById(R.id.makkimadaniicon);
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
            //     erab_textView.setTextIsSelectable(true);
            quran_textView = view.findViewById(R.id.quran_textView);
            erab_notes = view.findViewById(R.id.erab_notes);
            erabexpand = view.findViewById(R.id.erabexpand);
            erab_notes_expand = view.findViewById(R.id.erab_img);
            expandImageButton = view.findViewById(R.id.expandImageButton);
            quran_textView.setOnClickListener(this);
            quran_textView.setTag("qurantext");
            erab_notes_expand.setOnClickListener(this);
            erab_notes_expand.setTag("erab_notes");
            erabnotescardView = view.findViewById(R.id.base_cardview);
            kahteercardview = view.findViewById(R.id.katheer_base_cardview);
            mafoolatarow = view.findViewById(R.id.show);
            showkatheer = view.findViewById(R.id.showkatheer);
            hiddenGroup = view.findViewById(R.id.card_group);
            card_group = view.findViewById(R.id.katheer_card_group);
            mafoolatarow.setOnClickListener(this);
            mafoolbihi = view.findViewById(R.id.directobject);
            base_cardview = view.findViewById(R.id.base_cardview);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            SharedPreferences shared = androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext());
// Gets the layout params that will allow you to resize the layout
            //  ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) colllayout.getLayoutParams();
// Changes the height and width to the specified *pixels*
            mafoolatarow.setOnClickListener(view1 -> {
                TransitionManager.beginDelayedTransition(erabnotescardView, new AutoTransition());
                if (hiddenGroup.getVisibility() == View.VISIBLE) {
                    hiddenGroup.setVisibility(View.GONE);
                    mafoolatarow.setImageResource(android.R.drawable.arrow_down_float);
                } else {
                    //     colllayout.setLayoutParams(params);
                    hiddenGroup.setVisibility(View.VISIBLE);
                    mafoolatarow.setImageResource(android.R.drawable.arrow_up_float);
                }
            });
            showkatheer.setOnClickListener(view1 -> {
                TransitionManager.beginDelayedTransition(erabnotescardView, new AutoTransition());
                if (card_group.getVisibility() == View.VISIBLE) {
                    card_group.setVisibility(View.GONE);
                    showkatheer.setImageResource(android.R.drawable.arrow_down_float);
                } else {
                    //     colllayout.setLayoutParams(params);
                    card_group.setVisibility(View.VISIBLE);
                    showkatheer.setImageResource(android.R.drawable.arrow_up_float);
                }
            });
            erabexpand.setOnClickListener(view1 -> {
                if (erab_textView.getVisibility() == View.GONE) {
                    erab_textView.setVisibility(View.VISIBLE);
                    //  AnimationUtility.slide_down(context, erabexpand);
                    AnimationUtility.AnimateArrow(90.0f, erabexpand);
                } else {
                    erab_textView.setVisibility(View.GONE);
                    AnimationUtility.AnimateArrow(0.0f, erabexpand);
                    //   Fader.slide_down(context,expandImageButton);
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

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            //   mItemClickListener.onItemLongClick(getAdapterPosition(), v);
            mItemClickListener.onItemLongClick(getBindingAdapterPosition(), v);
            return true;

        }
    }

}






















