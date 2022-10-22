package org.sj.verbConjugation.trilateral.augmented.modifier.substituter.passive;

import java.util.*;
import org.sj.verbConjugation.trilateral.Substitution.*;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

public class GenericSubstituter7 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter7() {

    substitutions.add(new InfixSubstitution("ضْت", "ضْط")); // EX: (اضْطُلِعَ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ض' && super.isApplied(mazeedConjugationResult);
  }
}
