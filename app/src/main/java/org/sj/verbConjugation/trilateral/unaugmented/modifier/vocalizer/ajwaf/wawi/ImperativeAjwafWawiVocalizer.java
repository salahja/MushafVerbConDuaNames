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
public class ImperativeAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private final List substitutions = new LinkedList();

    public ImperativeAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوُC3ُ", "C1ُوC3ُ"));// EX: (قُومُوا، قُومُنَّ، بوءوا، أوبوا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوُC3ِ", "C1ُوC3ِ"));// EX: (قومِي، قومِنَّ، بوئي، أوبي)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوُC3َ", "C1ُوC3َ"));// EX: (قوما، قومَنَّ، بوءا، أوبا)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوُC3ْ", "C1ُC3ْ"));// EX: (قُمْ، قُمْنَانِّ، بُؤْ، أُبْ)
        substitutions.add(new ExpressionInfixSubstitution("اC1ْوُC3ّ", "C1ُC3ّ"));// EX: (أنتن صُنَّ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

}
