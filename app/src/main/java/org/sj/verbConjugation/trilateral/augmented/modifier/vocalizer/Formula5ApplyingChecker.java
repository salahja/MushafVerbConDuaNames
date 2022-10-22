package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer;

import java.util.*;

   
public class Formula5ApplyingChecker extends IFormulaApplyingChecker{
    private List twoStateList = new LinkedList();
    private List notVocalizedList = new LinkedList();

    public Formula5ApplyingChecker() {
        twoStateList.add("حول");
        twoStateList.add("روح");
        twoStateList.add("شور");

        notVocalizedList.add("جور");
        notVocalizedList.add("حوش");
        notVocalizedList.add("زوج");
        notVocalizedList.add("سوط");
        notVocalizedList.add("عور");
        notVocalizedList.add("هور");
    }
    public List getNotVocalizedList() {
        return notVocalizedList;
    }

    public List getTwoStateList() {
        return twoStateList;
    }
}
