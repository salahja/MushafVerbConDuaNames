package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.hanslexicon;

import java.util.List;

@Dao
public interface HansDao {
    @Query("SELECT * FROM hansdictionary where rootword=:root")
    List<hanslexicon> getHansDefinition(String root);

}




