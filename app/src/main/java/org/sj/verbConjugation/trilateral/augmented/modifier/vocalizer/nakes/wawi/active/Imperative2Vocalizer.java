package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {

        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (تَسامَ، تَزَكَّ)
        substitutions.add(new InfixSubstitution("وِي","يْ"));// EX: (أنتِ تسامَيْ، تزَكَّيْ)
        substitutions.add(new InfixSubstitution("وِن","يِن"));// EX: (أنتِ تسامَيِنَّ، تزَكَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو","وْ"));// EX: (أنتم تسامَوْا، تزَكَّوْا)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنتن تسامَيْنَ، تزَكَّيْنَ)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أنتما تسامَيا، تزكَّيا)


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
