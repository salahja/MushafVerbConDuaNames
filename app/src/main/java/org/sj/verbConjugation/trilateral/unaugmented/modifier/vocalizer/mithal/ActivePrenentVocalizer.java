package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.mithal;

import org.sj.verbConjugation.trilateral.Substitution.InfixSubstitution;
import org.sj.verbConjugation.trilateral.Substitution.SubstitutionsApplier;
import org.sj.verbConjugation.trilateral.unaugmented.ConjugationResult;
import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

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
public class ActivePrenentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private final List substitutions = new LinkedList();

    private final List acceptList = new LinkedList();
    private final List declineList = new LinkedList();

    public ActivePrenentVocalizer() {
        acceptList.add("وذر");
        acceptList.add("وسع");
        acceptList.add("وطء");

        declineList.add("وبء");
        declineList.add("وبه");
        declineList.add("وجع");
        declineList.add("وسع");
        declineList.add("وهل");

        substitutions.add(new InfixSubstitution("َوْ", "َ"));

    }


    public List getSubstitutions() {
        return substitutions;
    }

    /**
     * فحص أحد ثلاثة احتمالات
     *
     * @param conjugationResult ConjugationResult
     * @return boolean
     */
    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 9 || kov == 10 || kov == 11) &&
                ((noc == 2 || noc == 6)  //احمال1
                        || isApplied1(conjugationResult) //احتمال2
                        || isApplied2(conjugationResult)); // احتمال 3

    }

    private boolean isApplied1(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (!root.getConjugation().equals("4")) return false;

        Iterator iter = acceptList.iterator();
        while (iter.hasNext()) {
            String appliedRoot = (String) iter.next();
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return true;
        }
        return false;
    }

    private boolean isApplied2(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (!root.getConjugation().equals("3")) return false;

        Iterator iter = declineList.iterator();
        while (iter.hasNext()) {
            String appliedRoot = (String) iter.next();
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return false;
        }
        return true;
    }
}
