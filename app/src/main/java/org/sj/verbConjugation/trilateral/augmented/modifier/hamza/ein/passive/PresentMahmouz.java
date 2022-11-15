package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.passive;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.ein.AbstractEinMahmouz;

import java.util.LinkedList;
import java.util.List;

public class PresentMahmouz extends AbstractEinMahmouz {
    private final List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ")); // EX: (يُسْتَيْئَسُ، )
        substitutions.add(new InfixSubstitution("وْءَ", "وْءَ")); // EX: (يُسْتَوْءَلُ، يُسْتَوْءَى، )
        substitutions.add(new InfixSubstitution("وءَ", "وْءَ")); // EX: (يُوءَبُ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يُسْأَمُ، يُجْأَلُّ، يُسْتَرْأَفُ، )
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يُنْذَأجُ، يُبْتَأَسُ، )
        substitutions.add(new InfixSubstitution("َءَّ", "َأَّ")); // EX: (يُرَأَّسُ، يُتَرَأَّفُ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (يُتَّأدُ، )
        substitutions.add(new InfixSubstitution("اءَ", "اءَ")); // EX: (يُلاءَمُ، يُتَساءَلُ، )
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
