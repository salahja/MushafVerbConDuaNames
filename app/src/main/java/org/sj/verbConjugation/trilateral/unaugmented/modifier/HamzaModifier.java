package org.sj.verbConjugation.trilateral.unaugmented.modifier;

import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.util.SystemConstants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class HamzaModifier {
    private final Map modifiersMap = new HashMap();

    public HamzaModifier() {
        List activePastList = new LinkedList();
        List passivePastList = new LinkedList();
        List activePresentList = new LinkedList();
        List passivePresentList = new LinkedList();
        List imperativeList = new LinkedList();
        List emphasizedImperativeList = new LinkedList();

        //خمس أنواع  أساسية  للمهموز للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", emphasizedImperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //قائمة الماضي المبني لمعلوم
        activePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.ActivePastMahmouz());
        activePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.ActivePastMahmouz());
        activePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.lam.ActivePastMahmouz());

        //قائمة الماضي المبني لمجهول
        passivePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.PassivePastMahmouz());
        passivePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.PassivePastMahmouz());
        passivePastList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.lam.PassivePastMahmouz());


        //قائمة المضارع المبني لمعلوم
        activePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        activePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.ActivePresentMahmouz());
        activePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.ActivePresentMahmouz());
        activePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.lam.ActivePresentMahmouz());

        //قائمة المضارع المبني لمجهول
        passivePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        passivePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.PassivePresentMahmouz());
        passivePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.PassivePresentMahmouz());
        passivePresentList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.lam.PassivePresentMahmouz());

        //قائمة الأمر
        //وضع الحالات الخاصة أولاً
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.RaaImperativeMahmouz());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz1());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz2());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.SpecialImperativeMahmouz());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.ImperativeMahmouz());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.ImperativeMahmouz());
        imperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.lam.ImperativeMahmouz());

        //قائمة الأمر المؤكد
        emphasizedImperativeList.add(imperativeList.get(0));
        emphasizedImperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz1());
        emphasizedImperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz2());
        emphasizedImperativeList.add(new org.sj.verbConjugation.trilateral.unaugmented.modifier.hamza.ein.SpecialEmphsizedImperativeMahmouz());
        emphasizedImperativeList.add(imperativeList.get(4));
        emphasizedImperativeList.add(imperativeList.get(5));
        emphasizedImperativeList.add(imperativeList.get(6));
    }

    /**
     * تطبيق تغيير  الهمزة حسب الصيغة ماضي أو مضارع أو أمر للمعلوم أو لمجهول
     * قد لا يطبق أي نوع
     *
     * @param tense      String
     * @param active     boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List modifiers = (List) modifiersMap.get(tense + active);
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralModifier modifier = (IUnaugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
