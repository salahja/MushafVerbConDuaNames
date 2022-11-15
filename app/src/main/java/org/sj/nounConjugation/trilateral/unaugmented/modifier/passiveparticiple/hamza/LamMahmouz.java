package org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.hamza;

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
        substitutions.add(new SuffixSubstitution("ُوءِ", "ُوءِ"));// EX: (المَبْدُوءِ )
        substitutions.add(new InfixSubstitution("ُوءِ", "ُوئِ"));// EX: (مَبْدُوئِينَ )
        substitutions.add(new SuffixSubstitution("ِيءَ", "ِيءَ"));// EX: (المَقِيءَ )
        substitutions.add(new SuffixSubstitution("ِيءُ", "ِيءُ"));// EX: (المَقِيءُ )
        substitutions.add(new SuffixSubstitution("ِيءِ", "ِيءِ"));// EX: (المَقِيءِ )
        substitutions.add(new InfixSubstitution("ِيءٌ", "ِيءٌ"));// EX: (مَقِيءٌ )
        substitutions.add(new InfixSubstitution("ِيءٍ", "ِيءٍ"));// EX: (مَقِيءٍ )
        substitutions.add(new InfixSubstitution("ِيء", "ِيئ"));// EX: (مَقِيئَةٌ )

    }

    public List getSubstitutions() {
        return substitutions;
    }

}
