package org.sj.verbConjugation.trilateral.augmented.modifier.geminator.generic;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;

public class ActivePresentGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ActivePresentGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ُ", "ِC3ُّ")); // EX: (يُتِمُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3َ", "ِC3َّ")); // EX: (يُتِمَّان)
        substitutions.add(new ExpressionInfixSubstitution("ْC3ِC3ِ", "ِC3ِّ")); // EX: (تُتِمِّينَ)
        substitutions.add(new ExpressionSuffixSubstitution("ْC3ِC3ْ", "ِC3َّ")); // EX: (لم يُتِمَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3ِC3ُ", "َC3ُّ")); // EX: (يأتَمّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3ِC3َ", "َC3َّ")); // EX: (يأتَمّان)
        substitutions.add(new ExpressionInfixSubstitution("َC3ِC3ِ", "َC3ِّ")); // EX: (تأتَمِّينَ)
        substitutions.add(new ExpressionSuffixSubstitution("َC3ِC3ْ", "َC3َّ")); // EX: (لم يأتَمّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ُ", "اC3ُّ")); // EX: (يَتَصَامُّ،)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3َ", "اC3َّ")); // EX: (يَتَصَامَّا،)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ِ", "اC3ِّ")); // EX: (تَتَصَامِّي،)
        substitutions.add(new ExpressionSuffixSubstitution("اC3َC3ْ", "اC3َّ")); // EX: (لم يَتَصَامَّ،)
        substitutions.add(new ExpressionInfixSubstitution("اC3ِC3ُ", "اC3ُّ")); // EX: (يُحاجّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3ِC3َ", "اC3َّ")); // EX: (يُحاجّا)
        substitutions.add(new ExpressionInfixSubstitution("اC3ِC3ِ", "اC3ِّ")); // EX: (تُحاجِّي)
        substitutions.add(new ExpressionSuffixSubstitution("اC3ِC3ْ", "اC3َّ")); // EX: (لم  ي Kُحاجَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
