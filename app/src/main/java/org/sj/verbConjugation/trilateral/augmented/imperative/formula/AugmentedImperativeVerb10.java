package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;
import org.sj.verbConjugation.trilateral.augmented.imperative.*;


public class AugmentedImperativeVerb10 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb10(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    public String form() {
      //  return "�"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"�"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;
        return "ا"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+"و"+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;

    }
}
