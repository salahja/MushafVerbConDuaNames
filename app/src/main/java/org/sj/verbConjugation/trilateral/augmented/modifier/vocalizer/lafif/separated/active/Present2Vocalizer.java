package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يَتَوارَى، يَتَوَلَّى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يَتَوارَى، يَتَوَلَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَوارَ، يَتَوَلَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَوارَيْنَ، تَتَوَلَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَوارَوْنَ، تَتَوَلَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَوارَوُنَّ، تَتَوَلَّوُنَّ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (kov == 29 && formulaNo == 7) || (kov == 30 && (formulaNo == 7 || formulaNo == 8));
    }

}
