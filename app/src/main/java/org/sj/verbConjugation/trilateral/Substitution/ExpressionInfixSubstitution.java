package org.sj.verbConjugation.trilateral.Substitution;

import org.sj.verbConjugation.trilateral.TrilateralRoot;

public class ExpressionInfixSubstitution extends Substitution {

    public ExpressionInfixSubstitution(String segment, String result) {
        super(segment, result);
    }

    public String apply(String word, TrilateralRoot root) {
      if(word.length()>0)
      {
          ////System.out.printf(word);
      }
        ////System.out.println(segment+","+result);
        String wordSegment = segment.replaceAll("C1",root.getC1()+"");
        wordSegment = wordSegment.replaceAll("C2",root.getC2()+"");
        wordSegment = wordSegment.replaceAll("C3",root.getC3()+"");
        ////System.out.println(wordSegment+","+result);
        if (word.indexOf(wordSegment) == -1) return null;

        String replacedResult = result.replaceAll("C1",root.getC1()+"");
        replacedResult = replacedResult.replaceAll("C2",root.getC2()+"");
        replacedResult = replacedResult.replaceAll("C3",root.getC3()+"");

        return word.replaceAll(wordSegment,replacedResult);
    }
}
