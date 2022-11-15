package org.sj.verbConjugation.trilateral.augmented.active.present;

import org.sj.verbConjugation.trilateral.augmented.AugmentedPresentVerb;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.AugmentationFormula;
import org.sj.verbConjugation.util.PresentConjugationDataContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AbstractAugmentedPresentConjugator {
    private final List lastDprList;
    private final List connectedPronounList;

    public AbstractAugmentedPresentConjugator(List lastDprList, List connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    public AugmentedPresentVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getInstance().getCp(pronounIndex);
        String lastDpr = (String) lastDprList.get(pronounIndex);
        String connectedPronoun = (String) connectedPronounList.get(pronounIndex);
        String formulaClassName = getClass().getPackage().getName() + ".formula." + "AugmentedPresentVerb" + formulaNo;
        Object[] parameters = {root, cp, lastDpr, connectedPronoun};
        try {
            AugmentedPresentVerb verb = (AugmentedPresentVerb) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return verb;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            AugmentedPresentVerb verb = createVerb(root, i, formulaNo);
            result.add(verb);
        }
        return result;
    }

    public Map createAllVerbList(AugmentedTrilateralRoot root) {
        Map result = new HashMap();
        Iterator iter = root.getAugmentationList().iterator();
        while (iter.hasNext()) {
            AugmentationFormula formula = (AugmentationFormula) iter.next();
            List formulaVerbList = createVerbList(root, formula.getFormulaNo());
            result.put(formula.getFormulaNo() + "", formulaVerbList);
        }
        return result;
    }

}
