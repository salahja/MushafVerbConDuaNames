package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.*;

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
public class RaaPresentMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List substitutions = new ArrayList();

    public RaaPresentMahmouz() {
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (يَرَى)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        TrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
