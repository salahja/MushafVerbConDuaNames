package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ا")); // EX: (يَتَحَايَا، يَتَحَيَّا)
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (لن يَتَحَايَا، لن يتَحَيَّا)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَحَايَ، لم يَتَحَيَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَحَايَيْنَ، تَتَحَيَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَحايَوْنَ، تَتَحَيَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَحايَوُنَّ، تَتَحَيَّوُنَّ)


    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == 28 && (formulaNo == 7 || formulaNo == 8);
    }
}
