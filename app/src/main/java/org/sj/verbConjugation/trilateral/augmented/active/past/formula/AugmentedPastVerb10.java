package org.sj.verbConjugation.trilateral.augmented.active.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedPastVerb10 extends AugmentedPastVerb {
    public AugmentedPastVerb10(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }


    public String form() {
       // return "�"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"�"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        return "ا"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"و"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;

    }
}
