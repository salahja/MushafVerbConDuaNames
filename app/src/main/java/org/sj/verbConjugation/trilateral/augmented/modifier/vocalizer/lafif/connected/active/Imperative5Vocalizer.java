package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Imperative5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Imperative5Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (سَوِّ، احْوَوِّ)
        substitutions.add(new InfixSubstitution("ِّوِ", "ِّ")); // EX: (أنتِ سَوِّي، احْوَوِّي)
        substitutions.add(new InfixSubstitution("ِّوَ", "ِّيَ")); // EX: (أنتما سَوِّيا، احْوَوِّيا)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم سَوُّوا، احْوَوُّوا)
        substitutions.add(new InfixSubstitution("ِّوْ", "ِّي")); // EX: (أنتن سَوِّينَ، احْوَوِّينَ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' && kov == 28 && (formulaNo == 2 || formulaNo == 11);

    }
}
