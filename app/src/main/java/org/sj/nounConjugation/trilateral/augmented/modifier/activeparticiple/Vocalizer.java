package org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple;

import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.Ajwaf1Vocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.Ajwaf2Vocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.Mithal1Vocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.Mithal2Vocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.PreSeparatedLafifVocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.WawiNakesLafifVocalizer;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer.YaeiNakesLafifVocalizer;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
    private final PreSeparatedLafifVocalizer preSeparatedLafifVocalizer = new PreSeparatedLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new Mithal1Vocalizer());
        modifiers.add(new Mithal2Vocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(MazeedConjugationResult conjResult) {
        if (preSeparatedLafifVocalizer.isApplied(conjResult))
            preSeparatedLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
