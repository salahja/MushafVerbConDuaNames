package org.sj.verbConjugation.trilateral.augmented.modifier;

import java.util.*;
import org.sj.verbConjugation.trilateral.augmented.*;
import org.sj.verbConjugation.trilateral.Substitution.*;

 
public class Substituter {


    private List activeList = new LinkedList();
    private List passiveList = new LinkedList();


    public Substituter() {
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter1());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter2());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter3());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter4());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter5());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter6());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter7());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.GenericSubstituter8());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.SpecialSubstituter1());
        activeList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active.SpecialSubstituter2());

        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter1());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter2());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter3());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter4());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter5());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter6());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter7());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.GenericSubstituter8());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter1());
        passiveList.add(new org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter2());

    }

    public void apply(String tense, boolean active, MazeedConjugationResult conjResult) {
        List modifiers = null;
        if (!active ) {
            modifiers = passiveList;
        }
        else {
            modifiers = activeList;
        }

        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
