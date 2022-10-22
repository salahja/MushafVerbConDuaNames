package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPresentVerb7 extends AugmentedPresentVerb {

    public AugmentedPresentVerb7(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.present.AugmentedPresentVerb
     *   method
     */
    public String form() {
     //   return cp+ArabCharUtil.FATHA+"�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"�"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpr+connectedPronoun;

        return cp+ArabCharUtil.FATHA+"ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpr+connectedPronoun;

    }
}
