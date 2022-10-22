package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {
        substitutions.add(new SuffixSubstitution("وَ","ى"));// EX: (هو أدنى، سَمَّى ، حابى، انجلى، ارتضى، ارعَوَى، تسامى، تزكّى ، استرضى، احلولى)
        substitutions.add(new InfixSubstitution("وْت","يْت"));// EX: (أنا أدنَيْتُ، سَمَّيْتُ ، حابَيْتُ، انجليتُ، ارتضيتُ، ارعَوَيْتُ، تساميت، تزكَّيْتُ،  استرضيت، احلوليتُ)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنا أدنَيْتُ، سَمَّيْتُ ، حابَيْتُ، انجليتُ، ارتضيتُ، ارعَوَيْتُ، تساميت، تزكَّيْتُ،  استرضيت، احلوليتُ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (هم أدنَوْا، سَمَّوْا ، حابَوْا، انجَلَوْا، ارتضَوْا، ارعَوَوْا، تسامَوْا، تزكَّوْا ، استرضوا، احلولوا)
        substitutions.add(new InfixSubstitution("وَت", "ت")); // EX: (هي أدْنَتْ، سَمَّتْ ، حابَتْ، انْجَلَتْ، ارتضت، ارْعَوَتْ، تسامَتْ، تزكَّتْ ، استرضت، احلولت)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (هما أدنَيَا، سَمَّيَا ، حابَيَا، انْجَلَيَا، ارتضيا، ارعَوَيَا، تسامَيَا، تزكَّيَا ، استرضيا، احلوليا)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if ((kov == 22 || kov == 23) && formulaNo == 4) return true;
        if ((kov == 21 || kov == 23) && (formulaNo == 2 || formulaNo == 9)) return true;
        if (kov == 23 && (formulaNo == 6 || formulaNo == 10)) return true;

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
                return true;
            }
        }
        return false;
    }
}
