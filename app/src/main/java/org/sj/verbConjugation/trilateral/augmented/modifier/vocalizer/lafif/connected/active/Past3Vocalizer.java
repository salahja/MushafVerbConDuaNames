package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past3Vocalizer() {

        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (أسوَى، سَوَّى ساوَى، انغوى، استوى، تساوى، تَسَوَّى استغوى احْوَوَّى)
        substitutions.add(new InfixSubstitution("وْ","يْ"));// EX: (أسْوَيْتُ، سَوَّيْتُ ساوَيْتُ، انغويتُ، استوَيْتُ، تساويتُ، تسوَّيْتُ استغوَيْتُ احوَوَّيْتُ)
        substitutions.add(new InfixSubstitution("وَا","يَا"));// EX: (أسْوَيَا، سَوَّيا ساوَيا، انغويا، استوَيا، تساوَيَا، تَسَوَّيَا، استغوَيَا، احْوَوَّيَا)
        substitutions.add(new InfixSubstitution("وُو","وْ"));// EX: (أسْوَوْا، سَوَّوْا ساوَوْا، انغوَوْا، استوَوْا، تساوَوْا، تَسَوَّوْا، استغوَوْا، احْوَوَّوْا)
        substitutions.add(new InfixSubstitution("وَوَ","وَ"));// EX: (أسْوَتْ، )
        substitutions.add(new InfixSubstitution("وَّوَ","وَّ"));// EX: (سَوَّتْ، )

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
