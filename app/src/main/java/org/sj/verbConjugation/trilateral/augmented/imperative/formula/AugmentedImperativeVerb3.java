package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.imperative.AugmentedImperativeVerb;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedImperativeVerb3 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb3(AugmentedTrilateralRoot root, String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.imperative.AugmentedImperativeVerb
     * method
     */
    public String form() {
        return root.getC1() + ArabCharUtil.FATHA + "ا" + root.getC2() + ArabCharUtil.KASRA + root.getC3() + lastDim + connectedPronoun;

    }
}
