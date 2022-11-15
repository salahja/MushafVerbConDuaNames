package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.ExpressionSuffixSubstitution;
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
public class YaeiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    public YaeiPassivePresentVocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيُ", "وC2َى")); // EX: (يُودَى)
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيَ", "وC2َى")); // EX: (لن يُودَى)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيَ", "وC2َيَ"));// EX: (يُودَيانِ)
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيْ", "وC2َ")); // EX: (لم يُودَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيْ", "وC2َيْ"));// EX: (يُودَيْنَانِّ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيِي", "وC2َيْ")); // EX: (أنتِ تُودَيْنَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيُو", "وC2َوْ")); // EX: (أنتم تُودَوْنَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيُن", "وC2َوُن")); // EX: (أنتم تُودَوُنَّ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'ي') {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && (noc == 6 || noc == 4));
    }
}
