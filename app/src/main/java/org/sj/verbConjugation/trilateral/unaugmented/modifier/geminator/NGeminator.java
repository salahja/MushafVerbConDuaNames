package org.sj.verbConjugation.trilateral.unaugmented.modifier.geminator;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import org.sj.verbConjugation.util.SystemConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import org.sj.verb.trilateral.unaugmented.modifier.geminator.ngeminator.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:
 * الادغام للمنتهي بالنون هو نفسه من أجل كل الصيغ للمعلوم وللمجهول
 * ولكن تختلف فيما بينها بأرقام الضمائر
 * فهو الصف الأب للثلاث الصفوف في الماضي والمضارع والأمر
 * A composite pattern is applied here
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NGeminator extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List substitutions = new LinkedList();
    //أرقام الضمائر التي يمكن التطبيق من أجلها حسب الصيغةة  ماضي أو مضارع أو أمر
    private final Map indeciesMap = new HashMap();

    public NGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("نْنَ", "نَّ"));
        List indecies = new ArrayList(2);
        indecies.add("2");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PAST_TENSE, indecies);
        indecies = new ArrayList(2);
        indecies.add("7");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PRESENT_TENSE, indecies);
        indecies = new ArrayList(1);
        indecies.add("7");
        indeciesMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, indecies);
        indeciesMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, indecies);
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3() == 'ن' && (kov == 1 || kov == 2 || kov == 3 || kov == 5 || kov == 6 || kov == 11 || kov == 14 || kov == 15 || kov == 17 || kov == 18 || kov == 20));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //it is the same active or passive
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    /*protected List getAppliedPronounsIndecies(String tense) {
        return (List) indeciesMap.get(tense);
    }*/
}
