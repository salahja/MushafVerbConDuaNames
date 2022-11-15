package org.sj.verbConjugation.trilateral.unaugmented;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: يمثل نتيجة التصريف مع الجذر ونوع الجذر
 * يستعمل في المعالجة بعد التوليد
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ConjugationResult {
    protected int kov;
    protected UnaugmentedTrilateralRoot root;

    //13 conjugated verbs
    protected List originalResult;
    //القائمة بعد  الادغام والاعلال والهمزة
    protected List finalResult;

    public ConjugationResult(int kov, UnaugmentedTrilateralRoot root, List originalResult) {
        this.kov = kov;
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

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "ConjugationResult{" +
                "kov=" + kov +
                ", root=" + root +
                ", originalResult=" + originalResult +
                ", finalResult=" + finalResult +
                '}';
    }
}
