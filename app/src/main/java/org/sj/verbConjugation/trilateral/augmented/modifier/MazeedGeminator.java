package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.MazeedGenericGeminator;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.NEndedGeminator;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.NStartedGeminator;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.TEndedGeminator;
import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.TStartedGeminator;

public class MazeedGeminator {
    private final MazeedGenericGeminator mazeedGenericGeminator = new MazeedGenericGeminator();
    private final NEndedGeminator nEndedGeminator = new NEndedGeminator();
    private final NStartedGeminator nStartedGeminator = new NStartedGeminator();
    private final TEndedGeminator tEndedGeminator = new TEndedGeminator();
    private final TStartedGeminator tStartedGeminator = new TStartedGeminator();

    public MazeedGeminator() {
    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        //althoug it will enter the generic block, it may found some rules in the special ones
        if (mazeedGenericGeminator.isApplied(conjResult))
            mazeedGenericGeminator.apply(tense, active, conjResult);
        if (tStartedGeminator.isApplied(conjResult))
            tStartedGeminator.apply(tense, active, conjResult);
        if (tEndedGeminator.isApplied(conjResult))
            tEndedGeminator.apply(tense, active, conjResult);
        if (nStartedGeminator.isApplied(conjResult))
            nStartedGeminator.apply(tense, active, conjResult);
        if (nEndedGeminator.isApplied(conjResult))
            nEndedGeminator.apply(tense, active, conjResult);
    }

}
