package database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mazeed")
public class Mazeed {

/*
   root     TEXT    NOT NULL,
    form     TEXT    NOT NULL,
    verbtype TEXT    NOT NULL,
    babname  TEXT    NOT NULL,
    kov      TEXT    NOT NULL,
    kovname  TEXT    NOT NULL,
    id       INTEGER PRIMARY KEY AUTOINCREMENT
                     NOT NULL
);
 */

    @NonNull  public String root;
    @NonNull  public String form;

    @NonNull  public String verbtype;
    @NonNull
    public String babname;
    @NonNull
    public String kov;
    @NonNull
    public String kovname;
    @PrimaryKey
    @NonNull
    public int id;

    @NonNull
    public String getRoot() {
        return root;
    }

    public void setRoot(@NonNull String root) {
        this.root = root;
    }

    @NonNull
    public String getForm() {
        return form;
    }

    public void setForm(@NonNull String form) {
        this.form = form;
    }

    @NonNull
    public String getVerbtype() {
        return verbtype;
    }

    public void setVerbtype(@NonNull String verbtype) {
        this.verbtype = verbtype;
    }

    @NonNull
    public String getBabname() {
        return babname;
    }

    public void setBabname(@NonNull String babname) {
        this.babname = babname;
    }

    @NonNull
    public String getKov() {
        return kov;
    }

    public void setKov(@NonNull String kov) {
        this.kov = kov;
    }

    @NonNull
    public String getKovname() {
        return kovname;
    }

    public void setKovname(@NonNull String kovname) {
        this.kovname = kovname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mazeed(@NonNull String root, @NonNull String form, @NonNull String verbtype, @NonNull String babname, @NonNull String kov, @NonNull String kovname, int id) {
        this.root = root;
        this.form = form;
        this.verbtype = verbtype;
        this.babname = babname;
        this.kov = kov;
        this.kovname = kovname;
        this.id = id;
    }
}
