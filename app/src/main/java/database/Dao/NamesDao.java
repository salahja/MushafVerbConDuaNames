package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.AllahNames;
import database.entity.DuaGroup;

@Dao
public interface NamesDao {


    @Query(value = "SELECT * FROM Names")
    List<AllahNames> ALLAH_NAMES_LIST();

}
