package com.example.mushafconsolidated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mushafconsolidated.Entities.AllahNamesDetails;
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
public class NamesDetail extends BottomSheetDialogFragment {
    public static final String TAG = "SURAH";
    // TODO: Customize parameter argument names
    private static final String ARG_OPTIONS_DATA = "item_count";
    OnItemClickListener mItemClickListener;
    // private ColorSchemeAdapter colorSchemeAdapter;
    TextView textView;
    private ArrayList<AllahNamesDetails> namesDetails;

    // TODO: Customize parameters
    public static NamesDetail newInstance(int data) {
        final NamesDetail fragment = new NamesDetail();
        final Bundle args = new Bundle();
        args.putInt(ARG_OPTIONS_DATA, data);
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
        View view = inflater.inflate(R.layout.namesadapter, container, false);
        Bundle bundle = this.getArguments();
        String html = "<html>\n" +
                "<head>\n" +
                "<style type=\"text/css\">\n" +
                "@font-face {\n" +
                "    font-family: IndoPak;\n" +
                "    src: url(\"file:///android_asset/me_quran.ttf\")\n" +
                "}\n" +
                " body {\n" +
                "\n" +
                "  margin: 5%;\n" +
                "\n" +
                "}\n" +
                "h3   {color: blue;}\n" +
                "\n" +
                "div { \n" +
                "\n" +
                "  text-align: center;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                ".arabic-text{\n" +
                "  font-family: IndoPak, arial;\n" +
                "  \n" +
                "  border: 2px solid black;\n" +
                "  margin: 20px;\n" +
                "  padding: 20px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>";
        String close = "</body>\n" +
                "</html>";
        int item_count = bundle.getInt("item_count");
        Utils utils = new Utils(getActivity());
        namesDetails = utils.getNamesDetails(item_count);
        WebView title = (WebView) view.findViewById(R.id.title);
        String concat = html.concat(namesDetails.get(0).getTitle()).concat(namesDetails.get(0).getSummary().concat(namesDetails.get(0).getDetails().concat(close)));
        title.loadDataWithBaseURL(null, concat, "text/html", "utf-8", null);
        //    title.loadDataWithBaseURL(null,     namesDetails.get(1).getSummary().toString(), "text/html", "utf-8", null);
        return view;
        //   return inflater.inflate(R.layout.quranFontselection, container, false);
    }
    /*

     */

}