package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class YaeiPastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public YaeiPastVocalizer() {
        substitutions.add(new InfixSubstitution("ِيْ", "ِي")); // EX: (أنا أُودِيتُ، )
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (هم أُودُوا، )
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (هم يُدُّوا، )

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        if (mazeedConjugationResult.getRoot().getC1() != 'ي') {
            return false;
        }
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
