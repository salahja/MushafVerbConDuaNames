package org.sj.nounConjugation.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import org.sj.nounConjugation.TrilateralNounSubstitutionApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;

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
public class B2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public B2Vocalizer() {
        substitutions.add(new InfixSubstitution("ُوي", "ِيّ"));// EX: (جَنِيّ، قَوِيّ، وَفِيّ )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("فَعُول")) {
            return false;
        }
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
