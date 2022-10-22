package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedPresentVerb4 extends AugmentedPresentVerb {
    public AugmentedPresentVerb4(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }


    public String form() {
      //  return cp+ArabCharUtil.FATHA+"�"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
        return cp+ArabCharUtil.FATHA+"ن"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;


    }
}
