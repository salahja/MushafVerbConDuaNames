package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.*;

   
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();


    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (أحْيَا، حَيَّا، حايا، ازدَيَا، تحايا، تحَيَّا، استحيا)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أحْيَوْا، حَيَّوْا حايَوْا، ، ازدَيَوْا، تحايَوْا، تَحَيَّوْا، استَحْيَوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (أحْيَتْ، حيَّت، حايَتْ، ، ازدَيَتْ،  تحايتْ، تَحَيَّتْ، استحيَتْ)


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
