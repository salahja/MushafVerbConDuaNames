package org.sj.nounConjugation.trilateral.augmented;


import org.sj.nounConjugation.GenericNounSuffixContainer;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ���� ������� ������� ������� �� ���� �����      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AugmentedTrilateralNoun {
    protected AugmentedTrilateralRoot root;
    protected String suffix;

    public AugmentedTrilateralNoun(AugmentedTrilateralRoot root, String suffix) {
        this.root = root;
        this.suffix = suffix;
    }

    public abstract String form();

    public String toString() {
       String mm= GenericNounSuffixContainer.getInstance().getPrefix()+form();
        return mm;
    }
}
