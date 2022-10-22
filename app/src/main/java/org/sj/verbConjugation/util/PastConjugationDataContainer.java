package org.sj.verbConjugation.util;

import static org.sj.conjugator.utilities.ArabicLiterals.Damma;
import static org.sj.conjugator.utilities.ArabicLiterals.Fatha;
import static org.sj.conjugator.utilities.ArabicLiterals.Sukun;

import java.util.ArrayList;
import java.util.List;

import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

public class PastConjugationDataContainer {

  private List dpa2List = new ArrayList(6);

  private List lastDpaList = new ArrayList(13);

  private List connectedPronounsList = new ArrayList(13);

  private static PastConjugationDataContainer instance = new PastConjugationDataContainer();

  public static PastConjugationDataContainer getInstance() {
    return instance;
  }

  private PastConjugationDataContainer() {


    dpa2List.add(ArabCharUtil.FATHA);
    dpa2List.add(ArabCharUtil.FATHA);
    dpa2List.add(ArabCharUtil.FATHA);
    dpa2List.add(ArabCharUtil.KASRA);
    dpa2List.add(ArabCharUtil.DAMMA);
    dpa2List.add(ArabCharUtil.KASRA);


    lastDpaList.add(Fatha.trim());//ضَرَبَ"
    lastDpaList.add(Fatha.trim());//ضَرَبَا"
    lastDpaList.add(Damma.trim());//ضَرَبُوا"
    lastDpaList.add(Fatha.trim());//"ضَرَبَتْ"
    lastDpaList.add(Fatha.trim());//ضَرَبَتَا"
    lastDpaList.add(Sukun.trim());//ضَرَبْنَ"
    lastDpaList.add(Sukun.trim());//"ضَرَبَتْ"
    lastDpaList.add(Sukun.trim());//"ضَرَبْتُمَا
    lastDpaList.add(Sukun.trim());//ضَرَبْتُمْ"
    lastDpaList.add(Sukun.trim());//"ضَرَبْتِ"
    lastDpaList.add(Sukun.trim());//ضَرَبْتُنَّ"
    lastDpaList.add(Sukun.trim());//ضَرَبْتُ"
    lastDpaList.add(Sukun.trim());//ضَرَبْنَا"
    /*
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.SKOON);
    lastDpaList.add(ArabCharUtil.FATHA);
    lastDpaList.add(ArabCharUtil.FATHA);
    lastDpaList.add(ArabCharUtil.FATHA);
    lastDpaList.add(ArabCharUtil.FATHA);
    lastDpaList.add(ArabCharUtil.DAMMA);
    lastDpaList.add(ArabCharUtil.SKOON);

     */


    connectedPronounsList.add("");
    connectedPronounsList.add("ا");
    connectedPronounsList.add("وا");

    connectedPronounsList.add("تْ");
    connectedPronounsList.add("تَا");
    connectedPronounsList.add("نَ");

    connectedPronounsList.add("تَ");
    connectedPronounsList.add("تُمَا");
    connectedPronounsList.add("تُمْ");

    connectedPronounsList.add("تِ");
    connectedPronounsList.add("تُنَّ");


    connectedPronounsList.add("تُ");
    connectedPronounsList.add("نَا");
  }


  public String getDpa2(UnaugmentedTrilateralRoot root) {

    String s = (String) dpa2List.get((Integer.parseInt(root.getConjugation()) - 1));
    return s;
  }


  public String getLastDpa(int pronounIndex) {
    String s=  (String) lastDpaList.get(pronounIndex);
    return s;
  }


  public String getConnectedPronoun(int pronounIndex) {
    String s = (String) connectedPronounsList.get(pronounIndex);
    ////System.out.println(s);
    return s;
  }

}
