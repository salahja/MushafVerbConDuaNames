package org.sj.verbConjugation.trilateral.augmented.active.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPastVerb5 extends AugmentedPastVerb {

    public AugmentedPastVerb5(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
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

    //    return "�"+root.getC1()+ArabCharUtil.SKOON+"�"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        return "ا"+root.getC1()+ArabCharUtil.SKOON+"ت"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;

    }
}
