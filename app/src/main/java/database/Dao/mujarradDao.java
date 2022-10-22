package database.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import database.entity.MujarradVerbs;

@Dao
public interface mujarradDao {


    @Query(value = "SELECT * FROM mujarrad where root=:root")
    List<MujarradVerbs> getverbTri(String root);

    @Query(value = "SELECT * FROM mujarrad order by root")
    List<MujarradVerbs> getverbTriAll();
    @Query(value = "select DISTINCT root,bab,babname ,verbtype,kov,kovname,id,verb from mujarrad where kov=:kov order by root limit 30")
    List<MujarradVerbs> getMujarradWeakness(String kov);





    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MujarradVerbs entity);

}
