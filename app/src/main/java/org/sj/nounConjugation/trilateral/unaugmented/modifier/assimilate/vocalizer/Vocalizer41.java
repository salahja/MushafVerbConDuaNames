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
public class Vocalizer41 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer41() {
        substitutions.add(new SuffixSubstitution("ِوُ", "ِي")); // EX: (هذا الرَّضِي )
        substitutions.add(new SuffixSubstitution("ِوَ", "ِيَ")); // EX: (رأيتُ الرَّضِيَ )
        substitutions.add(new SuffixSubstitution("ِوِ", "ِي")); // EX: (مررت على الرَّضِي )
        substitutions.add(new InfixSubstitution("ِوٌ", "ٍ")); // EX: (هذا رَضٍ، )
        substitutions.add(new InfixSubstitution("ِوٍ", "ٍ")); // EX: (مررت على رَضٍ، )
        substitutions.add(new InfixSubstitution("ِوً", "ِيً")); // EX: (رأيت رَضِيًا، )
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (رَضِيان، رَضِيَةٌ، )
        substitutions.add(new InfixSubstitution("ِوُو", "ُو")); // EX: (رَضُونَ، )
        substitutions.add(new InfixSubstitution("ِوِي", "ِي")); // EX: (رَضِينَ )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return nounFormula.equals("فَعِل") && kov == 23 && noc == 4;
    }

}
