package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;


public class GenericSubstituter3 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter3() {
    substitutions.add(new InfixSubstitution("طْتَ","طَّ"));// EX: (اطَّلَبَ، يَطَّلِبُ، اطَّلِبْ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ط' && super.isApplied(mazeedConjugationResult);
  }
}
