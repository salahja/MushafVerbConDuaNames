package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ", "َاC3ُ"));// EX: (هو يُنهال، يُكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ِ", "َاC3ِ"));// EX: (أنتِ تُنهالين، تُكتالين)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ", "َاC3َ"));// EX: (أنتما تُنهالان، تُكتالان)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ", "َC3ْ"));// EX: (هنّ يُنْهَلْنَ، يُكْتَلْنَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        return (kov == 20 && formulaNo == 4) || ((kov == 18 || kov == 20) && formulaNo == 5);
    }
}
