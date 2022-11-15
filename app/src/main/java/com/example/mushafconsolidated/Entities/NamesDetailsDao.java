package com.example.mushafconsolidated.Entities;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NamesDetailsDao {
    @Query(value = "SELECT * FROM namedetails where id=:id")
    List<AllahNamesDetails> ALLAH_NAMES_DETAILS_DETAILS(int id);

}
