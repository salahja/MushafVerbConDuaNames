package sj.hisnul.Dao;

import androidx.room.Dao;
import androidx.room.Query;



import java.util.List;

import sj.hisnul.entity.hduanames;

@Dao
public interface hDuaNamesDao {
    @Query("SELECT * FROM hduanames ORDER BY id")
    List<hduanames> getDuanames();

    @Query("SELECT * FROM hduanames where category=:id ORDER BY category")
    List<hduanames> getDuanamesid(String id);
    @Query("SELECT * FROM hduanames where ID=:id ORDER BY category")
    List<hduanames> getDuanamesByID(String id);

    @Query("SELECT * FROM hduanames where fav=:id ORDER BY fav")
    List<hduanames> getFavdua(int id);

    @Query("SELECT * FROM hduanames where fav=:id ORDER BY fav")
    List<hduanames> getBookmarked(int id);

    @Query("SELECT * FROM hduanames where ID=:id ORDER BY fav")
    List<hduanames> isBookmarked(String id);




    @Query(value = "UPDATE hduanames set fav=:fav where ID=:id")
    int updateFav(int fav,String id);

}