package database.Dao;


import androidx.room.Dao;
import androidx.room.Query;

import database.entity.QuranicVerbsEntity;

import java.util.List;

@Dao
public interface QuranicVerbsDao {


    @Query(value = "SELECT * FROM quranicverbs where form=0")
    List<QuranicVerbsEntity> getverbsbyForm();


    @Query(value = "UPDATE quranicverbs set root=:uroot where id=:id")
     int updadateRoots(String uroot,int id);

    @Query(value = "UPDATE quranicverbs set thulathibab=:wazan where id=:id")
    int updadateThulathibab(String wazan,int id);

    @Query(value = "SELECT * from quranicverbs where form!=0")
    List<QuranicVerbsEntity> getverbsMazeed();




    //  @Query("UPDATE orders SET order_price=:price WHERE order_id = :id")
   // void update(Float price, int id);



}
