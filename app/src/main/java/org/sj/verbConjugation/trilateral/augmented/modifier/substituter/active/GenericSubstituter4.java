package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;


public class GenericSubstituter4 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter4() {
    substitutions.add(new InfixSubstitution("ذْتَ", "ذْدَ")); // EX: (اذْدَكَرَ، يَذْدَكِرُ، اذْدَكِرْ)


  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ذ' && super.isApplied(mazeedConjugationResult);
  }
}
