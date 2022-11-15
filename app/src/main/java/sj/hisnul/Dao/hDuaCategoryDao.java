package sj.hisnul.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import sj.hisnul.entity.hcategory;

@Dao
public interface hDuaCategoryDao {
    @Query("SELECT * FROM hcategory ORDER BY id")
    List<hcategory> getcatetory();

}