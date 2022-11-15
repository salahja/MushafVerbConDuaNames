package org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental;

import org.sj.nounConjugation.trilateral.unaugmented.modifier.ConjugationResult;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental.vocalizer.PreMithalLafifVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental.vocalizer.WawiNakesLafifVocalizer;
import org.sj.nounConjugation.trilateral.unaugmented.modifier.instrumental.vocalizer.YaeiNakesLafifVocalizer;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
public class Vocalizer {
    private final List modifiers = new LinkedList();
    private final PreMithalLafifVocalizer preMithalLafifVocalizer = new PreMithalLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        // تطبيق اعلال واحد اولا
        if (preMithalLafifVocalizer.isApplied(conjResult))
            preMithalLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}

