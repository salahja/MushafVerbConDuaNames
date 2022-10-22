package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.passive;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.*;


public class RaaPresentMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new ArrayList();

    public RaaPresentMahmouz() {
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (يُرَى)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        TrilateralRoot root = mazeedConjugationResult.getRoot();
        return mazeedConjugationResult.getFormulaNo() == 1 && root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
