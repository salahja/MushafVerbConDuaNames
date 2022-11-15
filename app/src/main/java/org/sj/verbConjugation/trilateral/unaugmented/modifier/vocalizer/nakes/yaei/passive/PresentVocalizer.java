package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive;

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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى"));// EX: (يُرْمَى، يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (لن يُرْمَى، يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيْ", "َ"));// EX: (لم يُرمَ، يسعَ، يخشَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ"));// EX: (أنتِ تُرمَيْنَ، تسعَيْنَ، تخشين )
        substitutions.add(new InfixSubstitution("َيُو", "َوْ"));// EX: (أنتم تُرمَوْنَ، تسعَوْنَ، تخشون )
        substitutions.add(new InfixSubstitution("َيُن", "َوُن"));// EX: (أنتم تُرمَوُنَّ، تُسعَوُنَّ، تُخشوُنَّ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 24 || kov == 26) && (noc == 2)) ||
                ((kov == 24 || kov == 25 || kov == 26) && (noc == 3 || noc == 4));
    }
}
