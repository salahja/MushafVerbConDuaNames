package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.MafoolMutlaqEnt;

import java.util.List;

@Dao
public interface MafoolMutlaqEntDao {
    @Query("SELECT * FROM mutlaqword ORDER BY surah,ayah")
    List<MafoolMutlaqEnt> getall();

    @Query("SELECT * FROM mutlaqword where surah=:surah and ayah=:ayah and wordno=:wordno")
    List<MafoolMutlaqEnt> getMafoolbihiword(int surah, int ayah, int wordno);

    @Query("SELECT * FROM mutlaqword where surah=:surah ")
    List<MafoolMutlaqEnt> getMutlaqsurah(int surah);

}




