package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Past1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ", "َC3ْ"));// EX: (أبَدْتُ، استقلتُ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ّ", "َC3ّ"));// EX: (أبَتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ", "َاC3َ"));// EX: (أبادَ، استقال)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ", "َاC3ُ"));// EX: (أبادُوا، استقالوا)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return ((kov == 19 || kov == 20) && formulaNo == 1) || ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 9);
    }
}
