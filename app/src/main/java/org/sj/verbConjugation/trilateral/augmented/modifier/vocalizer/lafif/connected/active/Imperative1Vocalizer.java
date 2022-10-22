package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (أحْيِ، أذْوِ، حايِ، داوِ، انزوِ، احتوِ، استحيِ، استهوِ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ أحْيِي، أذْوِي، حايِي، داوِي، انزوِي، احتوِي، استحيِي، استهوِي)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم أحْيُوا، أذْوُوا، حايُوا، داوُوا، انزوُوا، احتوُوا، استحيُوا، استهوُوا)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنتن أحْيِينَ، أذْوِينَ، حايِينَ، داوِينَ، انزوِينَ، احتوِينَ، استحيِينَ، استهوِينَ)

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
                        case 5:
                        case 9:
                            return true;
                    }

                case 28:
                    switch (formulaNo) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 9:
                            return true;
                    }
            }

        }
        return false;
    }


}
