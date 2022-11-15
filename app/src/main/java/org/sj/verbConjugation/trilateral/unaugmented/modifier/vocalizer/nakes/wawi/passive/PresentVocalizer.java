package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.passive;

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

        substitutions.add(new SuffixSubstitution("َوُ", "َى"));// EX: (يُغْزَى، يُزهى، يُرضَى، يُسْرَى)
        substitutions.add(new SuffixSubstitution("َوَ", "َى"));// EX: (لن يُغزى )
        substitutions.add(new SuffixSubstitution("َوْ", "َ"));// EX: (لم يُغْزَ)
        substitutions.add(new InfixSubstitution("َوَا", "َيَا"));// EX: (يُغزيان )
        substitutions.add(new InfixSubstitution("َوِي", "َيْ"));// EX: (أنتِ تُغْزَيْنَ )
        substitutions.add(new InfixSubstitution("َوَن", "َيَن"));// EX: (هو يُغْزَيَنَّ، يُزْهَيَنَّ)
        substitutions.add(new InfixSubstitution("َوِن", "َيِن"));// EX: (أنتِ تُغْزَيِنَّ)
        substitutions.add(new InfixSubstitution("َوْن", "َيْن"));// EX: (أنتن تُغْزَيْنَ)
        substitutions.add(new InfixSubstitution("َوُو", "َوْ"));// EX: (أنتم تُغْزَوْنَ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 21 || kov == 22 || kov == 23) && (noc == 1)) ||
                ((kov == 21 || kov == 23) && (noc == 5)) ||
                ((kov == 22 || kov == 23) && (noc == 3)) ||
                (kov == 23 && noc == 4);
    }
}
