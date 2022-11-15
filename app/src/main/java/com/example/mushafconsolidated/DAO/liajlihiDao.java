package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.LiajlihiEnt;

import java.util.List;

@Dao
public interface liajlihiDao {
    @Query("SELECT * FROM liajlihi ORDER BY surah,ayah")
    List<LiajlihiEnt> getall();

    @Query("SELECT * FROM liajlihi where surah=:surah and ayah=:ayah and wordno=:wordno")
    List<LiajlihiEnt> getMafoolLiajlihi(int surah, int ayah, int wordno);

    @Query("SELECT * FROM liajlihi where surah=:surah ORDER by surah,ayah")
    List<LiajlihiEnt> getMafoolLiajlihisurah(int surah);

}




