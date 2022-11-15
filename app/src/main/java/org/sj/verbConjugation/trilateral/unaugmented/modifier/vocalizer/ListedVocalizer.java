package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer;

import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

import java.util.Iterator;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:كان  من  ضمنها  هذا  الجذر  أو  لا في حالات الاعلال يتم فحص قائمة من الجذور اذا
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class ListedVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public ListedVocalizer() {
    }

    /**
     * isApplied
     *
     * @param conjugationResult ConjugationResult
     * @return boolean
     * @todo Implement this
     * org.sj.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier
     * method
     */
    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (!root.getConjugation().equals(getNoc() + "")) return false;

        Iterator iter = getAppliedRoots().iterator();
        while (iter.hasNext()) {
            String appliedRoot = (String) iter.next();
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return true;
        }
        return false;
    }

    protected abstract List getAppliedRoots();

    protected abstract int getNoc();
}
