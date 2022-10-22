package org.sj.verbConjugation.trilateral.Substitution;

import org.sj.verbConjugation.trilateral.TrilateralRoot;

public class ExpressionPrefixSubstitution extends Substitution {

    public ExpressionPrefixSubstitution(String segment, String result) {
        super(segment, result);
    }


    public String apply(String word, TrilateralRoot root) {
        String wordSegment = segment.replaceAll("C1",root.getC1()+"");
        wordSegment = wordSegment.replaceAll("C2",root.getC2()+"");
        wordSegment = wordSegment.replaceAll("C3",root.getC3()+"");

        if (!word.startsWith(wordSegment)) return null;

        String replacedResult = result.replaceAll("C1",root.getC1()+"");
        replacedResult = replacedResult.replaceAll("C2",root.getC2()+"");
        replacedResult = replacedResult.replaceAll("C3",root.getC3()+"");

        return word.replaceAll(wordSegment,replacedResult);

    }
}
