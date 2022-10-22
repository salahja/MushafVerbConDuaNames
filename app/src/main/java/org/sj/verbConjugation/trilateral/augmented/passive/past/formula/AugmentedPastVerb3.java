package org.sj.verbConjugation.trilateral.augmented.passive.past.formula;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.util.ArabCharUtil;


public class AugmentedPastVerb3 extends AugmentedPastVerb {

    public AugmentedPastVerb3(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.past.AugmentedPastVerb
     *   method
     */
    public String form() {
        return root.getC1()+ArabCharUtil.DAMMA+"و"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpa+connectedPronoun;
    }
}
