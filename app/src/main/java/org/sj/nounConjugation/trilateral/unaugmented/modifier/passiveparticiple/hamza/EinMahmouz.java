package org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.AbstractEinMahmouz;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;

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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("وْءُ", "وْءُ")); // EX: (مَوْءُود)
        substitutions.add(new InfixSubstitution("يْءُ", "يْئُ")); // EX: (مَيْئُوس)
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (مَسْؤُول)
        substitutions.add(new InfixSubstitution("ْءِ", "ْئِ")); // EX: (مَرْئِيّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
