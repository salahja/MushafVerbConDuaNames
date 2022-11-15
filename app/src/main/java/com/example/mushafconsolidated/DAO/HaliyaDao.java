package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.HalEnt;

import java.util.List;

@Dao
public interface HaliyaDao {
    @Query("SELECT * FROM jumlahaliy where surah=:surah and ayah=:ayah and status=1")
    List<HalEnt> getHaliya(int surah, int ayah);

    @Query("SELECT * FROM jumlahaliy where surah=:surah and status=1")
    List<HalEnt> getHaliyaSurah(int surah);
}




