package org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.Ajwaf1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.Ajwaf2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.WawiLafifNakes1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.WawiLafifNakes2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.YaeiLafifNakesVocalizer;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Vocalizer {
    private final List modifiers = new LinkedList();

    public Vocalizer() {
        modifiers.add(new WawiLafifNakes1Vocalizer());
        modifiers.add(new WawiLafifNakes2Vocalizer());
        modifiers.add(new YaeiLafifNakesVocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
