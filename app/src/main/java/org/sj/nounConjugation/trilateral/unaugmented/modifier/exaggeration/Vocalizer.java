package org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.AVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.B1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.B2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.C1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.C2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.C3Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.I1Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.I2Vocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer.JVocalizer;
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
        modifiers.add(new AVocalizer());
        modifiers.add(new B1Vocalizer());
        modifiers.add(new B2Vocalizer());
        modifiers.add(new C1Vocalizer());
        modifiers.add(new C2Vocalizer());
        modifiers.add(new C3Vocalizer());
        modifiers.add(new I1Vocalizer());
        modifiers.add(new I2Vocalizer());
        modifiers.add(new JVocalizer());

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
