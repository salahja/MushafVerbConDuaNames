package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;
import org.sj.verbConjugation.trilateral.augmented.imperative.*;

public class AugmentedImperativeVerb8 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb8(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    public String form() {
      //  return "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+root.getC3()+lastDim+connectedPronoun;
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+root.getC3()+lastDim+connectedPronoun;

    }
}
