package org.sj.nounConjugation.trilateral.augmented.modifier.passiveparticiple;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.nounConjugation.trilateral.augmented.modifier.passiveparticiple.hamza.*;
import org.sj.nounConjugation.trilateral.augmented.modifier.passiveparticiple.hamza.RaaEinMahmouz;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class Mahmouz {
    private List modifiers = new LinkedList();

    public Mahmouz() {
        modifiers.add(new RaaEinMahmouz());
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(MazeedConjugationResult conjResult) {
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
