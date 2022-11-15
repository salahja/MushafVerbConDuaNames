package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiVocalizer;

import java.util.LinkedList;
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
public class ActivePresentAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private final List substitutions = new LinkedList();

    public ActivePresentAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ُ", "ِيC3ُ")); // EX: (يبيع، يقيء، يئين)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ِ", "ِيC3ِ")); // EX: (تبيعين، لن تبيعي، تقيئين، تئينين)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3َ", "ِيC3َ")); // EX: (تبيعان، لن يبيعا، تقيئان، تئينان)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ْ", "ِC3ْ")); // EX: (تَبِعْنَ، لم يَبِعْ، يَقِئْ، يَئِنْ)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ّ", "ِC3ّ")); // EX: (أنتن تَلِنَّ ، هن يَلِنَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
