package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;


public abstract class AbstractEinMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    public AbstractEinMahmouz() {
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 6:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 9:
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

        case 13:
            switch (formulaNo) {
            case 1:
            case 2:
            case 5:
            case 9:
                return true;
            }

        case 22:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                return true;
            }

        case 25:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
                return true;
            }

        case 29:
            switch (formulaNo) {
            case 5:
            case 7:
            case 9:
                return true;
            }
        }
        return false;
    }

}
