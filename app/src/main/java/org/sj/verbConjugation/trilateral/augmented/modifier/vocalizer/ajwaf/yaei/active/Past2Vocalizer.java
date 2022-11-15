package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Past2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ", "َC3ْ"));// EX: (انْهَلْتُ، اكتلتُ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ّ", "َC3ّ"));// EX: (اختَتّ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ", "َاC3َ"));// EX: (انْهالَ، اكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ", "َاC3ُ"));// EX: (انهالوا، اكتالوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return (kov == 20 && formulaNo == 4) || ((kov == 20 || kov == 18) && formulaNo == 5);
    }
}
