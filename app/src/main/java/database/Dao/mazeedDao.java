package database.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import database.entity.Mazeed;
import database.entity.MujarradVerbs;

@Dao
public interface mazeedDao {


    @Query(value = "SELECT * FROM mazeed where root=:root")
    List<Mazeed> getMazeedRoot(String root);

    @Query(value = "SELECT * FROM mazeed order by root")
    List<Mazeed> getMazeedAll();


    @Query(value = "select DISTINCT root,form,babname ,verbtype,kov,kovname,id from mazeed where kov=:kov order by root limit 30")
    List<Mazeed> getMazeedWeakness(String kov);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MujarradVerbs entity);

}
