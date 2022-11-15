package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.QuranEntity;

import java.util.List;

@Dao
public interface QuranDao {
    @Query("SELECT * FROM qurans where surah=:surahid")
    List<QuranEntity> getQuranVersesBySurah(int surahid);

    @Query("SELECT * FROM qurans where surah=:surahid")
    List<QuranEntity> getTranslation(int surahid);

    @Query("SELECT * FROM qurans order by surah,ayah")
    List<QuranEntity> getAllQuran();

    @Query("SELECT * FROM qurans where surah=:surahid and ayah=:ayahid")
    List<QuranEntity> getsurahayahVerses(int surahid, int ayahid);

    @Query("select * from qurans where docid  between :start and :end")
    List<QuranEntity> getVersesByPart(int start, int end);

}
