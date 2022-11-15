package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.ChaptersAnaEntity;

import java.util.List;

@Dao
public interface AnaQuranChapterDao {
    @Query("SELECT * FROM chaptersana ORDER BY chapterid")
    List<ChaptersAnaEntity> getChapters();

    @Query("SELECT * FROM chaptersana where chapterid=:id")
    List<ChaptersAnaEntity> getSingleChapters(int id);

}




