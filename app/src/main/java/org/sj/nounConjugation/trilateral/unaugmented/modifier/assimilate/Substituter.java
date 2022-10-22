package org.sj.nounConjugation.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import org.sj.nounConjugation.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.*;

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
public class Substituter extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Substituter() {
        substitutions.add(new InfixSubstitution("اءَا","اوَا"));// EX: (عَمْياوان)
        substitutions.add(new InfixSubstitution("اءَي","اوَي"));// EX: (عَمْياوين)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getNounFormula().equals("فَعْلان"))
            return true;
        return false;
    }
}
