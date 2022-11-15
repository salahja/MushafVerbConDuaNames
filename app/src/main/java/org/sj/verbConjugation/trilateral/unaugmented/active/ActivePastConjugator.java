package org.sj.verbConjugation.trilateral.unaugmented.active;

import org.sj.verbConjugation.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbConjugation.util.PastConjugationDataContainer;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: تصريف الأفعال في الماضي    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastConjugator {
    private static final ActivePastConjugator instance = new ActivePastConjugator();

    private ActivePastConjugator() {
    }

    public static ActivePastConjugator getInstance() {
        return instance;
    }

    /**
     * إنشاء الفعل حسب الضمير
     *
     * @param pronounIndex int
     * @param root         UnaugmentedTrilateralRoot
     * @return PastConjugation
     */
    public ActivePastVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        String dpa2 = PastConjugationDataContainer.getInstance().getDpa2(root);
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        return new ActivePastVerb(root, dpa2, lastDpa, connectedPronoun);
    }

    /**
     * إنشاء  قائمة تحتوي الأفعال مع الضمائر الثلاثة عشر
     *
     * @param root UnaugmentedTrilateralRoot
     * @return List
     */
    public List createVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 13; i++) {
            boolean add = result.add(createVerb(i, root));
        }
        ////System.out.println(result);
        return result;
    }

    public List createVerbHua(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i = 0; i < 1; i++) {
            boolean add = result.add(createVerb(i, root));
        }
        ////System.out.println(result);
        return result;
    }

}
