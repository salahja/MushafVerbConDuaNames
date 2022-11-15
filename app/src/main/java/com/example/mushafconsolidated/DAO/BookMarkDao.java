package com.example.mushafconsolidated.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mushafconsolidated.Entities.BookMarks;

import java.util.List;

@Dao
public interface BookMarkDao {
    @Query("SELECT * FROM bookmark ORDER BY datetime")
    List<BookMarks> getBookMarks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBookmark(BookMarks entity);

    @Delete
    void deletebookmark(BookMarks bookMarks);

    @Query("Delete from bookmark")
    void deleteAllBookMakrs();
}
