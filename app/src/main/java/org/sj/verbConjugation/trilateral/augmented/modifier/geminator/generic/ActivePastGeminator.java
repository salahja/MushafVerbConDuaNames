package org.sj.verbConjugation.trilateral.augmented.modifier.geminator.generic;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

import java.util.LinkedList;
import java.util.List;

public class ActivePastGeminator extends SubstitutionsApplier {
    private final List substitutions = new LinkedList();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3َ", "َC3َّ"));// EX: (أَمَدَّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ُ", "َC3ُّ"));// EX: (أَمَدُّوا،)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3َ", "اC3َّ"));// EX: (حاجَّ، احمارَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ُ", "اC3ُّ"));// EX: (حاجُّوا، احمارُّوا)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3َ", "َC3َّ"));// EX: (احمرَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3ُ", "َC3ُّ"));// EX: (احمرُّوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
