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
public class Ajwaf4Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Ajwaf4Vocalizer() {
        substitutions.add(new InfixSubstitution("ايِءٌ", "اءٍ"));// EX: (هذا جاءٍ)
        substitutions.add(new InfixSubstitution("ايِءٍ", "اءٍ"));// EX: (مررتُ على جاءٍ)
        substitutions.add(new SuffixSubstitution("ايِءُ", "ائِي"));// EX: (هذا الجائِي، )
        substitutions.add(new SuffixSubstitution("ايِءِ", "ائِي"));// EX: (مررتُ على الجائِي )
        substitutions.add(new InfixSubstitution("ايِءُ", "اؤُ"));// EX: (جاؤُونَ، )
        substitutions.add(new InfixSubstitution("ايِءِ", "ائِ"));// EX: (جائِينَ، )
        substitutions.add(new InfixSubstitution("ايِء", "ائِي"));// EX: (جائيان، جائيَيْن، جائية، جائيًا، رأيتُ الجائِيَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return kov == 19 && (noc == 2 || noc == 4);
    }
}
