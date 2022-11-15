package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.imperative.AugmentedImperativeVerb;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedImperativeVerb2 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb2(AugmentedTrilateralRoot root, String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    public String form() {
        return root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SHADDA + ArabCharUtil.KASRA + root.getC3() + lastDim + connectedPronoun;
    }
}
