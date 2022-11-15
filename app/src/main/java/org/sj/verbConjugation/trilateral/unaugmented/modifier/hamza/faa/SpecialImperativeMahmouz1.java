package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa;

import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.TrilateralRoot;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

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
public class SpecialImperativeMahmouz1 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public SpecialImperativeMahmouz1() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'ء' && root.getC2() == 'خ' && root.getC3() == 'ذ' && root.getConjugation().equals("1");
    }

    /**
     * override this method to return the custom list
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "خُذْ");
        words.set(3, "خُذِي");
        words.set(4, "خُذَا");
        words.set(5, "خُذُوا");
        words.set(6, "خُذْنَ");
    }
}
