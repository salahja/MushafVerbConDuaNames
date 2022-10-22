package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.*;
import org.sj.verbConjugation.trilateral.Substitution.*;

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
public class PassivePastMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("ءِ", "إِ")); // EX: (إيبَ، إِبْتُ)
        substitutions.add(new PrefixSubstitution("ءُ", "أُ")); // EX: (أُكِلَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
