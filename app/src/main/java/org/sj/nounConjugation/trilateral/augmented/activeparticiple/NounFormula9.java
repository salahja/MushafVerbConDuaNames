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
public class NounFormula9 extends AugmentedTrilateralNoun {
    public NounFormula9(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.trilateral.TrilateralNoun method
     */
    public String form() {
       String ist=ArabCharUtil.MEEM+ArabCharUtil.DAMMA+ArabCharUtil.SEEN+ArabCharUtil.SKOON+ArabCharUtil.TA+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
  return ist;
    }
}
