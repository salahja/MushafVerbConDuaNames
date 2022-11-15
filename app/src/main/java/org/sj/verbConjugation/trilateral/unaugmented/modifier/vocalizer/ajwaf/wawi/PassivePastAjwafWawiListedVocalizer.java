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
public class PassivePastAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private final List substitutions = new LinkedList();

    public PassivePastAjwafWawiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ْ", "ُC3ْ"));// EX: ( بُهْتُ، دُئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3َ", "ِيC3َ"));// EX: (بِيه، دِيء)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ُ", "ِيC3ُ"));// EX: (بِيهوا، دِيئوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
