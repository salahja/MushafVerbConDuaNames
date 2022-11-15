package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.TameezEnt;

import java.util.List;

@Dao
public interface tameezDao {
    @Query("SELECT * FROM tameez ORDER BY surah,ayah")
    List<TameezEnt> getall();

    @Query("SELECT * FROM tameez where surah=:surah Order by surah,ayah")
    List<TameezEnt> getTameezSurah(int surah);

    @Query("SELECT * FROM tameez where surah=:surah and ayah=:ayah and wordno=:wordno")
    List<TameezEnt> getTameezWord(int surah, int ayah, int wordno);

}




