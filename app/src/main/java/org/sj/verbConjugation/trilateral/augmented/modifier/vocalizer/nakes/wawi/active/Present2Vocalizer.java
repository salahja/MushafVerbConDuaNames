package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (هو يَتَسامَى، يَتَزَكَّى)
        substitutions.add(new SuffixSubstitution("وَ", "ى")); // EX: (لن يَتَسامَى، يَتَزَكَّى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يَتَسامَ، يَتَزَكَّ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (أنتما تتسامَيان، تتزكَّيان)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تتسامَيْنَ، تتزَكَّيْنَ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تتسامَيِنَّ، تتزَكَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تتسامَوْنَ، تتزَكَّوْنَ)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنتن تتسامَيْنَ، تتزَكَّيْنَ)


    }



    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 7:
            case 8:
                return true;
            }
        }
        return false;
    }
}
