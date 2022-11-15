package org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental.hamza;

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
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ"));// EX: (المِقْرأُ)
        substitutions.add(new SuffixSubstitution("َءِ", "َأِ"));// EX: (المِقْرأِ)
        substitutions.add(new InfixSubstitution("اءًا", "اءً"));// EX: (مئثاءً)
        substitutions.add(new InfixSubstitution("َءٌ", "َأٌ")); // EX: (مِفْقَأٌ)
        substitutions.add(new InfixSubstitution("َءًا", "َأً")); // EX: (مِفْقَأً)
        substitutions.add(new InfixSubstitution("َءٍ", "َأٍ")); // EX: (مِفْقَأٍ)
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مِفْقآن)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مِفقأيْن، مِفقأة، مِفقأتان)
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (قارئة)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
