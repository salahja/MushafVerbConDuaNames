package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (حَيِّ، قَوِّ)
        substitutions.add(new InfixSubstitution("ِّيِ","ِّ"));// EX: (أنتِ حَيِّي، قَوِّي)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (أنتم حَيُّوا، قَوُّوا)
        substitutions.add(new InfixSubstitution("ِّيْ","ِّي"));// EX: (أنتن حَيِّينَ، قَوِّينَ)


    }



    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return (root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي' && (kov == 27 || kov == 28) && formulaNo == 2;
    }
}
