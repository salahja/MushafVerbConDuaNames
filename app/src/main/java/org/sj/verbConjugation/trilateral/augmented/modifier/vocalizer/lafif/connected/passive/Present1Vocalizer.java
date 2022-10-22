package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َا"));// EX: (يُحْيَا، يحيَّا، يحايَا، يزديَا، يتحَايَا، يتحيَّا، يُستحيَا)
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (لن يُحْيَا، يحيَّا، يحايَا، يزديَا، يتحَايَا، يتحيَّا، يُستحيَا)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُحْيَ، يحيَّ، يحايَ، يزديَ، يتحَايَ، يتحيَّ، يُستحيَ)
        substitutions.add(new InfixSubstitution("يِي","يْ"));// EX: (أنتِ تُحْيَيْنَ، تُحَيَّيْنَ، تحايَيْنَ، تزديَيْنَ، تتحايَيْنَ، تتحيَّيْنَ، تستحيَيْنَ)
        substitutions.add(new InfixSubstitution("يُو","وْ"));// EX: (أنتم تُحْيَوْنَ، تُحَيَّوْنَ، تُحايَوْنَ، تزدَيَوْنَ، تتحايَوْنَ، تتحيَّوْنَ، تستحيَوْنَ)
        substitutions.add(new InfixSubstitution("يُن","وُن"));// EX: (أنتم تُحْيَوُنَّ، تُحَيَّوُنَّ، تحايَوُنَّ تزديَوُنَّ، تُتَحَايَوُنَّ، تُتَحَيَّوُنَّ، تستحيَوُنَّ)


    }



    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == 28) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        }

        return false;
    }
}
