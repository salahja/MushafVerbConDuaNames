package org.sj.nounConjugation.trilateral.unaugmented.modifier.passiveparticiple.vocalizer;

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
public class WawiLafifNakes1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public WawiLafifNakes1Vocalizer() {
        substitutions.add(new InfixSubstitution("ُوو", "ُوّ")); // EX: (مأسُوّ، مَغْزُوّ، مَسْرُوّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        switch (kov) {
            case 21:
                return noc == 1 || noc == 5;
            case 22:
                return noc == 1 || noc == 3;
            case 23:
                switch (noc) {
                    case 1:
                    case 3:
                    case 5:
                        return true;
                }
        }
        return false;
    }
}
