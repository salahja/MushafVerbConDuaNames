package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafWawiVocalizer;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePresentAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private final List substitutions = new LinkedList();

    public ActivePresentAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ُ", "ُوC3ُ")); // EX: (يَقُومُ، يبوء، يؤوب)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ِ", "ُوC3ِ")); // EX: (تقومين، لن تقومِي، تبوئين، تؤوبين)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3َ", "ُوC3َ")); // EX: (تقومان، لن يقومَ، تبوءان، تؤوبان)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ْ", "ُC3ْ")); // EX: (تَقُمْنَ، لم يَقُمْ، يَبُؤْ، يَؤُبْ)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ّ", "ُC3ّ")); // EX: (أنتن تَصُنَّ، هنّ صُنَّ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

}
