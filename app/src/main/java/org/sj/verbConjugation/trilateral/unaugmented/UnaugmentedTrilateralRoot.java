package org.sj.verbConjugation.trilateral.unaugmented;

import org.sj.verbConjugation.Gerund;
import org.sj.verbConjugation.trilateral.TrilateralRoot;
import org.sj.verbConjugation.util.OrderedMap;

import java.util.Collection;

/**
 * <p>Title: </p>
 *
 * <p>Description: الجذر الثلاثي المجرد
 * متضمنا الأحرف الثلاثة وباب التصريف  واللزوم أو التعدية مع رموز المصادر              </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedTrilateralRoot implements TrilateralRoot {

    private char c1;
    private char c2;
    private char c3;
    private String conjugation;

    private String conjugationname;
    private String rulename;

    private String verbtype;
    private String verb;
    private final OrderedMap gerundes = new OrderedMap();

    public UnaugmentedTrilateralRoot() {
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    public String getVerbtype() {
        return verbtype;
    }

    public void setVerbtype(String verbtype) {
        this.verbtype = verbtype;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
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

    public String getConjugationname() {
        return conjugationname;
    }

    public void setConjugationname(String conjugationname) {
        this.conjugationname = conjugationname;
    }

    public String getConjugation() {
        return conjugation;
    }

    public void setConjugation(String conjugation) {
        this.conjugation = conjugation;
    }

    public char getC3() {
        return c3;
    }

    public void setC3(char c3) {
        this.c3 = c3;
    }

    public Collection getGerundsSymbols() {
        return gerundes.getOrderedKeys();
    }

    public Gerund getGerund(String symbol) {
        return (Gerund) gerundes.get(symbol);
    }

    public void addGerund(Gerund gerund) {
        gerundes.put(gerund.getSymbol(), gerund);
    }

    public boolean equals(Object obj) {
        UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) obj;
        return root.c1 == c1 && root.c2 == c2 && root.c3 == c3;
    }
}
