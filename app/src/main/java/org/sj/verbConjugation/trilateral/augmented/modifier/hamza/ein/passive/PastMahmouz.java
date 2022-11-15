package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.AbstractEinMahmouz;

import java.util.LinkedList;
import java.util.List;

public class PastMahmouz extends AbstractEinMahmouz {
    private final List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أُسْئِمَ، لُوئِمَ، انْذُئِجَ، ابتُئِسَ، تُسُوئِلَ، استُرئِفَ، اتُّئِدَ، )
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (اجْؤُلَّ، )
        substitutions.add(new InfixSubstitution("ُءُ", "ُؤُ"));// EX: (ارتُؤُوا، )
        substitutions.add(new InfixSubstitution("ُءِّ", "ُئِّ")); // EX: (رُئِّسَ، تُرُئِّفَ، )
        substitutions.add(new InfixSubstitution("ُءُّ", "ُؤُّ")); // EX: (رُؤُّوا، )
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
