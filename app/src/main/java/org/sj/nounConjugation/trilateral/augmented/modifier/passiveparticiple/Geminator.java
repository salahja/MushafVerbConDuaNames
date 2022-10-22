package org.sj.nounConjugation.trilateral.augmented.modifier.passiveparticiple;

import java.util.*;


import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.geminator.*;
import org.sj.nounConjugation.trilateral.augmented.modifier.geminator.*;

import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
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
public class Geminator {
    private List modifiers = new LinkedList();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
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
