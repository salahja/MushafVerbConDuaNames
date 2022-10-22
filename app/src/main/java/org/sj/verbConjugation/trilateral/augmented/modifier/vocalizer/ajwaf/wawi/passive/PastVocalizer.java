package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ْ", "ِC3ْ")); // EX: (أُقِمْتُ، استدرتُ،)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ّ", "ِC3ّ")); // EX: (أُمِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3َ", "ِيC3َ")); // EX: (أُقِيمَ، استُدِير،)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ُ", "ِيC3ُ")); // EX: (أُقِيمُوا، استُدِيروا،)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ْ", "ِC3ْ")); // EX: (انْقِدْتُ، اقْتِدْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ّ", "ِC3ّ")); // EX: (اختِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3َ", "ِيC3َ")); // EX: (انقِيدَ، اقْتِيدَ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ُ", "ِيC3ُ")); // EX: (انقِيدُوا، اقتِيدُوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return ((kov == 16 || kov == 17) && formulaNo == 1) ||
                ((kov == 15 || kov == 17) && formulaNo == 4) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 9);
    }
}
