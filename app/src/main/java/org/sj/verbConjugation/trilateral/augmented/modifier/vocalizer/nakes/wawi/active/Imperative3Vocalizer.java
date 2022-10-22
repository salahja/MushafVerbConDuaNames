package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (سَمِّ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم سَمُّوا)
        substitutions.add(new InfixSubstitution("وْن", "ين")); // EX: (أنتن سَمِّينَ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (أنتما سَمِّيَا)
        substitutions.add(new InfixSubstitution("وِ", "")); // EX: (أنتِ سَمِّي)


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
