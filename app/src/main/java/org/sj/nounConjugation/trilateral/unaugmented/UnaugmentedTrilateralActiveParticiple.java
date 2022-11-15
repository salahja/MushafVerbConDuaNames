package org.sj.nounConjugation.trilateral.unaugmented;

import org.sj.nounConjugation.GenericNounSuffixContainer;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;

public class UnaugmentedTrilateralActiveParticiple {
    private final UnaugmentedTrilateralRoot root;
    private final String suffix;

    public UnaugmentedTrilateralActiveParticiple(UnaugmentedTrilateralRoot root, String suffix) {
        this.root = root;
        this.suffix = suffix;
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this org.sj.noun.Trilateral.TrilateralNoun method
     */
    public String form() {
        //   return GenericNounSuffixContainer.getInstance().getPrefix()+root.getC1()+ArabCharUtil.FATHA+ArabCharUtil.Aleph+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
        String str;
        str = GenericNounSuffixContainer.getInstance().getPrefix() + root.getC1() + ArabCharUtil.FATHA + ArabCharUtil.Aleph + root.getC2() + ArabCharUtil.KASRA + root.getC3() + suffix;
        return str;
    }

    public String toString() {
        return form();
    }
}
