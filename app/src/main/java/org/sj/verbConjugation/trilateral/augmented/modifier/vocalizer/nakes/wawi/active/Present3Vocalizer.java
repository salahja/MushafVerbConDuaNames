package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (هو يُسَمِّي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسَمِّ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم تُسَمُّونَ)
        substitutions.add(new InfixSubstitution("وْن", "ين")); // EX: (أنتن تُسَمِّينَ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (لن يُسَمِّيَ)
        substitutions.add(new InfixSubstitution("وِ", "")); // EX: (أنتِ تُسَمِّينَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return (kov == 21 || kov == 23) && formulaNo == 2;
    }
}
