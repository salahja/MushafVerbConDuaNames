package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Vocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ","َC3ْ"));// EX: (انْهَلْتُ، اكتلتُ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ّ","َC3ّ"));// EX: (اختَتّ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ","َاC3َ"));// EX: (انْهالَ، اكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ","َاC3ُ"));// EX: (انهالوا، اكتالوا)

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
