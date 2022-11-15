package org.sj.verbConjugation.trilateral.augmented.passive.past.formula;

import org.sj.verbConjugation.trilateral.augmented.AugmentedPastVerb;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;

/**
 * Title: Sarf
 * <p>
 * Description: ������ �������
 * <p>
 * Copyright: Copyright (c) 2006
 * <p>
 * Company:
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AugmentedPastVerb8 extends AugmentedPastVerb {
    public AugmentedPastVerb8(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.past.AugmentedPastVerb
     * method
     */
    public String form() {
        return "ت" + ArabCharUtil.DAMMA + root.getC1() + ArabCharUtil.DAMMA + root.getC2() + ArabCharUtil.SHADDA + ArabCharUtil.KASRA + root.getC3() + lastDpa + connectedPronoun;
    }
}
