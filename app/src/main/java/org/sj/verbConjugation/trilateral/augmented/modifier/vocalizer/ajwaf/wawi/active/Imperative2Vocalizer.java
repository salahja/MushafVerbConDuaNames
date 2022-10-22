package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;



public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ُ","َاC3ُ"));// EX: (أنتم انقادوا، اقتادوا)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ِ","َاC3ِ"));// EX: (أنتِ انقادي، اقتادي)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3َ","َاC3َ"));// EX: (أنتما انقادا، اقتادا)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ْ","َC3ْ"));// EX: (أنتن انقدن، اقتدن)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return ((kov == 15 || kov == 17) && formulaNo == 4) || ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5);
    }
}
