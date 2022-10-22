package com.example.mushafconsolidated;

import static androidx.webkit.WebSettingsCompat.DARK_STRATEGY_USER_AGENT_DARKENING_ONLY;
import static androidx.webkit.WebSettingsCompat.FORCE_DARK_AUTO;
import static androidx.webkit.WebSettingsCompat.FORCE_DARK_ON;

import static com.example.Constant.QURAN_VERB_WAZAN;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.mushafconsolidated.Entities.GrammarRules;
import com.example.mushafconsolidated.intrface.OnItemClickListener;
import com.example.utility.QuranGrammarApplication;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     FontQuranListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class VerbFormsDialogFrag extends BottomSheetDialogFragment {
    //   public class VerbFormsDialogFrag extends Fragment {

    private static final String ARG_OPTIONS_DATA = "item_count";


    private String form;


    public static VerbFormsDialogFrag newInstance(String[] data) {
        final VerbFormsDialogFrag fragment = new VerbFormsDialogFrag();
        final Bundle args = new Bundle();
        args.putStringArray(ARG_OPTIONS_DATA, data);
        fragment.setArguments(args);
        return fragment;

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //  return inflater.inflate(R.layout.verb_forms, container, false);
        View view = inflater.inflate(R.layout.webview, container, false);
        Bundle bundle = this.getArguments();
        String[] stringArray = bundle.getStringArray(ARG_OPTIONS_DATA);
        form = (stringArray[0]);
        WebView wv = (WebView) view.findViewById(R.id.webview);

        Utils utils = new Utils(QuranGrammarApplication.getContext());
        String formstr = "Form";
        formstr = formstr.concat(" ").concat(form);
        ArrayList<GrammarRules> list = utils.getGrammarRulesByRules(formstr);
        if(!list.isEmpty()) {
            wv.loadDataWithBaseURL(null, list.get(0).getDetailsrules().toString(), "text/html", "utf-8", null);
        }
        return view;
    }


}