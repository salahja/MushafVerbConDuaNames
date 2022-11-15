package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

import java.util.LinkedList;
import java.util.List;

public class GenericSubstituter5 extends AbstractGenericSubstituter {
    private final List substitutions = new LinkedList();

    public GenericSubstituter5() {
        substitutions.add(new InfixSubstitution("زْت", "زْد"));// EX: (ازْدُرِدَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'ز' && super.isApplied(mazeedConjugationResult);
    }
}
