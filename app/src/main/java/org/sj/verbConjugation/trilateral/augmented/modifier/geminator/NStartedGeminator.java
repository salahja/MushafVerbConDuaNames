package org.sj.verbConjugation.trilateral.augmented.modifier.geminator;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;


public class NStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public NStartedGeminator() {
        substitutions.add(new InfixSubstitution("نْن","نّ"));// EX: (انَّمَسَ)
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (mazeedConjugationResult.getRoot().getC1() == 'ن') && kov == 1 && formulaNo == 4;
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
