package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer.SeparatedLafifActivePresentVocalizer;
import org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer.SeparatedLafifPassivePresentVocalizer;
import org.sj.verbConjugation.trilateral.augmented.modifier.pre.vocalizer.SeparatedLafifPassviePastVocalizer;
import org.sj.verbConjugation.util.SystemConstants;

public class PreVocalizer {
    private final SeparatedLafifActivePresentVocalizer separatedLafifActivePresentVocalizer = new SeparatedLafifActivePresentVocalizer();
    private final SeparatedLafifPassivePresentVocalizer separatedLafifPassivePresentVocalizer = new SeparatedLafifPassivePresentVocalizer();
    private final SeparatedLafifPassviePastVocalizer separatedLafifPassivePastVocalizer = new SeparatedLafifPassviePastVocalizer();

    public PreVocalizer() {
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        if (active) {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifActivePresentVocalizer.isApplied(conjResult))
                separatedLafifActivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        } else {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifPassivePresentVocalizer.isApplied(conjResult))
                separatedLafifPassivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
            else if (tense.equals(SystemConstants.PAST_TENSE) && separatedLafifPassivePastVocalizer.isApplied(conjResult))
                separatedLafifPassivePastVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }

    }

}
