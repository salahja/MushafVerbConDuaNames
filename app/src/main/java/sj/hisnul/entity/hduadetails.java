package sj.hisnul.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hduadetails")
public class hduadetails {
    @NonNull
    private int book_id;
    @NonNull
    private int dua_global_id;
    @NonNull
    private String ID;
    @NonNull
    private int dua_segment_id;
    private String top;
    private String arabic_diacless;
    private String arabic;
    private String transliteration;
    private String translations;
    private String bottom;
    private String reference;
    private String app_reference;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int pid;

    public hduadetails(int book_id, int dua_global_id, @NonNull String ID, int dua_segment_id, String top, String arabic_diacless, String arabic, String transliteration, String translations, String bottom, String reference, String app_reference, int pid) {
        this.book_id = book_id;
        this.dua_global_id = dua_global_id;
        this.ID = ID;
        this.dua_segment_id = dua_segment_id;
        this.top = top;
        this.arabic_diacless = arabic_diacless;
        this.arabic = arabic;
        this.transliteration = transliteration;
        this.translations = translations;
        this.bottom = bottom;
        this.reference = reference;
        this.app_reference = app_reference;
        this.pid = pid;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getDua_global_id() {
        return dua_global_id;
    }

    public void setDua_global_id(int dua_global_id) {
        this.dua_global_id = dua_global_id;
    }

    @NonNull
    public String getID() {
        return ID;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public int getDua_segment_id() {
        return dua_segment_id;
    }

    public void setDua_segment_id(int dua_segment_id) {
        this.dua_segment_id = dua_segment_id;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getArabic_diacless() {
        return arabic_diacless;
    }

    public void setArabic_diacless(String arabic_diacless) {
        this.arabic_diacless = arabic_diacless;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getApp_reference() {
        return app_reference;
    }

    public void setApp_reference(String app_reference) {
        this.app_reference = app_reference;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}