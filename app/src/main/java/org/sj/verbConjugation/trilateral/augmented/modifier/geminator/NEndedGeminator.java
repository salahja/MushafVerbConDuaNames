package org.sj.verbConjugation.trilateral.augmented.modifier.geminator;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;

public class NEndedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public NEndedGeminator() {
        substitutions.add(new InfixSubstitution("نْن","نّ"));// EX: (نحن سَكَّنَّا، هنَّ سَكَّنَّ)
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        if (mazeedConjugationResult.getRoot().getC3() != 'ن') return false;
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
                    case 14:
                    case 15:
                    case 17:
                    case 18:
                    case 20:
                        return true;
                }
        }

        return false;
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
