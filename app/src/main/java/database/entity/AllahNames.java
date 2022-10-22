package database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Names")
public class AllahNames {
    @PrimaryKey
    @NotNull
    private int   id ;

    @NotNull  private String    arabic  ;

    @NotNull  private String   trans;
    @NotNull  private String   meaning   ;

    public AllahNames(int id, @NotNull String arabic, @NotNull String trans, @NotNull String meaning) {
        this.id = id;
        this.arabic = arabic;
        this.trans = trans;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}

