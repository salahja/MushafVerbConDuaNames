package org.sj.verbConjugation.trilateral.unaugmented;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: قائمة الجذور الثلاثية المجردة   </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedTrilateralRootTree {
    private final List roots = new LinkedList();

    public UnaugmentedTrilateralRootTree() {
    }

    public void addRoot(UnaugmentedTrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
