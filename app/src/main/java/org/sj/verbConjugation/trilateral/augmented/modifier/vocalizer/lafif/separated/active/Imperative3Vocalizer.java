package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (وَصِّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ وَصِّي)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ وَصِّنَّ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن وَصِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم وَصُّوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (kov == 30 && formulaNo == 2);
    }



}
