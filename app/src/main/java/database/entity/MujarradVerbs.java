package database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(tableName = "mujarrad")
public class MujarradVerbs {


    @NonNull
    public String verb;

    @NonNull  public String root;
    @NonNull  public String bab;

    @NonNull  public String verbtype;

    @NonNull  public String babname;
    @NonNull  public String kov;
    @NonNull  public String kovname;
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;


    @Ignore
    public MujarradVerbs(String verb, String root, String babname, String verbtype) {
        this.verb=verb; this.root=root;this.babname=babname;this.verbtype=verbtype;
    }

    @NonNull
    public String getVerb() {
        return verb;
    }

    public void setVerb(@NonNull String verb) {
        this.verb = verb;
    }

    @NonNull
    public String getRoot() {
        return root;
    }

    public void setRoot(@NonNull String root) {
        this.root = root;
    }

    @NonNull
    public String getBab() {
        return bab;
    }

    public void setBab(@NonNull String bab) {
        this.bab = bab;
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

    public MujarradVerbs(@NonNull String verb, @NonNull String root, @NonNull String bab, @NonNull String verbtype, @NonNull String babname, @NonNull String kov, @NonNull String kovname, int id) {
        this.verb = verb;
        this.root = root;
        this.bab = bab;
        this.verbtype = verbtype;
        this.babname = babname;
        this.kov = kov;
        this.kovname = kovname;
        this.id = id;
    }
}
