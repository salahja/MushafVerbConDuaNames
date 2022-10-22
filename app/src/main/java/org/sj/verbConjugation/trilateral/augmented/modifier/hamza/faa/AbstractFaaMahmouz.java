package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;

public abstract class AbstractFaaMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractFaaMahmouz() {
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 3:
            switch (formulaNo) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 4:
            return formulaNo == 5;

        case 5:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 15:
            switch (formulaNo) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 18:
        case 27:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 8:
            case 9:
                return true;
            }

        case 21:
        case 24:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }
        }
        return false;
    }

}
