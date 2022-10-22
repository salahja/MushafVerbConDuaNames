package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُحَيِّي)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُحَيِّ)
        substitutions.add(new InfixSubstitution("ِّيِ","ِّ"));// EX: (أنتِ تُحَيِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (أنتم تُحَيُّونَ)
        substitutions.add(new InfixSubstitution("ِّيْ","ِّي"));// EX: (أنتن تُحَيِّينَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == 28 && formulaNo == 2;
    }
}
