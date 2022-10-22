package org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class SeparatedLafifActivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public SeparatedLafifActivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو")); // EX: (يُوصِي)
        substitutions.add(new InfixSubstitution("ُيْ", "ُو")); // EX: (يُودِي)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if (kov == 30 && formulaNo == 1) {
            return true;
        }
        return false;
    }
}
