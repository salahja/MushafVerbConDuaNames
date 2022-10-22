package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تحايَ، تداوَ، تَحَيَّ، تَقَوَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَحايَيْ، تَداوَيْ، تَحَيَّيْ، تَقَوَّيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَحايَوْا، تَدَاوَوْا، تَحَيَّوْا، تَقَوَّوْا)
        substitutions.add(new InfixSubstitution("يُن","وُن"));// EX: (أنتم تَحايَوُنَّ، تداوَوُنَّ، تَحَيَّوُنَّ، تَقَوَّوُنَّ)


    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return (root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي' && (kov == 27 || kov == 28) && (formulaNo == 7 || formulaNo == 8);

    }
}
