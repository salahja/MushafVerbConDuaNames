package org.sj.verbConjugation.trilateral.augmented.modifier.geminator;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.util.*;


public class TEndedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public TEndedGeminator() {
        substitutions.add(new InfixSubstitution("تْت", "تّ")); // EX: (أنا سَكَّتُّ ، أنتَ سَكَّتَّ ، أنتِ سَكَّتِّ )    }
    }

    public List getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        if (mazeedConjugationResult.getRoot().getC3() != 'ت') return false;

        switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                switch (kov) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 11:
                    case 17:
                    case 20:
                        return true;
                }
        }
        return false;
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        if (!tense.equals(SystemConstants.PAST_TENSE)) {
            return;
        }
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
