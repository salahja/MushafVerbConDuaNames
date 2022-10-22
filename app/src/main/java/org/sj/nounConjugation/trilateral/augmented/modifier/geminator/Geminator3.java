package org.sj.nounConjugation.trilateral.augmented.modifier.geminator;

import java.util.*;

import org.sj.nounConjugation.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;


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
public class Geminator3 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();
    public Geminator3() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (مُتَّبِعٌ، مُتَّئِمٌ)
    }


    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return mazeedConjugationResult.getRoot().getC1() == 'ت' && (kov == 1 || kov == 6) && formulaNo == 5;
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
