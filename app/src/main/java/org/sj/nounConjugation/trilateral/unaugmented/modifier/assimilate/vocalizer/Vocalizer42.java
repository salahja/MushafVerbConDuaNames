package org.sj.nounConjugation.trilateral.unaugmented.modifier.assimilate.vocalizer;

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
public class Vocalizer42 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer42() {
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي"));// EX: (هذا الصّدِي )
        substitutions.add(new SuffixSubstitution("ِيَ", "ِيَ"));// EX: (رأيتُ الصّدِيَ)
        substitutions.add(new SuffixSubstitution("ِيِ", "ِي"));// EX: (مررت على الصّدِي)
        substitutions.add(new InfixSubstitution("ِيٌ", "ٍ"));// EX: (هذا صَدٍ، )
        substitutions.add(new InfixSubstitution("ِيٍ", "ٍ"));// EX: (مررت على صَدٍ، )
        substitutions.add(new InfixSubstitution("ِيُو", "ُو"));// EX: (صَدُونَ، )
        substitutions.add(new InfixSubstitution("ِيِي", "ِي"));// EX: (صَدِينَ )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return nounFormula.equals("فَعِل") && (kov == 24 || kov == 26 || kov == 28) && noc == 4;
    }

}
