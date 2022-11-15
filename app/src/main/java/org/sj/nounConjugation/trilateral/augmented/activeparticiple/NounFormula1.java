package org.sj.nounConjugation.trilateral.augmented.activeparticiple;

import static org.sj.verbConjugation.util.ArabCharUtil.MEEM;

import org.sj.nounConjugation.trilateral.augmented.AugmentedTrilateralNoun;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;

public class NounFormula1 extends AugmentedTrilateralNoun {
    public NounFormula1(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }

    public String form() {
        return MEEM + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.KASRA + root.getC3() + suffix;
    }
}
