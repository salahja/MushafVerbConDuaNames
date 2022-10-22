package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;
import org.sj.verbConjugation.trilateral.augmented.imperative.*;


public class AugmentedImperativeVerb7 extends AugmentedImperativeVerb {

    public AugmentedImperativeVerb7(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
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
      //  return "�"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"�"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDim+connectedPronoun;
        return "ت"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDim+connectedPronoun;

    }
}
