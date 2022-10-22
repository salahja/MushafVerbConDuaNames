package database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Entity(tableName = "dua_group")
public class DuaGroup {

    private String ar_title;
    private String en_title;
    private String fr_title;
@PrimaryKey
@NonNull
   private int _id;

    public DuaGroup(String ar_title, String en_title, String fr_title, int _id) {
        this.ar_title = ar_title;
        this.en_title = en_title;
        this.fr_title = fr_title;
        this._id = _id;
    }

    public String getAr_title() {
        return ar_title;
    }

    public void setAr_title(String ar_title) {
        this.ar_title = ar_title;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getFr_title() {
        return fr_title;
    }

    public void setFr_title(String fr_title) {
        this.fr_title = fr_title;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}

