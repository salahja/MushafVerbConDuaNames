package org.sj.verbConjugation.trilateral.augmented.active.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedPastVerb8 extends AugmentedPastVerb {
    public AugmentedPastVerb8(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }


    public String form() {
      //  return "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;


    }
}
