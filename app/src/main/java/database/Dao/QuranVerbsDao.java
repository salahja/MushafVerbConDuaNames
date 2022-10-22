package database.Dao;


import androidx.room.Dao;
import androidx.room.Query;


import database.entity.QuranVerbsEntity;

import java.util.List;

@Dao
public interface QuranVerbsDao {


    @Query(value = "SELECT * FROM quranverbs order by CASE when :isASC=1 THEN form END ASC,CASE when :isASC=0 THEN frequency END DESC ")
    List<QuranVerbsEntity> getverbsbyForm(int isASC);

    @Query(value = "SELECT * FROM quranverbs order by CASE when :isASC=1 THEN form END ASC,CASE when :isASC=0 THEN frequency END DESC ")
    List<QuranVerbsEntity> getverbsbyFrequency(int isASC);


}
