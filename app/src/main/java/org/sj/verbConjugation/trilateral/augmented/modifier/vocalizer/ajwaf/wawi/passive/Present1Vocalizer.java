package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();
    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ُ", "َاC3ُ")); // EX: (هو يُقام، يُستدار)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ِ", "َاC3ِ")); // EX: (أنتِ تُقَامِينَ، تُستدارين)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3َ", "َاC3َ")); // EX: (أنتما تُقَامان، تُستداران)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ْ", "َC3ْ")); // EX: (هنّ يُقَمْنَ، يُستَدَرْنَ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return ((kov == 16 || kov == 17) && formulaNo == 1) || ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 9);
    }
}
