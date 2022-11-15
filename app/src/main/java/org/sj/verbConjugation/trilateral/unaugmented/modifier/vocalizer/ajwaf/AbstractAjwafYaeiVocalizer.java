package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: طريقة الفحص المشتركة للأجوف اليائي الماضي والمضارع والأمر         </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafYaeiVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractAjwafYaeiVocalizer() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        // تطبيق القانون العام للفحص
        return (conjugationResult.getRoot().getConjugation().equals("2")) &&
                (conjugationResult.getKov() == 18 || conjugationResult.getKov() == 19 || conjugationResult.getKov() == 20);
    }

}
