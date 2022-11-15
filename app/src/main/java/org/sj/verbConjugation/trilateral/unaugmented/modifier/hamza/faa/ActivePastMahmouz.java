package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.PrefixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.AbstractFaaMahmouz;

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
public class ActivePastMahmouz extends AbstractFaaMahmouz {
    private final List substitutions = new ArrayList();

    public ActivePastMahmouz() {
        substitutions.add(new PrefixSubstitution("ءَا", "آ")); // EX: (آبَ)
        substitutions.add(new InfixSubstitution("ءَ", "أَ")); // EX: (أكَلَ)
        substitutions.add(new InfixSubstitution("ءُ", "أُ")); // EX: (أُلْتُ من آل يؤول)
        substitutions.add(new PrefixSubstitution("ءِ", "إِ")); // EX: (إمْتُ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
