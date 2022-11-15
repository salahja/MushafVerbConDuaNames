package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.AbstractEinMahmouz;

import java.util.ArrayList;
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
public class PassivePastMahmouz extends AbstractEinMahmouz {
    private final List substitutions = new ArrayList();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("ُءِ", "ُئِ"));// EX: (سُئِلْتُ)
        substitutions.add(new InfixSubstitution("ُءُ", "ُؤُ"));// EX: (رُؤُوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
