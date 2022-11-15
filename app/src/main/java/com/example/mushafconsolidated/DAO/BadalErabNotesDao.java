package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.BadalErabNotesEnt;

import java.util.List;

@Dao
public interface BadalErabNotesDao {
    @Query("SELECT * FROM BADAL where surah=:surah and ayah=:ayah ORDER by surah,ayah")
    List<BadalErabNotesEnt> getBadalNotesSurahAyah(int surah, int ayah);

    @Query("SELECT * FROM badal where surah=:surah ORDER by surah,ayah")
    List<BadalErabNotesEnt> getBadalNotesSurah(int surah);

}




