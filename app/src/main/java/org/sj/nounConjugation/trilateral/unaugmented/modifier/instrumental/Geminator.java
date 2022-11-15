package org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental;

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
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3", "َC3ّ"));// EX: (مِجَنّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC3ُC3", "ُC3ّ"));// EX: (مُدُقّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3ْC3", "َC3ّ"));// EX: (دَفَّة)
        substitutions.add(new ExpressionInfixSubstitution("ُC3ْC3", "ُC3ّ"));// EX: (جُرَّة)
        substitutions.add(new ExpressionInfixSubstitution("ِC3ْC3", "ِC3ّ"));// EX: (سِكَّة)
        substitutions.add(new ExpressionInfixSubstitution("اC3ِC3", "اC3ّ"));// EX: (مَاصَّة)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
