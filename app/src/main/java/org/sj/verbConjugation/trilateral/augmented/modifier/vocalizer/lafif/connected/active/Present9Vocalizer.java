package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present9Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present9Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (يَتَساوَى، يَتَسَوَّى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يَتَساوَ، لم يَتَسَوَّ)
        substitutions.add(new SuffixSubstitution("وَ", "ى")); // EX: (لن يَتَساوَى، لن يتسوَّى)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تَتَساوَيانِ، تتسوَّيانِ)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تَتَساوَيْنَ، تتسوَّيْنَ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تَتَساوَيِنَّ، تتسوَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تَتَساوَوْنَ، تتسوَّوْنَ)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تَتَساوَيْنَ، تتسوَّيْنَ)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (تَتَساوَيَنَ، تتسوَّيَنَ)


    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == 28 && (formulaNo == 7 || formulaNo == 8);
    }
}
