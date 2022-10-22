package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer;

import java.util.List;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;

   
public abstract  class IFormulaApplyingChecker {
    public final static int TWO_STATE = 1;
    public final static int NOT_VOCALIZED = 2;
    public final static int NO_THING = 0;

    public IFormulaApplyingChecker() {
    }


    public int check(AugmentedTrilateralRoot root) {
        String rootString = root.getC1() + "" +root.getC2() +""+ root.getC3();
        if (getNotVocalizedList().contains(rootString))
            return NOT_VOCALIZED;
        if (getTwoStateList().contains(rootString))
            return TWO_STATE;
        return NO_THING;
    }


    public abstract List getNotVocalizedList();
    public abstract List getTwoStateList();

}
