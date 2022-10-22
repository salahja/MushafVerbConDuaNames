package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُوصِي، يوالِي، يَتَّقِي، يستوفِي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُوصِ، يوالِ، يَتَّقِ، يستوفِ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُوصِنَّ، توالِنَّ، تَتَّقِنَّ، تستوفِنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُوصِينَ، تُوالِينَ، تَتَّقِينَ، تَستوفِينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُوصِينَ، تُوالِينَ، تَتَّقِينَ، تَستوفِينَ)
        substitutions.add(new InfixSubstitution("ِيُو", "ُو")); // EX: (أنتم تُوصُونَ، تُوالُونَ، تَتَّقُونَ، تَستوفُونَ)
        substitutions.add(new InfixSubstitution("ِيُن", "ُن")); // EX: (أنتم تُوصُنَّ، تُوالُنَّ، تَتَّقُنَّ، تَستوفُنَّ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 29:
            switch (formulaNo) {
            case 5:
            case 9:
                return true;
            }

        case 30:
            switch (formulaNo) {
            case 1:
            case 3:
            case 5:
            case 9:
                return true;
            }
        }
        return false;
    }

}
