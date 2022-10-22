package org.sj.verbConjugation.trilateral.augmented.active.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPastVerb7 extends AugmentedPastVerb {

    public AugmentedPastVerb7(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.past.AugmentedPastVerb
     *   method
     */
    public String form() {
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;

     //   return "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"�"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;

    }
}
