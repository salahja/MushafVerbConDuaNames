package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُوَصِّي)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُوَصِّ)
        substitutions.add(new InfixSubstitution("يِن","ن"));// EX: (أنتِ تُوَصِّنَّ)
        substitutions.add(new InfixSubstitution("يِي","ي"));// EX: (أنتِ تُوَصِّينَ)
        substitutions.add(new InfixSubstitution("يْن","ين"));// EX: (أنتن تُوَصِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُو","ُّو"));// EX: (أنتم تُوَصُّونَ)
        substitutions.add(new InfixSubstitution("ِّيُن","ُّن"));// EX: (أنتم تُوَصُّنَّ)


    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (kov == 30 && formulaNo == 2);
    }
}
