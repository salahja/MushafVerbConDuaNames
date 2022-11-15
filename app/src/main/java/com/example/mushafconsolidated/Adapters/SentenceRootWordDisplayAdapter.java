package com.example.mushafconsolidated.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Constant;
import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.R;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.HashMap;

public class SentenceRootWordDisplayAdapter extends RecyclerView.Adapter<SentenceRootWordDisplayAdapter.ItemViewAdapter> {
    private static final String TAG = "VerseDisplayAdapter";
    private static final String ROOTWORDSTRING = "Root Word:-";
    private static final String LEMMA = "Lemma/Derivative-";
    OnItemClickListener mItemClickListener;
    @NonNull
    String ismalatitle = "( الآلَة:)";
    @NonNull
    String alaheader = "اِسْم الآلَة";
    @NonNull
    String zarfheader = "اِسْم الْظَرفْ";
    int rootcolor, weaknesscolor, wazancolor;
    boolean ismujarrad = false;
    boolean ismazeed = false;
    boolean isparticple, isconjugation;
    boolean isSarfSagheerMazeed;
    private Context context;
    private HashMap<String, SpannableStringBuilder> worddetails;
    private HashMap<String, String> vbdetail;
    private ArrayList<NewCorpusExpandWbwPOJO> corpusexpand;
    private boolean isSarfSagheerThulahi;
    private boolean isverbconjugation;
    private boolean particples;
    private ArrayList<ArrayList> ismfaelmafool;
    private boolean isnoun;
    private SpannableStringBuilder spannalbeShart;
    private SpannableStringBuilder spannableHarf;
    private HashMap<Integer, HashMap<String, SpannableStringBuilder>> worddetailsmap;
    private HashMap<Integer, HashMap<String, String>> verbdetailsmap;
    private SpannableStringBuilder spannable;
    // private ArrayList<GrammarWordEntity> grammarArayList = new ArrayList<>();
    private ArrayList<ArrayList> sarfsagheer;
    public SentenceRootWordDisplayAdapter(Context context) {
        this.context = context;
    }

    public boolean isSarfSagheerMazeed() {
        return isSarfSagheerMazeed;
    }

    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sentence_word_details, parent, false);
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
        Typeface appliedFont = Typeface.createFromAsset(context.getAssets(), quranFont);
        String theme = sharedPreferences.getString("themePref", "dark");
        Log.d(TAG, "onBindViewHolder: called");
        if (theme.equals("dark")) {
            rootcolor = Constant.BCYAN;
            weaknesscolor = Constant.BYELLOW;
            wazancolor = Constant.BBLUE;

        } else {
            rootcolor = Constant.WBURNTUMBER;
            weaknesscolor = Constant.GOLD;
            wazancolor = Constant.WMIDNIHTBLUE;

        }
        SpannableStringBuilder wordno = worddetailsmap.get(position + 1).get("wordno");
        int wordposition = Integer.parseInt(String.valueOf(wordno));
        if (verbdetailsmap.get(wordposition) != null) {
            ismujarrad = !verbdetailsmap.get(wordposition).get("wazan").equals("null");
            ismazeed = !verbdetailsmap.get(wordposition).get("form").equals("null");
        }
        isparticple = worddetailsmap.get(wordposition).get("PART") != null;
        isconjugation = ismujarrad || ismazeed || isparticple;
        //  holder.wordView.setText(worddetailsmap.get(wordposition).get("word"));
        String word = String.valueOf(worddetailsmap.get(wordposition).get("word"));
        holder.wordView.setText(word);
        System.out.println(worddetailsmap.get(wordposition).get("word"));
        holder.lemma.setText(LEMMA + worddetailsmap.get(wordposition).get("lemma"));
        holder.wdetailstv.setText(worddetailsmap.get(wordposition).get("worddetails"), TextView.BufferType.SPANNABLE);
        if (!(worddetailsmap.get(wordposition).get("root") == null)) {
            holder.rootView.setText(ROOTWORDSTRING + worddetailsmap.get(wordposition).get("root"));

        }
        if (!(worddetailsmap.get(wordposition).get("wordtranslation") == null)) {
            holder.translationView.setText(worddetailsmap.get(wordposition).get("wordtranslation"));

        }
        //   holder.wordView.setText(worddetailsmap.get(wordposition).get("word"));
        if (!(worddetailsmap.get(wordposition).get("PRON") == null)) {
            holder.pronoundetails.setText(worddetailsmap.get(wordposition).get("PRON"));

        }
        if (isconjugation) {
            holder.verbconjugationbtn.setVisibility(View.VISIBLE);
            holder.wordoccurancebtn.setVisibility(View.VISIBLE);

        } else if (!(worddetailsmap.get(wordposition).get("noun") == null)) {
            holder.noun.setText(worddetailsmap.get(wordposition).get("noun"));
            holder.wordoccurancebtn.setVisibility(View.VISIBLE);
            holder.verbconjugationbtn.setVisibility(View.GONE);

        } else {
            holder.verbconjugationbtn.setVisibility(View.GONE);
            holder.wordoccurancebtn.setVisibility(View.GONE);

        }
        Integer wordd = null;
        Integer verb = null;
        String verbwordno = "";
        try {
            verbwordno = verbdetailsmap.get(wordposition).get("wordno");
        } catch (NullPointerException e) {
        }
        //   wordd = Integer.valueOf(verbwordno);
        //    verb = Integer.valueOf(String.valueOf(worddetailswordno));
        StringBuilder vb = new StringBuilder();
        vb.append("V-");
        try {
            if (worddetailsmap.get(wordposition).get("thulathi") != null) {
                vb.append(worddetailsmap.get(wordposition).get("thulathi"));
            }

        } catch (NullPointerException e) {
        }
        try {
            if (worddetailsmap.get(wordposition).get("png") != null) {
                vb.append(worddetailsmap.get(wordposition).get("png"));
            }
        } catch (NullPointerException e) {
        }
        try {
            if (worddetailsmap.get(wordposition).get("tense") != null) {
                vb.append(worddetailsmap.get(wordposition).get("tense"));
            }
        } catch (NullPointerException e) {
        }
        try {
            if (worddetailsmap.get(wordposition).get("voice") != null) {
                vb.append(worddetailsmap.get(wordposition).get("voice"));
            }
        } catch (NullPointerException e) {
        }
        try {
            if (worddetailsmap.get(wordposition).get("mood") != null) {
                vb.append(worddetailsmap.get(wordposition).get("mood"));
            }
        } catch (NullPointerException e) {
        }
        if (vb.length() > 2) {
            holder.verbdetails.setVisibility(View.VISIBLE);
            holder.verbdetails.setText(vb.toString());
        }
        //  wordbdetail.put("surahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getSurah())));
        //   wordbdetail.put("ayahid", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getAyah())));
        //   wordbdetail.put("wordno", SpannableStringBuilder.valueOf(String.valueOf(corpusSurahWord.get(0).getWordno())));
        holder.referenceView.setText(worddetailsmap.get(wordposition).get("surahid") + ":" + worddetailsmap.get(wordposition).get("ayahid") + ":" + worddetailsmap.get(wordposition).get("wordno"));
        int sarfsagheerlen = 0;
        int length = 0;
        Object[] toArray = new Object[0];
        Object[] mazeedArray = new Object[0];
        holder.quranverseShart.setEllipsize(TruncateAt.MARQUEE);
        holder.spannableverse.setEllipsize(TruncateAt.MARQUEE);
        if (null != spannalbeShart) {
            Object[] spans = spannalbeShart.getSpans(0, spannalbeShart.length(), Object.class);
            if (spans.length > 0) {
                holder.quranverseShart.setText(spannalbeShart);
                holder.quranverseShart.setTypeface(appliedFont);
            }
        }
        if (null != spannableHarf) {
            Object[] spans = spannableHarf.getSpans(0, spannableHarf.length(), Object.class);
            if (spans.length > 0) {
                holder.spannableverse.setText(spannableHarf);
                holder.spannableverse.setTypeface(appliedFont);
            }
        }
        if (null != spannable) {
            Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
            if (spans.length > 0) {
                holder.spannableverse.setText(spannable, TextView.BufferType.SPANNABLE);
                //   holder.spannableverse.setText(spannable);
                holder.spannableverse.setTypeface(appliedFont);
            }
        }

    }

    @Override
    public int getItemCount() {
        return worddetailsmap.size();
    }

    public void setRootWordsAndMeanings(ArrayList<NewCorpusExpandWbwPOJO> sencorpusSurahWord, SpannableStringBuilder spannableShart, SpannableStringBuilder spannableHarf, SpannableStringBuilder spannable, HashMap<Integer, HashMap<String, SpannableStringBuilder>> worddetailsmap, HashMap<Integer, HashMap<String, String>> verbdetailsmap, FragmentActivity activity) {
        this.worddetailsmap = worddetailsmap;
        this.verbdetailsmap = verbdetailsmap;
        this.context = activity;
        this.spannalbeShart = spannableShart;
        this.spannableHarf = spannableHarf;
        this.corpusexpand = sencorpusSurahWord;
        this.spannable = spannable;

    }

    @Override
    public long getItemId(int position) {
        SpannableStringBuilder wordno1 = worddetailsmap.get(position).get("wordno");
        HashMap<String, SpannableStringBuilder> map = worddetailsmap.get(position);
        SpannableStringBuilder wordno = map.get("wordno");
        //   return SpannableStringBuilder;
        return Integer.parseInt(String.valueOf(wordno1));

    }

    public class ItemViewAdapter extends RecyclerView.ViewHolder
            implements View.OnClickListener // current clickListerner
    {
        public final TextView amr, nahiamr, ismfail, mumaroof, mamaroof, ismala,
                ismmafool, mumajhool, mamajhool, ismzarf;
        //ISMFAEL
        public final TextView isone, istwo, isthree, isfour, isfive, issix, isseven, iseight, isnine;
        public final TextView ismfemone, ismfemtwo, ismfemthree, ismfemfour, ismfemfive, ismfemsix, ismfemseven, ismfemeight, ismfemnine;
        public final TextView imafone, imaftwo, imafthree, imaffour, imaffive, imafsix, imafseven,
                imafeight, imafnine;
        public final TextView imafoolfemone, imafoolfemtwo, imafoolfemthree, imafoolfemfour, imafoolfemfive, imafoolfemsix, imafoolfemseven,
                imafoolfemeight, imafoolfemnine;
        public final TextView mifalone, mifaltwo, mifalthree, mifalfour, mifalfive, mifalsix, mifalseven, mifaleight, mifalnine;
        public final TextView mifalatunone, mifalatuntwo, mifalatunthree, mifalatunfour, mifalatunfive, mifalatunsix, mifalatunseven, mifalatuneight, mifalatunnine;
        public final TextView mifaalone, mifaaltwo, mifaalthree, mifaalfour, mifaalfive, mifaalsix, mifaalseven,
                mifaaleight, mifaalnine;
        public final TextView mafalunone, mafaluntwo, mafalunthree, mafalunfour, mafalunfive, mafalunsix, mafalunseven,
                mafaluneight, mafalunnine;
        public final TextView sin1, dual1, plu1, sin2, dual2, plu2, sin3, dual3, plu3;
        public final TextView sin4, dual4, plu4;
        public final TextView nom, acc, gen;
        public final TextView nom1, acc1, gen1;
        public final TextView nom2, acc2, gen2;
        public final TextView nom3, acc3, gen3;
        final TextView referenceView;
        final TextView wdetailstv;
        final TextView lemma;
        final TextView verbdetails;
        final TextView noun;
        final TextView pronoundetails;
        final TextView translationView;
        final TextView rootView, quranverseShart, spannableverse;
        final TextView babname, rootword, wazan, ismzarfheader, ismalaheader, masdaro, masdart, babno, babdetails;
        final TextView weaknessname, weaknesstype;
        final View sheet;
        Chip wordView;
        ImageView dismissview;
        TextView apmas, apfem, ppmas, ppfem, verbconjugationbtn, verbOccurancebtn, wordoccurancebtn;

        public ItemViewAdapter(@NonNull View view) {
            super(view);
            spannableverse = view.findViewById(R.id.spannableverse);
            quranverseShart = view.findViewById(R.id.quranverseShart);
            verbconjugationbtn = view.findViewById(R.id.verbconjugationbtn);
            verbOccurancebtn = view.findViewById(R.id.verboccurance);
            wordoccurancebtn = view.findViewById(R.id.wordoccurance);
            babname = view.findViewById(R.id.babno);
            rootword = view.findViewById(R.id.weaknesstype);
            ismzarfheader = view.findViewById(R.id.ismzarfheader);
            pronoundetails = view.findViewById(R.id.pronoundetails);
            noun = view.findViewById(R.id.noundetails);
            sheet = view.findViewById(R.id.sheet);
            wdetailstv = view.findViewById(R.id.wordDetails);
            lemma = view.findViewById(R.id.lemma);
            verbdetails = view.findViewById(R.id.verbdetails);
            dismissview = view.findViewById(R.id.dismissView);
            referenceView = view.findViewById(R.id.referenceView);
            wordView = view.findViewById(R.id.wordView);
            translationView = view.findViewById(R.id.translationView);
            rootView = view.findViewById(R.id.rootView);
            //   if(!particples) {
            //      dismissview.setOnClickListener(this);
            //  }
            //     view.setOnClickListener(this); // current clickListerner
            ismalaheader = view.findViewById(R.id.ismalaheader);
            ismala = view.findViewById(R.id.ismaalatable);
            wazan = view.findViewById(R.id.wazan);
            ismfail = view.findViewById(R.id.ismfail);
            masdaro = view.findViewById(R.id.masdar);
            mumaroof = view.findViewById(R.id.mumaroof);
            mamaroof = view.findViewById(R.id.mamaroof);
            ismmafool = view.findViewById(R.id.ismmafool);
            masdart = view.findViewById(R.id.masdar2);
            mumajhool = view.findViewById(R.id.mumajhool);
            mamajhool = view.findViewById(R.id.mamajhool);
            amr = view.findViewById(R.id.amr);
            nahiamr = view.findViewById(R.id.nahiamr);
            babno = view.findViewById(R.id.babno);
            ismzarf = view.findViewById(R.id.zarftable);
            babdetails = view.findViewById(R.id.babno);
            weaknesstype = view.findViewById(R.id.weaknesstype);
            weaknessname = view.findViewById(R.id.weknessname);
            ImageView listcollapse;
            spannableverse.setOnClickListener(this);
            //  view.setOnClickListener(this);
            wordView.setOnClickListener(this);
            verbconjugationbtn.setOnClickListener(this);
            wordoccurancebtn.setOnClickListener(this);
            //  verbOccurancebtn.setOnClickListener(this);
            wordoccurancebtn.setOnClickListener(this);
            sin4 = view.findViewById(R.id.singular4);
            dual4 = view.findViewById(R.id.dual4);
            plu4 = view.findViewById(R.id.plural4);
            //    }
            nom = view.findViewById(R.id.nominative);
            acc = view.findViewById(R.id.accusative);
            gen = view.findViewById(R.id.genitive);
            nom1 = view.findViewById(R.id.nominative1);
            acc1 = view.findViewById(R.id.accusative1);
            gen1 = view.findViewById(R.id.genitive1);
            nom2 = view.findViewById(R.id.nominative2);
            acc2 = view.findViewById(R.id.accusative2);
            gen2 = view.findViewById(R.id.genitive2);
            nom3 = view.findViewById(R.id.nominative3);
            acc3 = view.findViewById(R.id.accusative3);
            gen3 = view.findViewById(R.id.genitive3);
            sin1 = view.findViewById(R.id.singular1);
            dual1 = view.findViewById(R.id.dual1);
            plu1 = view.findViewById(R.id.plural1);
            sin2 = view.findViewById(R.id.singular2);
            dual2 = view.findViewById(R.id.dual2);
            plu2 = view.findViewById(R.id.plural2);
            sin3 = view.findViewById(R.id.singular3);
            dual3 = view.findViewById(R.id.dual3);
            plu3 = view.findViewById(R.id.plural3);
            apmas = view.findViewById(R.id.apmas);
            apfem = view.findViewById(R.id.apfem);
            ppmas = view.findViewById(R.id.ppmas);
            ppfem = view.findViewById(R.id.ppfem);
            ismfemone = view.findViewById(R.id.ismfemone);
            if (particples) {
                ismfemone.setText(R.string.faelmazi);
            }
            ismfemtwo = view.findViewById(R.id.ismfemtwo);
            ismfemthree = view.findViewById(R.id.ismfemthree);
            ismfemfour = view.findViewById(R.id.ismfemfour);
            ismfemfive = view.findViewById(R.id.ismfemfive);
            ismfemsix = view.findViewById(R.id.ismfemsix);
            ismfemseven = view.findViewById(R.id.ismfemseven);
            ismfemeight = view.findViewById(R.id.ismfemeight);
            ismfemnine = view.findViewById(R.id.ismfemnine);
            //
            isone = view.findViewById(R.id.isone);
            istwo = view.findViewById(R.id.istwo);
            isthree = view.findViewById(R.id.isthree);
            isfour = view.findViewById(R.id.isfour);
            isfive = view.findViewById(R.id.isfive);
            issix = view.findViewById(R.id.issix);
            isseven = view.findViewById(R.id.isseven);
            iseight = view.findViewById(R.id.iseight);
            isnine = view.findViewById(R.id.isnine);
//ismmafoolmasculine
            imafone = view.findViewById(R.id.imafone);
            imaftwo = view.findViewById(R.id.imaftwo);
            imafthree = view.findViewById(R.id.imafthree);
            imaffour = view.findViewById(R.id.imaffour);
            imaffive = view.findViewById(R.id.imaffive);
            imafsix = view.findViewById(R.id.imafsix);
            imafseven = view.findViewById(R.id.imafseven);
            imafeight = view.findViewById(R.id.imafeight);
            imafnine = view.findViewById(R.id.imafnine);
            //ismmafoolfeb
            imafoolfemone = view.findViewById(R.id.imafoolfemone);
            imafoolfemtwo = view.findViewById(R.id.imafoolfemtwo);
            imafoolfemthree = view.findViewById(R.id.imafoolfemthree);
            imafoolfemfour = view.findViewById(R.id.imafoolfemfour);
            imafoolfemfive = view.findViewById(R.id.imafoolfemfive);
            imafoolfemsix = view.findViewById(R.id.imafoolfemsix);
            imafoolfemseven = view.findViewById(R.id.imafoolfemseven);
            imafoolfemeight = view.findViewById(R.id.imafoolfemeight);
            imafoolfemnine = view.findViewById(R.id.imafoolfemnine);
            mifalone = view.findViewById(R.id.mifalone);
            mifaltwo = view.findViewById(R.id.mifaltwo);
            mifalthree = view.findViewById(R.id.mifalthree);
            mifalfour = view.findViewById(R.id.mifalfour);
            mifalfive = view.findViewById(R.id.mifalfive);
            mifalsix = view.findViewById(R.id.mifalsix);
            mifalseven = view.findViewById(R.id.mifalseven);
            mifaleight = view.findViewById(R.id.mifaleight);
            mifalnine = view.findViewById(R.id.mifalnine);
            mifalatunone = view.findViewById(R.id.mifalatunone);
            mifalatuntwo = view.findViewById(R.id.mifalatuntwo);
            mifalatunthree = view.findViewById(R.id.mifalatunthree);
            mifalatunfour = view.findViewById(R.id.mifalatunfour);
            mifalatunfive = view.findViewById(R.id.mifalatunfive);
            mifalatunsix = view.findViewById(R.id.mifalatunsix);
            mifalatunseven = view.findViewById(R.id.mifalatunseven);
            mifalatuneight = view.findViewById(R.id.mifalatuneight);
            mifalatunnine = view.findViewById(R.id.mifalatunnine);
            mifaalone = view.findViewById(R.id.mifaalone);
            mifaaltwo = view.findViewById(R.id.mifaaltwo);
            mifaalthree = view.findViewById(R.id.mifaalthree);
            mifaalfour = view.findViewById(R.id.mifaalfour);
            mifaalfive = view.findViewById(R.id.mifaalfive);
            mifaalsix = view.findViewById(R.id.mifaalsix);
            mifaalseven = view.findViewById(R.id.mifaalseven);
            mifaaleight = view.findViewById(R.id.mifaaleight);
            mifaalnine = view.findViewById(R.id.mifaalnine);
            mafalunone = view.findViewById(R.id.mafalunone);
            mafaluntwo = view.findViewById(R.id.mafaluntwo);
            mafalunthree = view.findViewById(R.id.mafalunthree);
            mafalunfour = view.findViewById(R.id.mafalunfour);
            mafalunfive = view.findViewById(R.id.mafalunfive);
            mafalunsix = view.findViewById(R.id.mafalunsix);
            mafalunseven = view.findViewById(R.id.mafalunseven);
            mafaluneight = view.findViewById(R.id.mafaluneight);
            mafalunnine = view.findViewById(R.id.mafalunnine);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());

            }
        }
    }
}


