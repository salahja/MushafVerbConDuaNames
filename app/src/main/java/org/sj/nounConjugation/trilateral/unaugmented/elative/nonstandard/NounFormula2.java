package org.sj.nounConjugation.trilateral.unaugmented.elative.nonstandard;

import org.sj.nounConjugation.INounSuffixContainer;
import org.sj.nounConjugation.NounFormula;
import org.sj.nounConjugation.trilateral.unaugmented.elative.ElativeSuffixContainer;
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
public class NounFormula2 extends NounFormula {
    public NounFormula2(UnaugmentedTrilateralRoot root, String suffixNo) {
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo) + 1;
        suffix = ElativeSuffixContainer.getInstance().get(this.suffixNo - 1).replaceAll(" ", "");
    }

    //to be used in refection getting the formula name
    public NounFormula2() {
    }

    public String form() {
        return root.getC1() + ArabCharUtil.DAMMA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + suffix;

    }

    public String getFormulaName() {
        return "فُعْلَى";
    }

    protected INounSuffixContainer getNounSuffixContainer() {
        return ElativeSuffixContainer.getInstance();
    }
}
