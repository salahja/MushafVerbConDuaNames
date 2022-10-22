package org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class SeparatedLafifPassivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public SeparatedLafifPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (يُوصَى)
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (يُودَى)ن
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
