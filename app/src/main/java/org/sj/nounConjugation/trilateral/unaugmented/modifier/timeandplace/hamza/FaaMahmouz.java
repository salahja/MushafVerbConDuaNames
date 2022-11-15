package org.sj.nounConjugation.trilateral.unaugmented.modifier.timeandplace.hamza;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.AbstractFaaMahmouz;
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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ"));// EX: (مَأوى، مَأواة، )
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
