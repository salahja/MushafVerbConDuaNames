package org.sj.nounConjugation.trilateral.unaugmented.modifier.elative.hamza;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.AbstractLamMahmouz;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;

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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ"));// EX: (هو الأجرأُ، )
        substitutions.add(new SuffixSubstitution("َءِ", "َأِ"));// EX: (كالأجرأِ، )
        substitutions.add(new InfixSubstitution("وْءَ", "وءَ"));// EX: (السُّوءَى، )
        substitutions.add(new InfixSubstitution("َءَا", "َآ"));// EX: (الأجرآن، )
        substitutions.add(new InfixSubstitution("َءُو", "َؤُو"));// EX: (الأجرؤون، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ"));// EX: (رأيتُ الأجرأَ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ"));// EX: (الجُرْأَى، )
        substitutions.add(new InfixSubstitution("َءِ", "َئِ"));// EX: (الأجرئِينَ، )
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
