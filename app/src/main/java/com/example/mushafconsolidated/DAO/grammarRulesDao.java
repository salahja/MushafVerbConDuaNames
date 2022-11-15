package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.GrammarRules;

import java.util.List;

@Dao
public interface grammarRulesDao {
    @Query("select *  from rules   ")
    List<GrammarRules> getGrammarRules();

    @Query("select *  from rules where harf=:harf")
    List<GrammarRules> getGrammarRulesByHarf(String harf);

}

