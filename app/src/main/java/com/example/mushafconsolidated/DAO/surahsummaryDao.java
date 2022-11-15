package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.surahsummary;

import java.util.List;

@Dao
public interface surahsummaryDao {
    @Query("SELECT * FROM surahsummary where surahid=:id   ORDER BY surahid")
    List<surahsummary> getSurahSummary(int id);

}




