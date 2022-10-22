package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تَوارَ، تَوَلَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَوارَيْ، تَوَلَّيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَوَارَوْا، تَوَلَّوْا)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَوَارَوُنَّ، تَوَلَّوُنَّ)

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
