package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.*;


public class PresentMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {

        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أنا أُوثِرُ، )
        substitutions.add(new InfixSubstitution("أَءْ", "آ")); // EX: (أنا آتَمِرُ، )
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (يَتَآكَلُ)
        substitutions.add(new InfixSubstitution("ْءَا", "ْآ")); // EX: (يَنْآدُ)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يَأْتَمِرُ، يسْتَأْمِرُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يَتَأَكَّدُ، )
        substitutions.add(new InfixSubstitution("َءِ", "َئِ")); // EX: (يَسْتَئِمُّ، )
        substitutions.add(new InfixSubstitution("ُءِ", "ُئِ")); // EX: (يُئِيسُ، )
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (يُؤْثِرُ، )
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (يُؤَثِّرُ، يُؤَاجَرُ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يَنْأطِرُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
