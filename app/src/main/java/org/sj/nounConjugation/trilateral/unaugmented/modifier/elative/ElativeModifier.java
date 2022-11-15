package org.sj.nounConjugation.trilateral.unaugmented.modifier.elative;

import org.sj.nounConjugation.NounLamAlefModifier;
import org.sj.nounConjugation.NounSunLamModifier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModifier;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

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
public class ElativeModifier implements IUnaugmentedTrilateralNounModifier {
    private static final ElativeModifier instance = new ElativeModifier();
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();
    private final AlkhairModifier alkhairModifier = new AlkhairModifier();
    private final AlSharModifier alSharModifier = new AlSharModifier();

    private ElativeModifier() {
    }

    public static ElativeModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (alkhairModifier.isApplied(conjResult)) {
            alkhairModifier.apply(conjResult);
        } else if (alSharModifier.isApplied(conjResult)) {
            alSharModifier.apply(conjResult);
        } else {
            if (geminator.isApplied(conjResult))
                geminator.apply(conjResult.getFinalResult(), root);
            vocalizer.apply(conjResult);
            mahmouz.apply(conjResult);
            NounLamAlefModifier.getInstance().apply(conjResult);
            NounSunLamModifier.getInstance().apply(conjResult);
        }
        return conjResult;
    }

}
