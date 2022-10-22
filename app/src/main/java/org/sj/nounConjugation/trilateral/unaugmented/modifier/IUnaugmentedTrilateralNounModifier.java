package org.sj.nounConjugation.trilateral.unaugmented.modifier;

import java.util.List;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public interface IUnaugmentedTrilateralNounModifier {
    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula);
}
