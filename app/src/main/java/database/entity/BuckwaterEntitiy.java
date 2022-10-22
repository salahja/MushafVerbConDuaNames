package database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "buckwater")
public class BuckwaterEntitiy {


    @PrimaryKey
    @NonNull
    public int decimel;
    @NonNull
    public String hex;
    @NonNull
    public String ascii;
    @NonNull
    public String orthography;


    public String arabic;

    public BuckwaterEntitiy(int decimel, @NonNull String hex, @NonNull String ascii, @NonNull String orthography, String arabic) {
        this.decimel = decimel;
        this.hex = hex;
        this.ascii = ascii;
        this.orthography = orthography;
        this.arabic = arabic;
    }

    public int getDecimel() {
        return decimel;
    }

    @NonNull
    public String getHex() {
        return hex;
    }

    @NonNull
    public String getAscii() {
        return ascii;
    }

    @NonNull
    public String getOrthography() {
        return orthography;
    }

    public String getArabic() {
        return arabic;
    }
}
