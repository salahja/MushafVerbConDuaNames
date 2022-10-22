package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import database.entity.BuckwaterEntitiy;
import database.entity.DuaGroup;

@Dao
public interface DuaGroupDao {


    @Query(value = "SELECT * FROM dua_group")
    List<DuaGroup> getAllDua();

}
