package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

import java.util.LinkedList;
import java.util.List;

public class GenericSubstituter1 extends AbstractGenericSubstituter {
    private final List substitutions = new LinkedList();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ثْت", "ثّ")); // EX: (اثُّمِدَ ، يُثَّمَدُ)
        substitutions.add(new InfixSubstitution("دْت", "دّ"));// EX: (ادُّخِرَ)
        substitutions.add(new InfixSubstitution("طْت", "طّ"));// EX: (اطُّلِبَ)
        substitutions.add(new InfixSubstitution("ذْت", "ذْد"));// EX: (اذْدُكِرَ)
        substitutions.add(new InfixSubstitution("زْت", "زْد"));// EX: (ازْدُرِدَ)
        substitutions.add(new InfixSubstitution("صْت", "صْط")); // EX: (اصْطُبِر)
        substitutions.add(new InfixSubstitution("ضْت", "ضْط")); // EX: (اضْطُلِعَ)
        substitutions.add(new InfixSubstitution("ظْت", "ظْط"));// EX: (اظْطُلِمَ)
        substitutions.add(new InfixSubstitution("يْت", "تّ"));// EX: (اتُّسِرَ)
        substitutions.add(new InfixSubstitution("وْت", "تّ"));// EX: (اتُّصِلَ ، اتُّقِيَ، اتُّئِيَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'ث' && super.isApplied(mazeedConjugationResult);
    }
}
