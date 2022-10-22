package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present4Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present4Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُذْوِي، يداوي، ينزوي، يحتوي، يستهوي)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُذْوِ، لم يداوِ، لم يَنْزَوِ، لم يَحْتَوِ، لم يَسْتَهْوِ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ تُذْوِينَ، تُداوِينَ، تنْزوين، تحتوين، تستهوين)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم تُذْوُونَ، تُداوُونَ، تنْزوون، تحتوون، تستهوون)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنتن تُذْوِينَ، تداوين، تنْزوين، تحتوين، تستهوين)


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