package org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple;

import java.util.*;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.hamza.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;

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
    private LamMahmouz lamMahmouz = new LamMahmouz();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(lamMahmouz);
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
        //خصيصا للفعل أثأ
        if (conjResult.getRoot().getC1() == 'ء' && conjResult.getRoot().getC3() == 'ء') {
            lamMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }

    }
}
