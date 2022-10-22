package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPresentVerb10 extends AugmentedPresentVerb {
    public AugmentedPresentVerb10(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }


    public String form() {
       // return cp+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"�"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
        return cp+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"و"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;


    }
}
