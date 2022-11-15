package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.CorpusEntity;

import java.util.List;

@Dao
public interface CorpusExpandedDao {
    @Query("SELECT * FROM CorpusExpand WHERE surah=:id")
    List<CorpusEntity> getVersesBySurah(int id);

    @Query("SELECT * FROM CorpusExpand WHERE surah=:id and ayah=:ayahid")
    List<CorpusEntity> getVersesBySurahAndAya(int id, int ayahid);
    //select surah,count(ayah) from CorpusExpand where surah=1 group by ayah

    @Query("select * from CorpusExpand where ayah  between :start and :end")
    List<CorpusEntity> getVersesByPart(int start, int end);

    @Query("SELECT * FROM CorpusExpand WHERE surah=:id and ayah=:ayahid and wordno=:wordid")
    List<CorpusEntity> getCorpusWord(int id, int ayahid, int wordid);
    //   SELECT VerseNew.chapter_no, VerseNew.verse_no, Translation.author_name, TranslationData.translation FROM TranslationData INNER JOIN Translation
    //  ON Translation.translation_id = TranslationData.translation_id INNER JOIN VerseNew ON VerseNew.verseID = TranslationData.verse_id    WHERE TranslationData.translation_id ="en_sahih"   and VerseNew.chapter_no= 2

}
