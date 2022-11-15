package org.sj.verbConjugation.trilateral.unaugmented.modifier.geminator.generic;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

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
public class PassivePastGeminator extends SubstitutionsApplier {
    private final List substitutions = new LinkedList();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3َ", "C3َّ"));
        substitutions.add(new ExpressionInfixSubstitution("C3ِC3ُ", "C3ُّ"));
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
