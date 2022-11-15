package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.NewNasbEntity;

import java.util.List;

@Dao
public interface NewNasbDao {
    @Query("SELECT * FROM newnasb where surah=:id order by surah,ayah ")
    List<NewNasbEntity> getHarfNasbIndices(int id);

    @Query("SELECT * FROM newnasb where surah=:id and ayah=:aid order by surah,ayah ")
    List<NewNasbEntity> getHarfNasbIndicesSurahAyah(int id, int aid);

    @Query("SELECT * FROM newnasb   order by surah,ayah ")
    List<NewNasbEntity> getHarfNasbIndAll();

}
