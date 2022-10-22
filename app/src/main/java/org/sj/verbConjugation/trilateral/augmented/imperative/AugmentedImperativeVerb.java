package org.sj.verbConjugation.trilateral.augmented.imperative;

import org.sj.verbConjugation.trilateral.augmented.*;


public abstract class AugmentedImperativeVerb {

    protected AugmentedTrilateralRoot root;
    protected String lastDim;
    protected String connectedPronoun;

    public AugmentedImperativeVerb(AugmentedTrilateralRoot root, String lastDim, String connectedPronoun) {
        this.root = root;
        this.lastDim = lastDim;
        this.connectedPronoun = connectedPronoun;
    }

    public abstract String form();

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpr() {
        return lastDim;
    }

    public String toString() {
        return form();
    }
}
