package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.modifier.geminator.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class MazeedGeminator {

    private MazeedGenericGeminator mazeedGenericGeminator = new MazeedGenericGeminator();

    private NEndedGeminator nEndedGeminator = new NEndedGeminator();

    private NStartedGeminator nStartedGeminator = new NStartedGeminator();


    private TEndedGeminator tEndedGeminator = new TEndedGeminator();

    private TStartedGeminator tStartedGeminator = new TStartedGeminator();

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
