package com.example.mushafconsolidated.Adapters;

import static android.graphics.Color.CYAN;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;

import com.example.mushafconsolidated.R;
import com.example.utility.QuranGrammarApplication;

import java.util.LinkedHashMap;
import java.util.List;

public class NounVerbOccuranceListAdapter extends BaseExpandableListAdapter {

    private final List<String> expandVerbTitles;
    private final LinkedHashMap<String, List<SpannableString>> expandVerbVerses;
    // private   HashMap<String, List<SpannableStringBuilder>> expandableListDetail;
    private Context context;
    private List<String> expandableListTitle;
    LinkedHashMap<String, List<SpannableString>> expandNounVerses = new LinkedHashMap<>();

    public NounVerbOccuranceListAdapter(Context context, List<String> expandableListTitle,
                                        LinkedHashMap<String, List<SpannableString>> expandNounVerses,

                                        LinkedHashMap<String, List<SpannableString>> expandVerbVerses, List<String> expandVerbTitles) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandNounVerses = expandNounVerses;
        this.expandVerbTitles = expandVerbTitles;
        this.expandVerbVerses = expandVerbVerses;
    }


    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandNounVerses.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);


    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }


    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        //  SpannableString expandedListText = (SpannableString) getChild(listPosition, expandedListPosition);

        Object child = getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_grammar_item, null);
        }
        Typeface mequran = Typeface.createFromAsset(QuranGrammarApplication.getContext().getAssets(), "Taha.ttf");
        //  Typeface mequran = Typeface.createFromAsset(DarkThemeApplication.getContext().getAssets(), quranfont);
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        TextView expandedListTextViewlane = (TextView) convertView
                .findViewById(R.id.expandedListItemverb);
        boolean contains = false;
        if(contains) {
            //setTextDirection(View.TEXT_DIRECTION_ANY_RTL)
            expandedListTextView.setTextDirection(View.TEXT_DIRECTION_LTR);
            //  CharSequence start = " Arabic to English" + child;
            //   expandedListTextView.setText((CharSequence) child);
            expandedListTextView.setText(HtmlCompat.fromHtml(String.valueOf(child),0));
        }else {
            expandedListTextView.setText(HtmlCompat.fromHtml(String.valueOf(child),0));

            //  expandedListTextView.setText((CharSequence) child);
        }


      expandedListTextView.setText(HtmlCompat.fromHtml(String.valueOf(child), 0));
        expandedListTextView.setTypeface(mequran);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandNounVerses.get(this.expandableListTitle.get(listPosition))
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
        listTitleTextView.setTypeface(null, Typeface.BOLD);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(QuranGrammarApplication.getContext());
        String preferences = prefs.getString("theme", "dark");
        if (preferences.equals("dark") || preferences.equals("blue")) {
            listTitleTextView.setTextColor(CYAN);
        } else {
            listTitleTextView.setTextColor(ContextCompat.getColor(QuranGrammarApplication.getContext(), R.color.burntamber));

        }

        listTitleTextView.setTextSize(18);
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