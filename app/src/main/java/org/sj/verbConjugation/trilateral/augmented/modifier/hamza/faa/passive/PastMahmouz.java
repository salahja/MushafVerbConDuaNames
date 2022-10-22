package org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.passive;

import java.util.*;

import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.modifier.hamza.faa.*;


public class PastMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new ExpressionInfixSubstitution("أُءْيِC3ْ","أُئِC3ْ"));// EX: (أُئِستُ )
        substitutions.add(new InfixSubstitution("أُءْيِ","أُئِي"));// EX: (أُئِيس )
        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أُوثِرَ، )
        substitutions.add(new InfixSubstitution("اءْتِ","ائْتِ"));// EX: (ائْتِلْتُ، )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (انْئِيدََ، استُئمّ )
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (انْؤُطِرَ، )
        substitutions.add(new PrefixSubstitution("ءُ", "أُ")); // EX: (أُثِّرَ، أُوجِرَ، )
        substitutions.add(new InfixSubstitution("اءْ", "اؤْ")); // EX: (اؤْتُمِرَ، )

        substitutions.add(new InfixSubstitution("ُءُ", "ُؤُ")); // EX: (تُؤُوكِلَ، تُؤُكِّدَ، )
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (استُؤْكِلَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
