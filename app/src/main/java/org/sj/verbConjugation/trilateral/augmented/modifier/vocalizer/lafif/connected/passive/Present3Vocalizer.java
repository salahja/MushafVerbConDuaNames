package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.Substitution.SuffixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.LinkedList;
import java.util.List;

public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (يُسْوَى، يُسَوَّى، يُساوَى، يُنْغَوَى، يُسْتَوَى، يُتَساوَى، يُتَسَوَّى، يُسْتَسْوَى، يُحْوَوَّى)
        substitutions.add(new SuffixSubstitution("َوَ", "َى"));// EX: (لن يُسْوَى، يُسَوَّى، يُساوَى، يُنْغَوَى، يُسْتَوَى، يُتَساوَى، يُتَسَوَّى، يُسْتَسْوَى، يُحْوَوَّى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسْوَ، يُسَوَّ، يُساوَ، يُنْغَوَ، يُسْتَوَ، يُتَساوَ، يُتَسَوَّ، يُسْتَسْوَ، يُحْوَوَّ)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تُسْوَيانِ، تُسَوَّيان، تُساوَيان، تُنْغَوَيان، تُسْتَوَيان، تُتَساوَيان، تُتَسَوَّيان، تُسْتَسْوَيان، تُحْوَوَّيان)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تُسْوَيْنَ، تُسَوَّيْنَ، تُساوَيْنَ، تُنْغَوَيْنَ، تُسْتَوَيْنَ، تُتَساوَيْنَ، تُتَسَوَّيْنَ، تُسْتَسْوَيْنَ، تُحْوَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تُسْوَيِنَّ، تُسَوَّيِنَّ، تُساوَيِنَّ، تُنْغَوَيِنَّ، تُسْتَوَيِنَّ، تُتَساوَيِنَّ، تُتَسَوَّيِنَّ، تُسْتَسْوَيِنَّ، تُحْوَوَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تُسْوَوْنَ، تُسَوَّوْنَ، تُساوَوْنَ، تُنْغَوَوْنَ، تُسْتَوَوْنَ، تُتَساوَوْنَ، تُتَسَوَّوْنَ، تُسْتَسْوَوْنَ، تُحْوَوَّوْنَ)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تُسْوَيْنَ، تُسَوَّيْنَ، تُساوَيْنَ، تُنْغَوَيْنَ، تُسْتَوَيْنَ، تُتَساوَيْنَ، تُتَسَوَّيْنَ، تُسْتَسْوَيْنَ، تُحْوَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (تُسْوَيَنَّ، تُسَوَّيَنَّ، تُساوَيَنَّ، تُنْغَوَيَنَّ، تُسْتَوَيَنَّ، تُتَساوَيَنَّ، تُتَسَوَّيَنَّ، تُسْتَسْوَيَنَّ، تُحْوَوَّيَنَّ)

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
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 11:
                    return true;
            }
        }
        return false;
    }
}
