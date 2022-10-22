package org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein;

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
public class PassivePresentMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public PassivePresentMahmouz() {
        substitutions.add(new InfixSubstitution("يْءَ","ْئَ"));// EX: (يُيْئَس)
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (يُسْأَل، يُنْأَم، يُضْأَل)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
