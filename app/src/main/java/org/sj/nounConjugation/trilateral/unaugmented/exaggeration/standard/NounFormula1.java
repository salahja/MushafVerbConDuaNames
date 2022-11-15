package org.sj.nounConjugation.trilateral.unaugmented.exaggeration.standard;

import org.sj.nounConjugation.NounFormula;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
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
public class NounFormula1 extends NounFormula {
    public NounFormula1(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    public String form() {
        return root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SHADDA + ArabCharUtil.FATHA + ArabCharUtil.Aleph + root.getC3() + suffix;
    }

    public String getFormulaName() {
        return "فَعَّال";
    }

}
