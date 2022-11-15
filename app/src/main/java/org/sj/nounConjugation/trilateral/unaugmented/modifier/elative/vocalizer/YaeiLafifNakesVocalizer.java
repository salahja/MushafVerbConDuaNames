package org.sj.nounConjugation.trilateral.unaugmented.modifier.elative.vocalizer;

import org.sj.nounConjugation.TrilateralNounSubstitutionApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;

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
public class YaeiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى"));// EX: (هذا الأهدى، )
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (رأيتُ الأهدى، )
        substitutions.add(new SuffixSubstitution("َيِ", "َى"));// EX: (مررتُ على الأهدى، )
        substitutions.add(new InfixSubstitution("َيُو", "َوْ"));// EX: (الأهدَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ"));// EX: (الأهدَيْنَ)
        substitutions.add(new InfixSubstitution("ْيَى", "ْيَا"));// EX: (الهديا)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        switch (kov) {
            case 26:
                switch (noc) {
                    case 2:
                    case 3:
                    case 4:
                        return true;
                }
            case 28:
                return noc == 2 || noc == 4;
        }
        return false;
    }
}
