package database.Dao;

import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import database.entity.verbcorpus;

@Dao
public interface RawDao {



        @RawQuery
        List<verbcorpus> getforms(SupportSQLiteQuery query);

}
