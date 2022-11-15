package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.VerbCorpus;

import java.util.List;

@Dao
public interface VerbCorpusDao {
    //chapterid, ayanumber, wordno
    @Query("SELECT * FROM verbcorpus where chapterno=:surahid and verseno=:ayaid and wordno=:wordid")
    List<VerbCorpus> getQuranRoot(int surahid, int ayaid, int wordid);

    @Query("SELECT * FROM verbcorpus where chapterno=:surahid and verseno=:ayaid ")
    List<VerbCorpus> getQuranRootaAyah(int surahid, int ayaid);

    @Query("SELECT * FROM verbcorpus where root_a=:root")
    List<VerbCorpus> getQuranRootbyString(String root);

}
