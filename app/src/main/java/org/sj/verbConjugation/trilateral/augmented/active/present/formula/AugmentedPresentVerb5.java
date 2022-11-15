package org.sj.verbConjugation.trilateral.augmented.active.present.formula;

import org.sj.verbConjugation.trilateral.augmented.AugmentedPresentVerb;
import org.sj.verbConjugation.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verbConjugation.util.ArabCharUtil;

public class AugmentedPresentVerb5 extends AugmentedPresentVerb {
    public AugmentedPresentVerb5(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.present.AugmentedPresentVerb
     * method
     */
    public String form() {
        String s="";
        //  return "�"+root.getC1()+ArabCharUtil.SKOON+"�"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        Character c1 = root.getC1();
        if (c1.toString().equals("ء")) {
            s= cp +"ت" + ArabCharUtil.SHADDA+ ArabCharUtil.FATHA +    root.getC2() + ArabCharUtil.KASRA + root.getC3() + lastDpr + connectedPronoun;
        }else {

            //  return cp+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+"�"+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
           s= cp + ArabCharUtil.FATHA + root.getC1() + ArabCharUtil.SKOON + "ت" + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.KASRA + root.getC3() + lastDpr + connectedPronoun;
        }
        return s;
    }
}
