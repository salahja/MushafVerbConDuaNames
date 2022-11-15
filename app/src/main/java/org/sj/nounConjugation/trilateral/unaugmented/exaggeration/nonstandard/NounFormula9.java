package org.sj.nounConjugation.trilateral.unaugmented.exaggeration.nonstandard;

import org.sj.nounConjugation.trilateral.unaugmented.exaggeration.NonStandardExaggerationNounFormula;
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
public class NounFormula9 extends NonStandardExaggerationNounFormula {
    public NounFormula9(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula9() {
    }

    public String form() {
        return ArabCharUtil.MEEM + ArabCharUtil.KASRA + root.getC1() + ArabCharUtil.SKOON + root.getC2() + ArabCharUtil.KASRA + ArabCharUtil.YA + root.getC3() + suffix;
    }

    public String getFormulaName() {
        return "مِفْعِيل";
    }

    public String getSymbol() {
        return "K";
    }

}
