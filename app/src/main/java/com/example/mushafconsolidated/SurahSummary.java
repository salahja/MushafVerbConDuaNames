package com.example.mushafconsolidated;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.mushafconsolidated.Entities.QuranEntity;
import com.example.mushafconsolidated.Entities.surahsummary;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     FontQuranListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class SurahSummary extends BottomSheetDialogFragment {
    public static final String TAG = "SURAH";
    // TODO: Customize parameter argument names
    private static final String ARG_OPTIONS_DATA = "item_count";
    OnItemClickListener mItemClickListener;
    // private ColorSchemeAdapter colorSchemeAdapter;
    TextView textView;

    // TODO: Customize parameters
    public static SurahSummary newInstance(int data) {
        final SurahSummary fragment = new SurahSummary();
        final Bundle args = new Bundle();
        args.putInt(ARG_OPTIONS_DATA, data);
        fragment.setArguments(args);
        return fragment;

    }

    @NonNull
    private static StringBuilder getVersesDetails(int item_count, ArrayList<surahsummary> surahSummary) {
        String versesrange = surahSummary.get(0).getVersesrange();
        List<QuranEntity> wbwentities = new ArrayList<>();
        StringBuilder header = new StringBuilder();
        ArrayList<List<QuranEntity>> wb = new ArrayList<>();
        String[] split = versesrange.split(",");
        for (String s : split) {
            String[] split1 = s.split("-");
            int s1 = Integer.parseInt(split1[0].trim());
            int from = Integer.parseInt(split1[0].trim());
            int s2 = Integer.parseInt(split1[1].trim());
            for (; s1 <= s2; s1++) {
                wbwentities = Utils.getsurahayahVerses(item_count, s1);
                header = new StringBuilder();
                header.append("From Verse").append(":").append(from).append(" to ").append(s2).append(",").append(from).append("-").append(s2);
                wbwentities.get(0).setErabspnabble(SpannableStringBuilder.valueOf(header));
                wb.add(wbwentities);

            }

        }
        StringBuilder ayah = new StringBuilder();
        ayah.append("<div class='ayah' >");
        for (List<QuranEntity> list : wb) {
            String str = String.valueOf(list.get(0).getErabspnabble());
            String[] split1 = str.split(",");
            String[] surahaya;
            int from = 0, to = 0;
            try {
                surahaya = split1[1].split("-");
                from = Integer.parseInt(surahaya[0]);
                to = Integer.parseInt(surahaya[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int vno = list.get(0).getAyah();
            NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("AR"));
            String s = "\uFD3E" + nf.format(vno) + "\uFD3F";
            if (list.get(0).getAyah() == from) {
                ayah.append("<h3>").append(split1[0]).append("</h3>");
            }
            ayah.append(s.concat(list.get(0).getQurantext().concat("<br>").concat(list.get(0).getTranslation().concat("<br>"))));
            if (list.get(0).getAyah() == to) {
                ayah.append("<hr>");
            }

        }
        ayah.append("</div>");
        return ayah;
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
        WebView webView = (WebView) view.findViewById(R.id.title);
        //  WebSettingsCompat.setForceDark(webView.settings, FORCE_DARK_ON);
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(webView.getSettings(),
                    WebSettingsCompat.FORCE_DARK_ON);
        }
        String html = "<html>\n" +
                "<head>\n" +
                "<style type=\"text/css\">\n" +
                "@font-face {\n" +
                "    font-family: IndoPak,arial;\n" +
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
                "  font-size: 20px;\n" +
                "}\n" +
                "h1,h2,h2 { \n" +
                "\n" +
                "  text-align: center;\n" +
                "  font-size: 25px;\n" +
                "}\n" +
                "\n" +
                ".ayah{color:#330000;" +
                "font-size:25px;" +
                "font-family:IndoPak,arial;}" +
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
        assert bundle != null;
        int item_count = bundle.getInt("item_count");
        Utils utils = new Utils(getActivity());
        ArrayList<surahsummary> surahSummary = utils.getSurahSummary(item_count);
        //   StringBuilder ayah = getVersesDetails(item_count, surahSummary);
        String sum = surahSummary.get(0).getSummary();
        sum = sum.replaceAll("God", "Allah(SWT)");
        String odiv = "<div>";
        String cdiv = "</div>";
        sum = sum.replaceAll("\\.", "<br>");
        odiv = odiv.concat(sum).concat(cdiv);
        //   String concat = html.concat(odiv).concat(ayah.toString()).concat(close);
        String concat = html.concat(odiv).concat(close);
        webView.loadDataWithBaseURL(null, concat, "text/html", "utf-8", null);
        return view;

    }

}