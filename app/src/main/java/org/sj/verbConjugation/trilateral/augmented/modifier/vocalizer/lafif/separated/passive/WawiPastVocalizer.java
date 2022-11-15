package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class WawiPastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public WawiPastVocalizer() {
        substitutions.add(new InfixSubstitution("ِيْ", "ِي"));// EX: (أنا أُوصِيتُ، وُفِّيتُ، وُولِيتُ، اتُّقِيتُ، تُوُوريتُ، تُوُلِّيتُ، استُوفِيتُ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ"));// EX: (هم أُوصُوا، وُولُوا، اتُّقُوا، تُوُورُوا، استُوفُوا)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ"));// EX: (هم وُفُّوا، تُوُلُّوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        if (mazeedConjugationResult.getRoot().getC1() != 'و')
            return false;
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        switch (kov) {
            case 29:
                switch (formulaNo) {
                    case 5:
                    case 7:
                    case 9:
                        return true;
                }
            case 30:
                switch (formulaNo) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                }
        }
        return false;
    }

}
