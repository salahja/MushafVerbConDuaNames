package org.sj.verbConjugation.trilateral.augmented.active.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPastVerb1 extends AugmentedPastVerb {

    public AugmentedPastVerb1(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
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
      //  return "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        return "أ"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;


    }
}
