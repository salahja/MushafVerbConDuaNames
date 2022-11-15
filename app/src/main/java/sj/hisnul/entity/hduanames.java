package sj.hisnul.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "hduanames")
public class hduanames {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int dua_global_id;
    @NonNull
    private int book_id;
    @NonNull
    private int chap_id;
    private String dua_id;
    private String chapname;
    @NonNull
    private String duaname;
    private String tags;
    @NonNull
    private String ID;
    @NonNull
    private String category;
    @NonNull
    private int fav;

    public hduanames(int dua_global_id, int book_id, int chap_id, String dua_id, String chapname, @NonNull String duaname, String tags, @NonNull String ID, @NonNull String category, int fav) {
        this.dua_global_id = dua_global_id;
        this.book_id = book_id;
        this.chap_id = chap_id;
        this.dua_id = dua_id;
        this.chapname = chapname;
        this.duaname = duaname;
        this.tags = tags;
        this.ID = ID;
        this.category = category;
        this.fav = fav;
    }

    public int getDua_global_id() {
        return dua_global_id;
    }

    public void setDua_global_id(int dua_global_id) {
        this.dua_global_id = dua_global_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getChap_id() {
        return chap_id;
    }

    public void setChap_id(int chap_id) {
        this.chap_id = chap_id;
    }

    public String getDua_id() {
        return dua_id;
    }

    public void setDua_id(String dua_id) {
        this.dua_id = dua_id;
    }

    public String getChapname() {
        return chapname;
    }

    public void setChapname(String chapname) {
        this.chapname = chapname;
    }

    @NonNull
    public String getDuaname() {
        return duaname;
    }

    public void setDuaname(@NonNull String duaname) {
        this.duaname = duaname;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @NonNull
    public String getID() {
        return ID;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }
}