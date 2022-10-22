package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   
public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past3Vocalizer() {
        substitutions.add(new InfixSubstitution("وْ", "ي")); // EX: (أنا ارعُوِيتُ)
        substitutions.add(new InfixSubstitution("وَّ", "وِيَ")); // EX: (هو ارْعُوِيَ)
        substitutions.add(new InfixSubstitution("وُّ", "وُ")); // EX: (هم ارْعُوُوا)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return kov == 23 && formulaNo == 6;
    }
}
