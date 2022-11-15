package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;

import com.example.mushafconsolidated.Entities.NounCorpus;

import java.util.List;

@Dao
public interface NounCorpusDao {
    @RewriteQueriesToDropUnusedColumns
//chapterid, ayanumber, wordno
    @Query("SELECT * FROM nouncorpus where surah=:surahid and ayah=:ayaid and wordno=:wordid order by surah,ayah,wordno")
    List<NounCorpus> getQuranNouns(int surahid, int ayaid, int wordid);

    @Query("SELECT * FROM nouncorpus where surah=:surahid and ayah=:ayaid  order by surah,ayah,wordno")
    List<NounCorpus> getQuranNounAyah(int surahid, int ayaid);

    @Query("SELECT * FROM nouncorpus  ")
    List<NounCorpus> getAllnouns();
    //   @Query("SELECT count(root_a), lemma_a,form,araword,tag,propone,proptwo FROM nouncorpus where root_a=:verbroot group by lemma_a,root_a,tag,propone,proptwo")
    //   List<NounCorpus> getNounBreakUp(String verbroot);
    //  select  count(root_a),root_a,lemma_a ,form ,araword,tag from nouncorpus where
    // root_a="كلم" group by lemma_a,root_a,tag,propone,proptwo

}
