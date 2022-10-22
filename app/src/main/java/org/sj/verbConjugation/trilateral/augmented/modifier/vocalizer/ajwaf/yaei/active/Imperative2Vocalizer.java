package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ُ","َاC3ُ"));// EX: (انتم انهالوا، اكتالوا)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ِ","َاC3ِ"));// EX: (أنتِ انهالي، اكتالي)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3َ","َاC3َ"));// EX: (أنتما انهالا، اكتالا)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ْ","َC3ْ"));// EX: (أنتن انْهَلْنَ، اكْتَلْنَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return (kov == 20  && formulaNo == 4) || ((kov == 20 || kov == 18) && formulaNo == 5);
    }
}
