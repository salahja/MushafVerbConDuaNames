package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Present6Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present6Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ى")); // EX: (يَتَداوَى، يتقوَّى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يَتَداوَى، لن يتقوَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَدَاوَ، لم يتقوَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تتداوَيْنَ، تتقوَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تتداوَوْنَ، تتقوَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَداوَوُنَّ، تتقوَّوُنَّ)


    }




    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == 'و' && root.getC3() == 'ي' && (kov == 27 || kov == 28) && (formulaNo == 7 || formulaNo == 8);
    }
}
