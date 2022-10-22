package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.mithal;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class WawiVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();


    public WawiVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (يُوجِبُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if (formulaNo != 1) return false;

        switch (kov) {
        case 9:
        case 10:
        case 11:
            return true;
        }

        return false;
    }
}
