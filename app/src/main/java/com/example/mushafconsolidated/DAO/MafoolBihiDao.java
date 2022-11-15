package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.MafoolBihi;

import java.util.List;

@Dao
public interface MafoolBihiDao {
    @Query("SELECT * FROM mafoolbihi ORDER BY surah,ayah")
    List<MafoolBihi> getall();

    @Query("SELECT * FROM mafoolbihi where surah=:surah ORDER BY surah,ayah,wordno")
    List<MafoolBihi> getBySurah(int surah);

    @Query("SELECT * FROM mafoolbihi where surah=:surah and ayah=:ayah and wordno=:wordno")
    List<MafoolBihi> getMafoolbihi(int surah, int ayah, int wordno);

    @Query(value = "UPDATE mafoolbihi set wordno=:no where id=:id")
    int updateMafoolWord(int no, int id);

    @Query(value = "select * from mafoolbihi a,qurans b where a.surah=b.surah and a.ayah=b.ayah")
    List<MafoolBihi> getMafoolbihiq();

}




