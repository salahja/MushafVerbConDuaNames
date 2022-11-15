package org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class SeparatedLafifActivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

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
        return kov == 30 && formulaNo == 1;
    }
}
