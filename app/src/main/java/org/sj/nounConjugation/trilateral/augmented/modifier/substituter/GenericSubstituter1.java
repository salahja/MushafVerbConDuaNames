package org.sj.nounConjugation.trilateral.augmented.modifier.substituter;

import java.util.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.nounConjugation.trilateral.augmented.modifier.AbstractGenericSubstituter;
import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;

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
public class GenericSubstituter1 extends AbstractGenericSubstituter {
    private List substitutions = new LinkedList();

    public GenericSubstituter1() {
        substitutions.add(new InfixSubstitution("ثْت","ثّ"));// EX: (اثِّمادٌ،)
    }

    public List getSubstitutions() {
        return substitutions;
    }
    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'ث' && super.isApplied(mazeedConjugationResult);
    }
}
