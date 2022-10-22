package database.Dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import database.entity.kov;
import database.entity.verbcorpus;


@Dao
public interface kovDao {


        @Query(value = "SELECT * FROM kov order by id ")
        List<kov> getRules();



}
