package org.sj.verbConjugation.trilateral.augmented.active.present;

import org.sj.verbConjugation.util.PresentConjugationDataContainer;

public class AugmentedActivePresentConjugator {
    private static final AugmentedActivePresentConjugator instance = new AugmentedActivePresentConjugator();
    private final AbstractAugmentedPresentConjugator nominativeConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getNominativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    private final AbstractAugmentedPresentConjugator accusativeConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getAccusativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    private final AbstractAugmentedPresentConjugator jussiveConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getJussiveLastDprList(),
            PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    private final AbstractAugmentedPresentConjugator emphasizedConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

    private AugmentedActivePresentConjugator() {
    }

    public static AugmentedActivePresentConjugator getInstance() {
        return instance;
    }

    public AbstractAugmentedPresentConjugator getAccusativeConjugator() {
        return accusativeConjugator;
    }

    public AbstractAugmentedPresentConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AbstractAugmentedPresentConjugator getJussiveConjugator() {
        return jussiveConjugator;
    }

    public AbstractAugmentedPresentConjugator getNominativeConjugator() {
        return nominativeConjugator;
    }
}
