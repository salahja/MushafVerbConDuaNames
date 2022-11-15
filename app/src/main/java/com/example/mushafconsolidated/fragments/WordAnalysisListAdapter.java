package com.example.mushafconsolidated.fragments;

import static android.graphics.Color.CYAN;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class WordAnalysisListAdapter extends BaseExpandableListAdapter {
    private final HashMap<String, List<String>> expandableListDetail;
    private final Context context;
    private final List<String> expandableListTitle;

    public WordAnalysisListAdapter(Context context, List<String> expandableListTitle,
                                   LinkedHashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        String expandedListText = (String) getChild(listPosition, expandedListPosition);
        // final SpannableStringBuilder expandedListText = (SpannableStringBuilder) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.word_analysis_item, null);
        }
        Typeface mequran = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), "Roboto.ttf");
        WebView expandedListTextView = (WebView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.loadDataWithBaseURL(null, expandedListText, "text/html", "utf-8", null);
        // holder. wordDictionary.loadDataWithBaseURL(null, data.toString(), "text/html", "utf-8", null);
        //  expandedListTextView.setText(expandedListText);
        //    expandedListTextView.setTypeface(mequran);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String preferences = prefs.getString("theme", "dark");
        if (preferences.equals("dark") || preferences.equals("blue")) {
            listTitleTextView.setTextColor(CYAN);
        } else {
            listTitleTextView.setTextColor(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.burntamber));

        }
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}