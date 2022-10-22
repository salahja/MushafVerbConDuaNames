package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;


public class Imperative4Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative4Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (أسْوِ، ساوِ، انْغَوِ، استَوِ، استَغْوِ)
        substitutions.add(new InfixSubstitution("ِوِ","ِ"));// EX: (أنتِ أسْوِي، ساوِي، انْغَوِي، استَوِي، استَغْوِي)
        substitutions.add(new InfixSubstitution("ِوَ","ِيَ"));// EX: (أنتما ِ أسْوِيا، ساوِيا، انْغَوِيا، استَوِيا، استَغْوِيا)
        substitutions.add(new InfixSubstitution("ِوُ","ُ"));// EX: (أنتم أسْوُوا، ساوُوا، انْغَوُوا، استَوُوا، استَغْوُوا)
        substitutions.add(new InfixSubstitution("ِوْ","ِي"));// EX: (أنتن أسْوِينَ، ساوِينَ، انْغَوِينَ، استَوِينَ، استَغْوِينَ)

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
