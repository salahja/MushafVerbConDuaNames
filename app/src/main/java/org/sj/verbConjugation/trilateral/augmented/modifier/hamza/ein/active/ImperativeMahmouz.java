package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.active;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.*;


public class ImperativeMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("وْءُ","وْءُ"));// EX: (اسْتَوْءُوا)
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (رَاءِ)
        substitutions.add(new SuffixSubstitution("َءِ","َئِ"));// EX: (انْفَئِ، اشْتَئِ)
        substitutions.add(new SuffixSubstitution("ْءِ","ْئِ"));// EX: (أنْئِ)
        substitutions.add(new SuffixSubstitution("َءِّ","َئِّ"));// EX: (رَئِّ)
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (أسْئِمْ، اسْتَرْئِفْ، أوْئِبْ، انْذَئِجْ، ابْتَئِسْ، اتَّئِدْ، لائِمْ)
        substitutions.add(new InfixSubstitution("َءِّ","َئِّ"));// EX: (رَئِّسْ،  )
        substitutions.add(new InfixSubstitution("َءَّ","َأَّ"));// EX: (ترَأَّفْ، )
        substitutions.add(new InfixSubstitution("َءُّ","َؤُّ"));// EX: (رَؤُّوا،  )
        substitutions.add(new InfixSubstitution("َءُ","َؤُ"));// EX: (انْفَؤُوا، ارْتَؤُوا)
        substitutions.add(new InfixSubstitution("ْءُ","ْؤُ"));// EX: (انْؤُوا، )
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (اجْأَلَّ، يَجْأوِّي، )
        substitutions.add(new InfixSubstitution("اءَ","اءَ"));// EX: (تَفاءَلْ، )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (راؤُوا، )
    }



    public List getSubstitutions() {
        return substitutions;
    }
}
