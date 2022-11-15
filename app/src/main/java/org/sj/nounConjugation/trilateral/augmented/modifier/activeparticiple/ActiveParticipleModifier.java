package org.sj.nounConjugation.trilateral.augmented.modifier.activeparticiple;

import org.sj.nounConjugation.NounLamAlefModifier;
import org.sj.nounConjugation.NounSunLamModifier;
import org.sj.nounConjugation.trilateral.augmented.modifier.Substituter;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.MazeedConjugationResult;
import org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import org.sj.verbConjugation.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;

import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ����� �������� ������ ��� ��� ������
 * ������ �������� �� ������� ������ ������
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActiveParticipleModifier {
    private static final ActiveParticipleModifier instance = new ActiveParticipleModifier();
    private final Substituter substituter = new Substituter();
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();

    private ActiveParticipleModifier() {
    }

    public static ActiveParticipleModifier getInstance() {
        return instance;
    }

    // AugmentedTrilateralModifierListener listener //todo
    public MazeedConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, boolean listener) {
        MazeedConjugationResult conjResult = new MazeedConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(conjResult);
        geminator.apply(conjResult);
        boolean applyVocalization = true;
        int result = FormulaApplyingChecker.getInstance().check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        } else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener)
                //  if (listener == null)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
                //    applyVocalization = listener.doSelectVocalization();
                applyVocalization = true;
        }
        if (applyVocalization) {
            vocalizer.apply(conjResult);
        }
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}

