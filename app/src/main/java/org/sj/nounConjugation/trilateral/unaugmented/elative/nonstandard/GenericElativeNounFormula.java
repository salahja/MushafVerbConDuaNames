package org.sj.nounConjugation.trilateral.unaugmented.elative.nonstandard;

import org.sj.nounConjugation.INounSuffixContainer;
import org.sj.nounConjugation.NounFormula;
import org.sj.nounConjugation.trilateral.unaugmented.elative.ElativeSuffixContainer;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public class GenericElativeNounFormula extends NounFormula {
    private NounFormula appliedNounFormula;

    public GenericElativeNounFormula(UnaugmentedTrilateralRoot root, String suffixNo) {
        if ((Integer.parseInt(suffixNo) + 1) % 2 == 0 && (ElativeSuffixContainer.getInstance().isDefinite() || ElativeSuffixContainer.getInstance().isAnnexed())) {
            appliedNounFormula = new NounFormula2(root, suffixNo);
        } else {
            appliedNounFormula = new NounFormula1(root, suffixNo);
        }
    }

    //to be used in refection getting the formula name
    public GenericElativeNounFormula() {
    }

    public String form() {
        return appliedNounFormula.form();
    }

    public String getFormulaName() {
        return "أَفْعَل";
    }

    protected INounSuffixContainer getNounSuffixContainer() {
        return ElativeSuffixContainer.getInstance();
    }
}
