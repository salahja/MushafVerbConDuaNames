package database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quranverbs")
public class QuranVerbsEntity {


    public String verb;
    public String root;
    public String thulathibab;
    public String form;
    public String frequency;
    public String meaning;
    @PrimaryKey
    @NonNull
    public int id;

    public QuranVerbsEntity(String verb, String root, String thulathibab, String form, String frequency, String meaning, int id) {
        this.verb = verb;
        this.root = root;
        this.thulathibab = thulathibab;
        this.form = form;
        this.frequency = frequency;
        this.meaning = meaning;
        this.id = id;
    }

    public String getVerb() {
        return verb;
    }

    public String  getRoots() {
        return root;
    }

    public String getThulathibab() {
        return thulathibab;
    }

    public String getForm() {
        return form;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getMeaning() {
        return meaning;
    }

    public int getId() {
        return id;
    }
}
