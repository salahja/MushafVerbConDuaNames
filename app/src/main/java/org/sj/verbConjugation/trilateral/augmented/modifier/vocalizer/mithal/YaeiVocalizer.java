package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.mithal;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class YaeiVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public YaeiVocalizer() {

        substitutions.add(new InfixSubstitution("ُيْ", "ُو")); // EX: (أوقَظُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if (formulaNo != 1) {
            return false;
        }

        switch (kov) {
        case 13:
        case 14:
            return true;
        }

        return false;
    }
}
