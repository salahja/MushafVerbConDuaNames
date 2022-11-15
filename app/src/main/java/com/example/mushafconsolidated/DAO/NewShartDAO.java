package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.NewShartEntity;

import java.util.List;

@Dao
public interface NewShartDAO {
    @Query("SELECT * FROM newshart ORDER BY surah,ayah")
    List<NewShartEntity> getShartAll();

    @Query("SELECT * FROM newshart where surah=:id")
    List<NewShartEntity> getShartBySurah(int id);

    @Query("SELECT * FROM newshart where surah=:id and ayah=:ayah order by indexstart")
    List<NewShartEntity> getShartBySurahAyah(int id, int ayah);

}




