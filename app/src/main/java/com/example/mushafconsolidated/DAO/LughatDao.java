package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.lughat;

import java.util.List;

@Dao
public interface LughatDao {
    @Query("SELECT * FROM onlylugat ORDER BY surah,ayah")
    List<lughat> getall();

    @Query("SELECT * FROM onlylugat where rootword=:root")
    List<lughat> getRootWordDictionary(String root);

    @Query("SELECT * FROM onlylugat where arabicword=:root")
    List<lughat> getArabicWord(String root);

}




