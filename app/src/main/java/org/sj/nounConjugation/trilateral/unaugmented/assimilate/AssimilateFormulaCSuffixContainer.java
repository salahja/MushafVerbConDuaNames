package org.sj.nounConjugation.trilateral.unaugmented.assimilate;

import org.sj.nounConjugation.INounSuffixContainer;

import java.util.ArrayList;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AssimilateFormulaCSuffixContainer implements INounSuffixContainer {
    private static final AssimilateFormulaCSuffixContainer instance = new AssimilateFormulaCSuffixContainer();
    //حالة النكرة
    private final ArrayList indefiniteSuffixList = new ArrayList(18);
    //حالة المعرفة
    private final ArrayList definiteSuffixList = new ArrayList(18);
    //حالة الاضافة
    private final ArrayList annexedSuffixList = new ArrayList(18);
    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private ArrayList currentSuffixList = indefiniteSuffixList;

    private AssimilateFormulaCSuffixContainer() {
        indefiniteSuffixList.add("ُ");
        indefiniteSuffixList.add("َاءُ");
        indefiniteSuffixList.add("َانِ");
        indefiniteSuffixList.add("َاوَانِ");
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َاءَ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َاوَيْنِ");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َاءَ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َاوَيْنِ");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("ٍ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َاءُ");
        definiteSuffixList.add("َانِ");
        definiteSuffixList.add("َاوَانِ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َاءَ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َاوَيْنِ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("َاءِ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َاوَيْنِ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("ِ");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َاءُ");
        annexedSuffixList.add("َا");
        annexedSuffixList.add("َاوَا");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َاءَ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َاوَيْ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("َاءِ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َاوَيْ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("ِ");

    }

    public static AssimilateFormulaCSuffixContainer getInstance() {
        return instance;
    }

    public void selectDefiniteMode() {
        prefix = "ال";
        currentSuffixList = definiteSuffixList;
    }

    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = indefiniteSuffixList;
    }

    public void selectAnnexedMode() {
        prefix = "";
        currentSuffixList = annexedSuffixList;
    }

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

}
