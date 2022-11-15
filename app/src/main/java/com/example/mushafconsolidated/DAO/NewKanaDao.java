package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.NewKanaEntity;

import java.util.List;

@Dao
public interface NewKanaDao {
    @Query("SELECT * FROM newkana ORDER BY surah,ayah")
    List<NewKanaEntity> getKanaall();

    @Query("SELECT * FROM newkana where surah=:id ORDER BY surah,ayah")
    List<NewKanaEntity> getkanabysurah(int id);

    @Query("SELECT * FROM newkana where surah=:id and ayah=:aid ORDER BY surah,ayah")
    List<NewKanaEntity> getkanabysurahAyah(int id, int aid);

}




