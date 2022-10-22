package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present8Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present8Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (يُسَوِّي، يَحْوَوِّي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسَوِّ، لم يَحْوَوِّ)
        substitutions.add(new InfixSubstitution("وِّوِ", "وِّ")); // EX: (أنتِ تُسَوِّينَ، تَحْوَوِّينَ)
        substitutions.add(new InfixSubstitution("ِّوَ", "ِّيَ")); // EX: (أنتما تُسَوِّيانِ، تَحْوَوِّيانِ، لن يُسَوِّيَ، لن يَحْوَوِّيَ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم تُسَوُّونَ، تَحْوَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّوْ", "ِّي")); // EX: (أنتن تُسَوِّينَ، تَحْوَوِّينَ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == 28 && (formulaNo == 2 || formulaNo == 11);
    }
}
