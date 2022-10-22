package org.sj.nounConjugation.trilateral.unaugmented;

import org.sj.verbConjugation.trilateral.unaugmented.*;
import org.sj.verbConjugation.util.*;
import org.sj.nounConjugation.GenericNounSuffixContainer;

public class UnaugmentedTrilateralPassiveParticiple {
    private UnaugmentedTrilateralRoot root;
    private String suffix;

    public UnaugmentedTrilateralPassiveParticiple(UnaugmentedTrilateralRoot root, String suffix) {
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
        return GenericNounSuffixContainer.getInstance().getPrefix()+ArabCharUtil.MEEM+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.DAMMA+ArabCharUtil.WAW+root.getC3()+suffix;
    }

    public String toString() {
        return form();
    }

}
