package org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.hamza;

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
        substitutions.add(new InfixSubstitution("َءَّا", "َآَّ"));// EX: (سآَّل)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ"));// EX: (سَؤُول)
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ"));// EX: (سُؤَلَة)
        substitutions.add(new InfixSubstitution("َءِ", "َئِ"));// EX: (سَئِمٌ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
