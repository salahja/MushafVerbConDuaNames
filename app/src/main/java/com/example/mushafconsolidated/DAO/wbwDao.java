package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.wbwentity;

import java.util.List;

@Dao
public interface wbwDao {
    @Query("SELECT * FROM wbw WHERE surah=:id")
    List<wbwentity> getwbwQuran(int id);

    @Query("SELECT * FROM wbw WHERE juz=:chapterno")
    List<wbwentity> getwbwQuranByjuz(int chapterno);

    @Query("SELECT * FROM wbw WHERE surah=:chapterno and ayah=:aya and wordno=:word")
    List<wbwentity> getwbwQuranBySurahAyahWord(int chapterno, int aya, int word);

    @Query("SELECT * FROM wbw WHERE surah=:chapterno and ayah=:aya and wordno>=:fw and wordno<=:lw")
    List<wbwentity> getwbwQuranbTranslation(int chapterno, int aya, int fw, int lw);

    @Query("SELECT * FROM wbw WHERE surah=:id and ayah=:aid ")
    List<wbwentity> getwbwQuranBySurahAyah(int id, int aid);

    @Query("SELECT * FROM wbw where surah=:surahid and ayah=:ayahid and wordno=:wordno")
    List<wbwentity> getwbwTranslationbywordno(int surahid, int ayahid, int wordno);
}
