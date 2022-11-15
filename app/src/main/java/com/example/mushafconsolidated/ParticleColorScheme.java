package com.example.mushafconsolidated;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.CorpusUtilityorig;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     FontQuranListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ParticleColorScheme extends BottomSheetDialogFragment {
    // TODO: Customize parameter argument names
    private static final String ARG_OPTIONS_DATA = "item_count";
    OnItemClickListener mItemClickListener;
    TextView textView;
    private ColorSchemeAdapter colorSchemeAdapter;

    // TODO: Customize parameters
    public static ParticleColorScheme newInstance(String[] data) {
        final ParticleColorScheme fragment = new ParticleColorScheme();
        final Bundle args = new Bundle();
        args.putStringArray(ARG_OPTIONS_DATA, data);
        fragment.setArguments(args);
        return fragment;

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.colorschemelayout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        // parentRecyclerView = view.findViewById(R.id.juzRecyclerView);
        RecyclerView recyclerView = view.findViewById(R.id.colorrecview);
        recyclerView.setLayoutManager(mLayoutManager);
        Map<String, ForegroundColorSpan> spanhash;
        spanhash = CorpusUtilityorig.getStringForegroundColorSpanMap();
        textView = view.findViewById(R.id.Colortv);
        ArrayList<String> particle = new ArrayList();
        particle.add("PN = \"Proper Noun(اسم علم)\",");
        particle.add("ADJ = \"Adjective(صفة)");
        particle.add("V =Verb(فعل)");
        particle.add("N =Noun");
        particle.add(" PRON = Pronouns(ضمير)");
        particle.add("DEM = Demonstrative Pronoun(اسم اشارة)");
        particle.add(" REL =  Relative Pronoun(اسم موصول)");
        particle.add("T =  Time Adverb(ظرف زمان)");
        particle.add("  LOC =  Location Adverb(ظرف مكان)");
        particle.add("DET  determiner()");
        particle.add("EMPH  Emphatic lām prefix(لام التوكيد) ");
        particle.add("IMPV  Imperative lāmprefix(لام الامر)");
        particle.add("PRP  Purpose lāmprefix(لام التعليل)");
        particle.add("CONJ  Coordinating conjunction(حرف عطف)");
        particle.add("SUB  	Subordinating conjunction(حرف مصدري)");
        particle.add("ACC  	Accusative particle(حرف نصب)");
        particle.add("AMD  	Amendment particle(حرف استدراك)	");
        particle.add("ANS  	Answer particle	(حرف جواب)");
        particle.add("AVR  	Aversion particle	(حرف ردع)");
        particle.add("CAUS  Particle of cause	(حرف سببية)");
        particle.add("CERT  Particle of certainty	(حرف تحقيق)");
        particle.add("CIRC  Circumstantial particle	(حرف حال)");
        particle.add("COM  	Comitative particle	(واو المعية)");
        particle.add("COND  Conditional particle(حرف شرط)");
        particle.add("EQ  	Equalization particle(حرف تسوية)");
        particle.add("EXH  	Exhortation particle(حرف تحضيض)");
        particle.add("EXL  	Explanation particle(حرف تفصيل)");
        particle.add("EXP  	Exceptive particle	(أداة استثناء)");
        particle.add("FUT  	Future particle	(حرف استقبال)");
        particle.add("INC  	Inceptive particle	(حرف ابتداء)");
        particle.add("INT  	Particle of interpretation(حرف تفسير)");
        particle.add("INTG  Interogative particle	(حرف استفهام)");
        particle.add("NEG  	Negative particle(حرف نفي)");
        particle.add("PREV  Preventive particle	(حرف كاف)");
        particle.add("PRO  	Prohibition particle(حرف نهي)");
        particle.add("REM  	Resumption particle	(حرف استئنافية)");
        particle.add("RES  	Restriction particle(أداة حصر)");
        particle.add("RET  	Retraction particle	(حرف اضراب)");
        particle.add("RSLT  Result particle(حرف واقع في جواب الشرط)");
        particle.add("SUP  	Supplemental particle	(حرف زائد)");
        particle.add("SUR  	Surprise particle	(حرف فجاءة)");
        particle.add("VOC  	Vocative particle	(حرف نداء)");
        particle.add("INL  	Quranic initials(	(حروف مقطعة	");
        ArrayList<String> details = new ArrayList<>();
        String sample = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ";
        colorSchemeAdapter = new ColorSchemeAdapter(spanhash, particle);
        recyclerView.setAdapter(colorSchemeAdapter);
        colorSchemeAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //      int checkedRadioButtonId = textView.getCheckedRadioButtonId();
                //Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        final TextView text;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            //  super(inflater.inflate(R.layout.fragment_item_list_dialog_list_dialog_item, parent, false));
            super(inflater.inflate(R.layout.coloradapter, parent, false));
            text = itemView.findViewById(R.id.Colortv);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

    private class ColorSchemeAdapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<String> particle;
        private String mItemCount;
        private Map<String, ForegroundColorSpan> spanhash;
        private OnItemClickListener mItemClickListener;

        ColorSchemeAdapter(String itemCount) {
            mItemCount = itemCount;
        }

        public ColorSchemeAdapter(Map<String, ForegroundColorSpan> spanhash, ArrayList<String> particle) {
            this.spanhash = spanhash;
            this.particle = particle;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String sample = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ";
            Typeface mequran = Typeface.createFromAsset(getContext().getAssets(), "me_quran.ttf");
            Typeface qalam = Typeface.createFromAsset(getContext().getAssets(), "AlQalam.ttf");
            Typeface amiri = Typeface.createFromAsset(getContext().getAssets(), "Pdms.ttf");
            String s = particle.get(position);
            String[] split = s.split("\\s");
            ForegroundColorSpan foregroundColorSpan = spanhash.get(split[0]);
            SpannableString sp = new SpannableString(s);
            sp.setSpan(foregroundColorSpan, 0, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.text.setText(sp);
            holder.text.setTextSize(20);

        }

        @Override
        public int getItemCount() {
            return particle.size();
        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }
    }

}