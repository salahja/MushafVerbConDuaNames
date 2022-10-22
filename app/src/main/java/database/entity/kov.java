package database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kov")
public  class kov {

  @NonNull    private String c1;
  @NonNull   private String    c2           ;
  @NonNull  private String    c3    ;
  @NonNull  private String    kov            ;
  @NonNull  private String   rulename        ;
  @NonNull   private String   example            ;

  @NonNull
  @PrimaryKey(autoGenerate = true)
  private int id;

  public kov(@NonNull String c1) {
    this.c1 = c1;
  }

  @NonNull
  public String getC1() {
    return c1;
  }

  public void setC1(@NonNull String c1) {
    this.c1 = c1;
  }

  @NonNull
  public String getC2() {
    return c2;
  }

  public void setC2(@NonNull String c2) {
    this.c2 = c2;
  }

  @NonNull
  public String getC3() {
    return c3;
  }

  public void setC3(@NonNull String c3) {
    this.c3 = c3;
  }

  @NonNull
  public String getKov() {
    return kov;
  }

  public void setKov(@NonNull String kov) {
    this.kov = kov;
  }

  @NonNull
  public String getRulename() {
    return rulename;
  }

  public void setRulename(@NonNull String rulename) {
    this.rulename = rulename;
  }

  @NonNull
  public String getExample() {
    return example;
  }

  public void setExample(@NonNull String example) {
    this.example = example;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
