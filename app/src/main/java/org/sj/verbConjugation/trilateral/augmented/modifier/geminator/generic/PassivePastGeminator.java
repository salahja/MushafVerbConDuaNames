package org.sj.verbConjugation.trilateral.augmented.modifier.geminator.generic;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

import java.util.LinkedList;
import java.util.List;

public class PassivePastGeminator extends SubstitutionsApplier {
    private final List substitutions = new LinkedList();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3َ", "ِC3َّ")); // EX: (أُحِبَّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ُ", "ِC3ُّ")); // EX: (أُحِبُّوا،)
        substitutions.add(new ExpressionInfixSubstitution("ُC3ِC3َ", "ُC3َّ")); // EX: (انْقُضَّ)
        substitutions.add(new ExpressionInfixSubstitution("ُC3ِC3ُ", "ُC3ُّ")); // EX: (انْقُضُّوا)
        substitutions.add(new ExpressionInfixSubstitution("وC3ِC3َ", "وC3َّ")); // EX: (حُوجَّ، احْمُورَّ)
        substitutions.add(new ExpressionInfixSubstitution("وC3ِC3ُ", "وC3ُّ")); // EX: (حُوجُّوا، احْمُورُّوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
