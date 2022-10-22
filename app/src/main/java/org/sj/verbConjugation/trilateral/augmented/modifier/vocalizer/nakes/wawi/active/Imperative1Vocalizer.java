package org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;


public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {
        substitutions.add(new InfixSubstitution("ِوُو","ُو"));// EX: (أنتم أدْنُوا، حابُوا، انجلُوا، ارتضُوا، ارعَوُوا، استرضُوا، احلَوْلُوا)
        substitutions.add(new InfixSubstitution("ِوُن","ُن"));// EX: (أنتم أدْنُنَّ، حابُنَّ، انجلُنَّ، ارتضُنَّ، ارعَوُنَّ، استرضُنَّ، احلَوْلُنَّ)
        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (أدْنِ، حابِ، انجلِ، ارتضِ، ارعَوِ، استرضِ، احلَوْلِ)
        substitutions.add(new InfixSubstitution("وْن","ين"));// EX: (أنتن أدنِينَ، حابِين، انجلِين، ارتضين، ارعوين، استرضين، احلولين)
        substitutions.add(new InfixSubstitution("ِوِ","ِ"));// EX: (أنتِ أدْنِي، حابِي، انجلِي، ارتضي، ارعوي، استرضي، احلولي)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أنتما أدْنِيا، حابِيا، انجلِيا، ارتضيا، ارعويا، استرضيا، احلوليا)



    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        if ((kov == 22 || kov == 23) && formulaNo == 4) return true;
        if ((kov == 21 || kov == 23) &&  formulaNo == 9) return true;
        if (kov == 23 && (formulaNo == 6 || formulaNo == 10)) return true;

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 1:
            case 3:
            case 5:
                return true;
            }
        }
        return false;
    }
}
