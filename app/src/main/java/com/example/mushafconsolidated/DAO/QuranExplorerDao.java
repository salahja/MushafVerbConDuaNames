package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.quranexplorer;

import java.util.List;

@Dao
public interface QuranExplorerDao {
    @Query("SELECT * FROM quranexplorer where title LIKE '%' || :search || '%'")
    List<quranexplorer> getFilter(String search);

    @Query("SELECT * FROM quranexplorer order by title")
    List<quranexplorer> getALL();

}




