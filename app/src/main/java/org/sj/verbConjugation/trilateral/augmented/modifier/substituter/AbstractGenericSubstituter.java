package org.sj.verbConjugation.trilateral.augmented.modifier.substituter;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

   
public abstract class AbstractGenericSubstituter extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractGenericSubstituter() {
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        if (formulaNo != 5) return false;

        boolean kovCond = false;
        switch (kov) {
        case 1:
        case 2:
        case 6:
        case 7:
        case 16:
        case 17:
        case 20:
        case 23:
        case 26:
        case 28:
            return true;
        }

        return false;
    }
}
