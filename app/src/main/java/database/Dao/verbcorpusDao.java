package database.Dao;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.QuranVerbsEntity;
import database.entity.verbcorpus;

@Dao
public interface verbcorpusDao {


    @Query(value = "SELECT * FROM verbcorpus where form !=:id")
    List<verbcorpus> getmazeedform(String id);



}
