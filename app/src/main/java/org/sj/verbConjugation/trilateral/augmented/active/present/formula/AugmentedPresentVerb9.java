package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPresentVerb9 extends AugmentedPresentVerb {

    public AugmentedPresentVerb9(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
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
      //  return cp+ArabCharUtil.FATHA+"�"+ArabCharUtil.SKOON+ "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
        return cp+ArabCharUtil.FATHA+"س"+ArabCharUtil.SKOON+ "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;


    }
}
