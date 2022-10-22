package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (هو أهدى، رقَّى، جارى، انثنى، اكتفى، تناسى، ترقَّى، استغنى، اعرورى، اجْأوَّى)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (هم أهدَوْا، رقَّوْا، جارَوْا، انثنَوْا، اكتفَوْا، تناسَوْا، ترقَّوْا، استغنَوْا، اعرَوْرَوا، اجأوَّوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (هي أهدَتْ، رقَّتْ ، جارَتْ، انثنَتْ، اكتفَتْ، تناسَتْ، ترقَّتْ ، استغنَتْ، اعْرَوْرَتْ ، اجأوَّتْ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if ((kov == 25 || kov == 26) && formulaNo == 4) return true;
        if (kov == 26 &&  formulaNo == 10) return true;
        if (kov == 25  && formulaNo == 11) return true;

        switch (kov) {
        case 24:
        case 25:
        case 26:
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
