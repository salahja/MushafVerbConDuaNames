package org.sj.nounConjugation.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

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
        substitutions.add(new InfixSubstitution("ِيٌ", "ٍ")); // EX: (هذا رامٍ)
        substitutions.add(new InfixSubstitution("ِيٍ", "ٍ")); // EX: (مررتُ على رامٍ)
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي")); // EX: (هذا الرامي، رامي السهم، )
        substitutions.add(new SuffixSubstitution("ِيَ", "ِيَ")); // EX: (رأيتُ الراميَ، راميَ السهم، )
        substitutions.add(new SuffixSubstitution("ِيِ", "ِي")); // EX: (مررتُ على الرامي، رامي السهم ، )
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (رامُونَ، )
        substitutions.add(new InfixSubstitution("ِيِ", "ِ")); // EX: (رامِينَ، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        switch (kov) {
            case 24:
            case 26:
                switch (noc) {
                    case 2:
                    case 3:
                    case 4:
                        return true;
                }
            case 25:
                return noc == 3 || noc == 4;
            case 27:
            case 29:
                return noc == 2;
            case 28:
                return noc == 2 || noc == 4;
            case 30:
                switch (noc) {
                    case 2:
                    case 4:
                    case 6:
                        return true;
                }

        }
        return false;
    }
}
