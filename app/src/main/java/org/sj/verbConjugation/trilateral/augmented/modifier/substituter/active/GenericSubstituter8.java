package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;


public class GenericSubstituter8 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter8() {
    substitutions.add(new InfixSubstitution("ظْتَ","ظْطَ"));// EX: (اظْطَلَمَ، يَظْطَلِمُ، اظْطَلِمْ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ظ' && super.isApplied(mazeedConjugationResult);
  }
}
