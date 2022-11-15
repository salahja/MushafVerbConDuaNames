package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;
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
public class ActivePresentMahmouz extends AbstractEinMahmouz {
    private final List substitutions = new ArrayList();

    public ActivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("ْءُ", "ْؤُ")); // EX: (لم يَمْؤُ)
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ"));// EX: (يَيْئَس)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يَسْأَل)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (يَنْئِمُ، يَئِدُ)
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (يَضْؤُل)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أنتم تَؤُوا، هم يَؤُوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
