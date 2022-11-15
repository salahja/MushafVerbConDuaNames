package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

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
public class SpecialEmphsizedImperativeMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public SpecialEmphsizedImperativeMahmouz() {
    }

    public List getSubstitutions() {
        return null;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'س' && root.getC2() == 'ء' && root.getC3() == 'ل';
    }

    /**
     * override this method to return the custom list
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    public void apply(List words, TrilateralRoot root) {
        words.set(2, "سَلَنَّ/اسْألَنَّ");
        words.set(3, "سَلِنَّ/اسْألِنَّ");
        words.set(4, "سَلاَنِّ/اسْألاَنِّ");
        words.set(5, "سَلُنَّ/اسْألُنَّ");
        words.set(6, "سَلْنَانِّ/اسْألْنَانِّ");
    }
}
