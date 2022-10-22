package org.sj.nounConjugation.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import org.sj.nounConjugation.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


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
public class Mithal2Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();


    public Mithal2Vocalizer() {
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (مُوقَظٌ، )
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 13:
        case 14:
            return formulaNo == 1;
        }


        return false;

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
