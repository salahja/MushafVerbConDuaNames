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
public class ActivePastMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public ActivePastMahmouz() {
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (سأل)
        substitutions.add(new InfixSubstitution("َءِ", "َئِ")); // EX: (سَئِمَ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (ضَؤُلَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
