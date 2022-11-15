package com.example.mushafconsolidated.Activity;

import android.os.Bundle;
import android.text.SpannableString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SearchResult extends WordOccuranceAct {
    List<String> expandLexconTitle;
    LinkedHashMap<String, List<SpannableString>> expandlexicon = new LinkedHashMap<>();

    public SearchResult() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executeDictionary();
    }

    void executeDictionary() {
        //  ArrayList<lanelexicon> lanesDifinition = utils.getLanesDifinition(root);
        //  ArrayList<SpannableString> lanesdifinition ;
        List list = new ArrayList();
        StringBuilder lanessb = new StringBuilder();
        //  for (lanelexicon lanes : lanesDifinition) {
        //  <p style="margin-left:200px; margin-right:50px;">
        //    list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
        //  list.add("<p style=\"margin-left:200px; margin-right:50px;\">");
        //  list.add(lanes.getDefinition() );
        list.add("");
        //   }
        expandlexicon.put("lanes Lexicon", list);
        expandlexicon.put("Hans", list);
        List<String> expandLexconTitle;
        expandLexconTitle = new ArrayList<String>(expandlexicon.keySet());
        expandNounTitles = new ArrayList<String>(expandNounVerses.keySet());
        expandVerbTitles = new ArrayList<String>(expandVerbVerses.keySet());
        expandNounVerses.putAll(expandlexicon);
        expandNounVerses.putAll(expandVerbVerses);
        expandNounTitles.addAll((expandLexconTitle));
        expandNounTitles.addAll(expandVerbTitles);

    }

}




