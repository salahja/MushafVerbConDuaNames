package org.sj.verbConjugation.trilateral.augmented.modifier.geminator;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

public class TStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public TStartedGeminator() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (اتَّبَعَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        if (mazeedConjugationResult.getRoot().getC1() == 'ت' && (kov == 1 || kov == 6) && (formulaNo == 5))
            return true;

        return false;
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
