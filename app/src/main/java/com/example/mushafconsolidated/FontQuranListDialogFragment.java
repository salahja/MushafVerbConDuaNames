package com.example.mushafconsolidated;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     FontQuranListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class FontQuranListDialogFragment extends BottomSheetDialogFragment  {
    public static final String TAG = "opton";
    private int chap_id,verse_id;
    private String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            chap_id = getArguments().getInt("chap_id");
            verse_id = getArguments().getInt("verse_no");
        }
        Utils utils = new Utils(getActivity());
      //  setStyle(DialogFragment.STYLE_NORMAL, R.style.ThemeOverlay_Material3_BottomSheetDialog);
    }



    // TODO: Customize parameter argument names
    private static final String ARG_OPTIONS_DATA = "item_count";
    OnItemClickListener mItemClickListener;
    RadioGroup radioGroup;
    private FontQuranAdapter fontQuranAdapter;
    RelativeLayout frameLayout;
    // TODO: Customize parameters
    public static FontQuranListDialogFragment newInstance(String[] data) {
        final FontQuranListDialogFragment fragment = new FontQuranListDialogFragment();
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
    /*    ContextThemeWrapper contextThemeWrapper= new ContextThemeWrapper(getActivity(),R.style.Theme_DarkBlue);


   return      inflater.cloneInContext(contextThemeWrapper).inflate(R.layout.quran_list_dialog, container, false);*/
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.quran_list_dialog, container, false);
        //  return inflater.inflate(R.layout.quranFontselection, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<String> details = new ArrayList<>();

        fontQuranAdapter = new FontQuranAdapter();
        recyclerView.setAdapter(fontQuranAdapter);
        fontQuranAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

            }
        });

    }

    private class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ImageView ivCopy, ivBookmark, ivShare;
        TextView textView,textView2,textView3;



        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            //  super(inflater.inflate(R.layout.fragment_item_list_dialog_list_dialog_item, parent, false));
            super(inflater.inflate(R.layout.options_bottom, parent, false));
            ivCopy = itemView.findViewById(R.id.imageView);
            ivBookmark = itemView.findViewById(R.id.imageView2);
            ivShare = itemView.findViewById(R.id.imageView3);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

           frameLayout= itemView.findViewById(R.id.bottomSheet);
           itemView.setOnClickListener(this);
            ivCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                    //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();
                    editor.putString("quranFont", "AlQalam.ttf");
                    editor.apply();
                    dismiss();
                }
            });
            ivBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                    //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();
                    editor.putString("quranFont", "me_quran.ttf");
                    editor.apply();
                    dismiss();
                }
            });
            ivShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                    //     SharedPreferences.Editor editor = getActivity().getSharedPreferences("properties", 0).edit();
                    editor.putString("quranFont", "Pdms.ttf");
                    editor.apply();
                    dismiss();
                }
            });

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

    private class FontQuranAdapter extends RecyclerView.Adapter<ViewHolder> {

        private OnItemClickListener mItemClickListener;



        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            SharedPreferences sharedPreferences =
                    androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext());
            Typeface mequran = Typeface.createFromAsset(getContext().getAssets(), "me_quran.ttf");
            Typeface qalam = Typeface.createFromAsset(getContext().getAssets(), "AlQalam.ttf");
            Typeface amiri = Typeface.createFromAsset(getContext().getAssets(), "Pdms.ttf");
            String isNightmode = sharedPreferences.getString("themepref", "dark");
            holder.ivShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.printf("check");
                }
            });
      /*      holder.ivShare.setOnClickListener(convertView -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,
                        holder.duaheader.getText() + "\n\n" +
                                holder.tvDuaArabic.getText() + "\n\n" +
                                holder.tvDuaTranslation.getText() + "\n\n" +
                                holder.tvDuaReference.getText() + "\n\n" +
                                convertView.getResources().getString(R.string.action_share_credit)
                );
                intent.setType("text/plain");
                convertView.getContext().startActivity(
                        Intent.createChooser(
                                intent,
                                convertView.getResources().getString(R.string.action_share_title)
                        )
                );
            });
*/



        }

        @Override
        public int getItemCount() {
            return 1;
        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }
    }

}