package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.mithal;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class WawiVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public WawiVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو"));// EX: (يُوجِبُ، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        if (formulaNo != 1) return false;
        switch (kov) {
            case 9:
            case 10:
            case 11:
                return true;
        }
        return false;
    }
}
