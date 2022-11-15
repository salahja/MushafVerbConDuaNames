package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.lanelexicon;

import java.util.List;

@Dao
public interface LaneDao {
    @Query("SELECT * FROM laneslexicon where rootword=:root")
    List<lanelexicon> getLanesDefinition(String root);

}




