package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

import java.util.LinkedList;
import java.util.List;

public class GenericSubstituter1 extends AbstractGenericSubstituter {
    private final List substitutions = new LinkedList();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ثْتَ", "ثَّ"));// EX: (اثَّمَدَ، يَثَّمِدُ، اثَّمِدْ)
        substitutions.add(new InfixSubstitution("دْتَ", "دَّ"));// EX: (ادَّخَرَ، يَدَّخِرُ، ادَّخِرْ)
        substitutions.add(new InfixSubstitution("طْتَ", "طَّ"));// EX: (اطَّلَبَ، يَطَّلِبُ، اطَّلِبْ)
        substitutions.add(new InfixSubstitution("ذْتَ", "ذْدَ")); // EX: (اذْدَكَرَ، يَذْدَكِرُ، اذْدَكِرْ)
        substitutions.add(new InfixSubstitution("زْتَ", "زْدَ"));// EX: (ازْدَرَدَ، يَزْدَرِدُ، ازْدَرِدْ)
        substitutions.add(new InfixSubstitution("صْتَ", "صْطَ"));// EX: (اصْطَبَر، يَصْطَبِرُ، اصْطَبِرْ)
        substitutions.add(new InfixSubstitution("ضْتَ", "ضْطَ"));// EX: (اضْطَلَعَ، يَضْطَلِعُ، اضْطَلِعْ)
        substitutions.add(new InfixSubstitution("ظْتَ", "ظْطَ"));// EX: (اظْطَلَمَ، يَظْطَلِمُ، اظْطَلِمْ)
        substitutions.add(new InfixSubstitution("وْتَ", "تَّ"));// EX: (اتَّصَلَ، يَتَّصِلُ، اتَّصِلْ)
        substitutions.add(new InfixSubstitution("يْتَ", "تَّ"));// EX: (اتَّسَرَ، يَتَّسِرُ، اتَّسِرْ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'ث' && super.isApplied(mazeedConjugationResult);
    }
}
