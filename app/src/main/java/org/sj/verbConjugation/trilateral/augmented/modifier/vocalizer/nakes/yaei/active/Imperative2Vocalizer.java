package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تَناسَ، تَرَقَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَناسَيْ، تَرَقَّيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَناسَوْا، تَرَقَّوْا)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَناسَوُنَّ، تَرَقَّوُنَّ)
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
