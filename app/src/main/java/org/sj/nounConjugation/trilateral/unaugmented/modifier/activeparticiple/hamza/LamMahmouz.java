package org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.hamza;

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
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (ظَامِئ)
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (باؤون )
        substitutions.add(new InfixSubstitution("ِآ","ِئَا"));// EX: (آثِئان)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
