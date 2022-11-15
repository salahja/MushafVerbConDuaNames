package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.example.mushafconsolidated.Entities.CorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.CorpusNounWbwGrouping;
import com.example.mushafconsolidated.Entities.CorpusNounWbwOccurance;
import com.example.mushafconsolidated.Entities.CorpusVerbWbwOccurance;
import com.example.mushafconsolidated.Entities.KanaPOJO;
import com.example.mushafconsolidated.Entities.MudhafPOJO;
import com.example.mushafconsolidated.Entities.NasbPOJO;
import com.example.mushafconsolidated.Entities.NewCorpusExpandWbwPOJO;
import com.example.mushafconsolidated.Entities.NounCorpusBreakup;
import com.example.mushafconsolidated.Entities.ShartPOJO;
import com.example.mushafconsolidated.Entities.SifaEntityPojo;
import com.example.mushafconsolidated.Entities.SifaPOJO;
import com.example.mushafconsolidated.Entities.TameezPOJO;
import com.example.mushafconsolidated.Entities.TameezPojoList;
import com.example.mushafconsolidated.Entities.VerbCorpusBreakup;

import java.util.List;

import sj.hisnul.entity.hduanames;
//import com.example.mushafconsolidated.Entities.JoinVersesTranslationDataTranslation;

@Dao
public interface RawDao {
    @RawQuery
    List<CorpusNounWbwOccurance> getnounoccurance(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusNounWbwOccurance> getnounoccurancebysurahayah(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusNounWbwGrouping> getNounGroups(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusExpandWbwPOJO> getCorpusWbw(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusExpandWbwPOJO> getCorpusWbwSurahAyah(SupportSQLiteQuery query);

    @RawQuery
    List<SifaEntityPojo> getSifaIndexes(SupportSQLiteQuery query);

    @RawQuery
    List<SifaPOJO> getMousufSifa(SupportSQLiteQuery query);

    @RawQuery
    List<ShartPOJO> getShart(SupportSQLiteQuery query);

    @RawQuery
    List<TameezPojoList> getTameez(SupportSQLiteQuery query);

    @RawQuery
    List<MudhafPOJO> getMudhaf(SupportSQLiteQuery query);

    @RawQuery
    List<NewCorpusExpandWbwPOJO> getNewCorpusWbw(SupportSQLiteQuery query);

    @RawQuery
    List<KanaPOJO> getKana(SupportSQLiteQuery query);

    @RawQuery
    List<NasbPOJO> getNasb(SupportSQLiteQuery query);

    @RawQuery
    List<NounCorpusBreakup> getNounBreakup(SupportSQLiteQuery query);

    @RawQuery
    List<VerbCorpusBreakup> getVerbBreakup(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusVerbWbwOccurance> getVerbOccuranceBreakVerses(SupportSQLiteQuery query);

    @RawQuery
    List<TameezPOJO> gettameezversescount(SupportSQLiteQuery query);

    @RawQuery
    List<CorpusExpandWbwPOJO> getCorpusWbwfortameez(SupportSQLiteQuery query);

    @RawQuery
    List<hduanames> getDuaCATNAMES(SupportSQLiteQuery query);

}
