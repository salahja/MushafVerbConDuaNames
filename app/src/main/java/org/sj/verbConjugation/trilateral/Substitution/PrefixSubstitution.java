package org.sj.verbConjugation.trilateral.Substitution;

import org.sj.verbConjugation.trilateral.TrilateralRoot;

public class PrefixSubstitution extends Substitution {

    public PrefixSubstitution(String segment, String result) {
        super(segment, result);
    }

    public String apply(String word, TrilateralRoot root) {
        return word.startsWith(segment)? word.replaceFirst(segment,result): null;
    }
}
