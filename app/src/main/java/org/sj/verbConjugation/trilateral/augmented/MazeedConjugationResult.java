package org.sj.verbConjugation.trilateral.augmented;

import java.util.ArrayList;
import java.util.List;

public class MazeedConjugationResult {
    private final int kov;
    private final int formulaNo;
    private final AugmentedTrilateralRoot root;
    //13 conjugated verbs
    private final List originalResult;
    private final List finalResult;

    public MazeedConjugationResult(int kov, int formulaNo, AugmentedTrilateralRoot root, List originalResult) {
        this.kov = kov;
        this.formulaNo = formulaNo;
        this.originalResult = originalResult;
        this.root = root;
        this.finalResult = new ArrayList(originalResult);
    }

    public List getFinalResult() {
        return finalResult;
    }

    public int getKov() {
        return kov;
    }

    public List getOriginalResult() {
        return originalResult;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public int getFormulaNo() {
        return formulaNo;
    }
}
