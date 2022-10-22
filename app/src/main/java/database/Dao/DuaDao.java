package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.BuckwaterEntitiy;
import database.entity.DuaDetails;

@Dao
public interface DuaDao {


    @Query(value = "select * from dua where group_id=:id")
    List<DuaDetails> getDua(int id);

}
