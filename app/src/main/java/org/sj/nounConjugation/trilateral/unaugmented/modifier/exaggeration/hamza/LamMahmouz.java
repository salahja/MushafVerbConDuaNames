package org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.hamza;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.*;

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
        substitutions.add(new InfixSubstitution("اءًا","اءً"));// EX: (بدّاءً،  )
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (البدّاءُ )
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (البدّاءِ )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (بدّاؤون )
        substitutions.add(new InfixSubstitution("اءِ","ائِ"));// EX: (بدّائِين )
        substitutions.add(new InfixSubstitution("َءَة","َأَة"));// EX: (هُزَأَة )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
