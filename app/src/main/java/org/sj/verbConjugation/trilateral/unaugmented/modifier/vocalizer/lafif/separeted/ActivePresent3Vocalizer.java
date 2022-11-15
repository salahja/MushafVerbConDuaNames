package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

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
public class ActivePresent3Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    public ActivePresent3Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى"));// EX: (يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (لن يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيْ", "َ"));// EX: (لم يَوْجَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ"));// EX: (أنتِ تَوْجَيْنَ)
        substitutions.add(new InfixSubstitution("َيُو", "َوْ"));// EX: (أنتم تَوْجَوْنَ)
        substitutions.add(new InfixSubstitution("َيُن", "َوُن"));// EX: (أنتم تَوْجَوُنَّ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 30 && noc == 4);
    }
}
