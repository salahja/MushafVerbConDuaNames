package org.sj.nounConjugation.trilateral.unaugmented;

import org.sj.nounConjugation.GenericNounSuffixContainer;
import org.sj.nounConjugation.IUnaugmentedTrilateralNounConjugator;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ����� ��� ������ ������� ������    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralActiveParticipleConjugator implements IUnaugmentedTrilateralNounConjugator {
    private static final UnaugmentedTrilateralActiveParticipleConjugator instance = new UnaugmentedTrilateralActiveParticipleConjugator();

    private UnaugmentedTrilateralActiveParticipleConjugator() {
    }

    public static UnaugmentedTrilateralActiveParticipleConjugator getInstance() {
        return instance;
    }

    public UnaugmentedTrilateralActiveParticiple createNoun(UnaugmentedTrilateralRoot root, int suffixIndex) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        return new UnaugmentedTrilateralActiveParticiple(root, suffix);
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new ArrayList(18);
        for (int i = 0; i < 18; i++)
            result.add(createNoun(root, i));
        return result;
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return null;
    }

}
