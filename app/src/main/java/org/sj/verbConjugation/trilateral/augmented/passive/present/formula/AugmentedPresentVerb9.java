package org.sj.verbConjugation.trilateral.augmented.passive.present.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPresentVerb9 extends AugmentedPresentVerb {

    public AugmentedPresentVerb9(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }

    public String form() {
       // return cp+ArabCharUtil.DAMMA+"�"+ArabCharUtil.SKOON+ "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpr+connectedPronoun;
        return cp+ArabCharUtil.DAMMA+"س"+ArabCharUtil.SKOON+ "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpr+connectedPronoun;


    }
}
