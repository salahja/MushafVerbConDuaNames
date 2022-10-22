package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (أوْصِ، والِ، اتَّقِ، استوفِ)
        substitutions.add(new InfixSubstitution("يِي","ي"));// EX: (أنتِ أوْصِي، والِي، اتَّقِي، استوفِي)
        substitutions.add(new InfixSubstitution("يِن","ن"));// EX: (أنتِ أوْصِنَّ، والِنَّ، اتَّقِنَّ، استوْفِنَّ)
        substitutions.add(new InfixSubstitution("يْن","ين"));// EX: (أنتن أوْصِينَ، والِينَ، اتقِينَ، استَوْفِينَ)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم أوْصُوا، والُوا، اتقُوا، استوفُوا)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 29:
            switch (formulaNo) {
            case 5:
            case 9:
                return true;
            }

        case 30:
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
