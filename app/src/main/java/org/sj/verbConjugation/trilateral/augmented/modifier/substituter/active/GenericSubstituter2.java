package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;



import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;


public class GenericSubstituter2 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter2() {
    substitutions.add(new InfixSubstitution("دْتَ","دَّ"));// EX: (ادَّخَرَ، يَدَّخِرُ، ادَّخِرْ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'د' && super.isApplied(mazeedConjugationResult);
  }
}
