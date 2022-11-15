package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;
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
public class Past1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (رمى، أتى، سعى، نأى، أبى )
        substitutions.add(new InfixSubstitution("َيُوا", "َوْا"));// EX: (رَمَوْا، أتَوْا، سَعَوْا، نأوْا، أبَوْا)
        substitutions.add(new InfixSubstitution("َيَت", "َت"));// EX: (رَمَتْ، رَمَتَا، أتَتْ، أتَتَا، سَعَتْ، سَعَتَا، نَأتْ، نأتَا، أبَتْ، أبَتَا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 24 || kov == 25 || kov == 26) && (noc == 2 || noc == 3);
    }
}
