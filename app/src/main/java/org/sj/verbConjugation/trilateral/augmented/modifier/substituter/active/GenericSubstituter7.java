package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

import java.util.LinkedList;
import java.util.List;

public class GenericSubstituter7 extends AbstractGenericSubstituter {
    private final List substitutions = new LinkedList();

    public GenericSubstituter7() {
        substitutions.add(new InfixSubstitution("ضْتَ", "ضْطَ"));// EX: (اضْطَلَعَ، يَضْطَلِعُ، اضْطَلِعْ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        boolean b = mazeedConjugationResult.getRoot().getC1() == 'ض' && super.isApplied(mazeedConjugationResult);
        return b;
    }
}
