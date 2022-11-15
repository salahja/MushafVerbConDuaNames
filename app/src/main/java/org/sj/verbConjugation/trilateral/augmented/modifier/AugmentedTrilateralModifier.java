package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import org.sj.verbConjugation.util.VerbLamAlefModifier;

import java.util.List;

public class AugmentedTrilateralModifier {
    private static final AugmentedTrilateralModifier instance = new AugmentedTrilateralModifier();
    private final Substituter substituter = new Substituter();
    private final MazeedGeminator mazeedGeminator = new MazeedGeminator();
    private final VocalizerAugmented vocalizerAugmented = new VocalizerAugmented();
    private final PreVocalizer preVocalizer = new PreVocalizer();
    private final SarfHamzaModifier sarfHamzaModifier = new SarfHamzaModifier();

    private AugmentedTrilateralModifier() {
    }

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
        } else if (result == IFormulaApplyingChecker.TWO_STATE) {
            //asking the listener to apply or not the vocaliztion
            //    applyVocalization = listener.doSelectVocalization();
            applyVocalization = listener;
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
