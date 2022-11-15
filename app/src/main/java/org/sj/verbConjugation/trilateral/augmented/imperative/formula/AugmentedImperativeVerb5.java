package org.sj.verbConjugation.trilateral.augmented.imperative.formula;

import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.trilateral.augmented.imperative.AugmentedImperativeVerb;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedImperativeVerb5 extends AugmentedImperativeVerb {
    public AugmentedImperativeVerb5(AugmentedTrilateralRoot root, String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.imperative.AugmentedImperativeVerb
     * method
     */
    public String form() {
        // return "�"+root.getC1()+ArabCharUtil.SKOON+"�"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;
        String s="";
        //  return "�"+root.getC1()+ArabCharUtil.SKOON+"�"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        Character c1 = root.getC1();
        if (c1.toString().equals("ء")) {

            s= "ا" + "ت" + ArabCharUtil.SHADDA +  ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.KASRA + root.getC3() + lastDim + connectedPronoun;
        }else {

            s= "ا" + root.getC1() + ArabCharUtil.SKOON + "ت" + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.KASRA + root.getC3() + lastDim + connectedPronoun;
        }
        return s;

    }
}
