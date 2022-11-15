package sj.hisnul.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import sj.hisnul.entity.hduanames;

@Dao
public interface hDuaNamesDao {
    @Query("select  * from hduanames where chap_id=:cid")
    List<hduanames> getdualistbychapter(int cid);

    @Query("select ROWID,* from hduanames group by chap_id")
    List<hduanames> getDuanames();

    @Query("SELECT * FROM hduanames where category=:id ORDER BY category")
    List<hduanames> getDuanamesid(String id);

    @Query("SELECT * FROM hduanames where category LIKE '%' || :search || '%'")
    List<hduanames> getDunamesbyCatId(String search);

    /*
    WHERE (category == 'search' OR
           category LIKE '%,search' OR
           category LIKE 'search,%' OR
           category LIKE '%,search,%');
     */
    @Query("SELECT * FROM hduanames where category =:search ||" +
            " category LIKE '%,'||:search ||" +
            " category like :search || ',%'")
    List<hduanames> getDunamesbyCatIdnew(String search);

    @Query("SELECT * FROM hduanames where ID=:id ORDER BY category")
    List<hduanames> getDuanamesByID(String id);

    @Query("SELECT * FROM hduanames where fav=:id ORDER BY fav")
    List<hduanames> getFavdua(int id);

    @Query("SELECT * FROM hduanames where fav=:id ORDER BY fav")
    List<hduanames> getBookmarked(int id);

    @Query("SELECT * FROM hduanames where ID=:id ORDER BY fav")
    List<hduanames> isBookmarked(String id);

    @Query(value = "UPDATE hduanames set fav=:fav where chap_id=:id")
    int updateFav(int fav, int id);

}