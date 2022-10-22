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
public abstract class AbstractEinMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();

        switch (kov) {
        case 6:
        case 9:
        case 13:
        case 22:
        case 25:
        case 29:
            return true;
        }

        return false;
    }
}
