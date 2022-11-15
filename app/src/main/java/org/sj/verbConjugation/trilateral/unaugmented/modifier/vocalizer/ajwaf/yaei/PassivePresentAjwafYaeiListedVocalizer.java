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
public class PassivePresentAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List substitutions = new LinkedList();

    public PassivePresentAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ", "َاC3ُ"));// EX: (يُباع، يُبات، لن تُباتوا)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ِ", "َاC3ِ"));// EX: (تُباعِينَ، تُباتين، لن تُباتي )
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ", "َاC3َ"));// EX: (تُباعان، تُباتان، لن يُباتَ، يُباتَنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ", "َC3ْ"));// EX: (يُبَعْنَ، يُبَتْنَ، لم تُبَتْ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ّ", "َC3ّ"));// EX: (أنتن تُلَنَّ، هن يُلَنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }


}
