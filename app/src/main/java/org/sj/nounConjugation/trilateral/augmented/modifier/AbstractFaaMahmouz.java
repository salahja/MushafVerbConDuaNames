package org.sj.nounConjugation.trilateral.augmented.modifier;

import org.sj.nounConjugation.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;


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
public abstract class AbstractFaaMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();

        switch (kov) {
        case 3:
        case 4:
        case 5:
        case 15:
        case 18:
        case 21:
        case 24:
        case 27:
            return true;
        }
        return false;
    }
}
