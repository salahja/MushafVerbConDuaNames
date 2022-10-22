package org.sj.verbConjugation.trilateral.augmented;

import java.util.*;

/**
 *   Title:
 *
 *   Description:
 *
 *   Copyright: Copyright (c) 2006
 *
 *   Company:
 *
 * @author not attributable
 * @version 1.0
 */
public class AugmentedTrilateralRootTree {
    private List roots = new LinkedList();

    public AugmentedTrilateralRootTree() {
    }

    public void addRoot(AugmentedTrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
