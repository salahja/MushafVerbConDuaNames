package org.sj.verbConjugation.trilateral.augmented.modifier.geminator;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.generic.*;
import org.sj.verbConjugation.util.SystemConstants;

public class MazeedGenericGeminator implements IAugmentedTrilateralModifier {

    private Map geminators = new HashMap();

    public MazeedGenericGeminator() {

        geminators.put(SystemConstants.PAST_TENSE + "true", new ActivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "true", new ActivePresentGeminator());
        ImperativeGeminator imperativeGeminator = new ImperativeGeminator();
        geminators.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.PAST_TENSE + "false", new PassivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "false", new PassivePresentGeminator());
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (formulaNo) {
        case 6:
            switch (kov) {
            case 1:
            case 6:
            case 17:
            case 20:
                return true;
            }
            return false;

        case 12:
            switch (kov) {
            case 1:
            case 11:
            case 17:
            case 20:
                return true;
            }
            return false;
        case 1:
        case 4:
            return kov == 2;

        case 3:
        case 7:
            return kov == 2 || kov == 3 || kov == 8;
        case 5:
        case 9:
            return kov == 2 || kov == 3;
        }
        return false;
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        SubstitutionsApplier geminator = (SubstitutionsApplier) geminators.get(tense + active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
