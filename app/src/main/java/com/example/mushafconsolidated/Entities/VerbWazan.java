package com.example.mushafconsolidated.Entities;

public class VerbWazan {
    public final static String BNASARA = "نصر"; //   A-U // NASRA-YANSURU
    public final static String BZARABA = "ضرب";  //   A-I // ZARABA-YASZRIBU
    public final static String BFATAH = "فتح";  //  A-A // FATHA-YAFTAHU
    public final static String BSAMIA = "سمح";   //  I-A  //SAMIA-YASMAHU
    public final static String BKARUMU = "كرم";   //   U-U  //KARUMA-YAKRUMU
    public final static String BHASIBA = "حسب";    //  I-I  //HASIBA-YAHSIU
    private String root;
    private String wazan;
    private String arabicword;

    public VerbWazan(String root, String wazan) {
        this.root = root;
        this.wazan = wazan;
    }
    public VerbWazan() {
    }

    public String getArabicword() {
        return arabicword;
    }

    public void setArabicword(String arabicword) {
        this.arabicword = arabicword;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    /*
        public String getWazan() {
            if(wazan.equals("N")){
                wazan="1";
            }else if(wazan.equals("Z")){

                wazan= Constants.BZARABA;
            }else if(wazan.equals("F")){
                wazan=BFATAH;

            }else if(wazan.equals("S")){
                wazan=BSAMIA;

            }else if(wazan.equals("K")){

                wazan=BKARUMU;
            }else if(wazan.equals("H")){

                wazan=BHASIBA;
            }

            return wazan;
        }
     */
    public String getWazan() {
        if (wazan.equals("N")) {
            wazan = "1";
        } else if (wazan.equals("Z")) {
            wazan = "2";
        } else if (wazan.equals("F")) {
            wazan = "3";

        } else if (wazan.equals("S")) {
            wazan = "4";

        } else if (wazan.equals("K")) {
            wazan = "5";
        } else if (wazan.equals("H")) {
            wazan = "6";
        }
        return wazan;
    }

    public void setWazan(String wazan) {
        this.wazan = wazan;
    }

    public String getWazan(String wazan) {
        if (wazan.equals("N")) {
            wazan = BNASARA;
        } else if (wazan.equals("Z")) {
            wazan = BZARABA;
        } else if (wazan.equals("F")) {
            wazan = BFATAH;

        } else if (wazan.equals("S")) {
            wazan = BSAMIA;

        } else if (wazan.equals("K")) {
            wazan = BKARUMU;
        } else if (wazan.equals("H")) {
            wazan = BHASIBA;
        }
        return wazan;
    }
}
