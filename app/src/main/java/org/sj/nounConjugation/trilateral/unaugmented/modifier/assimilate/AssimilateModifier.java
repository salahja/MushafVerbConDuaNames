package org.sj.nounConjugation.trilateral.unaugmented.modifier.assimilate;

import java.util.List;
import org.sj.nounConjugation.NounLamAlefModifier;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.*;
import org.sj.nounConjugation.NounSunLamModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق المعالجة الخاصة على اسم الفاعل
 * ابتداء بالادغام ثم الاعلال واخيرا الهمزة
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AssimilateModifier implements IUnaugmentedTrilateralNounModifier{
    private Substituter substituter = new Substituter();
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private AssimilateModifier() {
    }

    private static AssimilateModifier instance = new AssimilateModifier();

    public static AssimilateModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        substituter.apply(conjResult.getFinalResult(), root);
        geminator.apply(conjResult.getFinalResult(), root);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
