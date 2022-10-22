package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past1Vocalizer() {
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أُحْيُوا، أُذْوُوا، دُووُوا، حُويُوا، انزُوُوا، احتُوُوا، تُدُووُوا، استُهْوُوا)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (حُيُّوا، قُوُّوا، تُقُوُّوا، تُحُيُّوا)
        substitutions.add(new InfixSubstitution("يْ","ي"));// EX: (أُحْيِيتُ، حُيِّيتُ قُوِّيتُ دُوِيتُ، انزويت، احتويتُ، تُحُيِّيتُ تدويت، استُحْيِيتُ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        if ((root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي') {
            switch (kov) {
                case 27:
                    switch (formulaNo) {
                        case 1:
                        case 2:
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                            return true;
                    }

                case 28:
                    switch (formulaNo) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                            return true;
                    }
            }
        }
        return false;
    }


}
