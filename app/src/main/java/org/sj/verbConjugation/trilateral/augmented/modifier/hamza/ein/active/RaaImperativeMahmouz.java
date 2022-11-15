package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.active;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.TrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.ArrayList;
import java.util.List;

public class RaaImperativeMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List substitutions = new ArrayList();

    public RaaImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("ْءِ", "ِ"));// EX: (أَرِ، )
        substitutions.add(new InfixSubstitution("ْءُ", "ُ"));// EX: (أَرُوا، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        TrilateralRoot root = mazeedConjugationResult.getRoot();
        return mazeedConjugationResult.getFormulaNo() == 1 && root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }

}
