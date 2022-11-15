package org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.AbstractGeminator;
import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;

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
public class Geminator extends AbstractGeminator {
    List substitutions = new LinkedList();

    public Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("اC3ِC3", "اC3ّ"));// EX: (مادٌّ، مادًّا، مادٍّ، مادَّةٌ، مادُّون، مادِّينَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
