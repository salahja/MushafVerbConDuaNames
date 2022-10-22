package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

   

public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ُ", "ِيC3ُ")); // EX: (أنتم أقيموا، استديروا)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ِ", "ِيC3ِ")); // EX: (أنتِ أقيمي، استديري)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3َ", "ِيC3َ")); // EX: (أنتما أقيما، استديرا)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ْ", "ِC3ْ")); // EX: (أنتن أقِمْنَ، استدرْنَ)
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
