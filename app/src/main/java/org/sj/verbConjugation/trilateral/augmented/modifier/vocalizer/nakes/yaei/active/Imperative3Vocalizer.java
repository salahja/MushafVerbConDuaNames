package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (رَقِّ، اجْأوِّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ رَقِّي، اجْأوِّي)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ رَقِّنَّ، اجْأوِّنَّ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن رَقِّينَ، اجْأوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم رَقُّوا، اجْأوُّوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return ((kov == 26 || kov == 24) && formulaNo == 2) || (kov == 25 && (formulaNo == 2 || formulaNo == 11));
    }
}
