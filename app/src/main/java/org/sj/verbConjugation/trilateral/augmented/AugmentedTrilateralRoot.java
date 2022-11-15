package org.sj.verbConjugation.trilateral.augmented;

import org.sj.verbConjugation.trilateral.TrilateralRoot;
import org.sj.verbConjugation.util.AugmentationFormula;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AugmentedTrilateralRoot implements TrilateralRoot {
    private final Map augmentations = new HashMap();
    private char c1;
    private char c2;
    private char c3;
    private String form;
    private String verbtype;
    private String babname;

    public AugmentedTrilateralRoot() {
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getVerbtype() {
        return verbtype;
    }

    public void setVerbtype(String verbtype) {
        this.verbtype = verbtype;
    }

    public String getBabname() {
        return babname;
    }

    public void setBabname(String babname) {
        this.babname = babname;
    }

    public void addAugmentationFormula(AugmentationFormula formula) {
        augmentations.put(formula.getFormulaNo() + "", formula);
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

    public AugmentationFormula getAugmentationFormula(int formulaNo) {
        return (AugmentationFormula) augmentations.get(formulaNo + "");
    }
}
