package org.sj.verbConjugation.trilateral.augmented.modifier;

import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;

/**
 * Title: Sarf Program
 * <p>
 * Description: abstract interface to be implemented from the child classes
 * which will modify the verbs
 * <p>
 * <p>
 * Copyright: Copyright (c) 2006
 * <p>
 * Company: ALEXO
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public interface IAugmentedTrilateralModifier {
    boolean isApplied(MazeedConjugationResult mazeedConjugationResult);
}
