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
public class ActivePastAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private final List substitutions = new LinkedList();

    public ActivePastAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ", "ِC3ْ"));// EX: (بِعْتُ، قِئتُ، إِنْتُ،)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ّ", "ِC3ّ"));// EX: (نحن لِنَّا، هن لِنَّ، أنا لِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ", "َاC3َ"));// EX: (باع، قاء، آن،)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ", "َاC3ُ"));// EX: (باعوا، قاؤوا، آنوا،)
    }

    /**
     * @return List
     * @todo Implement this
     * org.sj.verb.trilateral.Substitution.SubstitutionsApplier method
     */
    public List getSubstitutions() {
        return substitutions;
    }

}
