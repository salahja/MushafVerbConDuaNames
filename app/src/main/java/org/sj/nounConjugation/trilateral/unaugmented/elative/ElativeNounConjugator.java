package org.sj.nounConjugation.trilateral.unaugmented.elative;

import org.sj.nounConjugation.IUnaugmentedTrilateralNounConjugator;
import org.sj.nounConjugation.NounFormula;
import org.sj.nounConjugation.trilateral.unaugmented.elative.nonstandard.GenericElativeNounFormula;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.Iterator;
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
public class ElativeNounConjugator implements IUnaugmentedTrilateralNounConjugator {
    private static final ElativeNounConjugator instance = new ElativeNounConjugator();
    static List formulas = new ArrayList(1);

    static {
        formulas.add("أَفْعَل");
    }

    private ElativeNounConjugator() {
    }

    public static ElativeNounConjugator getInstance() {
        return instance;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = new GenericElativeNounFormula(root, i + "");
            result.add(noun);
        }
        return result;

    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //todo
        ElativeNounFormulaTree formulaTree = null;//  DatabaseManager.getInstance().getElativeNounFormulaTree(root.getC1());
        if (formulaTree == null)
            return null;
        if (formulaTree == null)
            return null;
        Iterator iter = formulaTree.getFormulaList().iterator();
        while (iter.hasNext()) {
            ElativeNounFormula formula = (ElativeNounFormula) iter.next();
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                return formulas;
            }
        }
        return new LinkedList();
    }
}
