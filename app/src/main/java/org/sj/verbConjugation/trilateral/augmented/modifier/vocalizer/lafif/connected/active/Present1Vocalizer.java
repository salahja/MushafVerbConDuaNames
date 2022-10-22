package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُحْيِي، يحايِي، يزديي، يستحيي)
        substitutions.add(new SuffixSubstitution("ِيْ","ِ"));// EX: (لم يُحْيِ، لم يُحايِ، لم يَزدَيِ، لم يَسْتَحِي)
        substitutions.add(new InfixSubstitution("ِيِي","ِي"));// EX: (أنتِ تُحْيِينَ، تُحايِينَ، تزديين، تستحيين)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم تُحْيُون، تُحايُون، تزديون، تستحيون)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنتن تُحْيِينَ، تُحايِين، تزديين، تستحيين)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == 28) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;
    }
}