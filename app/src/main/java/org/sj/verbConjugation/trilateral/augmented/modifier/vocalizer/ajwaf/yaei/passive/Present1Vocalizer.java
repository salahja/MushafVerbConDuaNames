package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ","َاC3ُ"));// EX: (هو يُبادُ، يُستقال)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ِ","َاC3ِ"));// EX: (أنتِ تُبادِين، تُستقالين)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ","َاC3َ"));// EX: (أنتما تُبادان، تُستقالان)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ","َC3ْ"));// EX: (هنّ يُبَدْنَ، يُستَقَلْنَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 1) || ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 9);
    }
}
