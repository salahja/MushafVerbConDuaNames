package org.sj.nounConjugation.trilateral.unaugmented.instrumental;

import org.sj.nounConjugation.IUnaugmentedTrilateralNounConjugator;
import org.sj.nounConjugation.NounFormula;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;

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
public class StandardInstrumentalConjugator implements IUnaugmentedTrilateralNounConjugator {
    private static final StandardInstrumentalConjugator instance = new StandardInstrumentalConjugator();
    private static final List formulas = new LinkedList();

    static {
        formulas.add("مِفْعَل");
        formulas.add("مِفْعَلَة");
        formulas.add("مِفْعَال");
        formulas.add("فَعَّالَة");
    }

    private StandardInstrumentalConjugator() {
    }

    public static StandardInstrumentalConjugator getInstance() {
        return instance;
    }

    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, int formulaNo) {
        String formulaClassName = getClass().getPackage().getName() + ".standard.NounFormula" + formulaNo;
        Object[] parameters = {root, suffixNo + ""};
        try {
            NounFormula noun = (NounFormula) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return noun;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }
        return result;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return createNounList(root, formulas.indexOf(formulaName) + 1);
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //فقط للفعل المتعدي
        if (root.getVerbtype().equals(ArabCharUtil.MEEM) || root.getVerbtype().equals("ك"))
            return formulas;
        return new LinkedList();
    }

}
