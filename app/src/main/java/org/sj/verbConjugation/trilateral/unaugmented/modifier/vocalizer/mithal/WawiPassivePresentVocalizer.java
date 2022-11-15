package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.mithal;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

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
public class WawiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    public WawiPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو"));// EX: (يُوعَدُ، يُوهَبُ، يُورَثُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 9 && noc == 2) ||
                (kov == 10 && (noc == 3 || noc == 4 || noc == 5)) ||
                (kov == 11 && (noc == 2 || noc == 3 || noc == 4 || noc == 5));
    }
}
