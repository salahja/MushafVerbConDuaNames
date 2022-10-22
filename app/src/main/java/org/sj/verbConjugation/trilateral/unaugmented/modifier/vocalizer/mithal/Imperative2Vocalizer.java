package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.mithal;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.*;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;

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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new InfixSubstitution("اوْ","اي"));// EX: (ايجل، ايبأ، ايدد، ايئب )


    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 8 || kov == 9 || kov == 10 || kov == 11)  && noc == 4 ;
    }
}
