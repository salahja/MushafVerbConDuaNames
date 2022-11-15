package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.NewMudhafEntity;

import java.util.List;

@Dao
public interface NewMudhafDao {
    @Query("SELECT * FROM newmudhaf ORDER BY surah,ayah")
    List<NewMudhafEntity> getMudhafAll();

    @Query("SELECT * FROM newmudhaf where surah=:id ORDER BY surah,ayah")
    List<NewMudhafEntity> getMudhafSurah(int id);

    @Query("SELECT * FROM newmudhaf where surah=:id and ayah=:aid ORDER BY surah,ayah")
    List<NewMudhafEntity> getMudhafSurahAyah(int id, int aid);

    @Query("SELECT * FROM newmudhaf where surah=:id and ayah=:aid and wordfrom=:wordno ORDER BY surah,ayah")
    List<NewMudhafEntity> getMudhafSurahAyahWord(int id, int aid, int wordno);

}




