package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

import java.util.LinkedList;
import java.util.List;

public class GenericSubstituter4 extends AbstractGenericSubstituter {
    private final List substitutions = new LinkedList();

    public GenericSubstituter4() {
        substitutions.add(new InfixSubstitution("ذْت", "ذْد"));// EX: (اذْدُكِرَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'ذ' && super.isApplied(mazeedConjugationResult);
    }
}
