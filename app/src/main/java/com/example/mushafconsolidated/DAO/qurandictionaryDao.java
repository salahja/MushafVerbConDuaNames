package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.qurandictionary;

import java.util.List;

@Dao
public interface qurandictionaryDao {
    @Query("select *  from qurandictionary  group by rootarabic  ")
    List<qurandictionary> getDictionary();

}




