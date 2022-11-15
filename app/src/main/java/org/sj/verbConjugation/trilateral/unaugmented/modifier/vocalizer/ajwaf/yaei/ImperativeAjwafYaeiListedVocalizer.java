package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiListedVocalizer;

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
public class ImperativeAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List substitutions = new LinkedList();

    public ImperativeAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ُ", "C1َاC3ُ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ِ", "C1َاC3ِ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3َ", "C1َاC3َ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ْ", "C1َC3ْ"));
    }

    public List getSubstitutions() {
        return substitutions;
    }


}
