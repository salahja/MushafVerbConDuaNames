package database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Entity(tableName = "dua")
public class DuaDetails {
    @PrimaryKey
    private int   _id ;
    private int  group_id   ;
    @ColumnInfo(defaultValue = "0")
    private int    fav      ;
    private String    ar_dua  ;

    private String   en_translation;
    private String   en_reference   ;

    public DuaDetails(int _id, int group_id, int fav, String ar_dua, String en_translation, String en_reference) {
        this._id = _id;
        this.group_id = group_id;
        this.fav = fav;
        this.ar_dua = ar_dua;
        this.en_translation = en_translation;
        this.en_reference = en_reference;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String getAr_dua() {
        return ar_dua;
    }

    public void setAr_dua(String ar_dua) {
        this.ar_dua = ar_dua;
    }

    public String getEn_translation() {
        return en_translation;
    }

    public void setEn_translation(String en_translation) {
        this.en_translation = en_translation;
    }

    public String getEn_reference() {
        return en_reference;
    }

    public void setEn_reference(String en_reference) {
        this.en_reference = en_reference;
    }
}

