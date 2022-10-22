package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();


    public Past2Vocalizer() {
        substitutions.add(new InfixSubstitution("ِوُ","ُ"));// EX: (اُسْوُوا، سُووُوا، انغُوُوا، استُوُوا، تُسُووُوا، استُغْوُوا)
        substitutions.add(new InfixSubstitution("ِّوُ","ُّ"));// EX: (سُوُّوا، تُسُوُّوا، احْوُوُّوا)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أُسْوِيَ، سُوِّيَ أُسْوِيَتْ، أُسْوِيَا، سُووِيَ، انغُوِيَ، استُوِيَ، تُسُووِيَ، استُغْوِيَ احْوُوِّيَ)
        substitutions.add(new InfixSubstitution("وْ","ي"));// EX: (أُسْوِيتُ، سُوِّيتُ سُووِيتُ، انغُوِيتُ، استُوِيتُ، تُسُووِيتُ، استُغْوِيتُ)

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
