package org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf3WawiListedVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf3WawiVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf3YaeiListedVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf3YaeiVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.Ajwaf4Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.WawiLafifNakesVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer.YaeiLafifNakesVocalizer;
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
        modifiers.add(new WawiLafifNakesVocalizer());
        modifiers.add(new YaeiLafifNakesVocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new Ajwaf3WawiVocalizer());
        modifiers.add(new Ajwaf3WawiListedVocalizer());
        modifiers.add(new Ajwaf3YaeiVocalizer());
        modifiers.add(new Ajwaf3YaeiListedVocalizer());
        modifiers.add(new Ajwaf4Vocalizer());
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
