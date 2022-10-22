package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Imperative6Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative6Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (تَساوَ، تَسَوَّ)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تَساوَيْ، تَسَوَّيْ)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تَساوَيا، تَسَوَّيا)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تَساوَوْا، تَسَوَّوْا)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تَساوَيْنَ، تَسَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (أنتَ تَساوَيَنَّ، تَسَوَّيَنَّ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تَساوَيِنَّ، تَسَوَّيِنَّ)

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
