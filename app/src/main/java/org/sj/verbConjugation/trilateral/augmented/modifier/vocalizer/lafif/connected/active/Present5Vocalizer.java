package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present5Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُقَوِّي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُقَوِّ)
        substitutions.add(new InfixSubstitution("ِّيِ", "ِّ")); // EX: (أنتِ تقوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم تُقَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّيْ", "ِّي")); // EX: (أنتن تُقَوِّينَ)


    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        boolean b= root.getC2() == 'و' && root.getC3() == 'ي' && (kov == 28 || kov == 27) && formulaNo == 2;
        return b;
    }
}
