package database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quranicverbs")
public class QuranicVerbsEntity {


    public String verb;
    public String root;
    public String thulathibab;
    @NonNull
    public int form;
    public String chaptername;
    @NonNull
    public int frequency;
    public String meaning;
    @PrimaryKey
    @NonNull
    public int id;

    public QuranicVerbsEntity() {

    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String  getRoots() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getThulathibab() {
        return thulathibab;
    }

    public void setThulathibab(String thulathibab) {
        this.thulathibab = thulathibab;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
