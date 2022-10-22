
package org.sj.verbConjugation.trilateral.Substitution;

import java.util.*;
import org.sj.verbConjugation.trilateral.*;


public abstract class SubstitutionsApplier {

    protected static List defaultAppliedProunounsIndecies = new ArrayList(13);
    static {
        for (int i=0; i<13; i++) {
            defaultAppliedProunounsIndecies.add(i+1 +"");
        }
    }

    public SubstitutionsApplier() {

    }


    public void apply(List words, TrilateralRoot root) {
        for (int i=0; i< getAppliedPronounsIndecies().size(); i++) {
            int index = Integer.parseInt(getAppliedPronounsIndecies().get(i).toString())-1;
            Object wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            String word = wordObj.toString().trim();
            List list = getSubstitutions();
            Iterator subIter = getSubstitutions().iterator();
            while (subIter.hasNext()) {
                Substitution substitution = (Substitution) subIter.next();
                String result = substitution.apply(word, root);
                if (result != null) {

                    Object set = words.set(index, result);

                    break;
                }
            }
        }
    }
    public void applySarfSagheer(List words, TrilateralRoot root) {
        for (int i=0; i< 1; i++) {
            int index = Integer.parseInt(getAppliedPronounsIndecies().get(i).toString())-1;
            Object wordObj = words.get(index);
            if (wordObj == null) {
                continue;
            }
            String word = wordObj.toString().trim();
            List list = getSubstitutions();
            Iterator subIter = getSubstitutions().iterator();
            while (subIter.hasNext()) {
                Substitution substitution = (Substitution) subIter.next();
                String result = substitution.apply(word, root);
                if (result != null) {

                    Object set = words.set(index, result);

                    break;
                }
            }
        }
    }


    public abstract List getSubstitutions();

    protected List getAppliedPronounsIndecies() {
        return defaultAppliedProunounsIndecies;
    }


}
