package org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple.vocalizer;

import java.util.*;


import org.sj.nounConjugation.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("ِوُ", "ِي")); // EX: (هذا المُدْنِي،)
        substitutions.add(new SuffixSubstitution("ِوَ", "ِيَ")); // EX: (رأيتُ المُدْنِيَ،  )
        substitutions.add(new SuffixSubstitution("ِوِ", "ِي")); // EX: (مررتُ على المُدْنِي، )
        substitutions.add(new InfixSubstitution("ِوٌ", "ٍ")); // EX: (هذا مُدْنٍ)
        substitutions.add(new InfixSubstitution("ِوٍ", "ٍ")); // EX: (مررتُ على مُدْنٍ)
        substitutions.add(new InfixSubstitution("ِوً", "ِيً")); // EX: (رأيتُ مُدْنِيًا)
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (مُدْنِيَةٌ، مُدْنِيان، مُدْنِيتان، مُدْنِيات، )
        substitutions.add(new InfixSubstitution("ِوُ", "ُ")); // EX: (مُدْنُونَ، )
        substitutions.add(new InfixSubstitution("ِوِ", "ِ")); // EX: (مُدْنِينَ، )
    }
    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        if (mazeedConjugationResult.getRoot().getC3() != 'و')
            return false;

        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
            case 21:
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

            case 22:
                switch (formulaNo) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        return true;
                }

            case 23:
                switch (formulaNo) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
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
                    case 11:
                        return true;
                }
        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
