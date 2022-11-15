package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.SifaEntity;

import java.util.List;

@Dao
public interface SifaDao {
    @Query("SELECT * FROM sifa order by surah,ayah,wordno ")
    List<SifaEntity> getSifaindexesAll();

    @Query("SELECT * FROM sifa where surah=:id order by surah,ayah,wordno ")
    List<SifaEntity> getSifaindexesBySurah(int id);

    @Query("SELECT * FROM sifa where surah=:id and ayah=:ayd order by surah,ayah,wordno ")
    List<SifaEntity> getSifaindexesBySurahAyah(int id, int ayd);

}
