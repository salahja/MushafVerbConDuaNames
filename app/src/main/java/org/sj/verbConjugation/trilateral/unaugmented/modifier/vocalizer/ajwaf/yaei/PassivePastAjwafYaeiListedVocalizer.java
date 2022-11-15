package org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import org.sj.verbConjugation.trilateral.Substitution.ExpressionInfixSubstitution;
import org.sj.verbConjugation.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiListedVocalizer;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePastAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List substitutions = new LinkedList();

    public PassivePastAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ", "ُC3ّ"));// EX: ( بُتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ْ", "ُC3ْ"));// EX: (بُعْتُ، قُئتُ، أُنْتُ، شُئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ", "ُC3ّ"));// EX: (نحن لُنَّا، هن لُنَّ، أنا لِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3َ", "ِيC3َ"));// EX: (بِيع، قِيء، إين، شِيء، بِيت)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ُ", "ِيC3ُ"));// EX: (بِيعوا، قِيئوا، إينوا، شِيئوا، بِيتوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }


}
