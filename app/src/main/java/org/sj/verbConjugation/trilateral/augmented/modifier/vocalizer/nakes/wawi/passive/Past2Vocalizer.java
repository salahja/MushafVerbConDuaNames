package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Past2Vocalizer() {
        substitutions.add(new InfixSubstitution("وْ", "ي"));// EX: (أنا سُمِّيتُ، تُزُكِّيتُ)
        substitutions.add(new InfixSubstitution("وَ", "يَ"));// EX: (هو سُمِّيَ، تُزُكِّيَ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ"));// EX: (هم سُمُّوا، تُزُكُّوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return (kov == 22 && formulaNo == 8) || ((kov == 23 || kov == 21) && (formulaNo == 2 || formulaNo == 8));
    }
}
