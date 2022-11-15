package org.sj.conjugator.activity;

import org.sj.verbConjugation.trilateral.TrilateralRoot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AugmentedTrilateralRoot implements TrilateralRoot {
    //قائمة صيغ المزيد الممكنة لهذا الجذر
    private final Map augmentations = new HashMap();
    private char c1;
    private char c2;
    private char c3;

    public AugmentedTrilateralRoot() {
    }

    public AugmentedTrilateralRoot(String rootText) {
        char[] chars = rootText.toCharArray();
        this.c1 = chars[0];
        this.c2 = chars[1];
        this.c3 = chars[2];

    }

    public char getC1() {
        return c1;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public char getC2() {
        return c2;
    }

    public void setC2(char c2) {
        this.c2 = c2;
    }

    public char getC3() {
        return c3;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public Collection getAugmentationList() {
        return augmentations.values();
    }
}
