package sj.hisnul.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import sj.hisnul.entity.hduadetails;

@Dao
public interface hDuaItemDao {
    @Query("SELECT * FROM hduadetails ORDER BY id")
    List<hduadetails> getDuaItemsALL();

    @Query("SELECT * FROM hduadetails where ID=:aid")
    List<hduadetails> getDitem(String aid);

}