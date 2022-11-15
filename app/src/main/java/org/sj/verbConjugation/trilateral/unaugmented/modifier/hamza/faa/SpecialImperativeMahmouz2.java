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
public class SpecialImperativeMahmouz2 extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public SpecialImperativeMahmouz2() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'ء' && root.getC2() == 'ك' && root.getC3() == 'ل' && root.getConjugation().equals("1");
    }

    /**
     * override this method to return the custom list
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "كُلْ");
        words.set(3, "كُلِي");
        words.set(4, "كُلاَ");
        words.set(5, "كُلُوا");
        words.set(6, "كُلْنَ");
    }
}
