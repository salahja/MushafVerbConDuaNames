package org.sj.nounConjugation.trilateral.augmented.activeparticiple;

import org.sj.nounConjugation.trilateral.augmented.AugmentedTrilateralNoun;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NounFormula5 extends AugmentedTrilateralNoun {
    public NounFormula5(AugmentedTrilateralRoot root, String suffix) {
        super(root,suffix);

    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.trilateral.TrilateralNoun method
     */
    public String form() {
        return ArabCharUtil.MEEM+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.SKOON+ArabCharUtil.TA+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }
}
