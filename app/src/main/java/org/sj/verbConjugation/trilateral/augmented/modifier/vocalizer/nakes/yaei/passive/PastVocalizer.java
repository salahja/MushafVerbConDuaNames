package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {
        substitutions.add(new InfixSubstitution("يْ", "ي")); // EX: (أنا أُهْدِيتُ، رُقِّيتُ، جُوريتُ، انثُنيت، اكتُفِيتُ، تُنُوسِيتُ، استُغْنِيتُ، اعْرُوُرِيتُ، اجؤُوِّيتُ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (هم أُهْدُوا، جُورُوا، انثُنُوا، اكتُفُوا، تُنوسُوا، استُغْنُوا، اعْرُورُوا)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (هم رُقُّوا، تُرُقُّوا، اجؤُوُّوا)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 24:
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

        case 25:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
                return true;
            }

        case 26:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            }

        }
        return false;
    }
}
