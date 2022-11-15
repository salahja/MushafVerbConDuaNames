package org.sj.verbConjugation.trilateral.augmented.passive.past;

import org.sj.verbConjugation.trilateral.augmented.AugmentedPastVerb;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.AugmentationFormula;
import org.sj.verbConjugation.util.PastConjugationDataContainer;

import java.util.LinkedList;
import java.util.List;

public class AugmentedPassivePastConjugator {
    private static final AugmentedPassivePastConjugator instance = new AugmentedPassivePastConjugator();

    private AugmentedPassivePastConjugator() {
    }

    public static AugmentedPassivePastConjugator getInstance() {
        return instance;
    }

    public AugmentedPastVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        String formulaClassName = getClass().getPackage().getName() + ".formula." + "AugmentedPastVerb" + formulaNo;
        Object[] parameters = {root, lastDpa, connectedPronoun};
        try {
            AugmentedPastVerb verb = (AugmentedPastVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        AugmentationFormula augmentationFormula = root.getAugmentationFormula(formulaNo);
        //todo correct
        if (formulaNo == 20) {
            // if (augmentationFormula.getTransitive() == 'ل') {
            return createLazzemVerbList(root, formulaNo);
        } else {
            List result = new LinkedList();
            for (int i = 0; i < 13; i++) {
                AugmentedPastVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            }
            return result;
        }
    }

    //������ ������ ������ ��� �� �� �� ��
    public List createLazzemVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            if (i == 7 || i == 8) {
                AugmentedPastVerb verb = createVerb(root, i, formulaNo);
                result.add(verb);
            } else {
                result.add(null);
            }
        }
        return result;
    }

}
