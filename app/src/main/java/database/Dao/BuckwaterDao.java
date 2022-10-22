package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import database.entity.BuckwaterEntitiy;

import java.util.List;

@Dao
public interface BuckwaterDao {


    @Query(value = "SELECT * FROM buckwater")
    List<BuckwaterEntitiy> getArabic();

}
