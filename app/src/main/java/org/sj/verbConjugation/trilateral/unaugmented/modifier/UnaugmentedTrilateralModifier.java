package org.sj.verbConjugation.trilateral.unaugmented.modifier;

import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.util.VerbLamAlefModifier;

import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 * المعالجة
 * <p>Description: يقوم بفحص واجراء التعديلات المناسبة على الأفعال الثلاثية المجردة
 * بما فيها الاعلال والابدال والهمزة
 * حسب الصيغة ماضي أو مضارع او أمر
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralModifier {
    private static final UnaugmentedTrilateralModifier instance = new UnaugmentedTrilateralModifier();
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final HamzaModifier hamzaModifier = new HamzaModifier();
    private final PostHamzaModifier postHamzaModifier = new PostHamzaModifier();

    private UnaugmentedTrilateralModifier() {
    }

    public static UnaugmentedTrilateralModifier getInstance() {
        return instance;
    }

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     * البدء بالادغام
     *
     * @param root         UnaugmentedTrilateralRoot
     * @param kov          int
     * @param conjugations List
     * @param tense        String (From SystemConstans class the values are stored)  ماضي أو مضارع او أمر
     * @return ConjugationResult
     */
    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active) {
        return build(root, kov, conjugations, tense, active, true);
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations);
        if (applyGemination)
            geminator.apply(tense, active, conjResult);
        vocalizer.apply(tense, active, conjResult);
        hamzaModifier.apply(tense, active, conjResult);
        //خصيصاُ للفعل أثأ
        postHamzaModifier.apply(tense, active, conjResult);
        VerbLamAlefModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
