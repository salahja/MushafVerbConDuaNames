package org.sj.nounConjugation.trilateral.unaugmented.modifier.assimilate.vocalizer;

import org.sj.nounConjugation.TrilateralNounSubstitutionApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
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
public class Vocalizer1 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer1() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (هذا الأعمى، )
        substitutions.add(new SuffixSubstitution("ِيَ", "َى")); // EX: (رأيتُ الأعمى ، )
        substitutions.add(new SuffixSubstitution("ِيِ", "َى")); // EX: (مررتُ على الأعمى ، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return nounFormula.equals("أفعل") && (kov == 25 || kov == 26) && noc == 4;
    }

}
