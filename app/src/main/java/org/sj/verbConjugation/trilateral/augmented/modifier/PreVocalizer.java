package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer.*;
import org.sj.verbConjugation.util.SystemConstants;


public class PreVocalizer {

    private SeparatedLafifActivePresentVocalizer separatedLafifActivePresentVocalizer = new SeparatedLafifActivePresentVocalizer();
    private SeparatedLafifPassivePresentVocalizer separatedLafifPassivePresentVocalizer = new SeparatedLafifPassivePresentVocalizer();
    private SeparatedLafifPassviePastVocalizer separatedLafifPassivePastVocalizer = new SeparatedLafifPassviePastVocalizer();

    public PreVocalizer() {
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        if (active) {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifActivePresentVocalizer.isApplied(conjResult))
                separatedLafifActivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }
        else {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifPassivePresentVocalizer.isApplied(conjResult))
                separatedLafifPassivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
            else if (tense.equals(SystemConstants.PAST_TENSE) && separatedLafifPassivePastVocalizer.isApplied(conjResult))
                separatedLafifPassivePastVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }

    }

}
