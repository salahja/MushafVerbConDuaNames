package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPresentVerb3 extends AugmentedPresentVerb {

    public AugmentedPresentVerb3(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
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
       // return cp+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+"�"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
        return cp+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+ArabCharUtil.Aleph+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;


    }
}
