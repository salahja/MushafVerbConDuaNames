package sj.hisnul.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//primaryKeys ={"translation_id","verse_id"}

@Entity(tableName = "hcategory")
public class hcategory {
    @NonNull
    private String title;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public hcategory(@NonNull String title, int id) {
        this.title = title;
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}