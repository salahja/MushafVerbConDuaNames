package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;
import org.sj.verbConjugation.trilateral.augmented.imperative.*;

public class AugmentedImperativeVerb4 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb4(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.imperative.AugmentedImperativeVerb
     *   method
     */
    public String form() {
     //   return "�"+"�"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;
        return "ا"+"ن"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;

    }
}
