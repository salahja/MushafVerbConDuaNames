package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer;

import java.util.*;
   
public class Formula9ApplyingChecker extends IFormulaApplyingChecker{
    private List twoStateList = new LinkedList();
    private List notVocalizedList = new LinkedList();

    public Formula9ApplyingChecker() {
        twoStateList.add("جوب");
        twoStateList.add("جوف");
        twoStateList.add("خول");
        twoStateList.add("روح");
        twoStateList.add("روض");
        twoStateList.add("صوب");

        notVocalizedList.add("ءور");
        notVocalizedList.add("تيس");
        notVocalizedList.add("حوذ");
        notVocalizedList.add("حوس");
        notVocalizedList.add("حوض");
        notVocalizedList.add("فيل");
        notVocalizedList.add("قوس");
        notVocalizedList.add("ليث");
        notVocalizedList.add("نوق");
        notVocalizedList.add("نوك");
    }

    public List getNotVocalizedList() {
        return notVocalizedList;
    }

    public List getTwoStateList() {
        return twoStateList;
    }
}
