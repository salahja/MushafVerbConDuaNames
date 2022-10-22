package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present7Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present7Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (يُسْوِي، يُساوِي، تنغوي، يستوي، يستغوي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسْوِ، لم يُساوِ، لم ينغوِ، لم يَستوِ، لم يستغوِ)
        substitutions.add(new InfixSubstitution("وِوِ", "وِ")); // EX: (أنتِ تُسْوِينَ، تُساوِينَ، تنغوين، تستوين، تستغوين)
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (أنتما تُسْوِيَانِ، تُساوِيانِ، تنغويان، تستويان، تستغويان)
        substitutions.add(new InfixSubstitution("ِوُ", "ُ")); // EX: (أنتم تُسْوُونَ، تُساوُونَ، تنغوُونَ، تستوُونَ، تستغوون)
        substitutions.add(new InfixSubstitution("ِوْ", "ِي")); // EX: (أنتن تُسْوِينَ، تُساوِينَ، تنغوين، تستوين، تستغوين)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'و' && kov == 28) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;
    }
}
