package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza;

import org.sj.verbConjugation.trilateral.unaugmented.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب المشترك لمهموز اللام حسب شرط الفحص المشترك للمضارع والأمر والماضي           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractLamMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractLamMahmouz() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        switch (kov) {
        case 4:
        case 7:
        case 10:
        case 16:
        case 19:
            return true;
        }
        return false;
    }
}
