package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafWawiListedVocalizer;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private final List substitutions = new LinkedList();

    public ImperativeAjwafWawiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوَC3ُ", "C1َاC3ُ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوَC3ِ", "C1َاC3ِ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوَC3َ", "C1َاC3َ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوَC3ْ", "C1َC3ْ"));

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
