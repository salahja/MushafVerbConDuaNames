package org.sj.nounConjugation.trilateral.augmented.modifier.substituter;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.nounConjugation.TrilateralNounSubstitutionApplier;

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
public class SpecialSubstituter1 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new LinkedList();

    public SpecialSubstituter1() {
        substitutions.add(new InfixSubstitution("وْت","تّ"));// EX: (اتِّصال، اتِّقاء، اتِّأء)
    }
    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return mazeedConjugationResult.getRoot().getC1() == 'و' && formulaNo == 5 && (kov == 9 || kov == 10 || kov == 11 || kov == 29 || kov == 30);
    }
}
