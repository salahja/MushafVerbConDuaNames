package org.sj.nounConjugation.trilateral.unaugmented.exaggeration;

import org.sj.nounConjugation.IUnaugmentedTrilateralNounConjugator;
import org.sj.nounConjugation.NounFormula;
import org.sj.nounConjugation.trilateral.unaugmented.exaggeration.standard.NounFormula1;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class StandardExaggerationConjugator implements IUnaugmentedTrilateralNounConjugator {
    private static final StandardExaggerationConjugator instance = new StandardExaggerationConjugator();
    static List formulas = new ArrayList(1);

    static {
        formulas.add("فَعَّال");
    }

    private StandardExaggerationConjugator() {
    }

    public static StandardExaggerationConjugator getInstance() {
        return instance;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = new NounFormula1(root, i + "");
            result.add(noun);
        }
        return result;
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return formulas;
    }

}
