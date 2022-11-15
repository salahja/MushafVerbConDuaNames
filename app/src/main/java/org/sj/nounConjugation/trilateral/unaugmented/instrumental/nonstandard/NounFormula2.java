package org.sj.nounConjugation.trilateral.unaugmented.instrumental.nonstandard;

import org.sj.nounConjugation.trilateral.unaugmented.instrumental.NonStandardInstrumentalNounFormula;
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
public class NounFormula2 extends NonStandardInstrumentalNounFormula {
    public NounFormula2(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormula2() {
    }

    public String form() {
        switch (suffixNo) {
            case 1:
            case 3:
            case 7:
            case 9:
            case 13:
            case 15:
                return root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.FATHA + ArabCharUtil.Aleph + root.getC3() + suffix;
        }
        return "";
    }

    public String getFormulaName() {
        return "فِعَال";
    }

    public String getSymbol() {
        return "F";
    }

}
