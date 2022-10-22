package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (أذْوَى، قَوَّى، داوى، انزوى، احتوى،تداوى، تقوَّى استهوى)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أذوَوْا، قَوَّوْا داوَوْا، انزَوَوْا، احتَوَوْا، تداوَوْا، تَقَوَّوْا، استهوَوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (أذوَتْ، قَوَّت داوَت، انزوتْ، احتوتْ، تداوتْ، تقوَّتْ، استهوتْ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        if (root.getC2() == 'و' && root.getC3() == 'ي') {
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
