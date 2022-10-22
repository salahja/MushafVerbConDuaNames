package org.sj.verbConjugation.trilateral.augmented.modifier;

import java.util.*;


import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.*;
import org.sj.verbConjugation.util.VerbLamAlefModifier;


public class AugmentedTrilateralModifier {

    private AugmentedTrilateralModifier() {
    }

    private static AugmentedTrilateralModifier instance = new AugmentedTrilateralModifier();

    private Substituter substituter = new Substituter();
    private MazeedGeminator mazeedGeminator = new MazeedGeminator();
    private VocalizerAugmented vocalizerAugmented = new VocalizerAugmented();
    private PreVocalizer preVocalizer = new PreVocalizer();
    private SarfHamzaModifier sarfHamzaModifier = new SarfHamzaModifier();

    public static AugmentedTrilateralModifier getInstance() {
        return instance;
    }


    public MazeedConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, String tense, boolean active, boolean applyGemination, boolean listener) {
        MazeedConjugationResult conjResult = new MazeedConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(tense, active, conjResult);
        if (applyGemination) {
            mazeedGeminator.apply(tense, active, conjResult);
        }

        boolean applyVocalization = true;
        int result = FormulaApplyingChecker.getInstance().check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        }
        else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
            //    applyVocalization = listener.doSelectVocalization();
            applyVocalization = false;
        }

        if (applyVocalization) {
            preVocalizer.apply(tense, active, conjResult);
            vocalizerAugmented.apply(tense, active, conjResult);
        }

        sarfHamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

    public MazeedConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, String tense, boolean active, boolean listener) {
        return build(root, kov, formulaNo, conjugations, tense, active, true, listener);
    }

}
