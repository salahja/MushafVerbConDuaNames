package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.lam.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.lam.*;


public class PastMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (أجْزَأْتُ، كافأْتُ، انفقَأْتُ، ابتدَأْتُ، تدارَأْتُ، استَهْزَأْتُ، احْزَوْزَأْتُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (أجْزَأَ، كافَأَ، انْفَقَأَ، ابتدَأَ، تدارَأَ، استَهْزَأَ، احْزَوْزَأَ، )
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أجْزَؤُوا، كافَؤُوا، انفقَؤُوا، ابتدَؤُوا، تدارَؤُوا، استَهْزَؤُوا، احْزَوْزَؤُوا)
        substitutions.add(new InfixSubstitution("َّءْ", "َّأْ")); // EX: (جَزَّأْتُ، تَخَبَّأْتُ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (جَزَّأَ، تَخَبَّأَ،)
        substitutions.add(new InfixSubstitution("َّءُ", "َّؤُ")); // EX: (جَزَّؤُوا، تَخَبَّؤُوا، )
        substitutions.add(new InfixSubstitution("اءَ", "اءَ")); // EX: (أساءَ، استاءَ، )
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (أساؤُوا، استاؤُوا، )
    }



    public List getSubstitutions() {
        return substitutions;
    }
}
