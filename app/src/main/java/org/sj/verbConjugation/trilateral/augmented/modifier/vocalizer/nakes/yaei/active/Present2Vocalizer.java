package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (يَتَناسَى، يَتَرَقَّى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يَتَناسَى، يَتَرَقَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَناسَ، يَتَرَقَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَناسَيْنَ، تَتَرَقَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَناسَوْنَ، تَتَرَقَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَناسَوُنَّ، تَتَرَقَّوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (kov == 26 || kov == 24 || kov == 25) && (formulaNo == 7 || formulaNo == 8);
    }
}
